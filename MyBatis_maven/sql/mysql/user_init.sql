/*
	1. 關鍵字不區分大小寫, 慣用小寫
    2. 自訂欄位名稱: 全小寫, 以 _ 分隔 (搭配 myBatis)
*/
use labDB;
create table user (
	no 			Integer 		primary key auto_increment,
    name		varchar(100) 	not null,
    password	varchar(100)	not null	default "0000"
);