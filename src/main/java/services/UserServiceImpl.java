package services;

import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Override
    public User getUserByIdS(long userId) {
        /**
         * Gets user by its id.
         * @return User.
         */
        return userDAO.getUById(userId);
    }

    @Override
    public User getUserByEmail(String email){
        /**
         * Gets user by its email. Email is strictly matched.
         * @return User.
         */
        return userDAO.getUByEmail(email);
    }
    @Override
    public List<User> getUsersByNameS(String name, int pageSize, int pageNum) {
        /**
         * Get list of users by matching name. Name is matched using 'contains' approach.
         * In case nothing was found, empty list is returned.
         * @param name Users name or it's part.
         * @param pageSize Pagination param. Number of users to return on a page.
         * @param pageNum Pagination param. Number of the page to return. Starts from 1.
         * @return List of users.
         */
        return userDAO.getUsByName(name, pageSize,pageNum);
    }

    @Override
    public User createUserS(User user) {
        /**
         * Creates new user. User id should be auto-generated.
         * @param user User data.
         * @return Created User object.
         */
        return userDAO.createU(user);
    }

    @Override
    public User updateUserS(User user) {
        /**
         * Updates user using given data.
         * @param user User data for update. Should have id set.
         * @return Updated User object.
         */
        return userDAO.updateU(user);
    }

    @Override
    public boolean deleteUserS(long userId) {
        /**
         * Deletes user by its id.
         * @param userId User id.
         * @return Flag that shows whether user has been deleted.
         */
        return userDAO.deleteU(userId);
    }
}
