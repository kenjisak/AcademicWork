
let vendor01 = {
	name: "Staples",
	min_order: 20,
	delivery_fee: 5,
	supplies: {
		"Paper": {
			0: {
				name: "Printer Paper",
				description: "odio semper cursus. Integer mollis.",
				stock: 3,
				price: 5.50
			},
			1: {
				name: "Copy Paper",
				description: "elit pede, malesuada vel, venenatis.",
				stock: 6,
				price: 6.00
			},
			2: { 
				name: "Specialty Paper",
				description: "tellus sem mollis dui, in",
				stock: 15,
				price: 11.50
			},
			3: {
				name: "Notebook",
				description: "sit amet nulla. Donec non",
				stock: 45,
				price: 3.99
			},
			4: {
				name: "Cardstock",
				description: "Lorem ipsum dolor sit amet,",
				stock: 45,
				price: 10.50
			},
			5: {
				name: "Calendar",
				description: "Aliquam tincidunt, nunc ac mattis",
				stock: 6,
				price: 7.00
			}
		},
		"Writing Supplies": {
			6: {
				name: "Pen",
				description: "tellus. Aenean egestas hendrerit neque",
				stock: 60,
				price: 4.99
			},
			7: {
				name: "Mechanical Pencil Lead",
				description: "magna, malesuada vel, convallis in,",
				stock: 8,
				price: 4.00
			},
			8: {
				name: "Pencils (pack of 10)",
				description: "nec quam. Curabitur vel lectus.",
				stock: 33,
				price: 9.75
			},
			9: {
				name: "Markers",
				description: "Aliquam tincidunt, nunc ac mattis",
				stock: 4,
				price: 13.33

			},
			10: {
				name: "Eraser",
				description: "odio. Etiam ligula tortor, dictum",
				stock: 17,
				price: 1.50
			},
			11: {
				name: "Pencil Sharpener",
				description: "tincidunt, nunc ac mattis ornare,",
				stock: 2,
				price: 3.99
			},
			12: {
				name: "Fine Writing Pen Case",
				description: "Sed pharetra, felis eget varius",
				stock: 6,
				price: 15.99
			}
		},
		"Accessories": {
			13: {
				name: "Scissors",
				description: "Nam tempor diam dictum sapien.",
				stock: 10,
				price: 9.99
			},
			14: {
				name: "Glue Sticks (pack of 3)",
				description: "ipsum primis in faucibus orci",
				stock: 19,
				price: 4.99
			},
			15: {
				name: "3-Digit Combination Lock",
				description: "aliquet. Proin velit. Sed malesuada",
				stock: 4,
				price: 11.99
			}
		}
	}
}

let vendor02 = {
	name: "Indigo",
	min_order: 15,
	delivery_fee: 3.99,
	supplies: {
		"Creativity": {
			0: {
				name: "ABT MARKERS, PINK 5PK",
				description: "Sed auctor odio a purus.",
				stock: 30,
				price: 10.50
			},
			1: {
				name: "SET 0F 12 DUSTLESS CHALK",
				description: "quis arcu vel quam dignissim",
				stock: 10,
				price: 12.55
			},
			2: {
				name: "SET OF 12 DUAL ENDED COLOURING PENCILS",
				description: "diam luctus lobortis. Class aptent",
				stock: 11,
				price: 12.99
			}
		},
		"Journals": {
			3: {
				name: "SET OF 3 SPIRAL NOTEBOOKS, LAVENDER",
				description: "eget, volutpat ornare, facilisis eget",
				stock: 8,
				price: 15.00
			},
			4: {
				name: "COPTIC TAB NOTEBOOK, PINK",
				description: "euismod enim. Etiam gravida molestie",
				stock: 9,
				price: 11.00
			},
			5: {
				name: "A5 3-SUBJECT SPIRAL NOTEBOOK, ABSTRACT",
				description: "Donec vitae erat vel pede",
				stock: 14,
				price: 12.99
			}
		}
	}
}

