create table user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL UNIQUE,
  password varchar(100)  NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY ( id )
);