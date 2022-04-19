getAllRole
===

```sql
SELECT sr.ROLE_ID,sr.ROLE_NAME
FROM sys_role sr
         JOIN sys_user_role sur
ON sur.ROLE_ID = sr.ROLE_ID AND sur.USER_ID = #{userId}
```

getAllPerssion
===
```sql
SELECT sp.PERMISSION_ID, sp.PER_NAME
FROM sys_permission sp
          JOIN sys_role_permission srp ON sp.PERMISSION_ID = srp.PERMISSION_ID
         JOIN sys_role sr ON srp.ROLE_ID = sr.ROLE_ID
         JOIN sys_user_role sur ON sur.ROLE_ID = sr.ROLE_ID and sur.USER_ID =#{userId}
```