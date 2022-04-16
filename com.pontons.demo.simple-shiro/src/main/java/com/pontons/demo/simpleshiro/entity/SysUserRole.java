package com.pontons.demo.simpleshiro.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.beetl.sql.annotation.entity.*;
/*
* 用户角色关系表
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class SysUserRole implements java.io.Serializable {
	/**
	 * 用户ID
	 */
	private String userId ;
	/**
	 * 角色ID
	 */
	private String roleId ;
	private Date cdate ;
	private Date udate ;

}
