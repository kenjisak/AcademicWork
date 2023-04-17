.PHONY: setuid

3000userlogin: 3000userlogin.c
	gcc -Wall -O 3000userlogin.c -o 3000userlogin

setuid: 3000userlogin
	@echo "The following changes ownership to root, group to root, and sets the setuid bit on 3000userlogin:"
	sudo chown root:root 3000userlogin && sudo chmod u+s 3000userlogin
	@echo "3000userlogin is now setuid root!"