let vendor03 = {
	name: "Grand and Toy",
	min_order: 35,
	delivery_fee: 8,
	supplies: {
		"Whiteboards": {
			0: {
				name: "Cork Board",
				description: "Nunc sed orci lobortis augue",
				stock: 7,
				price: 19.00
			},
			1: {
				name: "Glass Dry-Erase Board",
				description: "nisl. Quisque fringilla euismod enim.",
				stock: 2,
				price: 149.00
			},
			2: {
				name: "Planning Board",
				description: "arcu. Sed et libero. Proin",
				stock: 19,
				price: 11.99
			}

		},
		"Organizers": {
			3: {
				name: "Desk Pad",
				description: "euismod enim. Etiam gravida molestie",
				stock: 4,
				price: 4.50
			},
			4: {
				name: "Document Holder",
				description: "lobortis quis, pede. Suspendisse dui",
				stock: 19,
				price: 5.99
			},
			5: {
				name: "Cubicle Hook",
				description: "lobortis quam a felis ullamcorper",
				stock: 11,
				price: 1.99
			}
		},
		"Paper": {
			6: {
				name: "Coloured Printer Paper",
				description: "sed pede. Cum sociis natoque",
				stock: 6,
				price: 7.00
			},
			7: {
				name: "Photo Paper",
				description: "Nunc laoreet lectus quis massa.",
				stock: 19,
				price: 17.70
			},
			8: {
				name: "Thermal Roll",
				description: "Donec egestas. Duis ac arcu.",
				stock: 4,
				price: 6.99
			}
		},
		"Craft Supplies": {
			9: {
				name: "Stickers (pack of 100)",
				description: "luctus ut, pellentesque eget, dictum",
				stock: 60,
				price: 3.99
			},
			10: {
				name: "Pom Poms (pack of 300)",
				description: "Nam ac nulla. In tincidunt",
				stock: 3,
				price: 8.00
			},
			11: {
				name: "Glitter Glue (300ml)",
				description: "interdum enim non nisi. Aenean",
				stock: 40,
				price: 5.99
			}
		},
		"Writing Supplies": {
			12: {
				name: "Highlighters (pack of 5)",
				description: "Phasellus dolor elit, pellentesque a,",
				stock: 19,
				price: 7.95
			},
			13: {
				name: "Blue Ink Pens (pack of 10)",
				description: "fames ac turpis egestas. Aliquam",
				stock: 3,
				price: 11.50
			},
			14: {
				name: "Sharpie Markers (pack of 3)",
				description: "aliquet odio. Etiam ligula tortor,",
				stock: 5,
				price: 5.99
			},
			15: {
				name: "Pen Refills (pack of 20)",
				description: "semper, dui lectus rutrum urna,",
				stock: 67,
				price: 10.58
			}
		},
		"Storage": {
			16: {
				name: "Storage Box",
				description: "at auctor ullamcorper, nisl arcu",
				stock: 9,
				price: 5.78
			},
			17: {
				name: "Binding Cases (pack of 10)",
				description: "penatibus et magnis dis parturient",
				stock: 39,
				price: 7.99
			},
			18: {
				name: "File Storage Drawer",
				description: "Pellentesque ut ipsum ac mi",
				stock: 2,
				price: 46.50
			},
			19: {
				name: "Portable Plastic File/Storage Box",
				description: "rhoncus. Proin nisl sem, consequat",
				stock: 5,
				price: 16.79
			}
		},
		"Security": {
			20: {
				name: "Key Cabinet",
				description: "mus. Donec dignissim magna a",
				stock: 1,
				price: 115.00
			},
			21: {
				name: "Key Safe",
				description: "cursus. Integer mollis. Integer tincidunt",
				stock: 5,
				price: 57.99
			}
		}
	}
}

let vendors = { "Staples": vendor01, "Indigo": vendor02, "Grand and Toy": vendor03 };

let select = document.getElementById("vendor-select");
let currentVendor = select.selectedIndex;
let order = {};
let ordersummary = {};//for order costs/numbers
//initialising 
ordersummary["subtotal"] = 0;
ordersummary["tax"] = 0;
ordersummary["orderdelFee"] = 0;
ordersummary["total"] = 0;

