package com.pontons.demo.simpleshiro.entity;
import java.util.Date;
import org.beetl.sql.annotation.entity.*;
/*
* 用户信息表
* gen by beetlsql3 2022-04-16
*/

@Table(name="sys_user_info")
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

	public SysUserInfo() {
	}

	/**
	* 用户id
	*@return
	*/
	public String getUserId(){
		return  userId;
	}
	/**
	* 用户id
	*@param  userId
	*/
	public void setUserId(String userId ){
		this.userId = userId;
	}
	/**
	* 用户名
	*@return
	*/
	public String getUserName(){
		return  userName;
	}
	/**
	* 用户名
	*@param  userName
	*/
	public void setUserName(String userName ){
		this.userName = userName;
	}
	/**
	* 用户名密码
	*@return
	*/
	public String getPassword(){
		return  password;
	}
	/**
	* 用户名密码
	*@param  password
	*/
	public void setPassword(String password ){
		this.password = password;
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
