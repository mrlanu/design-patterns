package io.lanu.design_patterns.strategy_pattern;

public class StrategyDemo{
    public static void main(String[] args){
        StrategyContext context = new StrategyContext(100);
        System.out.println("Enter month number between 1 and 12");
        int month = 7;
        System.out.println("Month = " + month);
        OfferStrategy strategy = context.getStrategy(month);
        context.applyStrategy(strategy);
    }
}
