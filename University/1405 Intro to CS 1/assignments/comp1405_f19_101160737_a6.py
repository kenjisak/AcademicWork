#Kenji Isak Laguan
#101160737

def instructions():
	print("Enter a valid row of chesspieces(enter 8 of any combination of upper or lowercase K, Q, R, N, B, P, - about 8 times. Uppercase for Black pieces and lowercase for white pieces\nThen you are given 3 options, either to quit, enter a new chessboard, or to move a piece. if you choose to move a piece then you will be prompted if you would like to either remove a piece or to move a piece\nYou will continously be prompted until you prompt to exit the program.\n When inputting rows and columns, choose a value between 0 - 7\n")
	#prints out instructions for the user to play the game
	#@params	none
	#@return	none
def move(board):
	loop1 = True
	while loop1 == True:
		rowog = int(input("Enter the row of the piece youd like to move: "))
		colog = int(input("Enter the column of the piece youd like to move: "))
		if int(0) <= rowog <= int(7) and int(0) <= colog <= int(7):
			if board[rowog][colog] != "-":
				loop1 = False
			else:
				print("This space is empty, choose another space with a piece")
		else:
			print("Number given is out of index, choose a number between 0 and 7")		
	loop2 = True
	while loop2 == True:
		rownew = int(input("Enter the new row location: "))
		colnew = int(input("Enter the new column location: "))
		if int(0) <= rownew <= int(7) and int(0) <= colnew <= int(7):	
			loop2 = False	
		else:
			print("Number given is out of index, choose a number between 0 and 7")	
	board[rownew][colnew] = board[rowog][colog]
	board[rowog][colog] = "-"
	printchess(board)
	score(board)
	questions(board)
	#asks the user for a valid location on the chessboard that isnt empty then moves the piece to a new location and replaces its old spot with a - string. then it reprints the chessboard and score and then asks the user questions again
	#@params	board is the chessboard being modified in this function
	#@return	none
def remove(board):
	loop = True
	while loop == True:
		rowog = int(input("Enter the row of the piece youd like to remove: "))	
		colog = int(input("Enter the column of the piece youd like to remove: "))
		if int(0) <= rowog <= int(7) and int(0) <= colog <= int(7):						
			if board[rowog][colog] == "-":
				print("This space already doesnt have a piece on it choose another space")
			else:
				loop = False	
		else:
			print("Number given is out of index, choose a number between 0 and 7")	
	board[rowog][colog] = "-"
	printchess(board)
	score(board)
	questions(board)
	#asks for user input on locations in the 2d array, then checks if the locations inputted is in the right index, then if theres already an empty space in that location then it loops back and asks the user for another location that isnt already empty then removes that piece and leaves it empty with a - string.then reprints the updated chessboard and score then asks the questions again
	#@params	board is the chessboard thats being modified in this function
	#@return	none
def makeboard():
	chessboard = []
	for x in range(8):
		emptylist = []
		loop = True
		while loop == True:			
			row = input("Enter pieces for the " + str(x+1) + " row ")
			row = list(row)
			if len(row) != 8:
				print("You must input 8 Pieces")
			else:
				loop = checkcharachters(row)
		chessboard.append(row)
	printchess(chessboard)
	score(chessboard)
	questions(chessboard)
	#creates the chessboard without list comprehensions, also checks if the user entered any other number of characters other than 8 and loops back.then also checks the characters in the input to see if theres any invalid pieces in it. prints the current state of the chessboard and also displays the current score.then asks the user questions wiht the function
	#@params	none
	#@return	none
def printchess(board):
	for x in range(len(board)):
		for y in range(len(board[x])):
			print(board[x][y],end = "")
		print()
	#displays the 2d chessboard using a nested loop
	#@params	board is the chessboard 2d array list
	#@return 	none
def checkcharachters(listofrow): #checks if each character in the row being inputed is a valid piece 
	for x in range(len(listofrow)):
		asciival = ord(listofrow[x])
		if asciival == ord("k") or asciival == ord("K") or asciival == ord("q") or asciival == ord("Q") or asciival == ord("r") or asciival == ord("R") or asciival == ord("n") or asciival == ord("N") or asciival == ord("b") or asciival == ord("B") or asciival == ord("p") or asciival == ord("P") or asciival == ord("-"):
			print("",end = "")		
		else:
			print("Invalid character detected")
			return True
			#@return 	returns true if theres an invalid chess piece in the row
	return False
	#@return	returns false if the entire row list is filled with all valid pieces
	
	#@params	listofrow is the row list thats being anazlyzed 
	
def score(board):
	whitescore = 0 
	blackscore = 0
	listofpoints = [0,10,5,3.5,3,1]
	for x in range(len(board)):
		for y in range(len(board[x])):
			if board[x][y] == "K":
				blackscore = blackscore + listofpoints[0]
			elif board[x][y] == "k":
				whitescore = whitescore + listofpoints[0]
			elif board[x][y] == "Q":
				blackscore = blackscore + listofpoints[1]
			elif board[x][y] == "q":
				whitescore = whitescore + listofpoints[1]
			elif board[x][y] == "R":
				blackscore = blackscore + listofpoints[2]
			elif board[x][y] == "r":
				whitescore = whitescore + listofpoints[2]
			elif board[x][y] == "N":
				blackscore = blackscore + listofpoints[3]
			elif board[x][y] == "n":
				whitescore = whitescore + listofpoints[3]
			elif board[x][y] == "B":
				blackscore = blackscore + listofpoints[4]
			elif board[x][y] == "b":
				whitescore = whitescore + listofpoints[4]
			elif board[x][y] == "P":
				blackscore = blackscore + listofpoints[5]
			elif board[x][y] == "p":
				whitescore = whitescore + listofpoints[5]
	print("White currently has a score of " + str(whitescore) + " and Black currently has a score of " + str(blackscore))
	if whitescore > blackscore :
		print("Therefore White is Winning.\n")
	elif whitescore < blackscore:
		print("Therefore Black is Winning.\n")
	else:
		print("Therefore they're tied.\n")	
	#this is the keeping score function, it contains a list of floating point values of the chess pieces, then checks each position on the board and checks which piece it is then adds it up to either the white or black piece scor. then displays the scores and who is wining or if theyre tied
	#@params	board is the chessboard that is being read and analyzed in this function.
	#@return	none
def questions(board):
	answer = input("Would you like to (1) quit the program, (2) enter another chessboard from scratch, or (3) move a piece on the current chessboard? ")
	if answer == "1":
		quit()
	elif answer == "2":
		start()
	elif answer == "3":
		anotheranswer = input("Would you like to (1) remove or (2) move a piece? ")
		if anotheranswer == "1":
			remove(board)
		elif anotheranswer == "2":		
			move(board)
	#this function displays the 3 options that the user can choose from, depending on which answer they input, the corresponding function is called inside the if statements. anotheranswer is for asking if the user would like to move or remove the piece giving them 2 options and then again calls the proper function depending on the user input
	#@params	board is the parameter that contains the 2d list of the chessboard so that it can be modified
	#@return	none
def start():
	instructions()
	makeboard()
	#this functin calls other functions to display the instructions and creates the chessboard
	#@params	none
	#@return	none
def main():
	start()
	#this is the main function that calls the start function to be able to start the process of making the chessboard and game.
	#@param		none
	#@return	none
main()

	
