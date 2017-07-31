package com.yiaosi.aps.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-07-19.
 */

public class AvatarNickNameEntity implements Serializable {
    private String userId; //环信ID
    private String avatar; // 头像
    private String nickName; //昵称

    public AvatarNickNameEntity(String userId, String avatar, String nickName) {
        this.userId = userId;
        this.avatar = avatar;
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
