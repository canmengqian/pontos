package com.pontons.demo.simpleshiro.entity;
import java.util.Date;

import lombok.*;
import lombok.experimental.Accessors;
import org.beetl.sql.annotation.entity.*;
/*
* 系统权限
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
@ToString
public class SysPermission implements java.io.Serializable {
	/**
	 * 权限ID
	 */
	private String permissionId ;
	/**
	 * 权限名称
	 */
	private String perName ;
	/**
	 * 创建时间
	 */
	private Date cdate ;
	/**
	 * 更新时间
	 */
	private Date udate ;


}
