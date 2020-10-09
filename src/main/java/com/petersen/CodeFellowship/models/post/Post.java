package com.petersen.CodeFellowship.models.post;

import com.petersen.CodeFellowship.models.user.ApplicationUser;
import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne
    public ApplicationUser applicationUser;
    public String body;
    public Date timeStamp;

    public Post(){}

    public Post(String body, Date timeStamp) {
        this.body = body;
        this.timeStamp = new Date(Calendar.getInstance().getTime().getTime());
    }
    public String toString(){
        return String.format("Blog post: %s, at %s", body, timeStamp);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
