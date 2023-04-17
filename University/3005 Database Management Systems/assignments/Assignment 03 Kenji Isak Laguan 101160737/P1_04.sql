/*
Q4) Find the names and address of all subscribers who subscribe 
to all of the available services. 
(Note the result for the current data might be empty but your query should work if the TA's add more data to the database.)

use subs and service subscribers
check using port id of each subscriber has 'MSG' and CWT and CFB and DSP and 3WC in service so 5 services or counts to 5
*/

/*select name, address from join and select with table creating portid count and name and address*/

select name,address
from
    (select portid,count(portid) as numserv 
    from service_subscribers
    group by portid
    having numserv = 5)

    natural join 

    subscribers;
    
/*no output since theres insufficient data
Test Output:

*/

