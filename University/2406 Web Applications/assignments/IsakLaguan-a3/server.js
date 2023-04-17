const express = require('express');
const fs = require("fs");

let app = express();
let vendordata = {};//vendor data base definition
loadvendordatabase();//initializes data base on server start up

app.use(express.static("public"));
app.set("view engine","pug");
app.set("views","views")

app.use(express.json());//parses data

//route handlers
app.get('/', function (req, res){
	res.status(200).render("home",{});//renders home pug page 
});

app.get('/vendors', function (req, res){
	res.format({
		"text/html": () => {res.status(200).render("vendorlist",{"vendors": vendordata})},//if headers are requesting for html, then render vendorlist pug page to display all vendors with links
		"application/json": () => {res.status(200).json({"vendors": Object.keys(vendordata)})}//if headers are requesting for json, then send back array of vendor keys as vendors object
	});
});

app.get('/addvendor', function (req, res){
	res.status(200).render("addvendor",{});//renders add a vendor pug page 
});

app.post('/vendors', function (req, res){
	if(req.body.name == "" || req.body.delivery_fee == "" || req.body.min_order == ""){//if any of the input fields are empty for adding a new vendor then return a 400 status code
		res.status(400).send();
	}else{//else if theyre all filled out then create new vendor into ram
		let nextID = Object.keys(vendordata).length;//next id for new vendor would be just length of keys for vendor database since id count starts at 0

		vendordata[nextID] = {};//defines new vendor object
		vendordata[nextID]["id"] = nextID;//the rest initializes all new vendor data 
		vendordata[nextID]["name"] = req.body.name;
		vendordata[nextID]["min_order"] = parseInt(req.body.min_order);
		vendordata[nextID]["delivery_fee"] = parseInt(req.body.delivery_fee);
		vendordata[nextID]["supplies"] = {};//empty supplies but just defines it to allow addition of new items

		res.status(200).json(vendordata[nextID]);//sends back the new vendor object as json as response
	}
});

app.get('/vendors/:vendorID', function (req, res){
	res.format({
		"text/html": () => {//if headers are requesting for html, then 
			if(Object.keys(vendordata).hasOwnProperty(req.params.vendorID)){//if the vendorID given as param in url is within the vendor data base then
				res.status(200).render("vendor",{"vendor": vendordata[req.params.vendorID]})//render that vendors page 
			}else{//else the vendorID isnt in the database so return a 404 response
				res.status(404).send("Vendor doesn't exist");
			}
		},
		"application/json": () => {//if headers are requesting for json, then 
			if(Object.keys(vendordata).hasOwnProperty(req.params.vendorID)){//if the vendorID given as param in url is within the vendor data base then
				res.status(200).json(vendordata[req.params.vendorID])//sends back that vendor object as json as response
			}else{//else the vendorID isnt in the database so return a 404 response
				res.status(404).send("Vendor doesn't exist");
			}
		}
	});
});

app.put('/vendors/:vendorID', function (req, res){
	res.format({
		"application/json": () => {//if headers are sending json data, then 
			if(Object.keys(vendordata).hasOwnProperty(req.params.vendorID)){//check if the vendorID given as param in url is within the vendor data base then
				//data passed in from client as {updateinfo:{"vendor": vendorinfo,"items": items}}
				let vendorinfo = req.body.updateinfo.vendor;//grabs vendor info from req body
				let iteminfo = req.body.updateinfo.items;//grabs items to add info from req body

				//updates that vendors data with whatever is filled out in the text fields even if it stayed the same
				vendordata[req.params.vendorID]["name"] = vendorinfo.name;
				vendordata[req.params.vendorID]["delivery_fee"] = vendorinfo.delivery_fee;
				vendordata[req.params.vendorID]["min_order"] = vendorinfo.min_order;

				Object.keys(iteminfo).forEach(category => {//goes through all categories in item list and checks if their empty to see if it needs updating for their items added
					if(Object.keys(iteminfo[category]).length != 0){//if the category has new items to add
						Object.keys(iteminfo[category]).forEach(itemid =>{//goes through all items to add
							// console.log(iteminfo[category][itemid]);
							vendordata[req.params.vendorID].supplies[category][itemid] = iteminfo[category][itemid] ;//adds new item into the current category of the vendor in database
						});
					}
				});
				res.status(200).send();
			}else{
				res.status(404).send();
			}
		}
	});
});

app.listen(3000);
console.log("Server listening at http://localhost:3000");

//functions
function loadvendordatabase(){
	//loads vendor data base
	fs.readdir("vendors", function(err,files) {
		if(err){//if error in reading the file return status 500 as response
			console.log("Error saving vendors");
			console.log(err);
		}
		for (let i = 0;i < files.length;i++){//adds vendor info into database
			let currvendor = require("./vendors/" + files[i]);
			vendordata[currvendor.id] = currvendor;
		}
	});
}
