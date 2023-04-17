/*
Q10) Produce a table that lists the name of all the service-subscribers that subscribe 
to at least all the same services as Jason Allison subscribes to but possibly others as well. 
Jason Allison rents the line with portID=2. (So this is the classic "subset" query.)

*/

select name
from subscribers s
where not exists
	    (select service
        from service_subscribers
        where service_subscribers.portid = 2

        except
	   
        select service
	    from service_subscribers
        where service_subscribers.portid = s.portid
        );

/*
Test Output:
name
--------------
Jason Allison
Michael Jordan
Joe Carter
Homer Simpson
Matt Stajan
*/

