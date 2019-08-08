一个以springboot为基础开发的前后端未分离论坛　

## 使用到
- IDEA
- bootstrap
- github

##建表语句
```sql
create table USER
(
   ID           INTEGER  auto_increment,
     ACCOUNT_ID   VARCHAR(100),
       NAME         VARCHAR(50),
         TOKEN        CHAR(36),
           GMT_CREATE   BIGINT,
             GMT_MODIFIED BIGINT,
                   primary key (ID)

);

```
