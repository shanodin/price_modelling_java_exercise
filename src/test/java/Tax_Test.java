import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tax_Test {
    Price price1;
    Tax tax1;

    @Before
    public void before() {
        tax1 = new Tax(20, "VAT");
        price1 = new Price(100, Currency.GBP, tax1);
    }

    @Test
    public void getPercent() {
        assertEquals(20, tax1.getPercent());
    }

    @Test
    public void getName() {
        assertEquals("VAT", tax1.getName());
    }

    @Test
    public void priceHasTaxes() {
        assertEquals(1, price1.getTaxes().length);
    }

    @Test
    public void calculateValue() {
        assertEquals(20.0, tax1.calculateValue(price1), 0.0f);
    }
}