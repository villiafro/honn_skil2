package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class VideoServiceStub implements VideoService{

    /**
     * An instance of the UserServiceStub to be
     * able to access the list of users.
     */
    UserServiceStub userServiceStub;

    /**
     * Sets the userServiceStub to a given UserService, to access the list of users
     * @param uss the given userService
     */
    public void setUserServiceStub(UserServiceStub uss){
        this.userServiceStub = uss;
    }

    /**
     * Gets a single video by its ID.
     * @param videoId The ID of the requested video.
     * @return The requested video or null if it doesn't exist.
     */
    @Override
    public Video getVideo(int videoId) {
        for(User user : userServiceStub.getUsers()) {
            for(Video video : user.getVideos()) {
                if (video.getVideoId() == videoId) {
                    return video;
                }
            }
        }
        return null;
    }

    /**
     * Gets a list of videos from a single user.
     * @param users A list of all users.
     * @param userId The ID of the user who's video list should be displayed.
     * @return The requested users list of videos or null if the user doesn´t exist.
     */
    @Override
    public List<Video> getVideosByUser(List<User> users, int userId) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserId() == userId){
                return users.get(i).getVideos();
            }
        }
        return null;
    }

    /**
     * Adds a video to the video list of a single user.
     * @param users A list of all users.
     * @param video The video to be added to the list of videos.
     * @param userId The ID of the user who's video list the video should be added to.
     * @return The ID of the added video.
     * @throws ServiceException if the user does not exist or if the video already exists.
     */
    @Override
    public int addVideo(List<User> users, Video video, int userId) throws ServiceException {
        if (getVideosByUser(users, userId) == null) {
            throw new ServiceException("Cannot find user");
        }
        else if(getVideo(video.getVideoId()) != null) {
            throw new ServiceException("Cannot add video");
        }

        userServiceStub.getUserById(userId).getVideos().add(video);
        return(video.getVideoId());
    }
}
