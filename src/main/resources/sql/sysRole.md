
sample
===
* 注释

	select #{use("cols")} from sys_role  where  #{use("condition")}

cols
===
	ROLE_ID,ROLE_NAME,IS_EFFECT,CDATE,UDATE

updateSample
===
	
	ROLE_ID=#{roleId},ROLE_NAME=#{roleName},IS_EFFECT=#{isEffect},CDATE=#{cdate},UDATE=#{udate}

condition
===

	1 = 1  
	-- @if(!isEmpty(roleId)){
	 and ROLE_ID=#{roleId}
	-- @}
	-- @if(!isEmpty(roleName)){
	 and ROLE_NAME=#{roleName}
	-- @}
	-- @if(!isEmpty(isEffect)){
	 and IS_EFFECT=#{isEffect}
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
	"roleId":"ROLE_ID",
	"roleName":"ROLE_NAME",
	"isEffect":"IS_EFFECT",
	"cdate":"CDATE",
	"udate":"UDATE"
	}
