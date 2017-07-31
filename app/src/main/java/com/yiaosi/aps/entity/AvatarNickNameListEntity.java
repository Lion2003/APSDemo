package com.yiaosi.aps.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-07-19.
 */

public class AvatarNickNameListEntity implements Serializable {
    private List<AvatarNickNameEntity> avatarNickNameList;

    public List<AvatarNickNameEntity> getAvatarNickNameList() {
        return avatarNickNameList;
    }

    public void setAvatarNickNameList(List<AvatarNickNameEntity> avatarNickNameList) {
        this.avatarNickNameList = avatarNickNameList;
    }


}
