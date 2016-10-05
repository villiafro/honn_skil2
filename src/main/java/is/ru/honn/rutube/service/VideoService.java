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

    /**
     * Gets a single video by its ID.
     * @param videoId The ID of the requested video.
     * @return The requested video or null if it doesn't exist.
     */
    Video getVideo(int videoId);

    /**
     * Gets a list of videos from a single user.
     * @param users A list of all users.
     * @param userId The ID of the user who's video list should be displayed.
     * @return The requested users list of videos or null if the user doesn´t exist.
     */
    List<Video> getVideosByUser(List<User> users, int userId);

    /**
     * Adds a video to the video list of a single user.
     * @param users A list of all users.
     * @param video The video to be added to the list of videos.
     * @param userId The ID of the user who's video list the video should be added to.
     * @return The ID of the added video.
     * @throws ServiceException if the user does not exist or if the video already exists.
     */
    int addVideo(List<User> users, Video video, int userId) throws ServiceException;
}
