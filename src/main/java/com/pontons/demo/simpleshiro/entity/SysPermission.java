package com.pontons.demo.simpleshiro.entity;
import java.util.Date;
import org.beetl.sql.annotation.entity.*;
/*
* 系统权限
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_permission")
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

	public SysPermission() {
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
	* 权限名称
	*@return
	*/
	public String getPerName(){
		return  perName;
	}
	/**
	* 权限名称
	*@param  perName
	*/
	public void setPerName(String perName ){
		this.perName = perName;
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
	* 更新时间
	*@return
	*/
	public Date getUdate(){
		return  udate;
	}
	/**
	* 更新时间
	*@param  udate
	*/
	public void setUdate(Date udate ){
		this.udate = udate;
	}

}
