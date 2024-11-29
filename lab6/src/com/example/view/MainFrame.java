package com.example.view;

// Импортируем конкретные классы из java.awt вместо всего пакета
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.Arrays;

// Импортируем наши модели явно
import com.example.model.Product;
import com.example.model.Liquid;
import com.example.model.Bulk;
import com.example.model.Car;
import com.example.model.Wagon;
import com.example.model.Train;
import com.example.model.Warehouse;
import com.example.model.TankWagon;
import com.example.model.BulkWagon;
import com.example.model.CarWagon;
import com.example.model.ContainerWagon;

/**
 * Главное окно приложения для управления перевозками.
 */
public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private JTable warehouseTable;
    private JTable trainTable;
    private DefaultTableModel warehouseModel;
    private DefaultTableModel trainModel;
    private Train currentTrain;

    /**
     * Конструктор главного окна.
     */
    public MainFrame() {
        setTitle("Перевозки");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initComponents();
        loadData();
    }

    /**
     * Инициализация компонентов интерфейса.
     */
    private void initComponents() {
        tabbedPane = new JTabbedPane();

        // Панель склада
        JPanel warehousePanel = new JPanel(new BorderLayout());
        String[] warehouseColumns = {"Тип", "Название", "Количество", "Ед. изм."};
        warehouseModel = new DefaultTableModel(warehouseColumns, 0);
        warehouseTable = new JTable(warehouseModel);
        warehouseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel warehouseButtonPanel = new JPanel();
        JButton addProductButton = new JButton("Добавить продукт");
        JButton editProductButton = new JButton("Изменить продукт");
        JButton deleteProductButton = new JButton("Удалить");
        JButton loadTrainButton = new JButton("Загрузить в поезд");

        warehouseButtonPanel.add(addProductButton);
        warehouseButtonPanel.add(editProductButton);
        warehouseButtonPanel.add(deleteProductButton);
        warehouseButtonPanel.add(loadTrainButton);

        warehousePanel.add(new JScrollPane(warehouseTable), BorderLayout.CENTER);
        warehousePanel.add(warehouseButtonPanel, BorderLayout.SOUTH);

        // Панель поезда
        JPanel trainPanel = new JPanel(new BorderLayout());
        String[] trainColumns = {"Тип вагона", "Груз", "Вместимость", "Ед. изм."};
        trainModel = new DefaultTableModel(trainColumns, 0);
        trainTable = new JTable(trainModel);
        trainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        trainPanel.add(new JScrollPane(trainTable), BorderLayout.CENTER);

        tabbedPane.addTab("Склад", warehousePanel);
        tabbedPane.addTab("Поезд", trainPanel);

        add(tabbedPane);

        // Обработчики событий
        addProductButton.addActionListener(e -> showAddProductDialog());
        editProductButton.addActionListener(e -> editSelectedProduct());
        deleteProductButton.addActionListener(e -> deleteSelectedProduct());
        loadTrainButton.addActionListener(e -> loadTrainFromWarehouse());
    }

    /**
     * Отображение диалогового окна для добавления нового продукта.
     */
    private void showAddProductDialog() {
        JDialog dialog = new JDialog(this, "Добавить продукт", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] productTypes = {"Жидкость", "Сыпучий груз", "Контейнер", "Автомобиль"};
        JComboBox<String> typeCombo = new JComboBox<>(productTypes);
        JTextField nameField = new JTextField(20);
        JTextField quantityField = new JTextField(10);

        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(new JLabel("Тип:"), gbc);
        gbc.gridx = 1;
        dialog.add(typeCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(new JLabel("Название:"), gbc);
        gbc.gridx = 1;
        dialog.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        dialog.add(new JLabel("Количество:"), gbc);
        gbc.gridx = 1;
        dialog.add(quantityField, gbc);

        JButton saveButton = new JButton("Сохранить");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        dialog.add(saveButton, gbc);

        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Название не может быть пустым");
                }

                int quantity = Integer.parseInt(quantityField.getText().trim());
                if (quantity <= 0) {
                    throw new IllegalArgumentException("Количество должно быть положительным числом");
                }

                Product newProduct;
                int type = typeCombo.getSelectedIndex() + 1;
                switch (type) {
                    case 1:
                        newProduct = new Liquid(type, name, quantity);
                        break;
                    case 2:
                        newProduct = new Bulk(type, name, quantity);
                        break;
                    case 3:
                        newProduct = new com.example.model.Container(type, name, quantity);  // Явно указываем путь к нашему Container
                        break;
                    case 4:
                        newProduct = new Car(type, name, quantity);
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный тип продукта");
                }

                // Добавляем новый продукт в склад
                Product[] currentProducts = Warehouse.getProducts();
                Product[] newProducts = Arrays.copyOf(currentProducts, currentProducts.length + 1);
                newProducts[newProducts.length - 1] = newProduct;
                Warehouse.setProducts(newProducts);

                loadWarehouseData();
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog,
                        "Количество должно быть числом",
                        "Ошибка ввода",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(dialog,
                        ex.getMessage(),
                        "Ошибка ввода",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    /**
     * Редактирование выбранного продукта.
     */
    private void editSelectedProduct() {
        int selectedRow = warehouseTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Выберите продукт для редактирования",
                    "Предупреждение",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Product product = Warehouse.getProducts()[selectedRow];
        showEditProductDialog(product, selectedRow);
    }

    /**
     * Отображение диалогового окна для редактирования продукта.
     *
     * @param product Продукт для редактирования
     * @param index Индекс продукта в массиве
     */
    private void showEditProductDialog(Product product, int index) {
        JDialog dialog = new JDialog(this, "Редактировать продукт", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField nameField = new JTextField(product.getName(), 20);
        JTextField quantityField = new JTextField(String.valueOf(product.getQuantity()), 10);

        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(new JLabel("Название:"), gbc);
        gbc.gridx = 1;
        dialog.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(new JLabel("Количество:"), gbc);
        gbc.gridx = 1;
        dialog.add(quantityField, gbc);

        JButton saveButton = new JButton("Сохранить");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        dialog.add(saveButton, gbc);

        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Название не может быть пустым");
                }

                int quantity = Integer.parseInt(quantityField.getText().trim());
                if (quantity <= 0) {
                    throw new IllegalArgumentException("Количество должно быть положительным числом");
                }

                // Обновляем продукт
                Product[] products = Warehouse.getProducts();
                switch (product.getTypeNumber()) {
                    case 1:
                        products[index] = new Liquid(1, name, quantity);
                        break;
                    case 2:
                        products[index] = new Bulk(2, name, quantity);
                        break;
                    case 3:
                        products[index] = new com.example.model.Container(3, name, quantity);  // Явно указываем путь к нашему Container
                        break;
                    case 4:
                        products[index] = new Car(4, name, quantity);
                        break;
                }

                loadWarehouseData();
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog,
                        "Количество должно быть числом",
                        "Ошибка ввода",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(dialog,
                        ex.getMessage(),
                        "Ошибка ввода",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    /**
     * Удаление выбранного продукта.
     */
    private void deleteSelectedProduct() {
        int selectedRow = warehouseTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Выберите продукт для удаления",
                    "Предупреждение",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Вы уверены, что хотите удалить этот продукт?",
                "Подтверждение удаления",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            Product[] currentProducts = Warehouse.getProducts();
            Product[] newProducts = new Product[currentProducts.length - 1];

            System.arraycopy(currentProducts, 0, newProducts, 0, selectedRow);
            System.arraycopy(currentProducts, selectedRow + 1, newProducts, selectedRow, currentProducts.length - selectedRow - 1);

            Warehouse.setProducts(newProducts);
            loadWarehouseData();
        }
    }

    /**
     * Загрузка товаров из склада в поезд.
     */
    private void loadTrainFromWarehouse() {
        currentTrain = Train.loadingOfGoods();
        loadTrainData();
        tabbedPane.setSelectedIndex(1); // Переключаемся на вкладку поезда
    }

    /**
     * Загрузка данных в интерфейс.
     */
    private void loadData() {
        loadWarehouseData();
        if (currentTrain != null) {
            loadTrainData();
        }
    }

    /**
     * Загрузка данных склада в таблицу.
     */
    private void loadWarehouseData() {
        warehouseModel.setRowCount(0);
        for (Product product : Warehouse.getProducts()) {
            String unit = "";
            switch (product.getTypeNumber()) {
                case 1: unit = "л"; break;
                case 2: unit = "кг"; break;
                case 3:
                case 4: unit = "шт."; break;
            }
            warehouseModel.addRow(new Object[]{
                    getProductTypeName(product.getTypeNumber()),
                    product.getName(),
                    product.getQuantity(),
                    unit
            });
        }
    }

    /**
     * Загрузка данных поезда в таблицу.
     */
    private void loadTrainData() {
        trainModel.setRowCount(0);
        if (currentTrain != null) {
            for (Wagon van : currentTrain.getList()) {
                String unit = "";
                String vanType = "";
                if (van instanceof TankWagon) {
                    unit = "л";
                    vanType = "Цистерна";
                } else if (van instanceof BulkWagon) {
                    unit = "кг";
                    vanType = "Вагон для сыпучих грузов";
                } else if (van instanceof ContainerWagon) {
                    unit = "шт.";
                    vanType = "Платформа для контейнеров";
                } else if (van instanceof CarWagon) {
                    unit = "шт.";
                    vanType = "Платформа для автомобилей";
                }

                trainModel.addRow(new Object[]{
                        vanType,
                        van.getCargoName(),
                        van.getCapacity(),
                        unit
                });
            }
        }
    }

    /**
     * Получение названия типа продукта по его номеру.
     *
     * @param typeNumber Номер типа продукта
     * @return Название типа продукта
     */
    private String getProductTypeName(int typeNumber) {
        switch (typeNumber) {
            case 1: return "Жидкость";
            case 2: return "Сыпучий груз";
            case 3: return "Контейнер";
            case 4: return "Автомобиль";
            default: return "Неизвестный тип";
        }
    }
}
