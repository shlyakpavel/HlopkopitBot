DROP TABLE IF EXISTS telegram.chat_user;
DROP TABLE IF EXISTS telegram.chats;
DROP TABLE IF EXISTS telegram.users;
DROP SCHEMA IF EXISTS telegram;

CREATE SCHEMA telegram;

CREATE TABLE telegram.users(
    user_id INT NOT NULL,
    username VARCHAR(50),
    firstname VARCHAR(50),
    last_name VARCHAR(50),
    is_bot BOOLEAN DEFAULT 0,
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);

CREATE TABLE telegram.chats(
    chat_id VARCHAR(50) NOT NULL,
    lucky_id INT4,
    loser_id INT4,
    user_of_the_day VARCHAR(50),
    loser_of_the_day VARCHAR(50),
    user_day_counter int not null default 0,
    loser_of_the_day_run_day int not null default 0, 
    user_of_the_day_run_day int not null default 0,
    CONSTRAINT chats_pk PRIMARY KEY (chat_id),
    CONSTRAINT lucky_fk FOREIGN KEY (lucky_id) REFERENCES telegram.users(user_id) ON UPDATE NO ACTION ON DELETE NO ACTION ,
    CONSTRAINT loser_fk FOREIGN KEY (loser_id) REFERENCES telegram.users(user_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE telegram.chat_user(
    id INT NOT NULL AUTO_INCREMENT,
    chat_id VARCHAR(50) NOT NULL,
    user_id INT NOT NULL,
    lucky_counter INT4 DEFAULT 0,
    loser_counter INT4 DEFAULT 0,
    user_day_counter INT4 default 0,
    CONSTRAINT chat_user_pk PRIMARY KEY (id)
);
