package com.cn.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author cn
 * @Date 2022/4/17
 */

/**
 * 用于数据的返回结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
	private long code;
	private String message;
	private Object data;

	/**
	 * 成功返回结果
	 * @param message
	 * @return
	 */
	public static RespBean success(String message){
		return new RespBean(200,message,null);
	}

	/**
	 * 成功返回结果
	 * @param message
	 * @param obj
	 * @return
	 */
	public static RespBean success(String message, Object obj){
		return new RespBean(200,message,obj);
	}

	/**
	 * 失败返回结果
	 * @param message
	 * @return
	 */
	public static RespBean error(String message){
		return new RespBean(500,message,null);
	}

	/**
	 * 失败返回结果
	 * @param message
	 * @param obj
	 * @return
	 */
	public static RespBean error(String message, Object obj){
		return new RespBean(500,message,obj);
	}
}