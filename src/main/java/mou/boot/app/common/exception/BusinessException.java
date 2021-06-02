package mou.boot.app.common.exception;

import lombok.Data;
import mou.boot.app.common.dto.ControllerDTO;

@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 8882366904034518521L;
    private Integer code;

    private ControllerDTO controllerDTO = new ControllerDTO();

    public BusinessException(Integer code) {
        this.code = code;
        if (!"200".equals(code)) {
            controllerDTO.fail("发生错误，调用失败");
        } else if (!"0".equals(code)) {
            controllerDTO.fail("发生错误，调用失败");
        }
    }

    public BusinessException(String message) {
        this.code = code;
        controllerDTO.fail(message);
    }

    public BusinessException(Integer code, String message) {
        this.code = code;
        controllerDTO.fail(message);
        controllerDTO.setRtn(code);
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        controllerDTO.fail(message);
        controllerDTO.setRtn(code);
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return controllerDTO.getMessage();
    }

    public void setMessage(String message) {
        controllerDTO.fail(message);
    }

    public String toString() {
        return "code ..." + this.code;
    }
}
