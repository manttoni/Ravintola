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
        user = new User("testaaja", "testaaja", "testaaja");
        users = new UsersInFile();
        users.readUsersFromFile();
        listaUsereista = users.getUsers();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void olematontaUseriaEiLoydy() {
        assertTrue(!users.isUser(user));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
