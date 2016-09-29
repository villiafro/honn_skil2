package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

import javax.management.ServiceNotFoundException;
import java.util.*;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson
 * @Date 26/09/2016
 */
public class UserServiceStub implements UserService{
    List<User> users = new ArrayList<>();

    @Override
    public int addUser(User user) throws ServiceNotFoundException {
        int id = user.getUserId();
        boolean notInList = true;

        for(int i = 0; i < users.size();i++){
            if(users.get(i).getUserId() == user.getUserId()){
                notInList = false;
            }
        }
        if(notInList){
            users.add(user);
            return id;
        }
        return -1;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserById(int userid) {
        for(int i = 0; i < users.size();i++){
            if(users.get(i).getUserId() == userid){
                return users.get(i);
            }
        }
        return null;
    }
}