function init() {
	//console.log("init");
	document.getElementById("vendor-select").innerHTML = genSelList();
	document.getElementById("vendor-select").addEventListener("change",vendorchange);//event listener for change
	document.getElementById("info").innerHTML = loadvendorinfo();//loads vendors info in info div in top left
	document.getElementById("right").innerHTML = loadvendororder();//loads order summary in right div in right section
	
}
	
function genSelList() {//given code, generates dropdown vendor list dynamically
	// default option
	let result = '<select name="vendor-select" id="vendor-select">';
	Object.keys(vendors).forEach(elem => {
		result += `<option value="${elem}">${elem}</option>`
	});
	result += '<option value="default" selected disabled hidden>Select a vendor</option>';//added this for default select a vendor value in dropdown
	result += "</select>";
	
	return result;
}

function vendorchange() {//dynamically handle changing the page for new vendor or staying with same vendor
	if(confirm("Are you sure?")){//checks if user wants to switch vendors
		currentVendor = document.getElementById("vendor-select").selectedIndex; //sets vendor to current selected one in dropdown

		order = {};//resets orderlist object  and order numbers
		ordersummary["subtotal"] = 0;
		ordersummary["tax"] = 0;
		ordersummary["orderdelFee"] = 0;
		ordersummary["total"] = 0;

		document.getElementById("info").innerHTML = loadvendorinfo();//updates vendorinfo, category with links, supply list, and order summary
		document.getElementById("left").innerHTML = loadvendorcategory();
		document.getElementById("middle").innerHTML = loadvendorsupply();
		document.getElementById("right").innerHTML = loadvendororder();
		document.getElementById("btn").addEventListener("click",checksubmitorder);//when button is clicked it checks if users allowed to send order depending on minimum order and current subtotal

		let addimgs = document.getElementsByClassName("addimg");//adds eventlisteners to add images after loading all info and passes the id of img parent node which is p tag id of item
		for(let i = 0;i < addimgs.length; i++){
			addimgs[i].addEventListener("click",function(){
			addvendororder(addimgs[i].parentNode.id);
			});
		}
	}else{//if user didnt want to switch then reset dropdown selected to the current vendor of the page and stays on same page
		document.getElementById("vendor-select").selectedIndex = currentVendor;
	}
	
}

function loadvendorinfo() {//displays info of current vendor in top left
	let result = "";
	if (currentVendor === -1){ //non selected index is -1 is default so outputs default values
		result += `<h1 id="vendorName">Select a Vendor</h1>\n<p id="minOrder">Minimum Order: $0.00</p>\n<p id="delFee">Delivery Fee: $0.00</p>`;
	}else{//selected index of vendors which accesses vendor info and displays
		result += `<h1 id="vendorName">${Object.values(vendors)[currentVendor].name}</h1>`
		result += `<p id="minOrder">Minimum Order: $${Object.values(vendors)[currentVendor].min_order.toFixed(2)}</p>`
		result += `<p id="vendordelFee">Delivery Fee: $${Object.values(vendors)[currentVendor].delivery_fee.toFixed(2)}</p>`
	}
	return result;
}

function loadvendororder() {//displays order summary of current vendor in right section, used as initalising
	let result = 'Order Summary<div id="itemorders"></div>';//adds div for item orders to be able to access later to add user order items in 
	
	if (currentVendor > -1){ //non selected index is default so outputs said values
		ordersummary["orderdelFee"] = Object.values(vendors)[currentVendor].delivery_fee;//accessing current vendors delivery fee
	}
	result += '<div id="ordernumbers">';//adds div for order numbers: subtotal,tax, delivery fee, and total. as well as submit button
	result += `<p id="subtotal">Subtotal: $${ordersummary["subtotal"].toFixed(2)}</p>`;
	result += `<p id="tax">Tax: $${ordersummary["tax"].toFixed(2)}</p>`;
	result += `<p id="orderdelFee">Delivery Fee: $${ordersummary["orderdelFee"].toFixed(2)}</p>`;
	result += `<p id="total">Total: $${ordersummary["total"].toFixed(2)}</p>`;
	result += `<button type="button" id="btn">Submit Order</button>`;
	result += '</div>';
	
	return result;
}

