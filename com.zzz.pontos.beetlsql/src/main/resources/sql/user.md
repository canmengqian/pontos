select
===

* 查询用户

```sql
select * from sys_user u where 1=1
-- @ if(isNotEmpty(name)){
and name like #{name}
-- @ }
order by u.id desc
```

selectOne
===

```sql
select * from sys_user u where()
```