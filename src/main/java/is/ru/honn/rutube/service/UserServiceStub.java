package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import java.util.*;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class UserServiceStub implements UserService{

    /**
     * A list of RuTube users.
     */
    List<User> users = new ArrayList<>();

    /**
     * Adds a user to the list of users.
     * @param user The user to be added to the list of users.
     * @return The ID of the user that was added.
     * @throws ServiceException if the userId already exists.
     */
    @Override
    public int addUser(User user) throws ServiceException {
        int id = user.getUserId();

        for(int i = 0; i < users.size();i++){
            if(users.get(i).getUserId() == user.getUserId()){
                throw new ServiceException("Adding user failed");
            }
        }
        users.add(user);
        return id;
    }

    /**
     * Gets a list of all users.
     * @return The list of all users.
     */
    @Override
    public List<User> getUsers() {
        return users;
    }


    /**
     * Gets a single user by his ID.
     * @param userId The ID of the requested user.
     * @return The requested user or null if he doesn't exist.
     */
    @Override
    public User getUserById(int userId) {
        for(int i = 0; i < users.size();i++){
            if(users.get(i).getUserId() == userId){
                return users.get(i);
            }
        }
        return null;
    }
}
