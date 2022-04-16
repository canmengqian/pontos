package com.pontons.demo.simpleshiro.entity;
import java.util.Date;
import org.beetl.sql.annotation.entity.*;
/*
* 系统角色权限表
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_role_permission")
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

	public SysRolePermission() {
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
	/**
	* 权限ID
	*@return
	*/
	public String getPermissionId(){
		return  permissionId;
	}
	/**
	* 权限ID
	*@param  permissionId
	*/
	public void setPermissionId(String permissionId ){
		this.permissionId = permissionId;
	}
	/**
	* 创建时间
	*@return
	*/
	public Date getCdate(){
		return  cdate;
	}
	/**
	* 创建时间
	*@param  cdate
	*/
	public void setCdate(Date cdate ){
		this.cdate = cdate;
	}
	/**
	* 修改时间
	*@return
	*/
	public Date getUdate(){
		return  udate;
	}
	/**
	* 修改时间
	*@param  udate
	*/
	public void setUdate(Date udate ){
		this.udate = udate;
	}

}
