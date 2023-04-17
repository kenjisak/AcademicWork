print("Grocery Items:\n1. Can of soup(5.99)\n2. Orange Juice(3.99)\n3. Chocolate Bar(1.99")

cost1 = int(5)
cost2 = int(3)
cost3 = int(1)

cart = int(0)
while True:
	itemnum = input("Enter the item number of the item would you like to purchase(Enter EXIT to quit) ")	
	if itemnum == "EXIT":
		break
	numofitem = int(input("How many of these would you like? "))
	if itemnum == "1":
		itemnum = int(cost1)
	elif itemnum == "2":
		itemnum = int(cost2)
	elif itemnum == "3":
		itemnum = int(cost3)

	cart = cart + (itemnum * numofitem)

total = cart * 1.13
print("Your total is: ",("{:.2f}".format(total)))

