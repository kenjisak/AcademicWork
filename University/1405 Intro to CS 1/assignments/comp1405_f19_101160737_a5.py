#Kenji Isak Laguan 101160737
#put your student name and identification here
#define and write each of your functions here
#replaces phrases(replaces by the way with btw automatically)
#replaces words(replaces please with plz automatically)
#replaces letters(replaces letter with a for @ or e for 3 I for 1 , o for 0 , 

# this is the definition of your main function
def stitchwords(listex):
	stringtocombine = ""
	#print(listex)
	for x in range(len(listex)):
		stringtocombine = stringtocombine + listex[x] + " "
	return(stringtocombine)
def stitchletters(listex):
	stringtocombine = ""
	#print(listex)
	for x in range(len(listex)):
		stringtocombine = stringtocombine + listex[x]
	return(stringtocombine)
	
def splitwords(sentence):
	word = ""
	newlist = []
	for x in sentence:
		if x == " " :
			newlist.append(word)
			word = ""
		else:
			word += x
	if word:
		newlist.append(word)
	return(newlist)

def toupper(string):
	strings = ""
	for x in range(len(string)):
		num = ord(string[x])
		if num > 96:
			asciivalue = num - 32
			strings = strings + chr(asciivalue)
		else: 
			strings = strings + chr(num)
	return(strings)
#def phrases(string):

def words(string):
	listwords = splitwords(string)
	for x in range(len(listwords)):
		if listwords[x] == "PLEASE":
			listwords[x] = "PLS"
		if listwords[x] == "PEOPLE":
			listwords[x] = "PPL"
		if listwords[x] == "THANKS":
			listwords[x] = "THX"
		if listwords[x] == "YOU":
			listwords[x] = "U"
	return(stitchwords(listwords))
	
def lettersfunc(string,letters):
	#make letters into list and single them out
	#if one of the letters is in the list then replace it
	newstring = string
	liststring = list(letters)
	listnewstring = list(newstring)
	#print(liststring)
	#print(listnewstring)
	for x in range(len(letters)):
		for y in range(len(string)):		
			if liststring[x]=="A" or liststring[x] == "a" and listnewstring[y] == "A":
				#newstring = newstring.replace("A","@")
				listnewstring[y] = "@"
			if liststring[x]=="E" or liststring[x]== "e" and listnewstring[y] == "E":
				#newstring = newstring.replace("E","3")
				listnewstring[y] = "3"
			if liststring[x]=="I" or liststring[x]== "i" and listnewstring[y] == "I":
				#newstring = newstring.replace("I","1")
				listnewstring[y] = "1"
			if liststring[x]=="O" or liststring[x]== "o" and listnewstring[y] == "O":
				#newstring = newstring.replace("O","0")
				listnewstring[y] = "0"
			if liststring[x]=="S" or liststring[x]== "s" and listnewstring[y] == "S":
				#newstring = newstring.replace("S","$")
				listnewstring[y] = "$"
			if liststring[x]=="T" or liststring[x]== "t" and listnewstring[y] == "T":
				#newstring = newstring.replace("T","7")
				listnewstring[y] = "7"
			if liststring[x]=="K" or liststring[x]== "k" and listnewstring[y] == "K":
				#newstring = newstring.replace("K","|<")
				listnewstring[y] = "|<"
			if liststring[x]=="L" or liststring[x]== "l" and listnewstring[y] == "L":
				#newstring = newstring.replace("L","|_")
				listnewstring[y] = "|_"
		if liststring[x] != "A" and liststring[x] != "a" and liststring[x] != "I" and liststring[x] != "i" and liststring[x] != "E" and liststring[x] != "e" and liststring[x] != "O" and liststring[x] != "o" and liststring[x] != "S" and liststring[x] != "s" and liststring[x] != "T" and liststring[x] != "t" and liststring[x] != "K" and liststring[x] != "k" and liststring[x] != "L" and liststring[x] != "l":
			print("This program cant replace the letter " + toupper(liststring[x]))
	return(stitchletters(listnewstring))


def main():
	stringinput = input("Type the string to be translated: ")
	sentence = toupper(stringinput)
	print(sentence)
	#print(splitwords(sentence))
	#extracts only characters and prints it in uppercase
	
	loopletters= True	
	loopwords = True
	loopphrases = True
	while loopwords == True: 	
		rephrases = input("Would you like to replace words? ")
		if(rephrases.lower() == "yes"):
			sentence = words(sentence)
			print(sentence)
			loopwords= False
		elif(rephrases.lower() == "no"):
			loopwords= False
		else: 
			print("Please enter yes or no.")
			
			
	while loopletters == True: 	
		rephrases = input("Would you like to replace letters? ")
		if(rephrases.lower() == "yes"):
			letterstoreplace = input("What letters do you want to replace? ")
			print(lettersfunc(sentence,letterstoreplace))
			loopletters= False
		elif(rephrases.lower() == "no"):
			loopletters = False
		else: 
			print("Please enter yes or no.")
	
	endinginput = input("Would you like to translate another string? ")
	if(endinginput.lower() == "yes"):
		main()
	else:
		exit()
	# write the part of the program that interacts with the user here
# these should be the last two lines of your submission
__name__ = '__main__'
if __name__ == '__main__':
	main()
