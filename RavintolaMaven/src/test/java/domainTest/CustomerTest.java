package domainTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Customer;
import domain.Order;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Anttoni
 */
public class CustomerTest {

    Customer c;

    public CustomerTest() {
    }

    @Before
    public void setUp() throws IOException {
        c = new Customer(11);
        c.addOrder(new Order(1, "ranskalaiset", 2));
        c.addOrder(new Order(2, "makkara", 2));

        //c on tilannu ranskalaiset ja makkaran
    }

    @Test
    public void tilauksetOikein() {
        assertTrue(c.getOrders().get(0).toString().equals("ranskalaiset * 2e") && c.getOrders().get(1).toString().equals("makkara * 2e"));
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
