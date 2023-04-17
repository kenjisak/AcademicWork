from Crypto.Cipher import PKCS1_OAEP
from Crypto.Cipher import AES
from Crypto.PublicKey import RSA

import base64

sessionkey_encrypted = open("skey.txt").read()
challenge_encrypted = open("challenge.txt").read()


decodedskey = base64.b64decode(sessionkey_encrypted)
decodedchallenge = base64.b64decode(challenge_encrypted)

privkey = RSA.importKey(open('mykey.pem').read())
cipher = PKCS1_OAEP.new(privkey)
skeydecrypted = cipher.decrypt(decodedskey)

print(skeydecrypted)

challcipher = AES.new(skeydecrypted,AES.MODE_ECB)
challdecrypted = challcipher.decrypt(decodedchallenge)

print(challdecrypted)

convertedint = 1 + int.from_bytes(challdecrypted,"big")
convertedhex = str.encode(format(convertedint,"x"))
print(convertedhex)

encryptagain = challcipher.encrypt(convertedhex)
print(encryptagain)
encodechallengeone = base64.b64encode(encryptagain)

print(encodechallengeone.decode('utf-8'))
writefile = open("encryptedchallenge.txt","w")
writefile.write(encodechallengeone.decode('utf-8'))
