package com.yiaosi.aps.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-12-08.
 */

public class CompanyMemberEntity implements Serializable {

    /**
     * status : 200
     * msg : success
     * result : {"pageInfo":{"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"total":15,"pages":3,"list":[{"userUuid":"f3b86b20d57c11e763530b77421bb297","username":"13600000000","nickname":"Eric","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13600000000","wechatId":null,"wechatName":null,"registDate":1512011830000,"remark":"nothing","isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":28,"userUuid":null,"companyUuid":null,"rolecode":3,"rolename":"UserAdmin","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"a1e11720d63a11e78cfdf74b47ec9736","username":"13700000000","nickname":"13700000000","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13700000000","wechatId":null,"wechatName":null,"registDate":1512093297000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":31,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"22976b20d63c11e78cfdf74b47ec9736","username":"13822544511","nickname":"13822544511","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13822544511","wechatId":null,"wechatName":null,"registDate":1512093942000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":32,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"a4d2a4e0d8c311e7246d68640b9c5628","username":"13678912345","nickname":"13678912345","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13678912345","wechatId":null,"wechatName":null,"registDate":1512372045000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":33,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"6dd0a400d95f11e7f06c88c42fbe0e5a","username":"13822544566","nickname":"13822544566","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13822544566","wechatId":null,"wechatName":null,"registDate":1512438955000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":34,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":5,"navigatepageNums":[1,2,3],"navigateFirstPage":1,"navigateLastPage":3,"lastPage":3,"firstPage":1}}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * pageInfo : {"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"total":15,"pages":3,"list":[{"userUuid":"f3b86b20d57c11e763530b77421bb297","username":"13600000000","nickname":"Eric","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13600000000","wechatId":null,"wechatName":null,"registDate":1512011830000,"remark":"nothing","isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":28,"userUuid":null,"companyUuid":null,"rolecode":3,"rolename":"UserAdmin","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"a1e11720d63a11e78cfdf74b47ec9736","username":"13700000000","nickname":"13700000000","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13700000000","wechatId":null,"wechatName":null,"registDate":1512093297000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":31,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"22976b20d63c11e78cfdf74b47ec9736","username":"13822544511","nickname":"13822544511","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13822544511","wechatId":null,"wechatName":null,"registDate":1512093942000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":32,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"a4d2a4e0d8c311e7246d68640b9c5628","username":"13678912345","nickname":"13678912345","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13678912345","wechatId":null,"wechatName":null,"registDate":1512372045000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":33,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"6dd0a400d95f11e7f06c88c42fbe0e5a","username":"13822544566","nickname":"13822544566","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13822544566","wechatId":null,"wechatName":null,"registDate":1512438955000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":34,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":5,"navigatepageNums":[1,2,3],"navigateFirstPage":1,"navigateLastPage":3,"lastPage":3,"firstPage":1}
         */

        private PageInfoBean pageInfo;

        public PageInfoBean getPageInfo() {
            return pageInfo;
        }

        public void setPageInfo(PageInfoBean pageInfo) {
            this.pageInfo = pageInfo;
        }

