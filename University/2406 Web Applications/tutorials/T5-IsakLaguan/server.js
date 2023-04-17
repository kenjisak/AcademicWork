/*
Card source: https://api.hearthstonejson.com/v1/25770/enUS/cards.json

Each card is a JS object
All have:
	id - string uniquely identifies the card
	artist - string indicating the name of the artist for the cards image
	cardClass - string indicating the class of the card
	set  - string indicating the set the card is from
	type - string indicating the type of the card
	text - string indicating card text
Some have:
	rarity - string indicating the rarity of the card
	mechanics - array of string indicating special mechanics
	
Routes:
	/cards - search all cards (query params: class, set, type, artist)
	/cards/:cardID - specific card with ID=:cardID
*/

const http = require('http');
const pug = require("pug");

const renderCards = pug.compileFile("listcards.pug");
const renderCardInfo = pug.compileFile("cardinfo.pug");
const renderCardQuery = pug.compileFile("cardquery.pug");
//Set up the required data
let cardData = require("./cards.json");
let cards = {}; //Stores all of the cards, key=id
cardData.forEach(card => {
	cards[card.id] = card;
});

//Initialize server
const server = http.createServer(function (request, response) {
	console.log(request.url);//prints url sent by request in console in editor for debugging, useful to keep on
	if(request.method === "GET"){//handles all get requests
		if(request.url === "/cards"){//handles requests for vendor stats page
			let cardobj = [];
			for (let i = 0;i < 25; i++){
				cardobj[i] = cards[Object.keys(cards)[i]];//loops and adds first 25 cards as objects
			}
			let content = renderCards({cardsData:cardobj});//sets data to be passed in as response for template engine stuff, vendor being variable to handle in pug page, stats data as object were setting it to
			response.statusCode = 200;
			response.setHeader("Content-Type", "text/html");
			response.end(content);
		}else if(request.url.startsWith("/cards/")){
			let cardId = request.url.slice(7);//grabs id from url
			let cardobj = {};
			if (cards.hasOwnProperty(cardId)){//id/card exists
				cardobj = cards[cardId];//sets card obj to existing card
			}else{//else unknown id 
				send404(response);//helper function to send 404 
			}
			let content = renderCardInfo({cardinfo:cardobj});//sets data to be passed in as response for template engine stuff, vendor being variable to handle in pug page, stats data as object were setting it to
			response.statusCode = 200;
			response.setHeader("Content-Type", "text/html");
			response.end(content);
		}else if(request.url.startsWith("/cards?")){
			let cardquery = request.url.slice(7);//grabs query from url
			let cardqueryparamvalue = cardquery.split("=");//grabs param and value
			let cardpass = {};
			//get all object keys then iterate through them, and push that object to card pass
			let count = 0;
			Object.keys(cards).forEach(card => {
				if (cards[card].hasOwnProperty(cardqueryparamvalue[0])){//query param exists, name
					//console.log(cards[card][cardqueryparamvalue[0]]);
					if(count < 25 && cards[card][cardqueryparamvalue[0]].toLowerCase().includes(cardqueryparamvalue[1].toLowerCase())){//if this cards name includes the given query name and less than 25 so only returns teh first 25 matches
						count ++;
						cardpass[card] = cards[card];//adds card that includes name
					}
				}
			});
			// for(let i = 0;i < 25; i++){// for just the first 25 cards search
			// 	cardobj[i] = cards[Object.keys(cards)[i]];//loops and adds first 25 cards as objects
			// 	if (cardobj[i].hasOwnProperty(cardqueryparamvalue[0])){//query param exists, name
			// 		console.log(cardobj[i][cardqueryparamvalue[0]]);
			// 		if(cardobj[i][cardqueryparamvalue[0]].toLowerCase().includes(cardqueryparamvalue[1].toLowerCase())){//if this cards name includes the given query name
			// 			cardpass.push(cards[cardobj[i].id]);//adds card that includes name
			// 		}
			// 	}
			// }
			cardpass['query'] = cardqueryparamvalue[1];
			let content = renderCardQuery({cardslist:cardpass});//sets data to be passed in as response for template engine stuff, vendor being variable to handle in pug page, stats data as object were setting it to
			response.statusCode = 200;
			response.setHeader("Content-Type", "text/html");
			response.end(content);
		}else{//else unknown request url sent
			send404(response);//helper function to send 404 
		}
	}else{//else unknown request url sent
		send404(response);//helper function to send 404 
	}
});

//Start server
server.listen(3000);
console.log("Server listening at http://localhost:3000");

function send404(response){//sets responses for 404 responses
	response.statusCode = 404;
	response.write("Unknwn resource.");
	response.end();
}