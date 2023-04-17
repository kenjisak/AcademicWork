PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;

DROP TABLE IF EXISTS Car;
DROP TABLE IF EXISTS Parts;
DROP TABLE IF EXISTS Parts_Categories;
DROP TABLE IF EXISTS Installation_videos;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Car_list;
DROP TABLE IF EXISTS Cars_belonging_to_user;

CREATE TABLE Car(
      carid integer primary key not null, --unique car number PRIMARY KEY
      make text NOT NULL, --car make e.g. subaru
      model text NOT NULL, --car model e.g. wrx
      year integer NOT NULL --car year
      );

INSERT INTO Car VALUES(1,'Subaru','WRX',2006);
INSERT INTO Car VALUES(2,'Subaru','WRX',2014);
INSERT INTO Car VALUES(3,'Subaru','Outback',2020);
INSERT INTO Car VALUES(4,'Mistubishi','Evo X',2015);
INSERT INTO Car VALUES(5,'Mazda','Speed 3',2013);
INSERT INTO Car VALUES(6,'Nissan','350z',2005);
INSERT INTO Car VALUES(7,'Honda','S2000',2008);
INSERT INTO Car VALUES(8,'Honda','Civic Type R',2018);
INSERT INTO Car VALUES(9,'Subaru','STI',2007);

CREATE TABLE Installation_videos(
      videoid integer primary key not null, --unique installation video number PRIMARY KEY 
      videolink text NOT NULL --installation video web link
      ); 

INSERT INTO Installation_videos VALUES(1,'https://www.youtube.com/watch?v=PDHCy59PkkE');--06brakelines
INSERT INTO Installation_videos VALUES(2,'https://www.youtube.com/watch?v=1Tm-9p0iDow');--06coils

INSERT INTO Installation_videos VALUES(3,'https://www.youtube.com/watch?v=l-USuQ1ldEg');--14expansiontank
INSERT INTO Installation_videos VALUES(4,'https://www.youtube.com/watch?v=tDJl2pMaHoc');--14exhaust
INSERT INTO Installation_videos VALUES(5,'https://www.youtube.com/watch?v=eVTBSikOu6A');--14shiftknob

INSERT INTO Installation_videos VALUES(6,'https://www.youtube.com/watch?v=eLXQ24svc5c');--20mudflap
INSERT INTO Installation_videos VALUES(7,'https://www.youtube.com/watch?v=nE1arGsXBNY');--20liftkit

INSERT INTO Installation_videos VALUES(8,'https://www.youtube.com/watch?v=DBUTpDzBv0s');--15bov
INSERT INTO Installation_videos VALUES(9,'https://www.youtube.com/watch?v=W_VgF35wAqw');--15clutch
INSERT INTO Installation_videos VALUES(10,'https://www.youtube.com/watch?v=0hlwiW8fct0');--15injector

INSERT INTO Installation_videos VALUES(11,'https://www.youtube.com/watch?v=LQNARFsLLXw');--13wing
INSERT INTO Installation_videos VALUES(12,'https://www.youtube.com/watch?v=MaoKoYybV-A');--13hoodscoop
INSERT INTO Installation_videos VALUES(13,'https://www.youtube.com/watch?v=9lC4PuFQLko');--13intake

INSERT INTO Installation_videos VALUES(14,'https://www.youtube.com/watch?v=l3v0NVWePQE');--05ss
INSERT INTO Installation_videos VALUES(15,'https://www.youtube.com/watch?v=uiW1lEvsiv8');--05bbk
INSERT INTO Installation_videos VALUES(16,'https://www.youtube.com/watch?v=1Zwq080FNoE');--05springs

INSERT INTO Installation_videos VALUES(17,'https://www.youtube.com/watch?v=2f7BBoDr9SE');--08hood
INSERT INTO Installation_videos VALUES(18,'https://www.youtube.com/watch?v=lc4RaMw2fpg');--08oilcooler
INSERT INTO Installation_videos VALUES(19,'https://www.youtube.com/watch?v=_E_EQ1z7q_0');--08rad

