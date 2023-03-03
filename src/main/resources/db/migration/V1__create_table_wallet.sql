CREATE  TABLE tab_wallet(
	tw_id INT NOT NULL AUTO_INCREMENT,
	tw_description VARCHAR(100) NOT NULL UNIQUE,
	tw_balance NUMERIC(9,2) NOT NULL DEFAULT 0,
	tw_deleted BOOLEAN NOT NULL DEFAULT 0,
	CONSTRAINT pk_tab_wallet PRIMARY KEY(tw_id)
);