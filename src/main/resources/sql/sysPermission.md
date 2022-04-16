
sample
===
* 注释

	select #{use("cols")} from sys_permission  where  #{use("condition")}

cols
===
	PERMISSION_ID,PER_NAME,CDATE,UDATE

updateSample
===
	
	PERMISSION_ID=#{permissionId},PER_NAME=#{perName},CDATE=#{cdate},UDATE=#{udate}

condition
===

	1 = 1  
	-- @if(!isEmpty(permissionId)){
	 and PERMISSION_ID=#{permissionId}
	-- @}
	-- @if(!isEmpty(perName)){
	 and PER_NAME=#{perName}
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
	"permissionId":"PERMISSION_ID",
	"perName":"PER_NAME",
	"cdate":"CDATE",
	"udate":"UDATE"
	}