function loadvendorcategory() {//displays info of current vendor category with links to supply list
	let result = 'Categories';
	for(const key in Object.values(vendors)[currentVendor].supplies){//goes through categories of vendors supply to make p tags with links for them and sends back to get displayed
		result += `<p><a href="#${key}">${key}</a></p>`;
	}	
	return result;
}

function loadvendorsupply() {//displays info of current vendor supply list
	let result ='Supply List';
	let itemcatlist = Object.values(vendors)[currentVendor].supplies;

	for(const key in itemcatlist){//iterates keys of supplies,Paper,whiteboards.... to display all items for each category
		result += `<p class="supplyCategory" id="${key}">${key}</p>`;

		let keysofitem = Object.keys(itemcatlist[key]);

		for(const insidekey in keysofitem){
			//accessing nested object items properties
			let itemname = itemcatlist[key][keysofitem[insidekey]].name;
			let description = itemcatlist[key][keysofitem[insidekey]].description;
			let stockinfo = itemcatlist[key][keysofitem[insidekey]].stock;
			let itemprice = itemcatlist[key][keysofitem[insidekey]].price.toFixed(2);
			
			result += `<p class="supply" id="${itemname}">${itemname} ($${itemprice}, stock = ${stockinfo}) <img class="addimg" id="${itemname} png"src="add.png" alt="item add to order"> <br>${description} </p>`;//ptags for the item in supply list with their add to order images 
		}
	}
	return result;
}

function reloadorder(itemprice,action) {//order updating function when user adds or deducts items
	if (action === "add"){
		ordersummary["subtotal"] += itemprice;//adds item price onto subtotal
	}else{
		ordersummary["subtotal"] -= itemprice;//subtracts item price from subtotal
	}
	ordersummary["tax"] = ordersummary["subtotal"] * 0.10;//taxes are 10% and calculated with subtotal
	ordersummary["total"] = ordersummary["subtotal"] + ordersummary["tax"] + ordersummary["orderdelFee"];//total costs calculation wtih all numbers

	let result = '';
	result += `<p id="subtotal">Subtotal: $${ordersummary["subtotal"].toFixed(2)}</p>`;//adds div for order numbers: subtotal,tax, delivery fee, and total. as well as submit button
	result += `<p id="tax">Tax: $${ordersummary["tax"].toFixed(2)}</p>`;
	result += `<p id="orderdelFee">Delivery Fee: $${ordersummary["orderdelFee"].toFixed(2)}</p>`;
	result += `<p id="total">Total: $${ordersummary["total"].toFixed(2)}</p>`;
	result += `<button type="button" id="btn">Submit Order</button>`;
	result += '</div>';
	
	document.getElementById("ordernumbers").innerHTML = result;
	document.getElementById("btn").addEventListener("click",checksubmitorder);//when button is clicked it checks if users allowed to send order depending on minimum order and current subtotal
}

function checksubmitorder() {//checks if users allowed to send order depending on minimum order and current subtotal
	if(ordersummary["subtotal"] >= Object.values(vendors)[currentVendor].min_order.toFixed(2)){//allow to submit order and reset if current subtotal is higher or equal to min order of vendor
		alert("Order has been submitted");
		location.reload();//reloads page to reset 
	}else{//doesnt allow user to submit order and outputs message under the button how much more then need to add to order
		let addthismuchtoorder = Object.values(vendors)[currentVendor].min_order - ordersummary["subtotal"];
		document.getElementById("ordernumbers").innerHTML += `<p id="minmsg">You must add $${addthismuchtoorder.toFixed(2)} more to your order before submitting</p>`;
	}
}

