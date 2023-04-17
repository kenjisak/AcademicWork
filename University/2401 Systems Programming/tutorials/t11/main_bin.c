#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "person.h"

int fexists(char *fileName);

int main(int argc, char *argv[]) {

  struct personalInfo person;
  FILE *fid;
  int i;
  int rc;

// add coded


  // if the file does not exist print message

  // open the file

  // read first record

  // print the record

  // close the file


  return 0;
}

/************************************************************************/
// Return whether the given file exists in the current directory.
// TODO: Complete this function.
int fexists(char *fileName)
{
  	FILE *fp = NULL;
	int rc = 0;

	// open the file

	fp = fopen(fileName, "r");

	// determine the recturn code

	if(!fp){
		rc = 0;
	}else{
		rc = 1;
		fclose(fp);
	}
	return(rc);
}
