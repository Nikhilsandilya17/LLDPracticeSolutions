package designPatterns.src.creational_design_pattern.builderSanket;

public class Budget {
    private String currency;
    private double amount;

    public Budget(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }
}
