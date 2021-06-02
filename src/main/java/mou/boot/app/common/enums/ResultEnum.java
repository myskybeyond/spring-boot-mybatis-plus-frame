package mou.boot.app.common.enums;

public enum ResultEnum {
    OK(200, "成功"),
    BAD_PARAM_REQUEST(802000, "参数错误请求"),
    INTERNAL_ERROR(802500, "系统错误，请联系管理员"),
    BAD_REQUEST(400, "错误请求"),
    FORBIDDEN(403, "服务拒绝执行"),
    NOT_SUPPORTED(505, "非法连接"),
    PAGE_NOT_FOUND(404, "页面未找到"),
    UNKNOWN(-1, "未知错误"),
    FAILE(9999, "系统错误"),
    LOGIN_FALL(9997, "用户名或密码错误"),
    THIRD_PARTY_FAILE(9000, "第三方接口错误"),
    DATA_NO_EXISTS(9995, "数据记录不存在"),
    REQUEST_PARAM_ERROR(802601, "请求参数错误"),
    REDIS_ERROR(802602, "redis操作错误"),
    ERROR_DB(502, "数据库错误");

    private Integer code;
    private String desc;

    private ResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getStrCode() {
        return this.code.toString();
    }
}
