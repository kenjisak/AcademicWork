# Challenge 2 Part 2:
# Write a Python program to determine the salt given the password and SHA256 hash value 
# The salt value is a sequence of 8 lowercase ascii characters
import string
import hashlib
from itertools import product, count
import time

def bruteForce(hashed_Password, password, encoding):
    # Iterate on each possible salt value and check if it matches the sha256 hash provided
    # The function should return the salt value 
    # use itertools of 8 lower case letters
    iterations = 0
    print("cracking salt...")
    for attempt in product(string.ascii_lowercase,repeat=8):
        iterations += 1
        salt = "".join(attempt)
        hashvalue = hashlib.sha256(str(password + salt).encode(encoding)).hexdigest()
        
        # print(salt)
        # print(hashvalue)
        
        if(hashvalue == hashed_Password):
            print(salt + ": " + str(password + salt))
            print("worked and took", time.time() - start_time, "seconds to run and " + str(iterations) + " iterations")# 1 hour 20 mins, 3,171,919,355 iterations
            return salt
    print("didnt work")

def checkSalt(salt, password, hashed_password):
    # simple check to see if a salt and password match a known hash
    if hashlib.sha256(str(password + salt).encode(encoding)).hexdigest() == hashed_password:
        print("Salt value is correct for the given password")
    else:
        print("Salt value is incorrect for the given password")

if __name__ == "__main__":
    start_time = time.time()
    encoding = "ascii"
    password = "comp3109"
    hashed_password = "439b1294daee04f7b3e7e2fd0adf71a1d084b487317deadd92e322597f29e6f8"
    # saltValue = bruteForce(hashed_password, password, encoding)
    saltValue = "akgzcukg"
    print(f"Salt value: {saltValue}")
    # sample values to check if you code works, checkSalt(salt, password, hashValue)
    checkSalt(saltValue,password,hashed_password)