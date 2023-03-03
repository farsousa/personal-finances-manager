CREATE  TABLE tab_activity(
	ta_id INT NOT NULL AUTO_INCREMENT,
	ta_description VARCHAR(100) NOT NULL,
	ta_value NUMERIC(9,2) NOT NULL,
	ta_effective_date DATE NOT NULL, -- in beggining, it´s the same as ta_forecast_date
	ta_forecast_date DATE NOT NULL,
	ta_status TINYINT NOT NULL, -- 0: Pendente; 1: Efetuado
	ta_type TINYINT NOT NULL, -- 0: Entrada; 1: Saída 
	ta_tw_id INT NOT NULL,
	CONSTRAINT pk_tab_activity PRIMARY KEY(ta_id),
	CONSTRAINT ck_ta_status CHECK (ta_status >= 0 AND ta_status <= 1),
	CONSTRAINT ck_ta_type CHECK (ta_type >= 0 AND ta_type <= 1),
	CONSTRAINT fk_ta_tw_id FOREIGN KEY(ta_tw_id) REFERENCES tab_wallet(tw_id)
);