DROP TABLE RESTAURANTTABLE;

create table RESTAURANTTABLE(
id CHAR(5) NOT NULL,
name VARCHAR(10) NOT NULL,
status VARCHAR(10),
CONSTRAINT resttable_pkey PRIMARY KEY(id)
);

DROP TABLE CUSTOMER;

create table CUSTOMER(
customer_name VARCHAR(50),
email VARCHAR(50) NOT NULL,
phone_number VARCHAR(50),
selected_table CHAR(5),
reserved_date_time DATETIME,
reservation_confirmation_id VARCHAR(100),
CONSTRAINT customer_pkey PRIMARY KEY(email)
);

