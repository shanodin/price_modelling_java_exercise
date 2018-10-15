import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Transaction_Test {
    Tax tax1;
    Tax tax2;
    Price price1;
    Price price2;
    Transaction transaction1;
    Transaction transaction2;

    @Before
    public void before() {
        tax1 = new Tax(20, "VAT");
        tax2 = new Tax(10, "random");
        price1 = new Price(100, Currency.GBP, tax1);
        price2 = new Price(100, Currency.USD, tax1, tax2);
        transaction1 = new Transaction(price1);
        transaction2 = new Transaction(price1, price2);
    }

    @Test
    public void getsOnePrice() {
        assertEquals(1, transaction1.getPrices().length);
    }

    @Test
    public void totalsOnePriceNoTax() {
        assertEquals(100, transaction1.getTotalNoTax());
    }

    @Test
    public void totalsOnePriceWithTax() {
        assertEquals(120, transaction1.getTotalWithTax());
    }

    @Test
    public void getsMultiplePrices() {
        assertEquals(2, transaction2.getPrices().length);
    }

    @Test
    public void totalsMultiplePricesNoTax() {
        assertEquals(200, transaction2.getTotalNoTax());
    }

    @Test
    public void totalsMultiplePricesWithTax() {
        assertEquals(250, transaction2.getTotalWithTax());
    }
}