package model;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by maksym_govorischev on 14/03/14.
 */
@Data
public class User {
    private static final AtomicInteger countU = new AtomicInteger(3);

    /**
     * User Id. UNIQUE.
     * @return User Id.
     */
    final long userId;
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.userId = countU.incrementAndGet();
    }

    public User(String name, String email, long userId){
        this.name=name;
        this.email=email;
        this.userId = userId;
    }
}
