package io.lanu.design_patterns.strategy_pattern;

import java.util.HashMap;
import java.util.Map;

public class StrategyContext {
    double price;
    Map<String, OfferStrategy> strategyMap = new HashMap<>();

    public StrategyContext(double price) {
        this.price = price;
        strategyMap.put(NoDiscountStrategy.class.getName(), new NoDiscountStrategy());
        strategyMap.put(QuarterDiscountStrategy.class.getName(), new QuarterDiscountStrategy());
    }

    public void applyStrategy(OfferStrategy strategy) {
        System.out.println("Price before offer - " + price);
        double finalPrice = price - (price * strategy.getDiscount() / 100);
        System.out.println("Discount - " + strategy.getDiscount() + " %");
        System.out.println("Final price - " + finalPrice);
    }

    public OfferStrategy getStrategy(int monthNo){
        if ( monthNo < 6 )  {
            return strategyMap.get(NoDiscountStrategy.class.getName());
        }else{
            return strategyMap.get(QuarterDiscountStrategy.class.getName());
        }

    }
}
