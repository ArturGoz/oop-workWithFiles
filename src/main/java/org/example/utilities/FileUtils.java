package org.example.utilities;

import org.example.models.Candy;
import org.example.models.Chocolate;
import org.example.service.Gift;

import java.io.*;
import java.util.Optional;

public class FileUtils {

    public static Gift loadSweetsFromFile(String fileName) {
        Gift gift = new Gift();

        // Використовуємо ClassLoader для доступу до файлу в ресурсах
        try (InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                int weight = Integer.parseInt(data[1].trim());
                int sugarContent = Integer.parseInt(data[2].trim());

                // Визначаємо тип солодощів на основі назви
                if (name.toLowerCase().contains("цукерка")) {
                    gift.addSweet(new Candy(name, weight, sugarContent));
                } else if (name.toLowerCase().contains("шоколад")) {
                    gift.addSweet(new Chocolate(name, weight, sugarContent));
                } else if (name.toLowerCase().contains("печиво")) {
                    gift.addSweet(new Chocolate(name, weight, sugarContent));
                } else {
                    // Інші типи солодощів
                    System.out.println("Невідомий тип солодощів: " + name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gift;
    }

    // Метод для зчитування діапазону ваги з файлу setWeightRange.txt
    public static Optional<double[]> loadSugarRangeFromFile(String fileName) {
        try (InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line = reader.readLine();
            if (line != null) {
                String[] values = line.split(",");
                double minWeight = Integer.parseInt(values[0].trim());
                double maxWeight = Integer.parseInt(values[1].trim());
                return Optional.of(new double[]{minWeight, maxWeight});
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}




