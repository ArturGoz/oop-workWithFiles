package org.example.models;

public class Cookie extends Sweet {
    private Boolean hasFilling; // Чи має начинку

    public Cookie(String name, double weight, double sugarContent, Object hasFilling) {
        super(name, weight, sugarContent);
        this.hasFilling = (Boolean) hasFilling;
    }

    @Override
    public void printDetails() {
        System.out.println("Cookie: " + getName() +
                ", With filling: " + (hasFilling ? "Yes" : "No") +
                ", Weight: " + getWeight() + "g" +
                ", Sugar Content: " + getSugarContent() + "g");
    }

    public Boolean getHasFilling() {
        return hasFilling;
    }

    public void setHasFilling(Boolean hasFilling) {
        this.hasFilling = hasFilling;
    }
}
