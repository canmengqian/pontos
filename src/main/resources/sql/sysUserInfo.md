
sample
===
* 注释

	select #{use("cols")} from sys_user_info  where  #{use("condition")}

cols
===
	USER_ID,USER_NAME,PASSWORD,CDATE,UDATE

updateSample
===
	
	USER_ID=#{userId},USER_NAME=#{userName},PASSWORD=#{password},CDATE=#{cdate},UDATE=#{udate}

condition
===

	1 = 1  
	-- @if(!isEmpty(userId)){
	 and USER_ID=#{userId}
	-- @}
	-- @if(!isEmpty(userName)){
	 and USER_NAME=#{userName}
	-- @}
	-- @if(!isEmpty(password)){
	 and PASSWORD=#{password}
	-- @}
	-- @if(!isEmpty(cdate)){
	 and CDATE=#{cdate}
	-- @}
	-- @if(!isEmpty(udate)){
	 and UDATE=#{udate}
	-- @}
	
jsonMap
===

    {
	"userId":"USER_ID",
	"userName":"USER_NAME",
	"password":"PASSWORD",
	"cdate":"CDATE",
	"udate":"UDATE"
	}
