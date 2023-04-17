import requests

challenge = open('encryptedchallenge.txt').read()

r = requests.post('http://134.117.225.40/sendchallenge_return.php', data={"sid" : '101160737',"challenge": challenge})
if r.status_code == requests.codes.ok:
    print(r.text)
else:
    print("error")
