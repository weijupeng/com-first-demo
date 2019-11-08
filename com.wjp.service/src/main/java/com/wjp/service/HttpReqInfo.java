package com.wjp.service;

/**
 * 请求的数据模型
 */
public class HttpReqInfo {
    private boolean header;
    private boolean file;
    private String param;
    private String value;
    private String fileName;
    private byte[] data;
    private String contentType = "text/plain";

    public boolean isHeader() {
        return header;
    }

    public boolean isFile() {
        return file;
    }

    public String getParam() {
        return param;
    }

    public String getValue() {
        return value;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getData() {
        return data;
    }

    private HttpReqInfo() {
    }

    /**
     * 普通参数
     *
     * @param param
     * @param value
     */
    public HttpReqInfo(String param, String value) {
        this.header = false;
        this.file = false;
        this.param = param;
        this.value = value;
    }

    /**
     * 文件参数
     *
     * @param param
     * @param fileName
     * @param data
     */
    public HttpReqInfo(String param, String fileName, byte[] data) {
        this.header = false;
        this.file = true;
        this.param = param;
        this.fileName = fileName;
        this.data = data;
    }

    public HttpReqInfo(String param, String fileName, String contentType, byte[] data) {
        this.header = false;
        this.file = true;
        this.param = param;
        this.fileName = fileName;
        this.data = data;
        this.contentType = contentType;
    }

    /**
     * 请求头参数
     *
     * @param param
     * @param value
     * @param header
     */
    public HttpReqInfo(String param, String value, boolean header) {
        this.header = header;
        this.file = false;
        this.param = param;
        this.value = value;
    }
}