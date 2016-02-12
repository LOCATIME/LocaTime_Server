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
	content_able int DEFAULT 0 NOT NULL,
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



