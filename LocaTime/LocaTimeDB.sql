SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS content;
DROP TABLE IF EXISTS user_table;




/* Create Tables */

CREATE TABLE content
(
	content_num int NOT NULL AUTO_INCREMENT,
	content_title varchar(30) NOT NULL,
	content_OriPrice int NOT NULL,
	content_SellingPrice int NOT NULL,
	content_able int NOT NULL,
	content_deadline date NOT NULL,
	user_id varchar(16) NOT NULL,
	PRIMARY KEY (content_num)
);


CREATE TABLE user_table
(
	user_id varchar(16) NOT NULL,
	user_pw varchar(520) NOT NULL,
	user_name varchar(20) NOT NULL,
	user_kakao varchar(20),
	user_phone varchar(15) NOT NULL,
	PRIMARY KEY (user_id)
);



/* Create Foreign Keys */

ALTER TABLE content
	ADD FOREIGN KEY (user_id)
	REFERENCES user_table (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

/*query*/


SET SESSION FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS content;
DROP TABLE IF EXISTS user_table;

CREATE TABLE content
(
	content_num int NOT NULL AUTO_INCREMENT,
	content_title varchar(30) NOT NULL,
	content_OriPrice int NOT NULL,
	content_SellingPrice int NOT NULL,
	content_able int NOT NULL,
	content_deadline date NOT NULL,
	user_id varchar(16) NOT NULL,
	PRIMARY KEY (content_num)
);


CREATE TABLE user_table
(
	user_id varchar(16) NOT NULL,
	user_pw varchar(520) NOT NULL,
	user_name varchar(20) NOT NULL,
	user_kakao varchar(20),
	user_phone varchar(15) NOT NULL,
	PRIMARY KEY (user_id)
);


ALTER TABLE content
	ADD FOREIGN KEY (user_id)
	REFERENCES user_table (user_id)
	ON UPDATE cascade
	ON DELETE cascade
;



insert into user_table(user_id,user_phone,user_pw,user_name,user_kakao)
values ('test1','010-1234-5678','1111','테스트','test01');

insert into content(content_title,content_OriPrice,content_deadline,content_SellingPrice,content_able,user_id)
values('스타벅스',3500,20151019,2500,0,'test1');


insert into user_table(user_id,user_phone,user_pw,user_name,user_kakao)
values ('test2','010-1234-5678','1111','테스트','test02');

insert into content(content_title,content_OriPrice,content_deadline,content_SellingPrice,content_able,user_id)
values('까페베네',3500,'20151019',2500,0,'test2');


insert into user_table(user_id,user_phone,user_pw,user_name,user_kakao)
values ('test3','010-1234-5678','1111','테스트','test03');

insert into content(content_title,content_OriPrice,content_deadline,content_SellingPrice,content_able,user_id)
values('커피빈','3500','20151029',2500,1,'test3');



insert into user_table(user_id,user_phone,user_pw,user_name,user_kakao)
values ('test4','010-1234-5678','1111','테스트','test04');

insert into content(content_title,content_OriPrice,content_deadline,content_SellingPrice,content_able,user_id)
values('파스쿠치',3500,'20151219',2500,1,'test4');


insert into user_table(user_id,user_phone,user_pw,user_name,user_kakao)
values ('test5','010-1234-5678','1111','테스트','test01');

insert into content(content_title,content_OriPrice,content_deadline,content_SellingPrice,content_able,user_id)
values('커피빈',3500,20151019,2500,0,'test5');

select * from user_table;


select content_title,content_OriPrice,content_SellingPrice,content_able,user_id
 	from content;

select * from content;

select c.content_title,c.content_OriPrice,c.content_deadline,c.content_SellingPrice,c.content_able,u.user_id, u.user_kakao
from user_table u, content c
where u.user_id=c.user_id
 and content_able=0
 ORDER BY content_deadline asc;
;

select count(*) from (select * from user_table
where user_id='test1' and user_pw='1111') A ;

select count(user_id) from user_table
where user_id='test1' and user_pw='1111';


select * from user_table
where user_id='test1';


