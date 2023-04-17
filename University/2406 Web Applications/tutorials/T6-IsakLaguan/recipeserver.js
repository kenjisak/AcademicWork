//Database to store all recipe data
//This will give you 3 recipes to start with
let database = {
	"0":{
		"ingredients":
		[
			{"name":"Crab","unit":"Tsp","amount":3},
			{"name":"Peas","unit":"Cup","amount":12},
			{"name":"Basil","unit":"Tbsp","amount":10},
			{"name":"Cumin","unit":"Liter","amount":3},
			{"name":"Salt","unit":"Tbsp","amount":1}
		],

		"name":"Boiled Crab with Peas",
		"preptime":"13",
		"cooktime":"78",
		"description":"A boring recipe using Crab and Peas",
		"id":"0"
	},
	"1":{
		"ingredients":
		[
			{"name":"Peanuts","unit":"Liter","amount":10},
			{"name":"Artichoke","unit":"Tsp","amount":3},
			{"name":"Basil","unit":"Cup","amount":11},
			{"name":"Sage","unit":"Grams","amount":13},
			{"name":"Pepper","unit":"Cup","amount":1}
		],

		"name":"Boiled Peanuts with Artichoke",
		"preptime":"73",
		"cooktime":"74",
		"description":"A exciting recipe using Peanuts and Artichoke",
		"id":"1"
	},
	"2":{
		"ingredients":
		[
			{"name":"Lobster","unit":"Tsp","amount":14},
			{"name":"Brussel Sprouts","unit":"Liter","amount":14},
			{"name":"Sage","unit":"Tbsp","amount":3},
			{"name":"Thyme","unit":"Tbsp","amount":12},
			{"name":"Pepper","unit":"Tsp","amount":10},
			{"name":"Cumin","unit":"Tbsp","amount":11}
		],

		"name":"Spicy Lobster with Brussel Sprouts",
		"preptime":"86",
		"cooktime":"19",
		"description":"A tasty recipe using Lobster and Brussel Sprouts",
		"id":"2"
	}
}

let nextID = Object.keys(database).length;//init as 3,need to increment after
const express = require('express');
let app = express();

app.use(express.static("public"));
app.set("view engine","pug");
app.set("views","views")
//Start adding route handlers here
app.use(express.json());

app.post('/recipes', function (req, res){
	let id = nextID.toString();
	database[id] = req.body;//sets new recipe object
	database[id]["id"] = id;//sets id of new recipe object in itself
	//console.log(database[id]);
	nextID++;
	res.status(200).send();
	//console.log("200");
});

app.get('/recipes', function (req, res){
	//console.log("200 get");
	res.status(200);
	res.render("browse",{recipes:database});	
});

app.get("/recipes/:id", function(req, res){
	//console.log(req.params.id);
	if(Object.keys(database).hasOwnProperty(req.params.id)){//if in data base
		//console.log("200");
		res.status(200);
		res.render("recipe",{recipe:database[req.params.id]});	
	}else{
		//console.log("404");
		res.status(404).send("Error ID not found");
	}
});

app.listen(3000);
console.log("Server listening at http://localhost:3000");
