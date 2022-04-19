package com.pontons.demo.simpleshiro.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.beetl.sql.annotation.entity.*;
/*
* 用户信息表
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class SysUserInfo implements java.io.Serializable {
	/**
	 * 用户id
	 */
	@AssignID
	private String userId ;
	/**
	 * 用户名
	 */
	private String userName ;
	/**
	 * 用户名密码
	 */
	private String password ;
	/**
	 * 创建时间
	 */
	private Date cdate ;
	/**
	 * 修改时间
	 */
	private Date udate ;


}
