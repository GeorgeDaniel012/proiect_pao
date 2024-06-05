CREATE TABLE Countries
	(countryId int PRIMARY KEY AUTO_INCREMENT,
    countryName varchar(30));

CREATE TABLE Users
	(userId int PRIMARY KEY AUTO_INCREMENT,
	username varchar(30),
    countryId int,
    email varchar(30),
    gender varchar(30),
    FOREIGN KEY (countryId)
		REFERENCES Countries(countryId)
        ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE Games
	(gameId int PRIMARY KEY AUTO_INCREMENT,
    gameName varchar(30),
    gameDescription varchar(100));

CREATE TABLE Categories
	(categoryId int PRIMARY KEY AUTO_INCREMENT,
    categoryName varchar(30),
    categoryDescription varchar(100),
    gameId int,
    descending bool,
    FOREIGN KEY (gameId)
		REFERENCES Games(gameId)
        ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE Runs
	(recordId int PRIMARY KEY AUTO_INCREMENT,
    recordDescription varchar(100),
    userId int,
    categoryId int,
    recordLink varchar(100),
    hours int,
    minutes int,
    seconds int,
    milliseconds int,
    FOREIGN KEY (userId)
		REFERENCES Users(userId)
        ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (categoryId)
		REFERENCES Categories(categoryId)
        ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE GameModerators
	(moderatorId int PRIMARY KEY AUTO_INCREMENT,
    userId int,
    gameId int,
	FOREIGN KEY (userId)
		REFERENCES Users(userId)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (gameId)
		REFERENCES Games(gameId)
        ON UPDATE CASCADE ON DELETE CASCADE
	);

insert into gamemoderators values
(3, 2, 2);

insert into games values
(2, "aaaaaa", "ssv");

insert into categories values
(1, "aaa", "bbb", 1, true);