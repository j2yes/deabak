drop table BOOKMARK;

CREATE TABLE BOOKMARK (
  BOOKMARK_ID            INT           NOT NULL AUTO_INCREMENT, 
  BOOKMARK_NAME          VARCHAR(200)     NOT NULL, 
  BOOKMARK_URL           VARCHAR(200)     NOT NULL, 
  BOOKMARK_DESC          VARCHAR(4000)            ,
  PRIMARY KEY (BOOKMARK_ID)     
)
;

INSERT INTO BOOKMARK 
	(BOOKMARK_NAME,
     BOOKMARK_URL,
     BOOKMARK_DESC) 
	VALUES
    ('google','www.google.com','google');

INSERT INTO BOOKMARK 
	(BOOKMARK_NAME,
     BOOKMARK_URL,
     BOOKMARK_DESC) 
	VALUES
    ('naver','www.naver.com','naver');

INSERT INTO BOOKMARK 
	(BOOKMARK_NAME,
     BOOKMARK_URL,
     BOOKMARK_DESC) 
	VALUES
    ('daum','www.daum.net','daum');
    
    commit;