        public static class PageInfoBean {
            /**
             * pageNum : 1
             * pageSize : 5
             * size : 5
             * startRow : 1
             * endRow : 5
             * total : 15
             * pages : 3
             * list : [{"userUuid":"f3b86b20d57c11e763530b77421bb297","username":"13600000000","nickname":"Eric","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13600000000","wechatId":null,"wechatName":null,"registDate":1512011830000,"remark":"nothing","isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":28,"userUuid":null,"companyUuid":null,"rolecode":3,"rolename":"UserAdmin","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"a1e11720d63a11e78cfdf74b47ec9736","username":"13700000000","nickname":"13700000000","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13700000000","wechatId":null,"wechatName":null,"registDate":1512093297000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":31,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"22976b20d63c11e78cfdf74b47ec9736","username":"13822544511","nickname":"13822544511","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13822544511","wechatId":null,"wechatName":null,"registDate":1512093942000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":32,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"a4d2a4e0d8c311e7246d68640b9c5628","username":"13678912345","nickname":"13678912345","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13678912345","wechatId":null,"wechatName":null,"registDate":1512372045000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":33,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]},{"userUuid":"6dd0a400d95f11e7f06c88c42fbe0e5a","username":"13822544566","nickname":"13822544566","password":"Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG","phone":"13822544566","wechatId":null,"wechatName":null,"registDate":1512438955000,"remark":null,"isDeleteUser":false,"companiesList":[{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}],"usersCompaniesRolesList":[{"userCompanyId":34,"userUuid":null,"companyUuid":null,"rolecode":7,"rolename":"CompanyUser","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]}]
             * prePage : 0
             * nextPage : 2
             * isFirstPage : true
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : true
             * navigatePages : 5
             * navigatepageNums : [1,2,3]
             * navigateFirstPage : 1
             * navigateLastPage : 3
             * lastPage : 3
             * firstPage : 1
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private int lastPage;
            private int firstPage;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * userUuid : f3b86b20d57c11e763530b77421bb297
                 * username : 13600000000
                 * nickname : Eric
                 * password : Q6Ehtd9avpV5hm8970CyiSXyEARcvzfG
                 * phone : 13600000000
                 * wechatId : null
                 * wechatName : null
                 * registDate : 1512011830000
                 * remark : nothing
                 * isDeleteUser : false
                 * companiesList : [{"companyUuid":"03925a70d58111e763530b77421bb297","parentCompanyId":null,"companyName":"广州亿澳斯软件股份有限公司","companyNo":"w3e5r2346545wer1d6","registerUser":"f3b86b20d57c11e763530b77421bb297","registerDate":1512013575000,"description":"Wrote nothing","serverIp":null,"isDeleteCompany":false}]
                 * usersCompaniesRolesList : [{"userCompanyId":28,"userUuid":null,"companyUuid":null,"rolecode":3,"rolename":"UserAdmin","apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]
                 */

                private String userUuid;
                private String username;
                private String nickname;
                private String password;
                private String phone;
                private Object wechatId;
                private Object wechatName;
                private long registDate;
                private String remark;
                private boolean isDeleteUser;
                private List<CompaniesListBean> companiesList;
                private List<UsersCompaniesRolesListBean> usersCompaniesRolesList;

                public String getUserUuid() {
                    return userUuid;
                }

