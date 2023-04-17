
const http = require('http');
const fs = require("fs");
const { chunk } = require('underscore');

//Create a server, giving it the handler function
//Request represents the incoming request object
//Response represents the outgoing response object
//Remember, you can break this apart to make it look cleaner

let items = [];//server side item list and default items added
items.push({name: "first", light: false, checked: false});
items.push({name: "second", light: false, checked: false});
items.push({name: "third", light: false, checked: false});

const server = http.createServer(function (request, response) {
	console.log(request.url);
	if(request.method === "GET"){
		if(request.url === "/" || request.url === "/todo.html"){
			//read the todo.html file and send it back
			fs.readFile("todo.html", function(err, data){
				if(err){
					response.statusCode = 500;
					response.write("Server error.");
					response.end();
					return;
				}
				response.statusCode = 200;
				response.setHeader("Content-Type", "text/html");
				response.write(data);
				response.end();
			});
		}else if(request.url === "/todo.js"){
			//read todo.js file and send it back
			fs.readFile("todo.js", function(err, data){
				if(err){
					response.statusCode = 500;
					response.write("Server error.");
					response.end();
				}
				response.statusCode = 200;
				response.setHeader("Content-Type", "application/javascript");
				response.write(data);
				response.end();
			});
		//Add any more 'routes' and their handling code here
		//e.g., GET requests for "/list", POST request to "/list"
		}else if(request.url === "/list"){//handle get request from client if request url is /list
			response.statusCode = 200;//sets status code to successful
			response.setHeader("Content-Type", "application/json");//sets content type to json
			response.write(JSON.stringify(items));//stringifies items array
			response.end();
		}else{//else unknown request url sent
			response.statusCode = 404;
			response.write("Unknwn resource.");
			response.end();
		}
	}else if(request.method === "POST"){//handle post request from client
		//any handling in here
		if(request.url === "/list"){//if request url is /additem
			let receivedData = "";// this block reads and receives the data sent from post request
			request.on("data", function(chunk) {
				receivedData += chunk
			})
			request.on("end", function(){//this block parses the data form request and adds it to the item array
				items.push(JSON.parse(receivedData));
			})
			response.statusCode = 200;//sets status to successful
			response.end();
		}else{//else unknown request url sent
			response.statusCode = 404;
			response.write("Unknwn resource.");
			response.end();
		}
	}else if(request.method === "PUT"){//handle put request from client
		//any handling in here
		if(request.url === "/list"){//if request url is /removeitem
			let receivedData = "";// this block reads and receives the data sent from put request
			request.on("data", function(chunk) {
				receivedData += chunk
			})
			request.on("end", function(){//this block parses the data form request and sets item array to it to update with non removed items
				items = JSON.parse(receivedData);
			})
			response.statusCode = 200;//sets status to successful
			response.end();
		}else{//else unknown request url sent
			response.statusCode = 404;
			response.write("Unknwn resource.");
			response.end();
		}
	}else{//else unknown request url sent
		response.statusCode = 404;
		response.write("Unknwn resource.");
		response.end();
	}
});

//Server listens on port 3000
server.listen(3000);
console.log('Server running at http://localhost:3000/');
