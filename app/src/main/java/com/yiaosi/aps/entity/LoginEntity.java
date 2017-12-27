package com.yiaosi.aps.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-11-17.
 */

public class LoginEntity implements Serializable {

    /**
     * Authorization : IosPlanToken eyJhbGciOiJIUzUxMiJ9.eyJjb21wYW55VXVpZCI6WyLlub_lt57kur_mvrPmlq_ova_ku7bogqHku73mnInpmZDlhazlj7giXSwicm9sZXMiOlt7ImF1dGhvcml0eSI6IlVzZXJBZG1pbiJ9XSwic3ViIjoiZjNiODZiMjBkNTdjMTFlNzYzNTMwYjc3NDIxYmIyOTciLCJpc3MiOiIxMzYwMDAwMDAwMCIsImF1ZCI6IlE2RWh0ZDlhdnBWNWhtODk3MEN5aVNYeUVBUmN2emZHIiwiZXhwIjoxNTEzMzA3NjYyLCJuYmYiOjE1MTI3MDI4NjJ9.PkflMMDYOEVnicJGhViwcbRM6wEA6KNWwJj6esw0cmkYUHqZOt2TA7ZlT4bIytls6uzEEMCbBlYNJ4x2sEa1Bg
     * companyName : [广州亿澳斯软件股份有限公司]
     * userUuid : f3b86b20d57c11e763530b77421bb297
     * companyUuid : [广州亿澳斯软件股份有限公司]
     * username : 13600000000
     */

    private String Authorization;
    private String companyName;
    private String userUuid;
    private String companyUuid;
    private String username;

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String Authorization) {
        this.Authorization = Authorization;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
