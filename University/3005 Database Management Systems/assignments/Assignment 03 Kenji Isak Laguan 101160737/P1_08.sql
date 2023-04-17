/*
Q8) Write an SQL query that would find if the line with phone number (613) 712-0024 is 
currently available to take a call because its channel is IDLE. That is, select the portid, 
directory number, and channel state of line (613) 712-0024.

get portid from the number in lines 
then use portid in channels to see if its state
*/
select state from
    (select portid, areacode || officecode || stationcode as number 
    from lines 
    where number = '6137120024')

    natural join 

    (channels);

/*
Test Output:
state
-----
BUSY
*/

