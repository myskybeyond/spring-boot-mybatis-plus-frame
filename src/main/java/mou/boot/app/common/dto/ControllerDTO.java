package mou.boot.app.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mou.boot.app.common.enums.ResultEnum;

import java.io.Serializable;
import java.util.Collection;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2021/3/4 13:59
 * @email: myskybeyond@163.com
 */
public class ControllerDTO<T> implements Serializable {
    private String message;
    private int rtn;
    private int total;
    private Long startTime;
    private Long endTime;
    private T result;

    public ControllerDTO() {
        this.setStartTime(System.currentTimeMillis());
    }

    public ControllerDTO(ResultEnum actionResultEnum) {
        this.rtn = actionResultEnum.getCode();
        this.message = actionResultEnum.getDesc();
        this.setStartTime(System.currentTimeMillis());
    }

    public ControllerDTO(int code, String message) {
        this.rtn = code;
        this.message = message;
        this.setStartTime(System.currentTimeMillis());
    }

    public ControllerDTO(ResultEnum actionResultEnum, T data) {
        this.rtn = actionResultEnum.getCode();
        this.message = actionResultEnum.getDesc();
        this.result = data;
        this.setStartTime(System.currentTimeMillis());
    }

    public ControllerDTO(T t) {
        this.success(t);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRtn() {
        return this.rtn;
    }

    public void setRtn(int rtn) {
        this.rtn = rtn;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void success(T result) {
        this.setMessage(ResultEnum.OK.getDesc());
        this.setRtn(ResultEnum.OK.getCode());
        this.setResult(result);
        if (result instanceof Collection) {
            this.setTotal(((Collection)result).size());
        }

    }

    public void fail(String message, int rtn) {
        this.setMessage(message);
        this.setRtn(rtn);
        this.setResult((T) null);
    }

    public void fail(String message) {
        this.setMessage(message);
        this.setRtn(-1);
        this.setTotal(-1);
        this.setResult((T) null);
    }

    public void onAuthorize() {
        this.setMessage("您没有执行该操作权限");
        this.setRtn(501);
        this.setTotal(-1);
        this.setResult((T) null);
    }

    public Double getResponseTime() {
        Double t = null;
        if (this.getStartTime() != null && this.getEndTime() != null) {
            t = (double)(this.getEndTime() - this.getStartTime()) / 1000.0D;
        }

        return t;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
        this.setEndTime(System.currentTimeMillis());
    }
}

