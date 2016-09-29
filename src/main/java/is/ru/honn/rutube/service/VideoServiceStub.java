package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;

import javax.management.ServiceNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson
 * @Date 26/09/2016
 */
public class VideoServiceStub implements VideoService{
    List<Video> videos = new ArrayList<>();

    @Override
    public Video getVideo(int videoId) {
        for(int i = 0; i < videos.size(); i++){
            if(videos.get(i).getVideoId() == videoId){
                return videos.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Video> getVideosbyUser(List<User> users, int userId) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserId() == userId){
                return users.get(i).getVideos();
            }
        }
        return null;
    }

    @Override
    public int addVideo(List<User> users, Video video, int userId) throws ServiceNotFoundException {
        int id = video.getVideoId();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserId() == userId){
                videos.add(video);
                return id;
            }
        }
        return -1;
    }
}
