package entity;

import contract.StateTaxStrategy;

public record State(String stateCode, double stateTaxRate) implements StateTaxStrategy {

    @Override
    public double computeStateSalesTax(double amount) {
        return (stateTaxRate / 100) * amount;
    }

    @Override
    public String toString() {
        return STR."State: \{stateCode} / Tax rate: \{stateTaxRate}%";
    }
}
