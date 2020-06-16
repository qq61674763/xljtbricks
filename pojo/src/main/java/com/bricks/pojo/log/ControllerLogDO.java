package com.bricks.pojo.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Login log do.
 *
 * @author XU
 * @date 2020.05.29
 * @program bricks
 * @description todo
 * @create 2020 /5/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControllerLogDO {

    /**
     * The Ip.
     */
    private String ip;

    /**
     * The Params.
     */
    private String params;

    /**
     * The Uri.
     */
    private String uri;

    /**
     * The Id.
     */
    private String id;

    /**
     * The Spend time.
     */
    private Long spendTime;
}
