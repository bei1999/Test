package com.example;

import java.io.Serializable;

/**
 * Created by hp on 2016/8/11.
 */
public   class LatestNormalNewsListBean implements Serializable {
    private String id;
    private String shortcutType;
    private String shortcutImg;
    private String shortcutVideo;
    private String headline;
    private String type;
    private String category;
    /**
     * id : 3341544d
     * name : fced
     * iconUrl : null
     * bgUrl : null
     * email : fced
     * profile : null
     * postNewsCount : 0
     * followCount : 0
     */

    private EditorBean editor;
    private String publishTime;
    private String content;
    private String atlas;
    private String staticUrl;
    private String shareUrl;
    private String qrUrl;
    private String distanceVal;
    private String distanceKey;
    private String latitude;
    private String longitude;
    private String likeNum;
    private boolean top;
    private boolean isBrowse;

    public boolean isBrowse() {
        return isBrowse;
    }

    public void setIsBrowse(boolean isBrowse) {
        this.isBrowse = isBrowse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortcutType() {
        return shortcutType;
    }

    public void setShortcutType(String shortcutType) {
        this.shortcutType = shortcutType;
    }

    public String getShortcutImg() {
        return shortcutImg;
    }

    public void setShortcutImg(String shortcutImg) {
        this.shortcutImg = shortcutImg;
    }

    public String getShortcutVideo() {
        return shortcutVideo;
    }

    public void setShortcutVideo(String shortcutVideo) {
        this.shortcutVideo = shortcutVideo;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public EditorBean getEditor() {
        return editor;
    }

    public void setEditor(EditorBean editor) {
        this.editor = editor;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAtlas() {
        return atlas;
    }

    public void setAtlas(String atlas) {
        this.atlas = atlas;
    }

    public String getStaticUrl() {
        return staticUrl;
    }

    public void setStaticUrl(String staticUrl) {
        this.staticUrl = staticUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getQrUrl() {
        return qrUrl;
    }

    public void setQrUrl(String qrUrl) {
        this.qrUrl = qrUrl;
    }

    public String getDistanceVal() {
        return distanceVal;
    }

    public void setDistanceVal(String distanceVal) {
        this.distanceVal = distanceVal;
    }

    public String getDistanceKey() {
        return distanceKey;
    }

    public void setDistanceKey(String distanceKey) {
        this.distanceKey = distanceKey;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }


}
