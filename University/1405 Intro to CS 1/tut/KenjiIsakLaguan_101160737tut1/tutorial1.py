import pygame 

pygame.display.init()
screen_size = (1000,1000)
screen = pygame.display.set_mode(screen_size)

LIGHT_SKY_BLUE = (130, 202, 250) 
GRAY = (115, 111, 110)
STEEL_BLUE = (72, 99, 160)

screen.fill(LIGHT_SKY_BLUE)

pygame.draw.rect(screen,GRAY,(500,300,100,400),0)#torso1

pygame.draw.rect(screen,STEEL_BLUE,(500,700,30,200),0)#left leg2
pygame.draw.rect(screen,STEEL_BLUE,(570,700,30,200),0)#right leg3

pygame.draw.circle(screen,STEEL_BLUE,(550,265),70,0)#head4
pygame.draw.circle(screen,STEEL_BLUE,(300,600),20,0)#left side hand5
pygame.draw.circle(screen,STEEL_BLUE,(800,600),20,0)#right side hand6

pygame.draw.polygon(screen,STEEL_BLUE,[(500,350),(300,600),(500,400)],0)#left side arm7
pygame.draw.polygon(screen,STEEL_BLUE,[(600,350),(800,600),(600,400)],0)#right side arm8

pygame.display.update()
pygame.time.delay(5000)
pygame.quit()
