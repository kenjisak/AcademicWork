/*
Q3) List the names of all the subscribers who are originators 
of a call to someone who is also a subscriber on the same switch 
(i.e. a line to line call)

use subs
line
facility
calls

get orig and term from calls,
compare if both portid is a LINE in facilities if it is
then grab the name using originator portid


join both tables where both orig and term is IN that table 
reference code:
select name from subscribers join
(select orig, term from calls
where orig in (select portid from lines)
and term in (select portid from lines)) on subscribers.portid = orig;
*/
select name
from
    (select orig as portid from calls 
    where orig IN (select portid from facilities where facility_type =  'LINE')
    and term IN (select portid from facilities where facility_type =  'LINE'))
    
    natural join

    subscribers;

/*
Test Output:
name       
-----------
Mats Sundin
Jason Allison
Homer Simpson
Michael Jordan
Ed Belfour
*/
