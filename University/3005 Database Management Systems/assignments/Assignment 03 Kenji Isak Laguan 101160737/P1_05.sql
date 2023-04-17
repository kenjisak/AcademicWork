/*
Q5) Find the names of all the subscribers who subscribe to at least three services. 
*/

select name
from
    (select portid,count(portid) as numserv 
    from service_subscribers
    group by portid
    having numserv >= 3)

    natural join 

    subscribers;


/*
Test Output:
name
--------------
Michael Jordan
Joe Carter
Homer Simpson
Vince Carter
Chris Pronger
Frank Thomas
Steve Sampras
Matt Stajan
*/

