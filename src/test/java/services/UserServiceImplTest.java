package services;

import dao.EventDAO;
import dao.UserDAO;
import model.Event;
import model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/test.xml")
class UserServiceImplTest {


    @Test
    void createUserSTest() {
        User u = new User("Jose Chavez", "jose@gmail.com");
        UserDAO userDaoMock = mock(UserDAO.class);
        when(userDaoMock.createU(u)).thenReturn(u);

        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.setUserDAO(userDaoMock);

        User newUser = userServiceImpl.createUserS(u);
        assertEquals(newUser,u);

    }
}