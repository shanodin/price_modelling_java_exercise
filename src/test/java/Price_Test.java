import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Price_Test {
    Tax tax1;
    Tax tax2;
    Price price1;
    Price price2;

    @Before
    public void before() {
        tax1 = new Tax(20, "VAT");
        tax2 = new Tax(10, "random");
        price1 = new Price(100, Currency.GBP, tax1);
        price2 = new Price(100, Currency.USD, tax1, tax2);
    }

    @Test
    public void hasValue() {
        assertEquals(100, price1.getValue());
    }

    @Test
    public void hasCurrency() {
        assertEquals(Currency.GBP, price1.getCurrency());
    }

    @Test
    public void canAddOneTax() {
        assertEquals(120, price1.priceTotal());
    }

    @Test
    public void canAddTwoTaxes() {
        assertEquals(130, price2.priceTotal());
    }

    @Test
    public void canGetTaxValues() {
        assertEquals("[20.0, 10.0]", java.util.Arrays.toString(price2.getTaxValues()));
    }
}