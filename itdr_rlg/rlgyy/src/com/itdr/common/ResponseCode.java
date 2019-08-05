package com.itdr.common;

public class ResponseCode <T> {
    private  Integer status;
    private  T data;
    private   String mag;

    public Integer getStats() {
        return status;
    }

    public void setStats(Integer stats) {
        this.status = stats;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }
    //成功时只返回状态码和数据，失败时返回状态码和信息


    @Override
    public String toString() {
        return "ResponseCode{" +
                "stats=" + status +
                ", data=" + data +
                ", mag='" + mag + '\'' +
                '}';
    }
}
