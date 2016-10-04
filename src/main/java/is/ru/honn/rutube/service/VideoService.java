package is.ru.honn.rutube.service;


import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public interface VideoService {
    Video getVideo(int videoId);
    List<Video> getVideosByUser(List<User> users, int userId);
    int addVideo(List<User> users, Video video, int userId) throws ServiceException;
}
