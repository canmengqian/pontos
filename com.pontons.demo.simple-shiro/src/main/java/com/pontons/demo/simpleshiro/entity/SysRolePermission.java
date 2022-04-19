package com.pontons.demo.simpleshiro.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.beetl.sql.annotation.entity.*;
/*
* 系统角色权限表
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_role_permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class SysRolePermission implements java.io.Serializable {
	/**
	 * 角色ID
	 */
	private String roleId ;
	/**
	 * 权限ID
	 */
	private String permissionId ;
	/**
	 * 创建时间
	 */
	private Date cdate ;
	/**
	 * 修改时间
	 */
	private Date udate ;


}
