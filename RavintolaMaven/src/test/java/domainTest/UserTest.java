package domainTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UsersInFile;
import domain.User;
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
public class UserTest {

    User user;
    UsersInFile users;
    List<User> listaUsereista;
    String testilista;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        testilista = "src/test/java/domainTest/testiuserlista.txt";
        users = new UsersInFile(testilista);
        users.readUsersFromFile();
        listaUsereista = users.getUsers();
        user = listaUsereista.get(0);
        user.setUsersInFileForTest(users);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void olematontaUseriaEiLoydy() throws IOException {
        assertTrue(!users.isUser("olematon"));
    }
    
    @Test
    public void passwordinVaihtoToimii() throws IOException{
        user.changePassword("uusi salasana");
        assertTrue(user.getPassword().equals("uusi salasana"));
    }
    
    @Test
    public void userTietaaMenun(){
        assertTrue(!user.getMenu().isEmpty());
    }
    
    @Test
    public void userTietaaPoydat(){
        assertTrue(!user.getTables().isEmpty());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
