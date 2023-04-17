import string
import hashlib
import itertools
from itertools import chain, product
import time

student_number = "101160737"
password = "" #bBhNj3
#iterate a-z,A-Z,0-9 then add character and start over checking
#if single char loop through doesnt work, add another char and check again
possiblevalues = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
start_time = time.time()

for i in chain.from_iterable(product(possiblevalues, repeat=i) for i in itertools.count(1)):
    password = "".join(i)
    hashvalue = hashlib.sha256((password + student_number).encode()).hexdigest()
    #print(value + ": " + hashvalue) 
    #if(hashvalue[0] == "c"):print("works");break
    if(hashvalue[0:6] == "c0ffee" and  hashvalue[6:8] == student_number[-2:]):
        print(password + ", " + password + student_number + ": " + hashvalue)
        print ("worked and took", time.time() - start_time, "seconds to run")
        break

    # bBhNj3, bBhNj3101160737: c0ffee377c081440a090a8dd0480693acf0c1f7ddb578160566d78a2bf82305d
    # worked and took 3714.021805524826 seconds = 61 mins to run
    # have it start itterrating from bbbbbb for faster time

#c , 0 ,f ,f ,e , e = 1/16 ^ (6) = 1/16,777,216
#3 , 7 = 1/16 ^ (2) = 1/256
#1/4,294,967,296 tries/values to get the string