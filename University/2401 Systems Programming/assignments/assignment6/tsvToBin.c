#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int fexistsread(char *fileName);
int fexistswrite(char *fileName);
void readFile(FILE *fid);

int main(int argc, char *argv[]) {
	FILE *fid;

	
	int rc = 0;
	// check if file exists
	rc = fexistsread("pandemic.tsv");
	// print message depending whether the file exists
	if (rc == 1){
		printf("File Exist");
		fid = fopen("pandemic.tsv", "r");
		readFile(fid);
	}else{
		printf("File dont exist");
	}
	
	
	return 0;
	//read line by line, check line by line if data on that line is ongoing,resolved, or incomplete, if either then write to the right files 
}

int fexistsread(char *fileName){
	FILE *fp = NULL;
	int rc = 0;
	fp = fopen(fileName, "r");
	if(!fp){
		rc = 0;
	}else{
		rc = 1;
		fclose(fp);
	}
	return(rc);
}
int fexistswrite(char *fileName){
	FILE *fp = NULL;
	int rc = 0;
	fp = fopen(fileName, "w+");
	if(!fp){
		rc = 0;
	}else{
		rc = 1;
		fclose(fp);
	}
	return(rc);
}
int chardatatoint(char *data){
	//data to int, numbers in thousands have quotations, convert nums to ints and return
	//else data is N/A, blank, so return -1 to indicate line is incomplete
}
void readFile(FILE *fid){
	char linedata[200];
	char *countrynumberdiscard;
	char *country;
	char *totalcases;
	//new cases
	char *totaldeaths;
	//new deaths
	char *totalrecovered;
	//active cases
	//serious
	//total cases/1m pop
	//deaths/1mpop
	//total tests
	//tests/1mpop
	char *population;
	
	
	FILE *fidwongoing = fopen("ongoing.bin", "w+");
	FILE *fidwresolved = fopen("resolved.bin", "w+");
	FILE *fidwincomplete  = fopen("incomplete.bin", "w+");
		
	int numoflines;
	int linecount;
	//use fget, do fget and keep a counter for how many lines; keep separate counter to count which line where one rn and to skip first line. 
	while(!feof(fid)){
		unsigned short int ongoingcounter;
		unsigned short int resolvedcounter;
		unsigned short int incompletecounter;
		char impact;
		linecount++;
		
		
		if (linecount == 1){
			//skip header read
			continue;
		}
		char *str;
		fgets(str,200,fid);//store all data of each line
		char *testtoken = strtok(str," ");
		int counter = 0;
		while(testtoken != NULL){//check how many data there is in a line.
			counter++;
			testtoken = strtok(NULL," ");	
		}
		if(counter <12){
			//write data to incomplete
		}else{//else if counter is 12 and has all data
			//save token data again
			
			//check if one of value is N/A
				//if it is then write to incomplete
			//if none of value is N/A then 
				//if cases == deaths +recovered, write to resolved.bin rescount ++, 
				//write all data except total cases;
				//else if cases != deaths + recovered then write to ongoing, oncount ++;
				//if total cases <= (population * 0.05)
					//impact = "L";
				//else if total cases >= (population * 0.30)
					//impact = "H";
				//else
					//impact = "M";
				//write all data at end of this
		}
		
		//make while loop to count how many data was acc saved, if less than 12 due to missing blank data return -1 for incomplete
		//when going through data if N/A appears then also return -1 for incomplete
				//go through that data and separate everything with strok,might have to make own version
		
				
		//usefget save all data to each of the chars declared
		//call chardatato int for each one of the non country data
		//if any returns a -1 write to incomplete.bin incomcount++;
		//else this country didnt return -1 then
			//if cases == deaths +recovered, write to resolved.bin rescount ++, 
				//write all data except total cases;
			//else if cases != deaths + recovered then write to ongoing, oncount ++;
				//if total cases <= (population * 0.05)
					//impact = "L";
				//else if total cases >= (population * 0.30)
					//impact = "H";
				//else
					//impact = "M";
				//write all data at end of this
	}

}

