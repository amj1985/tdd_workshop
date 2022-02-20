CREATE TABLE reports(
                       id SERIAL constraint re_ads_id_pkey PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       note int NOT NULL
)