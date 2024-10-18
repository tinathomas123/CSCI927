DROP TABLE TIMESLOT;

create table TIMESLOT(
day CHAR(15) NOT NULL,
date_time DATETIME,
selected_venue CHAR(5),
CONSTRAINT timeslot_pkey PRIMARY KEY(day, date_time, selected_venue)
);