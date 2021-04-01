package org.example.model;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/31 0:14
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * http 响应 json 数据, 前后统一约定的 json 格式
 *  {success: true, data: xxx}
 *  {success: false, code: xxx, message: xxx}
 */
@Getter
@Setter
@ToString
public class JSONResponse {

    // 业务是否成功
    private boolean success;
    // 业务操作的消息吗: 一般来说, 出现错误时的错误码才有意义, 给开发人员定位问题
    private String code;
    // 业务操作的失败消息: 给用户看的消息
    private String message;
    // 业务数据: 业务操作成功时, 给前端 ajax success 方法使用, 解析响应 json 数据, 渲染网页内容
    private Object data;

}
