.PHONY: setuid

3000shell2: 3000shell2.c
	gcc -Wall -O 3000shell2.c -o 3000shell2

setuid: 3000shell2
	@echo "The following changes ownership to root, group to root, and sets the setuid bit on 3000shell2:"
	sudo chown root:root 3000shell2 && sudo chmod u+s 3000shell2
	@echo "3000shell2 is now setuid root!"
