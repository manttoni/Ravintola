package daoTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UsersInFile;
import domain.User;
import domain.Waiter;
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
public class UsersInFileTest {

    UsersInFile users;

    public UsersInFileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        users = new UsersInFile();
    }

    @Test
    public void userienLukeminenToimii() throws IOException {
        List<User> lista;
        users.readUsersFromFile();
        lista = users.getUsers();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void userinLisaysToimii() throws IOException{
        String file = "src/test/java/daoTest/usertest.txt";
        
        
        Waiter newUser = new Waiter("testi", "testi");
        UsersInFile userWriter = new UsersInFile(file);
        userWriter.addUser(newUser);
        userWriter.writeUsersToFile();
        
        UsersInFile toinenLukija = new UsersInFile(file);
        toinenLukija.readUsersFromFile();
        
        File txt = new File(file);
        
        assertTrue(toinenLukija.getUsers().get(0).getUsername().equals("testi"));
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
