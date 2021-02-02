package com.myzone.demoutils.enums;

/**
 * @Author: zqy
 * @Date: 2020/1/16 15:40
 */
public enum ErrorCodeFile {

    /**
     * 异常以5开头
     * 系统级的错误码三位数字
     * 业务及的错误码四位数字
     */
    ERROR_UNKNOWN(5000, "未知异常"),
    ERROR_FILE_UPLOAD(5001,"上传文件失败"),
    ERROR_PIC_BASE64_EMPTY(5002,"base64图片不存在"),
    ERROR_PIC_URL_EMPTY(5003,"图片url不存在"),
    ERROR_PIC_FORMAT(5004,"图片格式不正确");

    private int code;
    private String msg;

    ErrorCodeFile(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public String print() {
        return this.getCode()+":"+this.getMsg();
    }

}
