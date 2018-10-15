public class Transaction {
    private Price[] prices;

    public Transaction(Price...prices) {
        this.prices = prices;
    }

    public Price[] getPrices() {
        return prices;
    }

    public int getTotalNoTax () {
        int runningTotal = 0;
        for (Price price : this.prices) {
            runningTotal += price.getValue();
        }
        return runningTotal;
    }

    public int getTotalWithTax () {
        int runningTotal = 0;
        for (Price price : this.prices) {
            runningTotal += price.priceTotal();
        }
        return runningTotal;
    }
}