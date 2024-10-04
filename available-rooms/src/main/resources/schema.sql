DROP TABLE ROOM;

create table ROOM(
room_number CHAR(5) NOT NULL,
room_name VARCHAR(10) NOT NULL,
status VARCHAR(10),
CONSTRAINT room_pkey PRIMARY KEY(room_number)
);

DROP TABLE CUSTOMER;

create table CUSTOMER(
customer_name VARCHAR(50),
email VARCHAR(50) NOT NULL,
phone_number VARCHAR(50),
selected_room CHAR(5),
booked_date DATE,
booking_id VARCHAR(100),
CONSTRAINT customer_pkey PRIMARY KEY(email)
);

