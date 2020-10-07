package com.petersen.CodeFellowship.controllers;

import com.petersen.CodeFellowship.models.post.Post;
import com.petersen.CodeFellowship.models.post.PostRepository;
import com.petersen.CodeFellowship.models.user.ApplicationUser;
import com.petersen.CodeFellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/addPost")
    public RedirectView makeNewPost(String body, Date timeStamp, long id){
        Post newPost = new Post(body, timeStamp);
        ApplicationUser user = applicationUserRepository.getOne(id);

        newPost.applicationUser = user;
        postRepository.save(newPost);

        user.posts.add(newPost);
        applicationUserRepository.save(user);

        return new RedirectView("/user/" + user.getUsername());
    }
    @PostMapping("/follow")
    public RedirectView followPost(String username, long follower, long followee){
        Post followerPost = postRepository.findById(follower).get();

        Post followeePost = postRepository.findById(followee).get();

        followerPost.usersWhoFollowMe.add(followeePost); //usersWhoFollowMe
        followeePost.usersWhoIHaveFollowed.add(followerPost); //usersWhoIHaveFollowed

        postRepository.save(followerPost);
        postRepository.save(followeePost);

        return new RedirectView("/user/" + username);
    }
}
