package my.study.durtimeblog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 公共返回对象
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RespTable {

	private long code;
	private String msg;
	private long count;
	private Object data;

	/**
	 * 功能描述: 成功返回结果
	 *
	 */
	public static RespTable success(int count,Object obj){
		return new RespTable(RespBeanEnum.TABLESUCCESS.getCode(), RespBeanEnum.TABLESUCCESS.getMessage(),count,obj);
	}

	/**
	 * 功能描述: 失败返回结果
	 *
	 */
	public static RespTable error(RespBeanEnum respBeanEnum, Object obj){
		return new RespTable(respBeanEnum.getCode(),respBeanEnum.getMessage(),0,obj);
	}

}