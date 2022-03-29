/*
	1. 關鍵字不區分大小寫, 慣用小寫
    2. 自訂欄位名稱: 全小寫, 以 _ 分隔 (搭配 myBatis)
*/
use labDB;
-- 建立主表.xxx
create table if not exists app_config (
    key_name		varchar(100) 	not null 	unique,
    key_value			varchar(100)	not null	default "",

    id 				Integer 		primary key auto_increment,		
    createdTime		datetime 		default now(),
    modifiedTime	timestamp	default now()
);

drop table if exists app_config;

commit;

insert into app_config (key_name, key_value) values("key", "123");

select * from app_config;

update app_config 
set key_value = "123"
where key_name = "key"
;


select now();

-- 建立歷史表.xxx_history
-- 同時複製 資料表的結構、紀錄
create table if not exists app_config_history 
select * from app_config;	

select * from app_config_history;

delimiter ||;
create trigger if not exists app_config_after_insert
after insert on app_config
for each row 
begin
	
end
||
delimiter ; 
;