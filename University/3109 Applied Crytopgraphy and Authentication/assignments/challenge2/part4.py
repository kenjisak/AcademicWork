# find the starting input of the hash chain for blake2 func
#d0b9e70ffdcba25ed7bc42a5667c712a4558a35a55f6ed4b9ad792fec2db587929bf043d01c9e81eb36ee10c1947ba02f8903f09bb226d89a8f5fe11d80a816b
# start with s0 = student id + i then hash that value another for loop till 1000 times hashed and check for a match if not keep going

import hashlib
import time
# Challenge 2 Part 4:
# Write a python program to find the preimage of a given BLAKE2 hash value
def find_preimage(hash, student_number):
    # function to find preimage of a BLAKE2 hash
    # Note: convert your initial value to bytes using str.encode()

    initial_value = student_number
    iterations = 0
    print("cracking preimage...")
    preimage = "" # j - 1 store preimage of each iteration

    for i in range(5000000):
        hashthis = initial_value + i # sid + i
        currenthashvalue = ""
        
        for j in range(1000): #hashes this 1000 times and checks for a match
            iterations += 1
            actualpreimage = preimage
            if (j == 0):
                currenthashvalue = hashlib.blake2b(str(hashthis).encode()).hexdigest()#encode wihtout hexdigest representation
                #hash initial value then set this as preimage then next time it uses preimage to hash again
            else:
                currenthashvalue = hashlib.blake2b(bytearray.fromhex(actualpreimage)).hexdigest()
            
            preimage = currenthashvalue

            # print("si value:      "+ str(hashthis))
            # print("current hash:  " + currenthashvalue)
            # print("preimage hash: " + actualpreimage)
            # print(" ")
            
            if(currenthashvalue == hash): #checks readable hexdigest representation against hash
                print("worked and took", time.time() - start_time, "seconds to run and " + str(iterations) + " iterations")#
                print("current hash: " + currenthashvalue)
                print("preimage hash: " + actualpreimage)
                print("hash: " + hash)
                return actualpreimage
        # print("si value:      "+ str(hashthis) + "       " + str(iterations))
        # print("DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE 1000 ITERATIONS")

if __name__ == "__main__":
    student_number = 101160737 #replace this with your student number
    hash = "d0b9e70ffdcba25ed7bc42a5667c712a4558a35a55f6ed4b9ad792fec2db587929bf043d01c9e81eb36ee10c1947ba02f8903f09bb226d89a8f5fe11d80a816b"
    start_time = time.time()
    # preimage is = 40aaae1439e7ff86cf203cf1e1cbb321b6c6b688e3567d4f94e0727f9e3337bc4110c018a335b18d204a0e4502852591ea013ea5182786b21fd70189f08b4f3b
    find_preimage(hash, student_number)
 