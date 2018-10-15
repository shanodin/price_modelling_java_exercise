public class Price {
    private int value;
    private Tax[] taxes;
    private Currency currency;

    public Price(int value, Currency currency, Tax...taxes) {
        this.value = value;
        this.taxes = taxes;
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public Tax[] getTaxes() {
        return taxes;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int priceTotal() {
        int runningTotal = this.value;
        for (Tax tax : this.taxes) {
            runningTotal += tax.calculateValue(this);
        }
        return runningTotal;
    }

    public double[] getTaxValues() {
        double[] taxValues = new double[this.taxes.length];
        for (int i = 0; i < this.taxes.length; i++) {
            double taxValue = this.taxes[i].calculateValue(this);
            taxValues[i] = taxValue;
        }
        return taxValues;
    }

}