function addvendororder(itemorderptagid) {//adds orders onto itemorders div inside order summary section
	let result = '';
	let itemprice = 0;//passes item price outside of for func and updates order numbers/costs
	let itemcatlist = Object.values(vendors)[currentVendor].supplies;
	for(const key in itemcatlist){//iterates keys of item category ex: supplies,Paper,whiteboards....
		let keysofitem = Object.keys(itemcatlist[key]);
		for(const insidekey in keysofitem){//iterates keys of each item....
			//keys of index for each item 0,1,2
			let item = itemcatlist[key][keysofitem[insidekey]];//item accessed ex. Paper: 0: (property= name or price)
			if(itemorderptagid === item.name ){
				if (!(itemorderptagid in order)){//checks if item isnt in order then adds item to order object and displays
					order[itemorderptagid] = 1;
					result += `<p id="${item.name}order" data-name="${item.name}" data-price="${item.price.toFixed(2)}">${item.name} x ${order[itemorderptagid]} ($${item.price.toFixed(2)})<img id="${item.name}rmv" class="removeimg" src="remove.png" alt="item remove from order"></p>`;
					itemprice = item.price;
				}else if(order[itemorderptagid] < item.stock){//checks if they can still add item to order comparing to stock then does it and displays
					order[itemorderptagid] += 1;
					itemprice = item.price;
					document.getElementById(`${item.name}order`).innerHTML = `${item.name} x ${order[itemorderptagid]} ($${item.price.toFixed(2)})<img id="${item.name}rmv" class="removeimg" src="remove.png" alt="item remove from order">`;
				}else{//dont add and alert out of stock
					alert("This item is out of stock");
				}
				document.getElementById("itemorders").innerHTML += result;//updates order list display
			}
		}
	}

	reloadorder(itemprice,"add");

	let rmvimgs = document.getElementsByClassName("removeimg");//removing then readding event listenters of all items in order because p tag of a single item gets updated and removes eventlisteners
	
	for(let i = 0;i < rmvimgs.length; i++){
		rmvimgs[i].removeEventListener("click",function(){
			removevendororder(rmvimgs[i].parentNode.id);
		});
	}

	for(let i = 0;i < rmvimgs.length; i++){
		rmvimgs[i].addEventListener("click",function(){
			removevendororder(rmvimgs[i].parentNode.id);
		});
	}
}

function removevendororder(itemorderptagid) {//removes orders from itemorders div inside order summary section
	let pricetodeduct = document.getElementById(itemorderptagid).getAttribute("data-price");//used for ease of access and less bulky code, added data-*attributes to p tag for ease of accessing data of items
	let itemname = document.getElementById(itemorderptagid).getAttribute("data-name");

	order[itemname] -= 1;//deducts item by 1 from order list

	if (order[itemname] === 0){//if item in order is 0 then delete item from order list and display and update
		delete order[itemname];
		let rmvimgs = document.getElementById(`${itemname}rmv`);//remove and re adds event listener of item then delete from doc just to make sure
		rmvimgs.removeEventListener("click",function(){
			removevendororder(rmvimgs.parentNode.id);
		});

		rmvimgs.addEventListener("click",function(){
			removevendororder(rmvimgs.parentNode.id);
		});
		document.getElementById(itemorderptagid).remove();//just deletes the p tag of item from order display
	}else{//still in order cus order >= 1, updates how many of item is in order list in display and removes and readds their event listeners
		document.getElementById(itemorderptagid).innerHTML = `${itemname} x ${order[itemname]} ($${pricetodeduct})<img id="${itemname}rmv" class="removeimg" src="remove.png" alt="item remove from order">`;
		//handle and remove listener here cus were updating
		let rmvimgs = document.getElementById(`${itemname}rmv`);

		rmvimgs.removeEventListener("click",function(){
			removevendororder(rmvimgs.parentNode.id);
		});
		rmvimgs.addEventListener("click",function(){
			removevendororder(rmvimgs.parentNode.id);
		});
	}	
	reloadorder(pricetodeduct,"sub");//updates order numbers display
}

