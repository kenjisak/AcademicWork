//modules
const http = require('http');
const fs = require("fs");
const pug = require("pug");
//for pug template engine rendering
const renderStats = pug.compileFile("pages/vendorstats.pug");

let currvendorid;//holds current vendor id
let vendordata = [];//holds all data of all vendors
let totalcount = {};//0: 50.99, 1: 0.00//total accumulator, , key being id of vendor and value being amount spent for orders//vendorid: total, general structure of vendororder variable
let numorders = {};//0: 3, 1: 2//order accumulator, key being id of vendor and value being how many orders been made //vendorid: numoforders, general structure of vendororder variable
let vendororder = {};//0:{0: 3,4: 1}, 2:{0: 1}//item units ordered accumulator, key being id of vendor and value being the list of items using key as item id and value being how many units ordered//vendorid:{itemid: units}, general structure of vendororder variable
const server = http.createServer(function (request, response) {//server
	console.log(request.url);//prints url sent by request in console in editor for debugging, useful to keep on
	if(request.method === "GET"){//handles all get requests
        if(request.url === "/" || request.url === "/home"){//handles home page requests whether href being http://localhost:3000 ,http://localhost:3000/, or http://localhost:3000/home
			//read the homepage.html file and send it back
			fs.readFile("pages/homepage.html", function(err, data){
				if(err){//if error in reading the file return status 500 as response
					send500(response);//helper function to clean up space
					return;
				}
				response.statusCode = 200;
				response.setHeader("Content-Type", "text/html");
				response.write(data);
				response.end();
			});
		}else if(request.url === "/vendorslist" || request.url === "/selectvendors"){//handles requests for generating dropdown list and for selecting vendors update
            //read the vendors folder and send it back
			fs.readdir("vendors", function(err,files) {
                if(err){//if error in reading the file return status 500 as response
					send500(response);//helper function to clean up space
				}
                for (let i = 0;i < files.length;i++){//adds vendor info in order of vendor id, lowest to greatest
                    vendordata.unshift(require("./vendors/" + files[i]));
                }
                response.statusCode = 200;
                response.setHeader("Content-Type", "application/json");
                response.write(JSON.stringify(vendordata));
                response.end();
            });
		}else if(request.url === "/vendorstats"){//handles requests for vendor stats page
			//sets data for stats page send it back for the template engine
			let statsdata = {};
			if(!currvendorid){//if a vendor hasnt been selected yet, ie on home page and clicks on vendorstats link, default values set to inform user to select a vendor first
				//then return default values to pug
				statsdata["name"] = "Please Select a Vendor";
				statsdata["totalcount"] = 0.00;
				statsdata["ordernum"] = 0;
				statsdata["popitem"] = "None";
			}else if(currvendorid && !totalcount.hasOwnProperty(currvendorid)){//if vendor is selected but no order has been made, send back current vendor name and other default data
				//then return default values to pug excpet for name
				statsdata["name"] = vendordata[currvendorid].name;
				statsdata["totalcount"] = 0.00;
				statsdata["ordernum"] = 0;
				statsdata["popitem"] = "None";
			}else{//else a vendor is selected and orders have been made so can process data for all and send back
				statsdata["name"] = vendordata[currvendorid].name;
				statsdata["totalcount"] = (totalcount[currvendorid]/numorders[currvendorid]);//total orders divided by number of orders made = average total
				statsdata["ordernum"] = numorders[currvendorid];
				statsdata["popitem"] = getpopitem();//uses helper function to get most popular item to clean up the space and clutter
			}
			
			let content = renderStats({vendor:statsdata});//sets data to be passed in as response for template engine stuff, vendor being variable to handle in pug page, stats data as object were setting it to
			response.statusCode = 200;
			response.setHeader("Content-Type", "text/html");
			response.end(content);
		}else if(request.url === "/orderform"){//handles requests for order form page
			//read the orderform.html file and send it back
			fs.readFile("pages/orderform.html", function(err, data){
				if(err){//if error in reading the file return status 500 as response
					send500(response);//helper function to clean up space
					return;
				}
				response.statusCode = 200;
				response.setHeader("Content-Type", "text/html");
				response.write(data);
				response.end();
			});
		}else if(request.url === "/client.js"){//handles requests for client javascript file
			//read client.js file and send it back
			fs.readFile("client.js", function(err, data){
				if(err){//if error in reading the file return status 500 as response
					send500(response);//helper function to clean up space
				}
				response.statusCode = 200;
				response.setHeader("Content-Type", "application/javascript");
				response.write(data);
				response.end();
			});
		}else if(request.url === "/styles.css"){//handles requests for styles css file
			//read styles.css file and send it back
			fs.readFile("resources/styles.css", function(err, data){
				if(err){//if error in reading the file return status 500 as response
					send500(response);//helper function to clean up space
				}
				response.statusCode = 200;
				response.setHeader("Content-Type", "text/css");
				response.write(data);
				response.end();
			});
        }else if(request.url === "/add.png"){//handles requests for add png file
			//read add.png file and send it back
			fs.readFile("resources/add.png", function(err, data){
				if(err){//if error in reading the file return status 500 as response
					send500(response);//helper function to clean up space
				}
				response.statusCode = 200;
				response.setHeader("Content-Type", "image/png");
				response.write(data);
				response.end();
			});
        }else if(request.url === "/remove.png"){//handles requests for remove png file
			//read remove.png file and send it back
			fs.readFile("resources/remove.png", function(err, data){
				if(err){//if error in reading the file return status 500 as response
					send500(response);//helper function to clean up space
				}
				response.statusCode = 200;
				response.setHeader("Content-Type", "image/png");
				response.write(data);
				response.end();
			});
        
		}else{//else unknown request url sent
			send404(response);//helper function to send 404 
		}
	}else if(request.method === "POST"){//handle all post requests from client
		if(request.url === "/addnewitem"){//handles requests for adding a new item to a vendor
			let receivedData = "";
			let newitem = [];//new item received from request
			request.on("data", function(chunk) {//reads and receives the data sent from request
				receivedData += chunk
			})
			request.on("end", function(){//this block parses the data from request
				newitem = JSON.parse(receivedData);//new item received from request being parsed 
				let currentVendor = vendordata[newitem[0]];//grabs all current vendor data stored in vendordata that has all vendors data, using 
				let item = {};//new item object definition to add to vendor data later
				item["name"] = newitem[2]; //sets new item name as whats passed in the request
				item["description"] = "Lorem ipsum dolor sit amet";//default description for item
				item["stock"] = newitem[4];//sets new item stock as whats passed in the request
				item["price"] = newitem[3];//sets new item price as whats passed in the request
				Object.keys(currentVendor.supplies).forEach(key => {//checks through each category in the supply list
					let category = newitem[1]; //sets category to whats passed in the request
					let itemkeys = Object.keys(currentVendor.supplies[key]);//key being the current category were traversing,  setting item keys for the current category
					
					if (category === key){//found category we need to add the new item in 
						let newitemid = parseInt(itemkeys[itemkeys.length - 1]);//grabs all ids of items in that category and finds the number of the last id
						currentVendor.supplies[key][newitemid + 1] = item;//and sets newitem id to + 1 of the last item id in category
					}
				});
			});
			response.statusCode = 200;
			response.end();
		}else if(request.url === "/currentVendor"){//handles requests for updating the current vendor selected to the server
			let receivedData = "";
			request.on("data", function(chunk) {//reads and receives the data sent from request
				receivedData += chunk
			})
			request.on("end", function(){//this block parses the data from request
				currvendorid = receivedData;//sets currvendorid to the id sent in from the client
			});
			response.statusCode = 200;
			response.end();
		
		}else{//else unknown request url sent
			send404(response);//helper function to clean up space
		}
	}else if(request.method === "PUT"){//handle put request from client
		if(request.url === "/submitOrder"){//handles requests for submitting an order
			let receivedData = "";
			let order = {};
			request.on("data", function(chunk) {//reads and receives the data sent from request
				receivedData += chunk
			})
			request.on("end", function(){//this block parses the data from request
				order = JSON.parse(receivedData);
				//update order here
				let vendorkey = Object.keys(order)[0];//gets vendor id from order data sent in by client
				Object.keys(order[vendorkey]).forEach(id => {//goes through all the items that need updating for their stock, repurposed code from client.js
					let currentVendor = vendordata[vendorkey];//grabs currentvendor selected data from vendordata
					let categories = Object.keys(currentVendor.supplies);//gets all category names from current vendor
					for (let i = 0; i < categories.length; i++) {//goes through all categories
						if (currentVendor.supplies[categories[i]].hasOwnProperty(id)) {//if the current category has the current item id then 
							currentVendor.supplies[categories[i]][id].stock -= order[vendorkey][id];//accesses item and subtracts the stock value used from the keypair accessed in order
							break;
						}
					}
					vendordata[vendorkey] = currentVendor;//probably dont need this line but updates the vendordata directly just in case
					
					//tracks popular item
					if (!vendororder.hasOwnProperty(vendorkey)){//if vendor key isnt there of the vendor then create
						vendororder[vendorkey] = {};//adds vendor key
					}
					if (vendororder[vendorkey].hasOwnProperty(id)){//checks for items if theyve been ordered before
						vendororder[vendorkey][id] += order[vendorkey][id]//adds on units ordered to existing item
					}else {//create item ordered in data for that vendor
						vendororder[vendorkey][id] = order[vendorkey][id]//sets on units ordered to item
					}
					
				});
			
				//tracks totals
				if(totalcount.hasOwnProperty(vendorkey)){//checks if vendor sold stuff before by checking if the vendor id is one of the keys
					totalcount[vendorkey] += parseFloat(order["total"]);//adds on total ordered to existing total accumulator
				}else{//create total ordered in data for that vendor
					totalcount[vendorkey] = parseFloat(order["total"]);//sets total ordered to total accumulator
				}
				//order num track
				if(numorders.hasOwnProperty(vendorkey)){//checks if vendor sold stuff before by checking if the vendor id is one of the keys
					numorders[vendorkey] += 1;//increments the existing numorders accumulator
				}else{//create num of orders in data for that vendor
					numorders[vendorkey] = 1;//initializes the numorders accumulator
				}
			});
			response.statusCode = 200;
			response.end();
		}else{//else unknown request url sent
			send404(response);//helper function to clean up space
		}
	}else{//else unknown request url sent
		send404(response);//helper function to clean up space
	}
});

