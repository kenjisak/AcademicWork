#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//kenji isak laguan
//101160737

typedef struct {
	char *name;
	double *cost;
	float *weight;
	int storageflag; //ref = 0, frozen = 1
}GroceryItemType;

typedef struct {
	GroceryItemType **groceryitem;//max items = 25
	int itemcountbag;//real count of items in bag = 25
	double totalweight;//max weight = 5kg
}BagType;

typedef struct {
	GroceryItemType **loosegroceryitems;
	int totalitemcountcart;// max items = 100
	int bagscount;
	BagType **packedbags;
}CartType;

int additemtocart(GroceryItemType*, CartType*);
int additemtobag(GroceryItemType*, BagType*);
int removeitemfrombag(GroceryItemType*, BagType*);
void displayitem(GroceryItemType*);
void displaybagcontents(BagType*, int);
void displaycartcontents(CartType*);
void packbags();
void removeperishableitemsfromcart();

int main() {
	GroceryItemType testItems[12];
	char* sampleItemNames[] = { "Smart-Ones Frozen Entrees", "SnackPack Pudding", "Breyers Chocolate Icecream", "Nabob Coffee", "Gold Seal Salmon", "Ocean Spray Cranberry Cocktail", "Heinz Beans Original", "Lean Ground Beef", "5-Alive Frozen Juice", "Coca-Cola 12-pack", "Toilet Paper - 48 pack", "Crate of milk" };
	float sampleItemPrices[] = { 1.99, 0.99, 2.99, 3.99, 1.99, 2.99, 0.79, 4.94, 0.75, 3.49, 40.96, 12.99 };
	float sampleItemWeights[] = { 0.311, 0.396, 2.27, 0.326, 0.213, 2.26, 0.477, 0.75, 0.426, 5.112, 10.89f, 6.18f };
	float sampleItemPerish[] = { 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1 };

}
int additemtocart(GroceryItemType *item,CartType *cart) {
	cart->loosegroceryitems = item;
	return 1;
}
int additemtobag(GroceryItemType* item, BagType* bag) {
	return 1;
}
int removeitemfrombag(GroceryItemType* item, BagType* bag) {
	return 1;
}
void displayitem(GroceryItemType* item) {
	if (item->storageflag == 1) {
		printf("\t*%s weighing %0.3fkg with price $%0.2f\n", item->name, *item->weight, *item->cost);
	}
	else {
		printf("\t%s weighing %0.3fkg with price $%0.2f\n", item->name, *item->weight, *item->cost);
	}
}
void displaybagcontents(BagType *bag, int bagnum) {
	//use displayitem func
	printf("BAG %d (Total Weight = %0.3fkg)",bagnum , bag->totalweight);
	for (int i = 0; i<bag->groceryitem; i++) {
		displayitem(bag->groceryitem[i]);
	}
}
void displaycartcontents(CartType* cart) {
	//use displayitem and displaybagcontents func
	for (int i = 0;i<cart->bagscount; i++) {
		displaybagcontents(cart->packedbags[i], i);
	}
}
void packbags() {
	
}
void removeperishableitemsfromcart() {

}