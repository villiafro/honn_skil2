package is.ru.honn.rutube.service;


import is.ru.honn.rutube.domain.User;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public interface UserService {
    /**
     * Adds a user to the list of users.
     * @param user The user to be added to users.
     * @return The ID of the user that was added.
     * @throws ServiceException if the userId already exists in users.
     */
    int addUser(User user) throws ServiceException;

    /**
     * Gets a list of all users.
     * @return The list of all users.
     */
    List<User> getUsers();

    /**
     * Gets a single user by his ID.
     * @param userId The ID of the requested user.
     * @return The requested user or null if he doesn't exist.
     */
    User getUserById(int userId);
}
