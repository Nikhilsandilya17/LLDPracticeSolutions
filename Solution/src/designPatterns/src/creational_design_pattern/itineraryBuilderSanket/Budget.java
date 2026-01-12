package designPatterns.src.creational_design_pattern.itineraryBuilderSanket;

public class Budget {
    private final String currency;
    private final double amount;

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