//Server listens on port 3000
server.listen(3000);
console.log('Server running at http://localhost:3000/');

//helper functions
function getpopitem(){//gets the most popular item
	let items = vendororder[currvendorid];//sets the items as all the item ids of the current vendors thats been ordered 
	let itemid;//init
	let maxnum = 0;//init
	Object.keys(items).forEach(key =>{//goes through item id keys
		if(items[key] > maxnum){//checks if the units ordered for that item is bigger than the current maxnumber
			maxnum = items[key];//if its then set those units as the current max number
			itemid = key;//sets item id to the current itemid iteration
		}
	});
	return getItemName(itemid);//returns the item name through helper function
}

function getItemName(id) {//repurposed code from client.js.....Given an ID of an item in the current vendors' supply list, returns that item object if it exists.
	let currentVendor = vendordata[currvendorid];//sets current vendor data from the vendordata 
	let categories = Object.keys(currentVendor.supplies);
	for (let i = 0; i < categories.length; i++) {
		if (currentVendor.supplies[categories[i]].hasOwnProperty(id)) {
			return currentVendor.supplies[categories[i]][id].name;
		}
	}
	return null;
}

function send404(response){//sets responses for 404 responses
	response.statusCode = 404;
	response.write("Unknwn resource.");
	response.end();
}

function send500(response){//sets responses for 404 responses
	response.statusCode = 500;
	response.write("Server error.");
	response.end();
}