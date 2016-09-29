package is.ru.honn.rutube.service;

import javax.management.ServiceNotFoundException;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson
 * @Date 26/09/2016
 */
public interface VideoService {
    Video getVideo(int videoId);
    List<Video> getVideosbyUser(List<User> users, int userId);
    int addVideo(List<User> users, Video video, int userId) throws ServiceNotFoundException;
}
