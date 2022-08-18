USE lab_db;

/*
1.建立主表
2.建立異動紀錄表(歷史紀錄表) _history _log
帳號:
1.首字限定英文
2.可用字元: 
2.1.英文:區分大小寫
2.2.數字:
2.3.符號:
3.長度: 
密碼:

*/

-- create table
DROP TABLE IF EXISTS account;
CREATE TABLE IF NOT EXISTS account (
	id	 		INT 			PRIMARY KEY AUTO_INCREMENT,
	
    name		VARCHAR(100)	NOT NULL UNIQUE,
    password	VARCHAR(100)	NOT NULL DEFAULT "0000",
    
    modifiable_flag	BOOLEAN			NOT NULL DEFAULT TRUE,
    deleted_flag	BOOLEAN 		NOT NULL DEFAULT FALSE,
    created_time 	DATETIME		NOT NULL DEFAULT now(),
    modified_time 	TIMESTAMP 		NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

SELECT * FROM account;

-- initialize data 初始資料
INSERT INTO account (name, password, modifiable_flag) VALUES ("root", "root", FALSE);
INSERT INTO account (name, password, modifiable_flag) VALUES ("guest", "guest", FALSE);
INSERT INTO account (name, password) VALUES ("tester", "tester");
INSERT INTO account (name, password) VALUES ("developer", "developer");
INSERT INTO account (name) VALUES ("John");
INSERT INTO account (name) VALUES ("Frank");
INSERT INTO account (name) VALUES ("Ken");

SELECT * FROM account;
