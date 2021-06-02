package mou.boot.app.common.exception;

/**
 * @description:第三方接口调用异常类
 * @author: JianTao Li
 * @time: 2021/3/24 11:20
 * @email: myskybeyond@163.com
 */
public class ApiException extends BusinessException{
    public ApiException(Integer code) {
        super(code);
    }

    public ApiException(){
        super("第三方接口调用发生异常");
    }
}
