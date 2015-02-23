CREATE TABLE IF NOT EXISTS MEMBER (
    id integer NOT NULL AUTO_INCREMENT,
    email varchar(100) NOT NULL UNIQUE,
	nickname varchar(50) NOT NULL UNIQUE,
    password varchar(100) NOT NULL,
    CONSTRAINT member_id PRIMARY KEY(id)
    );