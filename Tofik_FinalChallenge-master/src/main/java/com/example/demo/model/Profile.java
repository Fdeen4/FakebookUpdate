package com.example.demo.model;

import com.example.demo.model.auth.AppUser;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String profilepicture;
    private String coverpicture;
    private String birthDate;
    private String bio;

    @OneToMany(mappedBy = "profile")
    private Set<Interest> interests;

    @OneToMany(mappedBy = "profile")
    private Set<PreviousPost>posts;

    @OneToMany(mappedBy = "profile")
    private Set<Friend> friends;

    @OneToOne
    AppUser profileOwner;

    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;

    @OneToMany(mappedBy = "whoPosted")
    private Set<UserPost> post;


    public Profile() {
        this.interests = new HashSet<>();
        this.posts = new HashSet<>();
        this.friends = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public String getCoverpicture() {
        return coverpicture;
    }

    public void setCoverpicture(String coverpicture) {
        this.coverpicture = coverpicture;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Set<UserPost> getPost() {
        return post;
    }

    public void setPost(Set<UserPost> post) {
        this.post = post;
    }

    public Set<Interest> getInterests() {
        return interests;
    }

    public void setInterests(Set<Interest> interests) {
        this.interests = interests;
    }

    public Set<PreviousPost> getPosts() {
        return posts;
    }

    public void setPosts(Set<PreviousPost> posts) {
        this.posts = posts;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public AppUser getProfileOwner() {
        return profileOwner;
    }

    public void setProfileOwner(AppUser profileOwner) {
        this.profileOwner = profileOwner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addInterest(Interest interest){
        interests.add(interest);
    }

    public void addPost(PreviousPost previousPost){
        posts.add(previousPost);
    }

    public void addFriend(Friend friend){
        friends.add(friend);
    }

    public void removeFriend(Friend friend){
        friends.remove(friend);
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
