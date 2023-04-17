#!/usr/bin/env python3
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
from Crypto.Random import get_random_bytes

BLOCK_SIZE = AES.block_size


def ecb_penguin(key: bytes, img: bytes) -> bytes:
    """
    set the mode to ECB
    extracts the image body bytes by removing the first 54 bytes since thats the standard bmp header bytes at the beginning of a bmp image
    then encrypt the image body with padding as ECB needs full blocks of BLOCK_SIZE bytes to encrypt.
    then add back the image header onto the encrypted image body and return that so that we can write to the file and create the ecb penguin image

    ECB penguin looks the way it is because each plaintext block is encrypted the same way so if there are identical plaintext blocks this
    will result in identical ciphertext blocks as well which is why you can still see the penguin in the ecb encrypted image
    """
    cipher = AES.new(key,AES.MODE_ECB)
    imgbody = img[54:]
    encrypytedbody = cipher.encrypt(pad(imgbody,BLOCK_SIZE))
    ciphertext = img[0:54] + encrypytedbody
    return ciphertext


def cbc_penguin(key: bytes, iv: bytes, img: bytes) -> bytes:
    """ 
    set the mode to CBC with the given IV
    extracts the image body bytes by removing the first 54 bytes since thats the standard bmp header bytes at the beginning of a bmp image
    then encrypt the image body with padding as CBC needs full blocks of BLOCK_SIZE bytes to encrypt.
    then add back the image header onto the encrypted image body and return that so that we can write to the file and create the cbc penguin image

    CBC penguin looks the way it is because the starting plaintext block gets a unique initialization vector
    generated to be XORed with the plaintext and then gets encrypted. that resulting cipher text is then passed 
    onto the next block which gets XORed with the plaintext before encryption. then the same happens to the next block and so on.
    which results to each block consisting of different cipher text from the rest since the ciphertext of the previous blocks
    affect the next blocks and gets rid of identical ciphertext blocks. resulting in not knowing the 
    initial image from the cbc encrypted image.
    """
    assert iv is not None

    cipher = AES.new(key,AES.MODE_CBC,iv)
    imgbody = img[54:]
    encrypytedbody = cipher.encrypt(pad(imgbody,BLOCK_SIZE))
    ciphertext = img[0:54] + encrypytedbody
    return ciphertext

if __name__ == "__main__":
    key = b"3109SaysAvoidECB"

    with open("tux.bmp", "rb") as f:
        img = f.read()

    with open("ecb_tux.bmp", "wb") as f:
        ciphertext = ecb_penguin(key, img)
        f.write(ciphertext)

    #   TODO: Uncomment below for cbc_penguin()
    #   TODO: Generate BLOCK_SIZE random bytes for the IV
    iv = get_random_bytes(BLOCK_SIZE)
    with open("cbc_tux.bmp", "wb") as f:
        ciphertext = cbc_penguin(key, iv, img)
        f.write(ciphertext)
