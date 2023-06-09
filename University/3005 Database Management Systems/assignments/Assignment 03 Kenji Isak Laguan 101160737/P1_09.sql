/*
Q9) Do the same as question 1.7 but this time only include trunks that have at least one 'IDLE' channel. 
That is, write an SQL query that will produce in one table a list of all the acceptable trunks that can 
be used to route a call to the 416 area code, office code 334 have at least one idle channel. 
This query should list the trunks in the order of preference. 

list the trunks with at least one channel thats IDLE
(The answer should list trunks routes 416,334 then 416,000 then 000,000 for example)
*/

select distinct portid as trunks
from
    (select distinct portid from 
        (select portid, (area || office) as area_office
        from trunk_routes)
    where area_office = '416334'
    or area_office = '416000'
    or area_office = '000000')

    natural join

    channels
where state = 'IDLE';
/*
Test Output:
trunks       
-----------
102
106
107 
*/

