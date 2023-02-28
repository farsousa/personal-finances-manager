CREATE  TABLE TAB_WALLET(
	ID INT NOT NULL AUTO_INCREMENT,
	DESCRIPTION VARCHAR(100) NOT NULL,
	BALANCE NUMERIC(9,2) NOT NULL DEFAULT 0,
	DELETED BOOLEAN NOT NULL DEFAULT 0,
	CONSTRAINT pk_tab_wallet PRIMARY KEY(id)
);