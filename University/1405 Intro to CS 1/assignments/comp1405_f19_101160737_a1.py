#Kenji Isak Laguan
#101160737
import pygame 

drawing_window = pygame.display.set_mode((500,500))
drawing_window.fill((102, 152, 255))
#sky blue rgb hex value(#6698FF)sky
#####################################################################################
pygame.draw.ellipse(drawing_window,(52, 124, 44) , (0,350,500,300),0)
#jungle green rgb hex value(#347C2C)land
####################################################################################
pygame.draw.rect(drawing_window, (255, 235, 205), (150,200,200,200),0)
#blanched almond rgb hex value(#FFEBCD) house
pygame.draw.rect(drawing_window, (131, 92, 59), (180,320,50,80),0)
#brown bear rgb hex value (#835C3B)door
#####################################################################################
pygame.draw.circle(drawing_window,(255, 255, 255) , (300,340) , 30,0) 
#white rgb hex value(#FFFFFF)window next to door
pygame.draw.circle(drawing_window,(255, 255, 255) , (300,250) , 30,0) 
#white rgb hex value(#FFFFFF)window top right
pygame.draw.circle(drawing_window,(255, 255, 255) , (200,250) , 30,0) 
#white rgb hex value(#FFFFFF)window top left
pygame.draw.circle(drawing_window, (253, 208, 23) , (0,0) ,100, 0)
#bright gold rgb hex value (#FDD017) sun
#########################################################################################
pygame.draw.polygon(drawing_window,(131, 92, 59) , [(150,200),(350,200),(250,100)],0)
#brown bear rgb hex value (#835C3B) roof
########################################################################
pygame.draw.rect(drawing_window,(131, 92, 59) , (270,337,60,5),0)
#brown bear rgb hex value (#835C3B)window panes next to door horizontal
pygame.draw.rect(drawing_window,(131, 92, 59) , (297,310,5,60),0)
#brown bear rgb hex value (#835C3B)window panes next to door vertical

pygame.draw.rect(drawing_window,(131, 92, 59) , (270,247,60,5),0)
#brown bear rgb hex value (#835C3B)window panes top right horizontal
pygame.draw.rect(drawing_window,(131, 92, 59) , (297,220,5,60),0)
#brown bear rgb hex value (#835C3B)window panes top right vertical

pygame.draw.rect(drawing_window,(131, 92, 59) , (170,247,60,5),0)
#brown bear rgb hex value (#835C3B)window panes next to door horizontal
pygame.draw.rect(drawing_window,(131, 92, 59) , (197,220,5,60),0)
#brown bear rgb hex value (#835C3B)window panes next to door vertical
######################################################################
pygame.draw.circle(drawing_window,(131, 92, 59) , (300,340) , 30,3) 
#brown bear rgb hex value (#835C3B)window next to door circle frame
pygame.draw.circle(drawing_window,(131, 92, 59) , (300,250) , 30,3) 
#brown bear rgb hex value (#835C3B)window top right circle frame
pygame.draw.circle(drawing_window,(131, 92, 59) , (200,250) , 30,3) 
#brown bear rgb hex value (#835C3B)window top left circle frame
##############################################################################
pygame.draw.polygon(drawing_window,(111, 78, 55) , [(30,450),(130,450),(80,400)],0)
#coffee rgb hex value (#6F4E37) base of tree
pygame.draw.rect(drawing_window, (111, 78, 55), (60,250,40,200),0)
#coffee rgb hex value (#6F4E37) tree trunk
pygame.draw.polygon(drawing_window,(102, 124, 38) , [(30,250),(130,250),(80,100)],0)
#fern green hex value(#667C26) tree leaves
#################################################################################
pygame.display.update()
pygame.time.delay(3000)
pygame.display.quit()

