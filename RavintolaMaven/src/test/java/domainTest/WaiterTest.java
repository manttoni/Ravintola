/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainTest;

import domain.Customer;
import domain.Table;
import domain.Waiter;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Anttoni
 */
public class WaiterTest {
    
    Waiter waiter;
    Customer c;
    
    public WaiterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        waiter = new Waiter("waiter", "waiter");
        c = new Customer(1);
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void orderinLisaysToimii(){
        Customer c = new Customer(1);
        waiter.addOrderToCustomer(c, 1);
        assertTrue(!c.getOrders().isEmpty());
    }
    
    @Test
    public void copyMetodiPalauttaaOikein(){
        Table t = new Table(1);
        t.addCustomer(c);
        Customer toinen = new Customer(2);
        t.addCustomer(toinen);
        List<Customer> asiakkaat = waiter.getCustomersCopy(t);
        assertTrue(asiakkaat.size() == 2);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
