import requests

mycert = open('mycert.crt').read()
# print(csrtext)
r = requests.post('http://134.117.225.40/getchallenge_return.php', data={"sid" : "101160737","cert": mycert})
if r.status_code == requests.codes.ok:
    # print(r.text)
    response = r.json()
    skey = response['sessionkey_encrypted']
    challenge = response['challenge_encrypted']
    print("Session Key Encrypted:",skey)
    print("\nChallenge Encrypted:",challenge)

    writefile = open("skey.txt","w")
    writefile.write(skey)     

    writefile = open("challenge.txt","w")
    writefile.write(challenge)     
else:
    print("error")