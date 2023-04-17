from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

def byte_xor(ba1, ba2):
    return bytes([_a ^ _b for _a, _b in zip(ba1, ba2)])

def generate_attack_iv(iv,plaintext):
    """implement me"""
    mal = b"$99 to 101160737"
    output = bytearray(len(plaintext))

    for i in range(len(plaintext)):
        output[i] = plaintext[i] ^ mal[i]

    # print("output: ", output)
    newiv = bytearray(len(iv))

    for i in range(len(output)):
        newiv[i] = output[i] ^ iv[i]
    return newiv
    
def generate_attack_iv2(iv,plaintext):
    """implement me"""
    mal = b"$__ to 101160737"
    output = bytearray(len(plaintext))

    for i in range(len(plaintext)):
        if(i > 2): #remove this if for part 1
            output[i] = plaintext[i] ^ mal[i]

    # print("output: ", output)
    newiv = bytearray(len(iv))

    for i in range(len(output)):
        newiv[i] = output[i] ^ iv[i]
    return newiv
    
if __name__ == '__main__':

    key = b"very secure key!" # note this is not the key we used to encrypt the message in challenge 5!
    msg = b"$55 to 123456789"
    print('Original Message:', msg)

    iv = get_random_bytes(AES.block_size)
    cipher = AES.new(key,AES.MODE_CBC,iv)
    encrypted = cipher.encrypt(msg)
    print('Encrypted: ', encrypted)
    
    cipher = AES.new(key,AES.MODE_CBC,iv)
    decrypted = cipher.decrypt(encrypted)
    print('IV        ', iv)
    print('Decrypted:', decrypted )

    newiv = generate_attack_iv2(iv,msg)
    print('New IV:   ', bytes(newiv ))
    cipher = AES.new(key,AES.MODE_CBC,newiv)
    decrypted = cipher.decrypt(encrypted)
    print('Decrypted:', decrypted )
    
    part1plaintext = b'$12 to 999123456'
    part1iv = b'm\xd9\xf3\x94\xea\x8e)pF\xc3\x16cm\xb59\xc0'
    part1encrypted = b'\xab\xae\xba\xde!\xc4\x8d\xb7\x13\x1a\x99\xde\xed\x1d\xec\xab'
    part1newiv = bytes(generate_attack_iv(part1iv,part1plaintext))
    print("\nPart 1 newiv: ",part1newiv)

    part2plaintext = b'$12 to 999123456'
    part2iv = b'\x99\xf4\x9f\xa7\x03\xcc\x81+$\xd5\\\x13n\x1f\xbfj'
    part2encrypted = b'\xdfW\xdb\xc1[\te\x8b-\xa2\xfcB\xf88\xb4F'
    part2newiv = bytes(generate_attack_iv2(part2iv,part2plaintext))
    print("\nPart 2 newiv: ",part2newiv)
    
    assert part1newiv == b'm\xd1\xf8\x94\xea\x8e)xO\xcb\x16gn\xb6?\xc1'
    assert part2newiv == b'\x99\xf4\x9f\xa7\x03\xcc\x81#-\xdd\\\x17m\x1c\xb9k'