INSERT INTO Installation_videos VALUES(20,'https://www.youtube.com/watch?v=zkh1b_plOvg');--18intercooler
INSERT INTO Installation_videos VALUES(21,'https://www.youtube.com/watch?v=gRd2uvkdWts');--18exhaust
INSERT INTO Installation_videos VALUES(22,'https://www.youtube.com/watch?v=IlDxrBVNzk8');--18strutbar

CREATE TABLE Parts(
      partid integer primary key not null, --unique car part number PRIMARY KEY
      name text NOT NULL, --car part name
      brand text NOT NULL, --car part brand
      videoid integer NOT NULL REFERENCES Installation_videos(videoid)--installation video number FOREIGN KEY
      );


INSERT INTO Parts VALUES(1,'Stainless Steel Brake Lines - Front','Stoptech',1);
INSERT INTO Parts VALUES(2,'Stainless Steel Brake Lines - Rear','Stoptech',1); --1 installation video that belonds to 2 parts
INSERT INTO Parts VALUES(3,'Coilovers','BC',2);

INSERT INTO Parts VALUES(4,'Aluminum Coolant Expansion Tank','Mishimoto',3);
INSERT INTO Parts VALUES(5,'Catback Exhaust','GrimmSpeed',4);
INSERT INTO Parts VALUES(6,'Delrin Shiftknob','Cobb',5);

INSERT INTO Parts VALUES(7,'UR Black Mud Flap w/ Silver logo','Rally Armor',6);
INSERT INTO Parts VALUES(8,'Trails Spring Lift Kit','GrimmSpeed',7);

INSERT INTO Parts VALUES(9,'Respons Blow Off Valve','Go Fast Bits',8);
INSERT INTO Parts VALUES(10,'HD Pressure Plate/Street Disc Combo','ACT',9);
INSERT INTO Parts VALUES(11,'Fuel Injectors 1300cc','Injector Dynamics',10);

INSERT INTO Parts VALUES(12,'Gurney Flap Wing Extension','Cork Sport',11);
INSERT INTO Parts VALUES(13,'Hood Scoop - Forged Carbon Fiber','Cork Sport',12);
INSERT INTO Parts VALUES(14,'Stage II Power Series Short Ram Intake','Cork Sport',13);

INSERT INTO Parts VALUES(15,'Short Shifter','IRP',14);
INSERT INTO Parts VALUES(16,'Big Brake Kit','Stoptech',15);
INSERT INTO Parts VALUES(17,'Sport Springs','H&R',16);

INSERT INTO Parts VALUES(18,'Carbon Fiber Hood','Seibon',17);
INSERT INTO Parts VALUES(19,'Oil Cooler','Mishimoto',18);
INSERT INTO Parts VALUES(20,'Performance Radiator','Mishimoto',19);

INSERT INTO Parts VALUES(21,'Intercooler','HKS',20);
INSERT INTO Parts VALUES(22,'Gemini R400 Titanium Tip Full Exhaust System','Invidia',21);
INSERT INTO Parts VALUES(23,'Front Strut Tower Bar','Cusco',22);

CREATE TABLE Parts_Categories(
      carid integer NOT NULL REFERENCES Car(carid), --car number FOREIGN KEY
      partid integer NOT NULL REFERENCES Parts(partid), --car part number FOREIGN KEY
      categoryname text NOT NULL, --category name for car parts e.g. suspension
      PRIMARY KEY (carid, partid) --compound key car number and car part number
      );


INSERT INTO Parts_Categories VALUES(1,1,'Brakes'); 
INSERT INTO Parts_Categories VALUES(1,2,'Brakes');
INSERT INTO Parts_Categories VALUES(1,3,'Suspension');

INSERT INTO Parts_Categories VALUES(2,4,'Cooling');
INSERT INTO Parts_Categories VALUES(2,5,'Exhaust');
INSERT INTO Parts_Categories VALUES(2,6,'Interior');

INSERT INTO Parts_Categories VALUES(3,7,'Exterior');
INSERT INTO Parts_Categories VALUES(3,8,'Suspension');

INSERT INTO Parts_Categories VALUES(4,9,'Engine');
INSERT INTO Parts_Categories VALUES(4,10,'Drivetrain');
INSERT INTO Parts_Categories VALUES(4,11,'Engine');

INSERT INTO Parts_Categories VALUES(5,12,'Exterior');
INSERT INTO Parts_Categories VALUES(5,13,'Exterior');
INSERT INTO Parts_Categories VALUES(5,14,'Engine');

