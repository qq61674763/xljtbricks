package com.bricks.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * The type Result response.
 *
 * @author XU
 * @date 2020.05.22
 * @program bricks
 * @description todo
 * @create 2020 /5/22
 */
@Data
public class ResultResponse implements Serializable {

    private static final long serialVersionUID = -8998892670602954128L;

    /**
     * 返回代码
     * The Code.
     */
    private Integer code;
    /**
     * 是否成功
     * The Success.
     */
    private Boolean success;
    /**
     * 代码说明
     * The Message.
     */
    private String message;
    /**
     * 数据
     * The Data.
     */
    private Object data;

    public ResultResponse(ResultCodeEnum resultCodeEnum, Object data) {
        this.code = resultCodeEnum.getCode();
        this.success = resultCodeEnum.getSuccess();
        this.message = resultCodeEnum.getMsg();
        this.data = data;
    }
}
