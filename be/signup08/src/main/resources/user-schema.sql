DROP TABLE IF EXISTS USER;
CREATE TABLE USER (
      ID BIGINT PRIMARY KEY AUTO_INCREMENT,
      USER_ID VARCHAR(20) NOT NULL,
      PASSWORD VARCHAR(64) NOT NULL,
      NAME VARCHAR(64),
      BIRTHDAY DATE,
      GENDER ENUM('female', 'male'),
      EMAIL VARCHAR(64),
      PHONE_NUMBER VARCHAR(64),
      INTEREST VARCHAR(255),
      AGREEMENT BIT,
      CREATED_DATE_TIME DATE
);
