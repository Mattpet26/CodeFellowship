package com.petersen.CodeFellowship.controllers;

import com.petersen.CodeFellowship.models.post.Post;
import com.petersen.CodeFellowship.models.post.PostRepository;
import com.petersen.CodeFellowship.models.user.ApplicationUser;
import com.petersen.CodeFellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
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
    public RedirectView followUser(Principal principal, Long id) {
        ApplicationUser userToFollow = applicationUserRepository.getOne(id);
        ApplicationUser follower = applicationUserRepository.findByUsername(principal.getName());

        userToFollow.getFollower(follower);
        follower.follow(userToFollow);

        applicationUserRepository.save(userToFollow);
        applicationUserRepository.save(follower);

        System.out.println("following a new user!" + userToFollow.getUsername());

        return new RedirectView("/user/" + userToFollow.getUsername()); // get the username not the id
    }
    @PostMapping("/unfollow")
    public RedirectView unfollowUser(Principal principal, Long id) {
        ApplicationUser userToUnfollow = applicationUserRepository.getOne(id);
        ApplicationUser follower = applicationUserRepository.findByUsername(principal.getName());

        userToUnfollow.removeFollower(follower);
        follower.removeFollow(userToUnfollow);

        applicationUserRepository.save(userToUnfollow);
        applicationUserRepository.save(follower);

        System.out.println("You unfollowed a user!" + userToUnfollow.getUsername());

        return new RedirectView("/user/" + userToUnfollow.getUsername());
    }
    @GetMapping("/feed")
    public String renderFeed(Model m, Principal principal) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        m.addAttribute("user", user);
        m.addAttribute("principal", principal);
        return "feed";
    }
}
