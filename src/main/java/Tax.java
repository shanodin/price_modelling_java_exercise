public class Tax {
    private int percent;
    private String name;

    public Tax (int percent, String name) {
        this.percent = percent;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPercent() {
        return percent;
    }

    public double calculateValue(Price price) {
        int priceNum = price.getValue();
        return (this.percent * 100) / priceNum;
    }
}