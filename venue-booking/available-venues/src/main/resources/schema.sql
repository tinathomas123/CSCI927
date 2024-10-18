DROP TABLE VENUE;

create table VENUE(
id CHAR(5) NOT NULL,
name VARCHAR(50) NOT NULL,
status VARCHAR(10),
CONSTRAINT venue_pkey PRIMARY KEY(id)
);

DROP TABLE CUSTOMER;

create table CUSTOMER(
customer_name VARCHAR(50),
email VARCHAR(50) NOT NULL,
phone_number VARCHAR(50),
selected_venue CHAR(5),
booked_date_time DATETIME,
booking_confirmation_id VARCHAR(100),
CONSTRAINT customer_pkey PRIMARY KEY(email)
);