                public void setUserUuid(String userUuid) {
                    this.userUuid = userUuid;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public Object getWechatId() {
                    return wechatId;
                }

                public void setWechatId(Object wechatId) {
                    this.wechatId = wechatId;
                }

                public Object getWechatName() {
                    return wechatName;
                }

                public void setWechatName(Object wechatName) {
                    this.wechatName = wechatName;
                }

                public long getRegistDate() {
                    return registDate;
                }

                public void setRegistDate(long registDate) {
                    this.registDate = registDate;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public boolean isIsDeleteUser() {
                    return isDeleteUser;
                }

                public void setIsDeleteUser(boolean isDeleteUser) {
                    this.isDeleteUser = isDeleteUser;
                }

                public List<CompaniesListBean> getCompaniesList() {
                    return companiesList;
                }

                public void setCompaniesList(List<CompaniesListBean> companiesList) {
                    this.companiesList = companiesList;
                }

                public List<UsersCompaniesRolesListBean> getUsersCompaniesRolesList() {
                    return usersCompaniesRolesList;
                }

                public void setUsersCompaniesRolesList(List<UsersCompaniesRolesListBean> usersCompaniesRolesList) {
                    this.usersCompaniesRolesList = usersCompaniesRolesList;
                }

                public static class CompaniesListBean {
                    /**
                     * companyUuid : 03925a70d58111e763530b77421bb297
                     * parentCompanyId : null
                     * companyName : 广州亿澳斯软件股份有限公司
                     * companyNo : w3e5r2346545wer1d6
                     * registerUser : f3b86b20d57c11e763530b77421bb297
                     * registerDate : 1512013575000
                     * description : Wrote nothing
                     * serverIp : null
                     * isDeleteCompany : false
                     */

                    private String companyUuid;
                    private Object parentCompanyId;
                    private String companyName;
                    private String companyNo;
                    private String registerUser;
                    private long registerDate;
                    private String description;
                    private Object serverIp;
                    private boolean isDeleteCompany;

                    public String getCompanyUuid() {
                        return companyUuid;
                    }

                    public void setCompanyUuid(String companyUuid) {
                        this.companyUuid = companyUuid;
                    }

                    public Object getParentCompanyId() {
                        return parentCompanyId;
                    }

                    public void setParentCompanyId(Object parentCompanyId) {
                        this.parentCompanyId = parentCompanyId;
                    }

                    public String getCompanyName() {
                        return companyName;
                    }

                    public void setCompanyName(String companyName) {
                        this.companyName = companyName;
                    }

                    public String getCompanyNo() {
                        return companyNo;
                    }

                    public void setCompanyNo(String companyNo) {
                        this.companyNo = companyNo;
                    }

                    public String getRegisterUser() {
                        return registerUser;
                    }

                    public void setRegisterUser(String registerUser) {
                        this.registerUser = registerUser;
                    }

                    public long getRegisterDate() {
                        return registerDate;
                    }

                    public void setRegisterDate(long registerDate) {
                        this.registerDate = registerDate;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public Object getServerIp() {
                        return serverIp;
                    }

                    public void setServerIp(Object serverIp) {
                        this.serverIp = serverIp;
                    }

                    public boolean isIsDeleteCompany() {
                        return isDeleteCompany;
                    }

                    public void setIsDeleteCompany(boolean isDeleteCompany) {
                        this.isDeleteCompany = isDeleteCompany;
                    }
                }

                public static class UsersCompaniesRolesListBean {
                    /**
                     * userCompanyId : 28
                     * userUuid : null
                     * companyUuid : null
                     * rolecode : 3
                     * rolename : UserAdmin
                     * apsRoleName : null
                     * apsViewLine : null
                     * apsEditLine : null
                     */

                    private int userCompanyId;
                    private Object userUuid;
                    private Object companyUuid;
                    private int rolecode;
                    private String rolename;
                    private Object apsRoleName;
                    private Object apsViewLine;
                    private Object apsEditLine;

                    public int getUserCompanyId() {
                        return userCompanyId;
                    }

                    public void setUserCompanyId(int userCompanyId) {
                        this.userCompanyId = userCompanyId;
                    }

                    public Object getUserUuid() {
                        return userUuid;
                    }

                    public void setUserUuid(Object userUuid) {
                        this.userUuid = userUuid;
                    }

                    public Object getCompanyUuid() {
                        return companyUuid;
                    }

                    public void setCompanyUuid(Object companyUuid) {
                        this.companyUuid = companyUuid;
                    }

                    public int getRolecode() {
                        return rolecode;
                    }

                    public void setRolecode(int rolecode) {
                        this.rolecode = rolecode;
                    }

                    public String getRolename() {
                        return rolename;
                    }

                    public void setRolename(String rolename) {
                        this.rolename = rolename;
                    }

                    public Object getApsRoleName() {
                        return apsRoleName;
                    }

                    public void setApsRoleName(Object apsRoleName) {
                        this.apsRoleName = apsRoleName;
                    }

                    public Object getApsViewLine() {
                        return apsViewLine;
                    }

                    public void setApsViewLine(Object apsViewLine) {
                        this.apsViewLine = apsViewLine;
                    }

                    public Object getApsEditLine() {
                        return apsEditLine;
                    }

                    public void setApsEditLine(Object apsEditLine) {
                        this.apsEditLine = apsEditLine;
                    }
                }
            }
        }
    }
}
