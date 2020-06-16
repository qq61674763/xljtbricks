package com.bricks.common.result;

/**
 * The enum Result code enum.
 *
 * @author xu
 * @date 2020.05.22
 */
public enum ResultCodeEnum {

    /**
     * Success result code enum.
     */
    succeed(true,20000,"成功"),
    /**
     * Unknown result code enum.
     */
    unknown(false,40000,"未知错误"),
    /**
     * Params error result code enum.
     */
    paramsError(false,40001,"参数错误，请校验参数"),
    /**
     * Need login result code enum.
     */
    needLogin(false,40002,"未登录或登录超时，请重新登录"),
    /**
     * Forbidden result code enum.
     */
    forbidden(false,40003,"没有权限访问，请联系管理员");

    /**
     * 是否成功
     * The Success.
     */
    private final Boolean success;
    /**
     * 状态码
     * The Code.
     */
    private final Integer code;
    /**
     * 状态码说明
     * The Msg.
     */
    private final String msg;

    ResultCodeEnum(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
