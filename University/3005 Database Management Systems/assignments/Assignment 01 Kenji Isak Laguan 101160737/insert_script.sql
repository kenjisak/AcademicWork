PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;

DELETE FROM cds WHERE contributor = '101160737';
DELETE FROM songs WHERE contributor = '101160737';

INSERT INTO cds VALUES('101160737CD1','Ginny','Sylo Nozra','Cameron Hale, Leo Dessi',2020,'101160737');
INSERT INTO cds VALUES('101160737CD2','After The Sun','RINI','RINI',2018,'101160737');

INSERT INTO songs (title,composer,cd_id,track,contributor) VALUES('Ginny','Sylo Nozra','101160737CD1',1,'101160737');
INSERT INTO songs (title,composer,cd_id,track,contributor) VALUES('Hulu','Sylo Nozra','101160737CD1',2,'101160737');
INSERT INTO songs (title,composer,cd_id,track,contributor) VALUES('Meet Me in Amsterdam','RINI','101160737CD2',1,'101160737');
INSERT INTO songs (title,composer,cd_id,track,contributor) VALUES('Aphrodite','RINI','101160737CD2',2,'101160737');
INSERT INTO songs (title,composer,cd_id,track,contributor) VALUES('Good Intentions','RINI','101160737CD2',3,'101160737');
INSERT INTO songs (title,composer,cd_id,track,contributor) VALUES('After the Sun','RINI','101160737CD2',4,'101160737');
INSERT INTO songs (title,composer,cd_id,track,contributor) VALUES('Oceane (feat. Olivia Escuyos)','RINI','101160737CD2',5,'101160737');

COMMIT;
