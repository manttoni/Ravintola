/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoTest;

import dao.TablesInFile;
import domain.Table;
import java.io.File;
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
public class TablesInFileTest {
    
    String testifile;
    
    public TablesInFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testifile = "src/test/java/daoTest/tabletest.txt";
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ekassaTablessaOnAsiakas() throws IOException{
        TablesInFile tablereader = new TablesInFile(testifile);
        tablereader.readTablesFromFile();
        List<Table> lista = tablereader.getTables();
        assertTrue(!lista.get(0).getCustomers().isEmpty());
    }
    
    @Test
    public void tablenLisaysFileen() throws IOException{
        TablesInFile tablereader = new TablesInFile(testifile);
        File tesfil = new File(testifile);
        tablereader.readTablesFromFile();
        //tiedostosta on otettu talteen tiedot. tiedosto alustetaan, testataan, saako tiedot kirjoitettua oikein
        tablereader.writeTablesToFile();
        assertTrue(!tablereader.getTables().get(0).getCustomers().isEmpty());
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
