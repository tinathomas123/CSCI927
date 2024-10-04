DROP TABLE BOOKINGDATE;

create table BOOKINGDATE(
day CHAR(15) NOT NULL,
date DATE,
selected_room CHAR(5),
CONSTRAINT timeslot_pkey PRIMARY KEY(day, date, selected_room)
);