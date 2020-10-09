package com.petersen.CodeFellowship.models.user;

import com.petersen.CodeFellowship.models.post.Post;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String bio;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "follows",
            joinColumns = { @JoinColumn(name = "follower")},
            inverseJoinColumns = {@JoinColumn(name = "following")}
    )
    Set<ApplicationUser> following = new HashSet<>();

    @ManyToMany(mappedBy = "following")
    Set<ApplicationUser> followers = new HashSet<>();

    // this mapped by may need to change. It needs to match the sql database
    @OneToMany(mappedBy = "applicationUser", cascade = CascadeType.ALL)
    public List<Post> posts = new ArrayList<Post>();

    public ApplicationUser(String username, String password, String firstName, String lastName, Date dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    public ApplicationUser(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    public void removeFollower(ApplicationUser follower) {
        followers.remove(follower);
    }

    public void removeFollow(ApplicationUser userToUnfollow) {
        following.remove(userToUnfollow);
    }

    public void setFollowing(Set<ApplicationUser> following) {
        this.following = following;
    }

    public void setFollowers(Set<ApplicationUser> followers) {
        this.followers = followers;
    }

    public Set<ApplicationUser> getFollowers() {
        return followers;
    }

    public void follow(ApplicationUser userToFollow) {
        following.add(userToFollow);
    }

    public void getFollower(ApplicationUser follower) {
        followers.add(follower);
    }

    public Set<ApplicationUser> getFollowing() {
        return following;
    }

}
