file = open("100-usernames.txt","r")
writefile = open("output.txt","w")

for line in file:
    result = ''.join(('"',line.replace("\n",'",')))
    writefile.write(result) #writes to file of just passwords

