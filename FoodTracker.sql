CREATE DATABASE IF NOT EXISTS weightTracker;

USE weightTracker;

DROP TABLE IF EXISTS weights;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(40) NOT NULL, 
	email VARCHAR(40), 
	PRIMARY KEY (id)
);

CREATE TABLE weights (
	id INT (11) NOT NULL AUTO_INCREMENT,
	user_id INT (11) NOT NULL, 
	measureDate VARCHAR (40) NOT NULL,
	weight Int(11) NOT NULL,
	PRIMARY KEY (id), 
	FOREIGN KEY (user_id) references users (id)
