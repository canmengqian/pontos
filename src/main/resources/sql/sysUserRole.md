
sample
===
* 注释

	select #{use("cols")} from sys_user_role  where  #{use("condition")}

cols
===
	USER_ID,ROLE_ID,CDATE,UDATE

updateSample
===
	
	USER_ID=#{userId},ROLE_ID=#{roleId},CDATE=#{cdate},UDATE=#{udate}

condition
===

	1 = 1  
	-- @if(!isEmpty(userId)){
	 and USER_ID=#{userId}
	-- @}
	-- @if(!isEmpty(roleId)){
	 and ROLE_ID=#{roleId}
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
	"roleId":"ROLE_ID",
	"cdate":"CDATE",
	"udate":"UDATE"
	}
