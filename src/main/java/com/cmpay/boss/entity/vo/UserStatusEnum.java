package com.cmpay.boss.entity.vo;

public enum UserStatusEnum {

                            /*
                             * 用户状态
                             * S:正常
                             * F:冻结（不可登入）
                             * D:删除
                             */
                            S("S", "0"), F("F", "1"), D("D", "9");
    private String statusCode;
    private String statusNum;

    /**
     * @param statusCode
     * @param statusNum
     */
    private UserStatusEnum(String statusCode, String statusNum) {
        this.statusCode = statusCode;
        this.statusNum = statusNum;
    }

    /**
     * Getter method for property <tt>statusCode</tt>.
     * 
     * @return property value of statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Getter method for property <tt>statusNum</tt>.
     * 
     * @return property value of statusNum
     */
    public String getStatusNum() {
        return statusNum;
    }

    /**
     * Setter method for property <tt>statusCode</tt>.
     * 
     * @param statusCode value to be assigned to property statusCode
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Setter method for property <tt>statusNum</tt>.
     * 
     * @param statusNum value to be assigned to property statusNum
     */
    public void setStatusNum(String statusNum) {
        this.statusNum = statusNum;
    }

}
