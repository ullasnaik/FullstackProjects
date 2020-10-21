package app.players.favouriteservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {
    @Id
    private String pid;
    private String name;
    private String fullName;
    private String userId;

    public Player(String pid,String name, String email,String userId) {
        this.pid=pid;
        this.name = name;
        this.fullName = email;
        this.userId=userId;
    }

    public Player() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

