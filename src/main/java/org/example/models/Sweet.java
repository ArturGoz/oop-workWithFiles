package org.example.models;

import java.util.Objects;

/*
 * Абстракций клас для цукерок, шоколадок та печива
 * Містить потрібні атрибути та функції
 */
abstract public class Sweet {
    private String name;
    private double weight; // вага в грамах
    private double sugarContent; // вміст цукру у грамах

    public Sweet(String name, double weight, double sugarContent) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = Math.min(weight, sugarContent);
    }

    public abstract void printDetails(); // Абстрактний метод для виводу інформації про солодощі

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(double sugarContent) {
        this.sugarContent = Math.min(weight, sugarContent);
    }


}
