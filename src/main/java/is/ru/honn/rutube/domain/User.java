package is.ru.honn.rutube.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class User {
    int userId;
    String firstName;
    String lastName;
    String email;
    String displayName;
    LocalDate birthDate;
    List<Video> videos;

    public User(int userId, String firstName, String lastName, String email, String displayName, String birthDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.displayName = displayName;
        this.birthDate = LocalDate.parse(birthDate);
        videos = new ArrayList<>();
    }

    public void setVideos(List<Video> videos){
        this.videos = videos;
    }

    public int getUserId(){
        return this.userId;
    }

    public List<Video> getVideos(){
        return videos;
    }
}
