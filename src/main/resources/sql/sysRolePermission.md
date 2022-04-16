
sample
===
* 注释

	select #{use("cols")} from sys_role_permission  where  #{use("condition")}

cols
===
	ROLE_ID,PERMISSION_ID,CDATE,UDATE

updateSample
===
	
	ROLE_ID=#{roleId},PERMISSION_ID=#{permissionId},CDATE=#{cdate},UDATE=#{udate}

condition
===

	1 = 1  
	-- @if(!isEmpty(roleId)){
	 and ROLE_ID=#{roleId}
	-- @}
	-- @if(!isEmpty(permissionId)){
	 and PERMISSION_ID=#{permissionId}
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
	"permissionId":"PERMISSION_ID",
	"cdate":"CDATE",
	"udate":"UDATE"
	}
