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

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", sugarContent=" + sugarContent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweet sweet = (Sweet) o;
        return Double.compare(weight, sweet.weight) == 0 && Double.compare(sugarContent, sweet.sugarContent) == 0 && Objects.equals(name, sweet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, sugarContent);
    }

}
