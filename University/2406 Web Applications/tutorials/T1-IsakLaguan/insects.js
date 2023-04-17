//Problem 1
let pop = 2;
let counter = 1;
console.log(pop);

while(pop < 10000 ){
    counter++;
    pop = pop * 2;
    console.log(pop , counter);
}

console.log("It will take " + counter +" weeks for the insect population to exceed 10,000 insects\n");

// 2 first then count till 4 and pop * .60, output

//Problem 1
let pop2 = 2;
let counter2 = 1;
let weekcount = 1;
console.log(pop2);

do{
    counter2++;
    weekcount++;
    pop2 = pop2 * 2
    console.log(pop2); 

    if(counter2 == 4){
        pop2 = pop2 * 0.60;
        counter2 = 0;
    }
}while(pop2 < 10000)

console.log("It will take " + weekcount +" weeks for the insect population to exceed 10,000 insects when 40% of the population is killed by disease every 4 weeks");
