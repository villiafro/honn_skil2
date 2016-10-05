package is.ru.honn.rutube.observer;

import is.ru.honn.rutube.domain.User;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public interface Observer {
    public User notify(User user);
}
