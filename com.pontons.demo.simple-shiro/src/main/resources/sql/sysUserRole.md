getAllRole
===
```sql
SELECT sr.ROLE_ID,sr.ROLE_NAME
FROM sys_role sr
         JOIN sys_user_role sur 
ON sur.ROLE_ID = sr.ROLE_ID AND sur.USER_ID = #userId#

```