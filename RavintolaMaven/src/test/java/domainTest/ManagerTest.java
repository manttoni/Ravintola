/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainTest;

import domain.Manager;
import java.io.IOException;
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
public class ManagerTest {

    String testfile;

    public ManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testfile = "src/test/java/domainTest/menutest.txt";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void menustaPoistaminenToimii() throws IOException {
        Manager manager = new Manager("testi", "testi");
        for (int i = 0; i < manager.getMenu().size(); i++) {

            manager.removeFromMenu(i);
        }
        assertTrue(!manager.getMenu().isEmpty());
        //tämä ei näköjään onneksi poista itse tiedostosta, koska se tapahtuu vasta logatessa ulos
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
