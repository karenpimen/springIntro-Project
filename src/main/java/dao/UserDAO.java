package dao;

import data.DataSource;
import model.*;
import java.util.*;

public class UserDAO {
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    public User getUById(long userId) {
        return dataSource.userMap.get("user: "+userId);
    }

    public User getUByEmail(String email){
        for(Map.Entry<String,User> entry: dataSource.userMap.entrySet()){
            if(entry.getValue().getEmail().equals(email))
                return entry.getValue();
        }
        return null;
    }

    public List<User> getUsByName(String name, int pageSize, int pageNum) {
        List <User> users = new ArrayList<User>();

        for(Map.Entry<String,User> entry :dataSource.userMap.entrySet()){
            if(entry.getValue().getName().contains(name)){
                users.add(entry.getValue());
            }
        }
        return users;
    }

    public User createU(User user) {
        dataSource.userMap.put("user: "+user.getUserId(), user);
        return user;
    }

    public User updateU(User user) {
        return dataSource.userMap.replace("user: "+user.getUserId(), user);
    }

    public boolean deleteU(long userId) {
        return dataSource.userMap.remove("user: "+userId)!= null;
    }
}
