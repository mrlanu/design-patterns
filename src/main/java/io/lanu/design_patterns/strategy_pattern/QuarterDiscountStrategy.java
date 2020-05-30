package io.lanu.design_patterns.strategy_pattern;

public class QuarterDiscountStrategy implements OfferStrategy {

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public double getDiscount() {
        return 10;
    }
}
