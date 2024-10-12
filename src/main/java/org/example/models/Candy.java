package org.example.models;

public class Candy extends Sweet {
    private String filling; // Наприклад: карамель, шоколад

    public Candy(String name, double weight, double sugarContent, Object filling) {
        super(name, weight, sugarContent);
        this.filling = (String) filling;
    }

    @Override
    public void printDetails() {
        System.out.println("Candy: " + getName() +
                ", Filling: " + filling +
                ", Weight: " + getWeight() + "g" +
                ", Sugar Content: " + getSugarContent() + "g");
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }
}