INSERT INTO Parts_Categories VALUES(6,15,'Interior');
INSERT INTO Parts_Categories VALUES(6,16,'Brakes');
INSERT INTO Parts_Categories VALUES(6,17,'Brakes');

INSERT INTO Parts_Categories VALUES(7,18,'Exterior');
INSERT INTO Parts_Categories VALUES(7,19,'Cooling');
INSERT INTO Parts_Categories VALUES(7,20,'Cooling');

INSERT INTO Parts_Categories VALUES(8,21,'Engine');
INSERT INTO Parts_Categories VALUES(8,22,'Exhaust');
INSERT INTO Parts_Categories VALUES(8,23,'Suspension');

INSERT INTO Parts_Categories VALUES(9,1,'Brakes'); -- Parts belonging to Many Cars
INSERT INTO Parts_Categories VALUES(9,2,'Brakes');
INSERT INTO Parts_Categories VALUES(9,3,'Suspension');

CREATE TABLE Users(
      userid text primary key not null, -- unique user name that can contain letters or/and numbers e.g. 05subie PRIMARY KEY 
      password text NOT NULL --user password
      ); 

INSERT INTO Users VALUES('StabLeRM','Ml&8A^bc');
INSERT INTO Users VALUES('IaMelENt','#TzRPaR9');
INSERT INTO Users VALUES('ATiONTEN','Mh@qe%G7');
INSERT INTO Users VALUES('wAntIoNE','%ChhD8Dm');
INSERT INTO Users VALUES('TAstAnia','D%jDQNqj');
INSERT INTO Users VALUES('AlTHANTI','!Y9fmP7E');
INSERT INTO Users VALUES('OWnGIRvy','&sIIS$Iw');
INSERT INTO Users VALUES('sEAthROs','Vti*GOlw');
INSERT INTO Users VALUES('erItiDEn','iL%J!7uP');
INSERT INTO Users VALUES('agErYnci','icM%EJaF');
INSERT INTO Users VALUES('STRoMBay','@jO@3$Q7');

CREATE TABLE Car_list(
      carlistid integer NOT NULL, --unique list of cars number owned by a user PRIMARY KEY 
      userid text NOT NULL REFERENCES Users(userid), --user name FOREIGN KEY
      PRIMARY KEY (carlistid, userid) --compound key list of cars number and user name
      );

INSERT INTO Car_list VALUES(1,'StabLeRM');
INSERT INTO Car_list VALUES(2,'IaMelENt');
INSERT INTO Car_list VALUES(3,'ATiONTEN');
INSERT INTO Car_list VALUES(4,'wAntIoNE');
INSERT INTO Car_list VALUES(5,'TAstAnia');

CREATE TABLE Cars_belonging_to_user(
      carlistid integer NOT NULL REFERENCES Car_list(carlistid), --list of cars number FOREIGN KEY
      userid text NOT NULL REFERENCES Users(userid), --user name FOREIGN KEY
      carid integer NOT NULL REFERENCES Cars(carid), --car number FOREIGN KEY
      PRIMARY KEY (carlistid, userid, carid), --compound key list of cars number and user name and car number
      FOREIGN KEY (carlistid, userid) REFERENCES Car_list(carlistid, userid)
      );

INSERT INTO Cars_belonging_to_user VALUES(1,'StabLeRM',1);
INSERT INTO Cars_belonging_to_user VALUES(1,'StabLeRM',2);
INSERT INTO Cars_belonging_to_user VALUES(1,'StabLeRM',3);

INSERT INTO Cars_belonging_to_user VALUES(2,'IaMelENt',2);
INSERT INTO Cars_belonging_to_user VALUES(2,'IaMelENt',7);

INSERT INTO Cars_belonging_to_user VALUES(3,'ATiONTEN',1);
INSERT INTO Cars_belonging_to_user VALUES(3,'ATiONTEN',4);

INSERT INTO Cars_belonging_to_user VALUES(4,'wAntIoNE',5);
INSERT INTO Cars_belonging_to_user VALUES(4,'wAntIoNE',6);

INSERT INTO Cars_belonging_to_user VALUES(5,'TAstAnia',8);

COMMIT;
