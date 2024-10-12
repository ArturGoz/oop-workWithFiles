package org.example;


import org.example.models.Sweet;
import org.example.service.Gift;
import org.example.utilities.FileUtils;

import java.util.Optional;


public class Main {
    static double minSugar;
    static double maxSugar;
    static String filePath = "sweetsData.txt";
    static String rangeFileName = "setWeightRange.txt";

    public static void main(String[] args) {
        Gift gift = FileUtils.loadSweetsFromFile(filePath);

        // Виводимо дані про солодощі
        for (Sweet sweet : gift.getSweets()) {
            sweet.printDetails();
        }

        Optional<double[]> sugarRange = FileUtils.loadSugarRangeFromFile(rangeFileName);

        if (sugarRange.isPresent()) {
            double[] range = sugarRange.get();
            minSugar = range[0];
            maxSugar = range[1];
            System.out.println("Мінімальна вага цукру: " + minSugar + ", Максимальна вага цукру: " + maxSugar);
        } else {
            System.out.println("Не вдалося зчитати діапазон ваги з файлу.");
        }

        gift.findSweetsBySugarRange(minSugar, maxSugar).forEach(Sweet::printDetails);
    }
}

