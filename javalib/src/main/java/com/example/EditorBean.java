package com.example;

import java.io.Serializable;

/**
 * Created by lzb on 16/9/8.
 */
public class EditorBean implements Serializable {
    private String id= "";
    private String name;
    private String iconUrl;
    private String bgUrl;
    private String email;
    private String profile;
    private String postNewsCount;
    private String followCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getBgUrl() {
        return bgUrl;
    }

    public void setBgUrl(String bgUrl) {
        this.bgUrl = bgUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPostNewsCount() {
        return postNewsCount;
    }

    public void setPostNewsCount(String postNewsCount) {
        this.postNewsCount = postNewsCount;
    }

    public String getFollowCount() {
        return followCount;
    }

    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }
}
