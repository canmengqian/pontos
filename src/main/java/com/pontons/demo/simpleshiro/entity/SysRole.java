package com.pontons.demo.simpleshiro.entity;
import java.util.Date;
import org.beetl.sql.annotation.entity.*;
/*
* 系统角色表
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_role")
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

	public SysRole() {
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
	* 角色名称
	*@return
	*/
	public String getRoleName(){
		return  roleName;
	}
	/**
	* 角色名称
	*@param  roleName
	*/
	public void setRoleName(String roleName ){
		this.roleName = roleName;
	}
	/**
	* 角色是否生效
	*@return
	*/
	public Integer getisEffect(){
		return  isEffect;
	}
	/**
	* 角色是否生效
	*@param  isEffect
	*/
	public void setisEffect(Integer isEffect ){
		this.isEffect = isEffect;
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
