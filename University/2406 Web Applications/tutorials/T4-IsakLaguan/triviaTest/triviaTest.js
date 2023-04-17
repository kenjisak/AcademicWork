let questions = 0;  //counts the number of answered questions
let correct = 0;    //counts the number of questions answered correctly
let currentQuestion = null;
let arrofans = [];
function init(){
	document.getElementById("score").innerHTML = `Your score: ${correct}/${questions}`;
	getNextQuestion();
	document.getElementById("submit").onclick = submitAnswer;	
}

function getNextQuestion(){
	xhttp = new XMLHttpRequest();

    //This is only going to get called when readyState changes
	xhttp.onreadystatechange = function() {
        //If the response is available and was successful
		if(this.readyState==4 && this.status==200){
			//Take the response text (that is in JSON format), parse it into JS object
			let responseObject = JSON.parse(this.responseText);

            //Extract questions from array and update our array
			currentQuestion = responseObject.results[0];
			console.log(currentQuestion); //look at the object; what keys does it have?

            //render this question on our page
			render();
		}
	}
	//request one question from a web server
	xhttp.open("GET", `https://opentdb.com/api.php?amount=1`);
	xhttp.send();
}

function render(){
	// Implement this function
	// it should display the question (and all four of the answers) on the page
	// you can randomly shuffle the options before displaying them 

	document.getElementById("submit").style.display = "none";//resets submit button to invis
	populateandshuffle();//call to add answers to the array and shuffle order
	let questionsdiv = document.getElementById("question");
	questionsdiv.innerHTML = currentQuestion.question;//displays question onto page
	
	for (let i = 0;i < arrofans.length;i++){//goes through answer array and displays the selection of answers
		questionsdiv.innerHTML += `<br><input type="radio" id="${arrofans[i]}" name="${currentQuestion.category}" value="${arrofans[i]}">${arrofans[i]}`;
	}

	for (let i = 0;i < arrofans.length;i++){//event listeners for each of the answers to display the submit button
		//console.log(arrofans[i]);
		document.getElementById(arrofans[i]).addEventListener("click",displaybutton);
	}

}

function submitAnswer(){
	// Implement this function
	// This function runs when the button is clicked, - it should display user's score
	// You can also request for another question from here to continue the game
	if(document.getElementById(decodeHTML(currentQuestion.correct_answer)).checked){//checks if the selected answer is the correct one, if it is then add a point
		correct += 1;
	}
	questions += 1;//counter for num of questions
	init();//game goes on indefinitely
}

//you can add other functions.
function populateandshuffle(){
	arrofans = [];//resets answer array
	arrofans.push(decodeHTML(currentQuestion.correct_answer));//add correct options to array
	for (let ans in currentQuestion.incorrect_answers){//adds incorrect options to array
		arrofans.push(decodeHTML(currentQuestion.incorrect_answers[ans]));
	}
	// for (let ans in arrofans){
	// console.log(arrofans[ans]);
	// } 
	//shuffle the options
	let i = arrofans.length,  j;//randomly shuffles answer array
	while (i != 0) {
		j = Math.floor(Math.random() * i);
		i--;
		[arrofans[i], arrofans[j]] = [arrofans[j], arrofans[i]];
	}
	// console.log("asdasdasdasdadsa");
	// for (let ans in arrofans){
	// console.log(arrofans[ans]);
	// } 
}
function displaybutton(){
	document.getElementById("submit").style = "display: block";//displays submit button
}
function decodeHTML(html) {//helper function to decode html entities
	let txt = document.createElement('textarea');
	txt.innerHTML = html;
	return txt.value;
};
