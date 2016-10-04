package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;


import java.util.*;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class UserServiceStub implements UserService{
    List<User> users = new ArrayList<>();

    //Pæling að beila á int id = user.getUserId();
    @Override
    public int addUser(User user) throws ServiceException {
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
        throw new ServiceException();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }


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
