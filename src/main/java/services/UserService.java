package services;

import model.User;

import java.util.List;

public interface UserService {

    User getUserByIdS(long userId);

    User getUserByEmail(String email);
    List<User> getUsersByNameS(String name, int pageSize, int pageNum);

    User createUserS(User user);

    User updateUserS(User user);

    boolean deleteUserS(long userId);

}
