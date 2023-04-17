/*
Q6) Produce a table that lists the most popular service (or services). 
That is, give the name of the service that has the most subscribers.
*/
select service,max(numserv) as count 
from    (select service,count(service) as numserv 
        from service_subscribers
        group by service);

/*
Test Output:
service  count
-------  -----
MSG      25
*/

