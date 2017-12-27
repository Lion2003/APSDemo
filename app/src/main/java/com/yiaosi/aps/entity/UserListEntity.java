package com.yiaosi.aps.entity;

import java.util.List;

/**
 * Created by Administrator on 2017-11-16.
 */

public class UserListEntity {
    /**
     * status : 200
     * msg : success
     * result : {"pageInfo":{"pageNum":1,"pageSize":5,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"userId":1,"userName":"admin","nickName":"admin","password":"123123","uuid":"1werwe","phone":"","wechatId":null,"wechatName":null,"registDate":null,"remark":null,"isUsed":false,"isDelete":false,"isVerify":false,"apsRoleName":null,"apsViewLine":null,"apsEditLine":null}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":5,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}}
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
         * pageInfo : {"pageNum":1,"pageSize":5,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"userId":1,"userName":"admin","nickName":"admin","password":"123123","uuid":"1werwe","phone":"","wechatId":null,"wechatName":null,"registDate":null,"remark":null,"isUsed":false,"isDelete":false,"isVerify":false,"apsRoleName":null,"apsViewLine":null,"apsEditLine":null}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":5,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
             * size : 1
             * startRow : 1
             * endRow : 1
             * total : 1
             * pages : 1
             * list : [{"userId":1,"userName":"admin","nickName":"admin","password":"123123","uuid":"1werwe","phone":"","wechatId":null,"wechatName":null,"registDate":null,"remark":null,"isUsed":false,"isDelete":false,"isVerify":false,"apsRoleName":null,"apsViewLine":null,"apsEditLine":null}]
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 5
             * navigatepageNums : [1]
             * navigateFirstPage : 1
             * navigateLastPage : 1
             * firstPage : 1
             * lastPage : 1
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
            private int firstPage;
            private int lastPage;
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

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
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
                 * userId : 1
                 * userName : admin
                 * nickName : admin
                 * password : 123123
                 * uuid : 1werwe
                 * phone :
                 * wechatId : null
                 * wechatName : null
                 * registDate : null
                 * remark : null
                 * isUsed : false
                 * isDelete : false
                 * isVerify : false
                 * apsRoleName : null
                 * apsViewLine : null
                 * apsEditLine : null
                 */

                private int userId;
                private String userName;
                private String nickName;
                private String password;
                private String uuid;
                private String phone;
                private Object wechatId;
                private Object wechatName;
                private Object registDate;
                private Object remark;
                private boolean isUsed;
                private boolean isDelete;
                private boolean isVerify;
                private Object apsRoleName;
                private Object apsViewLine;
                private Object apsEditLine;

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getUuid() {
                    return uuid;
                }

                public void setUuid(String uuid) {
                    this.uuid = uuid;
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

                public Object getRegistDate() {
                    return registDate;
                }

                public void setRegistDate(Object registDate) {
                    this.registDate = registDate;
                }

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
                    this.remark = remark;
                }

                public boolean isIsUsed() {
                    return isUsed;
                }

                public void setIsUsed(boolean isUsed) {
                    this.isUsed = isUsed;
                }

                public boolean isIsDelete() {
                    return isDelete;
                }

                public void setIsDelete(boolean isDelete) {
                    this.isDelete = isDelete;
                }

                public boolean isIsVerify() {
                    return isVerify;
                }

                public void setIsVerify(boolean isVerify) {
                    this.isVerify = isVerify;
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
