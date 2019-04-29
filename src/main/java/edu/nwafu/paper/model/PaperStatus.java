package edu.nwafu.paper.model;

/**
 * @author TinChiWay
 * @data 2018/5/14
 */
public enum PaperStatus {
    UNSUBMIT(0, "未提交审核"),
    APPROVED(1, "审核通过"),
    SUBMITFORREVIEW(2, "提交待审核"),
    AUDITNOTPASSED(3, "审核不通过");


    private int value;
    private String name;

    PaperStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String getName(int value) {
        for (PaperStatus status : PaperStatus.values()) {
            if (status.value == value) {
                return status.name;
            }
        }
        return "状态信息错误，请联系管理员";
    }

}
