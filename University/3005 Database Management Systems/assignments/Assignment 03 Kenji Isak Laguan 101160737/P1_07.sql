/*
Q7) Write an SQL query that will produce in one table a list of all the acceptable trunks 
that can be used to route a call to the 416 area code, office code 334. This query should 
list the trunks in the order of preference. 

(The answer should list trunks with routes 416,334 then those with 416,000 and then those 
with 000,000 for example)
find for 416-334 can do AND or just concat together into another table and check 416334
then find 416-000 and then 000-000
use trunk routes and trunk maybe
*/

select portid as trunks
from
    (select distinct portid from 
        (select portid, (area || office) as area_office
        from trunk_routes)
    where area_office = '416334'
    or area_office = '416000'
    or area_office = '000000');

/*
Test Output:
trunks       
-----------
102
106
107 
*/


