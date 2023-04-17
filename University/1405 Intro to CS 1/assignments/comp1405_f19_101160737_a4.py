#Kenji Isak Laguan
#101160737
#chroma key
# first image is a background image
# second image is the ghost
#overlay the ghost on the background , centered at a point defined by user
# can be done with less than 50 lines of code
import pygame

#ask user for instructions, requires branching control structure
#get filenames of ghost image and background image with input function call
#display background image
#after displaying, ask user for the x and y coordinates at which to center the ghost, you can ask for the values in the terminal
#if user gives invalid coordinates, loop back to ask again
#use nested loops to check each pixels from the ghost image and see if the pixel is green or not, if the pixel is green , then dont copy that pixel onto background
#if nested loop encounters pixel not green , then must average red,green,and blue values of the non green pixel with the corresponding pixel from the background. to get semi transparency
#must update display once finished processing using pygame.display.update and leave the window open 
#abandoned_homestead.bmp
#ghost_with_broom.bmp
def program():
	#filenameback = input("Enter the file name for the background image: ")
	#filenameghost = input("Enter the file name for the ghost image: ")

	filenameback = "abandoned_homestead.bmp"
	filenameghost = "ghost_with_broom.bmp"

	backgroundimage = pygame.image.load("/home/student/Desktop/images/" + filenameback)
	ghostimage = pygame.image.load("/home/student/Desktop/images/" + filenameghost)

	(widthback , heightback) = backgroundimage.get_rect().size
	(widthghost , heightghost) = ghostimage.get_rect().size

	drawing_window = pygame.display.set_mode((widthback , heightback))
	drawing_window.blit(backgroundimage, (0,0))
	pygame.display.update()	

	
	loop = True 
	while loop == True:
		ghostx = input("Enter the ghost x coordinate: ")
		ghosty = input("Enter the ghost y coordinate: ")
		ghostx = int(ghostx)
		ghosty = int(ghosty)
		
		if ghostx > widthback or ghostx < 0: 
			loop = True
			print("Invalid Coordinates")
		elif ghosty > heightback or ghosty < 0:
			loop = True
			print("Invalid Coordinates")
		else:
			loop = False
	
	newxcoor = (ghostx - (widthghost/2))
	newycoor = (ghosty - (heightghost/2))
	
	for x in range(widthghost):
		for y in range(heightghost):
			(rghost,gghost, bghost,_) = ghostimage.get_at((x,y))
			if gghost!= 255:
				if(x+newxcoor) >=0 and (y+newycoor) >= 0 and (x+newxcoor) < widthback and (y+newycoor)<heightback:	
					(rback,gback, bback,_) = backgroundimage.get_at((x+ghostx,y))
					drawing_window.set_at((x+newxcoor),(y+newycoor),((rghost + rback)/2),((gghost + gback)/2),((bghost + bback)/2))	
	pygame.display.update()
instructions = input("Would you like intructions? ")
if instructions == "yes": 
	print("instructions")
	program()
else:
	program()

	
