/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RavintolaDomain.Customer;
import RavintolaDomain.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        c = new Customer(1, lista);
        
        //c on tilannu ranskalaiset ja makkaran
    }
    
    @Test
    public void tilauksetOikein(){
        List<Order> o = c.getOrders();
        Order ranet = new Order(1, "ranskalaiset", 2);
        Order makkara = new Order(2, "makkara", 2);
        assertTrue(o.get(0).toString().equals(ranet.toString()) && o.get(1).toString().equals(makkara.toString()));
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
