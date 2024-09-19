package com.example;
/**
 * Класс для перевода величин из метров и сантиметров в другие единицы измерения.
 */
public class UnitConverter {
    private static final double FOOT_IN_CM = 30.48;
    private static final double INCH_IN_CM = 2.54;
    private static final double VERSHOK_IN_CM = 4.45;
    private static final double ARSHIN_IN_CM = 71.2;

    /**
     * Переводит величины из метров и сантиметров в футы и дюймы, а также в аршины и вершки.
     *
     * @param meters количество метров
     * @param centimeters количество сантиметров
     * @return двумерный массив, где первый элемент содержит футы и дюймы, а второй элемент — аршины и вершки
     */
    public double[][] convertAll(double meters, double centimeters) {
        double totalCm = meters * 100 + centimeters;

        // Перевод в футы и дюймы
        double feet = Math.floor(totalCm / FOOT_IN_CM);
        double inches = Math.round((totalCm % FOOT_IN_CM) / INCH_IN_CM);

        // Перевод в аршины и вершки
        double arshins = Math.floor(totalCm / ARSHIN_IN_CM);
        double remainingCm = totalCm % ARSHIN_IN_CM;
        double vershoks = Math.round(remainingCm / VERSHOK_IN_CM);

        return new double[][] {
                {feet, inches},
                {arshins, vershoks}
        };
    }
}
