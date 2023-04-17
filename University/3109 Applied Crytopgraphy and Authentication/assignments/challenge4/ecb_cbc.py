#!/usr/bin/env python3
from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

BLOCK_SIZE = AES.block_size

def bytexor(a: bytes, b:bytes) -> bytes:
	"""
	XOR two byte arrays (trims the longer input)
	"""
	return bytes([x ^ y for (x, y) in zip(a, b)])

def decrypt(ciphertext: bytes) -> bytes:
    key = bytes.fromhex("2c4b295fe9ca7c02208e22d25e2875a8")
    cipher = AES.new(key, AES.MODE_ECB)

    try:
        decrypted = cipher.decrypt(ciphertext)
    except ValueError as e:
        print(f"ERROR: {e}")
        return -1

    return decrypted


def encrypt(plaintext: bytes) -> bytes:
    key = bytes.fromhex("2c4b295fe9ca7c02208e22d25e2875a8")
    iv = get_random_bytes(BLOCK_SIZE)
    cipher = AES.new(key, AES.MODE_CBC, iv)

    encrypted = cipher.encrypt(plaintext)
    ciphertext = iv + encrypted

    return ciphertext

def splitblocks(ciphertext: bytes) -> bytes:
    return [ciphertext[i:i+BLOCK_SIZE] for i in range(0, len(ciphertext), BLOCK_SIZE)]

def get_plaintext(ciphertext: bytes):
    """
    starting off with using a helper function to split the ciphertext bytes into blocks 
    setting iv as the first element of the cipherblock array since encrypt() added it to the beginning of the ciphertext before returning
    deleting the iv from the cipherblock array so when we iterate we can start at 0 with decipherable text and not the iv

    decrypted byte definition to add decrypted blocks while looping
    
    need to decipher the blocks one by one, can start with the beginning or end. but decided to start at the beginning
    using the decrypt() provided we decrypt() the first block then given from challenge 1 bytexor() that with IV to get back the first plaintext block
    for the rest of the blocks we do the same and decrypt() the block then bytexor() that with the previous cipherblock.
        (this is because after the first block, CBC XOR the previous cipherblock with the plaintext block)
        (ECB doesnt XOR the plaintext block before encrypting which is why its not a direct inverse but still usable to decrypt)
    after getting the plaintext block we add it to the decrypted variable to concat the plaintext blocks together and return 
    that once finished decrypting all blocks.
    """
    cipherblocks = splitblocks(ciphertext)
    iv = cipherblocks[0]
    del cipherblocks[0] # gets rid of iv block in ciphertext split in blocks

    decrypted = b"" # to concat plaintext block bytes

    for i in range(len(cipherblocks)): # decrypts in forward motion of the blocks
        if i == 0: # if its the first cipherblock then
            decryptblock = bytexor(decrypt(cipherblocks[i]), iv) # decrypt the first cipherblock with the given decrypt() function that makes use of ecb decrypting, then bytexor with IV to get the plaintext block
            decrypted += decryptblock # add the plaintext block into the decrypted block pile
        else: # else if its the 2nd cipherblock and after
            prevcipherblock = cipherblocks[i-1] # sets previous cipherblock 
            decryptblock = bytexor(decrypt(cipherblocks[i]), prevcipherblock) # decrypt the next cipherblock with the given decrypt(), then bytexor with previous cipherblock to get the plaintext block
            decrypted += decryptblock # add the plaintext block into the decrypted block pile

    return decrypted # return decrypted ciphertext

if __name__ == "__main__":
    key = get_random_bytes(BLOCK_SIZE)
    plaintext = b"comp3109_3cb_5uck5_4v01d_17!!!!!"
    # plaintext = b"aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbcccccccccccccccc" # tested other plaintext with blocks divisble by BLOCK_SIZE which is 16
    ciphertext = encrypt(plaintext)
    # print(plaintext)
    decrypted = get_plaintext(ciphertext)
    # print(decrypted)
    assert decrypted == plaintext