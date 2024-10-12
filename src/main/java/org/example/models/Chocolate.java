package org.example.models;

public class Chocolate extends Sweet {
    private String type; // Тип шоколаду (темний, молочний, білий)

    public Chocolate(String name, double weight, double sugarContent, Object type) {
        super(name, weight, sugarContent);
        this.type = (String) type;
    }

    @Override
    public void printDetails() {
        System.out.println("Chocolate: " + getName() +
                ", Type: " + type +
                ", Weight: " + getWeight() + "g" +
                ", Sugar Content: " + getSugarContent() + "g");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
