package org.example;


import org.example.models.Candy;
import org.example.models.Chocolate;
import org.example.models.Cookie;
import org.example.models.Sweet;
import org.example.service.Gift;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static double minWeight;
    static double maxWeight;
    static String filePath = "sweetsData.txt";
    static String rangeFileName = "setWeightRange.txt";

    public static void main(String[] args) {
        Gift gift = FileUtils.loadSweetsFromFile(filePath);

        // Виводимо дані про солодощі
        for (Sweet sweet : gift.getSweets()) {
            System.out.println(sweet);
        }

        Optional<double[]> weightRange = FileUtils.loadWeightRangeFromFile(rangeFileName);

        if (weightRange.isPresent()) {
            double[] range = weightRange.get();
             minWeight = range[0];
             maxWeight = range[1];
            System.out.println("Мінімальна вага: " + minWeight + ", Максимальна вага: " + maxWeight);
        } else {
            System.out.println("Не вдалося зчитати діапазон ваги з файлу.");
        }
        System.out.println(gift.findSweetsBySugarRange(minWeight,maxWeight).toString());
    }
}

