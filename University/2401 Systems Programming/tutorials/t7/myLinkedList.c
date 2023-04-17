#include <stdio.h>
#include <string.h>
#include <stdlib.h>


// define employee structures

#define NAME_LENGTH  16

// define employee structures
typedef struct name {
  char firstName[NAME_LENGTH];
  char familyName[NAME_LENGTH];
} NameType;

typedef struct emp{
  unsigned int	id;
  float salary;
  NameType name;
} EmployeeType;

// define linked list structures
typedef struct listNodeStruct ListNodeType;

struct listNodeStruct {
	EmployeeType *data;
	ListNodeType *next;	// next node in the linked list
};

// forward references to employee operations
void printEmployee(EmployeeType *emp);
void initEmployee(EmployeeType *emp, char *firstName, char *familyName, unsigned int id, float salary);

// forward references to linked list operations
int addNode(ListNodeType **head, EmployeeType *data);
void printList(ListNodeType *head);
void deleteNode(ListNodeType **head, EmployeeType **data);

int main(void) {
	int i;

	EmployeeType employee[5];
	EmployeeType *data = NULL;

	initEmployee(&employee[0], "Joe", "Clark", 567890345,100345);
	initEmployee(&employee[1],"Brian", "Mulroney", 567890767, 178983);
	initEmployee(&employee[2],"Jean", "Chretien", 567345890, 190329);
	initEmployee(&employee[3],"Paul", "Martin", 567899528, 192456);
	initEmployee(&employee[4],"Kim", "Campbell", 567436582, 192234);


	printf("array of employees \n");
	for (i = 0; i < 5; i++) {
		printEmployee(&employee[i]);
	}

	ListNodeType *empHead = NULL;

	// add five nodes  
	for (i = 0; i < 5; i++) {
		addNode(&empHead, &employee[i]);
	}

	printf("\n Printing the list from the first node to the last node \n");
	printList(empHead);



	// delete five nodes  
	for (i = 0; i < 5; i++) {
	  deleteNode(&empHead, &data);
	  printf("deleted node [%d] \n",i);
	  printEmployee(data);
	}
	
	printf("\n");
	printf("\n Printing the list from the first node to the last node \n");
	printList(empHead);
	return 0;
}


// define employee operations

void printEmployee(EmployeeType *emp)
{
	printf("%-16s %-16s %8d  %8.2f \n",emp->name.firstName, emp->name.familyName,emp->id, emp->salary);

}

void initEmployee(EmployeeType *emp, char *firstName, char *familyName, unsigned int id, float salary)
{
	strncpy(emp->name.firstName, firstName, NAME_LENGTH - 1);
	strncpy(emp->name.familyName, familyName, NAME_LENGTH - 1);
	emp->id = id;
	emp->salary = salary;

}


// define linked list operations

/***********************************************************/
/*
Purpose:  adds a record as the first node of the linked list 
input:
head - head of the list
data - a pointer to an Employee record

Output
head - the updated head of the list 

Return
0 - if data was successfully added to the list
1 - if node was not added to the list
*/


int addNode(ListNodeType **head, EmployeeType *data)
{

	ListNodeType *newitem = NULL;


	// Step 1 allocate memory for the node and initialize all pointers to NULL
	newitem = (struct listNodeStruct *)malloc(sizeof(struct listNodeStruct));
	if (newitem == NULL){
		return 1;
	}
    // if an error occured then return 1

	// Step 2 assign the employee record to data
	newitem->data = data;
	// Step 3 update the next field of the new node to point to the first node in the list as a "next" node
		//next field of newitem, points to the first node in the list as a "next"node
	newitem->next = head[0];
	// Step 4 update the list head to point to the new node.
	head[0] = newitem;
    //
	return(0);

}



/***********************************************************/
/*
Purpose:  prints the list from the first node to the last node
input:
head - head of the list

Output
None

Return
None
*/

void printList(ListNodeType *head) 
{

    // while list is not empty 
        // print the node (using the printEmployee() function)
        // advance to the next node
        ListNodeType *temp = head;
	while(temp != NULL){
		printEmployee(temp->data);
		temp = temp->next;
	}
}


/***********************************************************/
/*
Purpose:  delete the first node from the linked list 
input:
head - head of the list

Output
head - the updated head of the list 
data - the data that was stroed in the record 

Return
none 
*/

void deleteNode(ListNodeType **head, EmployeeType **data)
{

	ListNodeType *todelete = NULL;

    
	// Step 1 
    // if the list is empty then
    //     set data to NULL
    //     return
    // else set p to the point to the first node
	if(head == NULL){
		*data = NULL;
		//return 0;
	}else{
		todelete = *head;
	}
	// Step 2 assign the data in the node to the output data 
	*data = (*head)->data;//data is a pointer of all employee data// this is whats getting printed after the pointer to the head gets deleted
	// Step 3 set the head to point to the next node in the list 
	*head = (*head)->next; 
	// Step 4 free the node pointed to by p and set p to NULL
	free(todelete);
	todelete = NULL;
}
/***********************************************************/




