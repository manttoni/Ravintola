package domainTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Customer;
import domain.Table;
import java.util.ArrayList;
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
public class TableTest {

    Table table;
    Customer c;

    public TableTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        table = new Table(1);
        c = new Customer(1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void customerinLisaysTableen() {
        table.addCustomer(c);
        assertTrue(!table.getCustomers().isEmpty());
    }

    @Test
    public void customerinCheckOut() {
        table.addCustomer(c);
        table.checkOutCustomer(c);
        assertTrue(table.getCustomers().isEmpty());
    }
    
    @Test
    public void customerLoytyyIDlla(){
        table.addCustomer(c);
        assertTrue(table.getCustomerWithID(1).equals(c));
    }
    
    @Test
    public void generoiVapaanID(){
        table.addCustomer(c);
        Customer c1 = new Customer(2);
        table.addCustomer(c1);
        Customer c2 = new Customer(4);
        table.addCustomer(c2);
        Customer uusi = new Customer(table.getNewCustomerID());
        assertTrue(uusi.getID() == 4);
    }
    
    @Test
    public void tablelleAsiakkaidenSettaaminen(){
        List<Customer> lista = new ArrayList<>();
        lista.add(new Customer(1));
        lista.add(new Customer(2));
        table.setCustomers(lista);
        assertTrue(table.getCustomers().size() == 2);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
