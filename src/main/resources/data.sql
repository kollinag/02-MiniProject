Insert Into COUNTRY_MASTER(COUNTRY_ID,COUNTRY_NAME) Values(1,'India');
Insert Into COUNTRY_MASTER(COUNTRY_ID,COUNTRY_NAME) Values(2,'Usa');

Insert Into STATE_MASTER(STATE_ID,STATE_NAME,COUNTRY_ID) Values(1,'Andhra Pradesh',1);
Insert Into STATE_MASTER(STATE_ID,STATE_NAME,COUNTRY_ID) Values(2,'Karnataka',1);
Insert Into STATE_MASTER(STATE_ID,STATE_NAME,COUNTRY_ID) Values(3,'New Jersy',2);
insert into STATE_MASTER(STATE_ID,STATE_NAME,COUNTRY_ID) values(4,'Ohio',2);

Insert Into CITY_MASTER(CITY_ID,CITY_NAME,STATE_ID) Values(1,'Vizag',1);
Insert Into CITY_MASTER(CITY_ID,CITY_NAME,STATE_ID) Values(2,'Guntur',1);
Insert Into CITY_MASTER(CITY_ID,CITY_NAME,STATE_ID) Values(3,'Banglore',2);
Insert Into CITY_MASTER(CITY_ID,CITY_NAME,STATE_ID) Values(4,'Mysore',2);
Insert Into CITY_MASTER(CITY_ID,CITY_NAME,STATE_ID) Values(5,'Maywood',3);
Insert Into CITY_MASTER(CITY_ID,CITY_NAME,STATE_ID) Values(6,'Westwood',3);
Insert Into CITY_MASTER(CITY_ID,CITY_NAME,STATE_ID) Values(7,'Oakwood',4);
Insert Into CITY_MASTER(CITY_ID,CITY_NAME,STATE_ID) Values(8,'Cuyahoga County',4);