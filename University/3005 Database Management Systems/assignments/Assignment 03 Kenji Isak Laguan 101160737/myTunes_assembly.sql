PRAGMA foreign_keys=OFF;

DROP TABLE IF EXISTS ALLCDSTEMP;
DROP TABLE IF EXISTS ALLSONGSTEMP;
DROP TABLE IF EXISTS cds;
DROP TABLE IF EXISTS songs;

CREATE TABLE ALLCDSTEMP(
      cd_id text primary key not null, --cd unique id
      title text NOT NULL, --title of CD
      artist text NOT NULL, --artist whose CD it is or "various artists"
      producer text default NULL,
      year integer,
      contributer text --student number who contributed the data
      );

CREATE TABLE ALLSONGSTEMP(
      song_id integer primary key not null, --auto incrementing key
      title text NOT NULL, --title of song
      composer text NOT NULL, --person or persons who wrote the song
      cd_id text NOT NULL, --cd this song appears on
      track integer NOT NULL, --track number of the song on CD
      contributer text --student number who contributed the data
      );

/*read all sql files and add them to temp tables, then add temp table data to orig table created at the end*/
/*create tables cd and songs, copy data into ALLTABLES then drop the cd and songs table*/
.mode column
.read myTunes_Abdelghny.sql

insert into ALLCDSTEMP(cd_id,title,artist,producer,year,contributer) select cd_id,title,artist,producer,year,contributer from cds;
insert into ALLSONGSTEMP(title,composer,cd_id,track,contributer) select title,composer,cd_id,track,contributer from songs;

DROP TABLE IF EXISTS cds;
DROP TABLE IF EXISTS songs;
.read myTunes_Ali.sql

insert into ALLCDSTEMP(cd_id,title,artist,producer,year,contributer) select cd_id,title,artist,producer,year,contributer from cds;
insert into ALLSONGSTEMP(title,composer,cd_id,track,contributer) select title,composer,cd_id,track,contributer from songs;

DROP TABLE IF EXISTS cds;
DROP TABLE IF EXISTS songs;
.read myTunes_Fatemeh.sql

insert into ALLCDSTEMP(cd_id,title,artist,producer,year,contributer) select cd_id,title,artist,producer,year,contributer from cds;
insert into ALLSONGSTEMP(title,composer,cd_id,track,contributer) select title,composer,cd_id,track,contributer from songs;

DROP TABLE IF EXISTS cds;
DROP TABLE IF EXISTS songs;
.read myTunes_Monica.sql

insert into ALLCDSTEMP(cd_id,title,artist,producer,year,contributer) select cd_id,title,artist,producer,year,contributer from cds;
insert into ALLSONGSTEMP(title,composer,cd_id,track,contributer) select title,composer,cd_id,track,contributer from songs;

DROP TABLE IF EXISTS cds;
DROP TABLE IF EXISTS songs;
.read myTunes_Rezieh.sql

insert into ALLCDSTEMP(cd_id,title,artist,producer,year,contributer) select cd_id,title,artist,producer,year,contributer from cds;
insert into ALLSONGSTEMP(title,composer,cd_id,track,contributer) select title,composer,cd_id,track,contributer from songs;

DROP TABLE IF EXISTS cds;
DROP TABLE IF EXISTS songs;
.read myTunes_Saman.sql

insert into ALLCDSTEMP(cd_id,title,artist,producer,year,contributer) select cd_id,title,artist,producer,year,contributer from cds;
insert into ALLSONGSTEMP(title,composer,cd_id,track,contributer) select title,composer,cd_id,track,contributer from songs;

DROP TABLE IF EXISTS cds;
DROP TABLE IF EXISTS songs;

CREATE TABLE cds(
      cd_id text primary key not null, --cd unique id
      title text NOT NULL, --title of CD
      artist text NOT NULL, --artist whose CD it is or "various artists"
      producer text default NULL,
      year integer,
      contributer text --student number who contributed the data
      );

CREATE TABLE songs(
      song_id integer primary key not null, --auto incrementing key
      title text NOT NULL, --title of song
      composer text NOT NULL, --person or persons who wrote the song
      cd_id text NOT NULL, --cd this song appears on
      track integer NOT NULL, --track number of the song on CD
      contributer text --student number who contributed the data
      );

insert into cds(cd_id,title,artist,producer,year,contributer) select cd_id,title,artist,producer,year,contributer from ALLCDSTEMP;
insert into songs(title,composer,cd_id,track,contributer) select title,composer,cd_id,track,contributer from ALLSONGSTEMP;

DROP TABLE IF EXISTS ALLCDSTEMP;
DROP TABLE IF EXISTS ALLSONGSTEMP;