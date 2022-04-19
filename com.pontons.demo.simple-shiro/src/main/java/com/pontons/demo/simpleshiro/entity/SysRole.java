package com.pontons.demo.simpleshiro.entity;
import java.util.Date;

import lombok.*;
import lombok.experimental.Accessors;
import org.beetl.sql.annotation.entity.*;
/*
* 系统角色表
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
@ToString
public class SysRole implements java.io.Serializable {
	/**
	 * 角色ID
	 */
	@AssignID
	private String roleId ;
	/**
	 * 角色名称
	 */
	private String roleName ;
	/**
	 * 角色是否生效
	 */
	private Integer isEffect ;
	/**
	 * 创建时间
	 */
	private Date cdate ;
	/**
	 * 修改时间
	 */
	private Date udate ;



}
