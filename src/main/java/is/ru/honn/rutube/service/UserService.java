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
    int addUser(User user) throws ServiceException;
    List<User> getUsers();
    User getUserById(int userId);
}
