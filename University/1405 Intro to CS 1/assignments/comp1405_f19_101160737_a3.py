#Kenji Isak Laguan
#101160737

#Paranormal Horror
#	"Paranormal Activity" - home recording
#	"It" - based on stephen kings book
#	"The Nun" - demonic nun
#	"Annabelle" - possessed vintage doll
#	"The Conjuring" - haunted farmhouse 
#	"Sinister" - monster looks like a kiss member
#	"Insidious" - son is in a coma
#	"The Ring" - cursed videotape leading to the viewers death in 7 days
#	"The Possession of hannah grace" - excorcism
#	"Mama" - horrific mother

#Scifi Horror
#	"Splice" - created a hybrid species
#	"Alien covenant" - has a xenomorph
#	"The Cabin in the Woods" - a cabin in the woods
#	"Life" - on board the ISS
#	"Cloverfield" - point of view from a video camera of a charachter
#	"Predator" - alien that hunts other species for sport
#	"Bright Burn" - boy has a red cape
#	"A Quiet Place" - monsters that hunt by sound
#	"Apollo 18" - moon mission
#	"Resident Evil: The Final Chapter" - based off a video game
loop = True
def scifi():
	splice = input("Does the movie have people create a hybrid species? ")
	if splice.lower() == "yes":
		print("Your movie is Splice")
	else:
		alien = input("Does the movie have a Xenomorph? ")
		if alien.lower() == "yes":
			print("Your movie is Alien Covenant")
		else:
			cabin = input("Does the movie have a cabin in the woods? ")
			if cabin.lower() == "yes":
				print("Your movie is The Cabin in the Woods")
			else:
				life = input("Is the movie set on the ISS? ")
				if life.lower() == "yes":
					print("Your movie is Life")
				else:
					cloverfield = input("Is the movie filmed in the point of view of a video camera of a charachter? ")
					if cloverfield.lower() == "yes":
						print("Your movie is Cloverfield")
					else:
						predator = input("Does the movie have an alien that hunts other species for sport? ")
						if predator.lower() == "yes":
							print("Your movie is Predator")
						else:
							bright = input("Does the movie have a boy with a red cape? ")
							if bright.lower() == "yes":
								print("Your movie is Bright Burn")
							else:
								quiet = input("Does the movie have monsters that hunt by sound? ")
								if quiet.lower() == "yes":
									print("Your movie is A Quiet Place")
								else:
									apollo = input("Does the movie have a moon mission? ")
									if apollo.lower() == "yes":
										print("Your movie is Apollo 18")
									else:
										resident = input("Is the movie based off a video game? ")
										if resident.lower() == "yes":
											print("Your movie is Resident Evil: The Final Chapter")
										else:
											print("Your movie isn't listed here")

def paranormal():
	paranormalactivity = input("Is the movie filmed in the point of view as a home recording? ")
	if paranormalactivity.lower() == "yes":
		print("Your movie is Paranormal Activity")
	else:
		it = input("Is the movie based off a Stephen King book? ")
		if it.lower() == "yes":
			print("Your movie is It")
		else:
			nun = input("Does the movie have a demonic nun? ")
			if nun.lower() == "yes":
				print("Your movie is The Nun")
			else:
				annabelle = input("Does the movie have a possessed vintage doll? ")
				if annabelle.lower() == "yes":
					print("Your movie is Annabelle")
				else:
					conjuring = input("Does the movie have a haunted farmhouse? ")
					if conjuring.lower() == "yes":
						print("Your movie is The Conjuring")
					else:
						sinister = input("Does the movie have a monster that looks like a kiss member? ")
						if sinister.lower() == "yes":
							print("Your movie is Sinsister")
						else:
							insidious = input("Does the movie have the son in a comatose? ")
							if insidious.lower() == "yes":
								print("Your movie is Insidious")
							else:
								ring = input("Does the movie have a cursed video tape leading to the viewers death in 7 days? ")
								if ring.lower() == "yes":
									print("Your movie is The Ring")
								else:
									possession = input("Does the movie have an excorcism? ")
									if possession.lower() == "yes":
										print("Your movie is The Possession of Hannah Grace")
									else:
										mama = input("Does the movie have a horrific mother? ")
										if mama.lower() == "yes":
											print("Your movie is Mama")
										else:
											print("Your movie isn't listed here")


while loop == True:

	instructions = input("Would you like instructions before you start? ")
	if instructions.lower() == "yes":
		print("\nFirst you will be prompted to choose between one of two subgenres. You must enter the number corresponding to the subgenre otherwise the program will terminate.\n\nThen you will be given a series of questions regarding to movies in that subgenre.You must only answer either yes or no to any of them.\n")
		subgenre = input("Which subgenre would you like?\n1. Paranormal Horror\n2. Sci-Fi Horror\n")
		if subgenre == "1":
			paranormal()
			loop = input("Would you like to start again?") 
			if loop.lower() == "yes":
				loop = True
			else:
				loop = False
		elif subgenre == "2":
			scifi()
			loop = input("Would you like to start again?") 
			if loop.lower() == "yes":
				loop = True
			else:
				loop = False
		else:
			quit()
	else:
		subgenre = input("Which subgenre would you like?\n1. Paranormal Horror\n2. Sci-Fi Horror\n")
		if subgenre == "1":
			paranormal()
			loop = input("Would you like to start again?") 
			if loop.lower() == "yes":
				loop = True
			else:
				loop = False
		elif subgenre == "2":
			scifi()
			loop = input("Would you like to start again?") 
			if loop.lower() == "yes":
				loop = True
			else:
				loop = False
		else:
			quit()
