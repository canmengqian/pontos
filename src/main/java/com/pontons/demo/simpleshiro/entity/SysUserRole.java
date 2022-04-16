package com.pontons.demo.simpleshiro.entity;
import java.util.Date;
import org.beetl.sql.annotation.entity.*;
/*
* 用户角色关系表
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_user_role")
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

	public SysUserRole() {
	}

	/**
	* 用户ID
	*@return
	*/
	public String getUserId(){
		return  userId;
	}
	/**
	* 用户ID
	*@param  userId
	*/
	public void setUserId(String userId ){
		this.userId = userId;
	}
	/**
	* 角色ID
	*@return
	*/
	public String getRoleId(){
		return  roleId;
	}
	/**
	* 角色ID
	*@param  roleId
	*/
	public void setRoleId(String roleId ){
		this.roleId = roleId;
	}
	public Date getCdate(){
		return  cdate;
	}
	public void setCdate(Date cdate ){
		this.cdate = cdate;
	}
	public Date getUdate(){
		return  udate;
	}
	public void setUdate(Date udate ){
		this.udate = udate;
	}

}
