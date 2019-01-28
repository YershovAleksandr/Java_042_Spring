DROP TABLE IF EXISTS posts;
CREATE TABLE posts (
	id int (4) ZEROFILL NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    text varchar(500) NOT NULL,
    primary key(id)
) DEFAULT CHARSET=utf8;