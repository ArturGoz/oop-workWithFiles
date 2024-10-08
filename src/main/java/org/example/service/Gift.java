package org.example.service;

import org.example.models.Sweet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Візерунок, який містить солодощі
 * Містить потрібні функції для лабораторної роботи
 */

public class Gift {
private List<Sweet> sweets;

    public Gift() {
        this.sweets = new ArrayList<>();
    }

    public void addSweet(Sweet... sweets) {
        this.sweets.addAll(Arrays.asList(sweets));
    }

    public double getTotalWeight(){
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }
    public void sortBySugarContent(){
        sweets.sort(Comparator.comparingDouble(Sweet::getSugarContent));
    }

    public List<Sweet> findSweetsBySugarRange(double minSugar, double maxSugar) {
        return sweets.stream()
                .filter(sweet -> sweet.getSugarContent() >= minSugar && sweet.getSugarContent() <= maxSugar)
                .collect(Collectors.toList());
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "sweets=" + sweets +
                '}';
    }

}
