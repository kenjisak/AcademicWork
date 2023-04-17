//The drop-down menu
let select = document.getElementById("vendor-select");
//Stores the currently selected vendor index to allow it to be set back when switching vendors is cancelled by user
let currentSelectIndex = select.selectedIndex;
//Stores the current vendor to easily retrieve data. The assumption is that this object is following the same format as the data included above. If you retrieve the vendor data from the server and assign it to this variable, the client order form code should work automatically.
let currentVendor;
//Stored the order data. Will have a key with each item ID that is in the order, with the associated value being the number of that item in the order.
let order = {};
//Called on page load. Initialize the drop-down list, add event handlers, and default to the first vendor.
let total = 0;//design change to be able to access total through other functions and send it back to server
let selectdefault;//design change to minimize breaks
function init() {
	getgenSelList();//calls request to server to generate dropdown menu
	document.getElementById("vendor-select").onchange = getSelectVendor;//when changed in dropdown menu call getSelectVendor to request server data and start changing the page
	getSelectVendor();//server request func to update page to selected vendor
}

//Generate new HTML for a drop-down list containing all vendors.
//For A2, you will likely have to make an XMLHttpRequest from here to retrieve the array of vendor names.
function genSelList(vendors) {
	let result = '<select name="vendor-select" id="vendor-select">';
	Object.keys(vendors).forEach(elem => {
		result += `<option value="${elem}">${elem}</option>`
	});
	result += "</select>";
	selectdefault = Object.keys(vendors)[0];//sets default select option, workound for program breaking with non selected vendor issue
	return result;
}
function getgenSelList(){//XMLHttpRequest to retrieve the array of vendor names.
	xhttp = new XMLHttpRequest();
    //This is only going to get called when readyState changes
	xhttp.onreadystatechange = function() {
        //If the response is available and was successful
		if(this.readyState==4 && this.status==200){
			//Take the response text (that is in JSON format), parse it into JS object
			let receiveddata = JSON.parse(this.responseText);//if request was successful then update client item list after parsing the response data
			let receivedvendors = {};//data for vendor objects
			for (let i = 0;i < receiveddata.length;i++){
				receivedvendors[receiveddata[i].name] = receiveddata[i];//sets key as the name of the vendors, and value as the vendor data as an object
			}//get array of objects vendors[i] access names by going through list of vendors vendors[i].name
			document.getElementById("vendor-select").innerHTML = genSelList(receivedvendors);//updates page of dropdown menu by using the select vendors genSelList with vendors data passed in
		}
	}
	xhttp.open("GET", `http://localhost:3000/vendorslist`);
	xhttp.send();
}

//Helper function. Returns true if object is empty, false otherwise.
function isEmpty(obj) {
	for (var key in obj) {
		if (obj.hasOwnProperty(key))
			return false;
	}
	return true;
}

//Called when drop-down list item is changed.
//For A2, you will likely have to make an XMLHttpRequest here to retrieve the supplies list data for the selected vendor
function selectVendor(vendors) {
	let result = true;

	//If order is not empty, confirm the user wants to switch vendors
	if (!isEmpty(order)) {
		result = confirm("Are you sure you want to clear your order and switch vendor?");
	}

	//If switch is confirmed, load the new vendor data
	if (result) {
		
		//Get the selected index and set the current vendor
		
		//if value is undefined then set a default vendor name
		let selected = selectdefault;
		if (!select.options[select.selectedIndex]){
			selected = selectdefault;
		}else{
			selected = select.options[select.selectedIndex].value;
		}
		currentSelectIndex = select.selectedIndex;

		//In A2, current vendor will be data you received from the server
		currentVendor = vendors[selected];
		//send post request to update current vendor in server, design change
		postCurrentVendor();
		//Update the page contents to contain the new supply list
		document.getElementById("left").innerHTML = getCategoryHTML(currentVendor);
		document.getElementById("left").innerHTML += newCategoryHTML(currentVendor);
		document.getElementById("middle").innerHTML = getSuppliesHTML(currentVendor);

		//Clear the current oder and update the order summary
		order = {};
		updateOrder();
		
		//Update the vendor info on the page
		let info = document.getElementById("info");
		info.innerHTML = "<h1>" + currentVendor.name + "</h1>" + "<br>Minimum Order: $" + currentVendor.min_order + "<br>Delivery Fee: $" + currentVendor.delivery_fee + "<br><br>";
	} else {
		//If user refused the change of vendor, reset the selected index to what it was before they changed it
		let select = document.getElementById("vendor-select");
		select.selectedIndex = currentSelectIndex;
	}
}
function postCurrentVendor(){//send post request to update current vendor in server
	xhttp = new XMLHttpRequest();
		//This is only going to get called when readyState changes
	xhttp.onreadystatechange = function() {
		//If the response is available and was successful
		if(this.readyState==4 && this.status==200){
			//do nothing, probably dont need this block of code, kept in case of needing to do something
		}
	}

	xhttp.open("POST", `http://localhost:3000/currentVendor`);
	xhttp.setRequestHeader("Content-Type", "application/json");//sets content type of data sent
	xhttp.send(JSON.stringify(currentVendor.id));//sends currentvendor id to server
}
function getSelectVendor(){//XMLHttpRequest to retrieve the selected vendor data
	xhttp = new XMLHttpRequest();
    //This is only going to get called when readyState changes
	xhttp.onreadystatechange = function() {
        //If the response is available and was successful
		if(this.readyState==4 && this.status==200){
			//Take the response text (that is in JSON format), parse it into JS object
			let receiveddata = JSON.parse(this.responseText);//if request was successful then update client item list after parsing the response data
			let receivedvendors = {};//data for vendor objects
			for (let i = 0;i < receiveddata.length;i++){
				receivedvendors[receiveddata[i].name] = receiveddata[i];//sets key as the name of the vendors, and value as the vendor data as an object
			}//get array of objects vendors[i] access names by going through list of vendors vendors[i].name
			selectVendor(receivedvendors);//updates page to display vendor data of their products etc. by using selectVendor with vendors data passed in
		}
	}
	xhttp.open("GET", `http://localhost:3000/selectvendors`);
	xhttp.send();
}
//Given a vendor object, produces HTML for the left column
function getCategoryHTML(vend) {
	let supplies = vend.supplies;
	let result = "<h3>Categories</h3><br>";
	Object.keys(supplies).forEach(key => {
		result += `<a href="#${key}">${key}</a><br>`;
	});
	return result;
}
//Given a vendor object, produces HTML for the left column new category
function newCategoryHTML(vend) {
	let supplies = vend.supplies;
	//html for new category
	let result = "<br><h3>Add New Item to Category</h3>";
	result += '<select name="category-select" id="category-select">';
	result += '<option value="" disabled selected>Select a Category</option>';
	Object.keys(supplies).forEach(key => {//generates drop down menu for categories in the current vendors supply list
		result += `<option value="${key}">${key}</option>`;
	});
	result += "</select><br><br>";
	//input html for new item data
	result += '<div>Item name: <input type="text" id="itemname" placeholder="Enter Item Name(ex. Pen)" /></div><br>';
	result += '<div>Item price: <input type="text" id="itemprice" placeholder="Enter Item Price(ex. 10.99)"/></div><br>';
	result += '<div>Item stock: <input type="text" id="itemstock" placeholder="Enter Item Stock(ex. 5)"/></div><br>';
	result += `<button type="button" id="addnewitem" onclick="addnewitem()">Add New Item</button>`
	//can add reset button if wanted
	return result;
}
function addnewitem(){//function handler for adding a new item 
	let sendrequest = true;//for some reason return wasnt working to prevent sending the requests so implemented this work around instead
	//all of this to get data that was inputted in for the new item 
	let newcat = document.getElementById("category-select");
	let selectedcat = newcat.options[newcat.selectedIndex].value;
	let itemname = document.getElementById("itemname").value;
	let itemprice = document.getElementById("itemprice").value;
	let itemstock = document.getElementById("itemstock").value;

	//if any of the fields for the new item are empty or not selected then warns the user
	if (selectedcat === ""){
		alert("Please select a Category");
		sendrequest = false;
		return;
	}else if (itemname === ""){
		alert("Please enter Item Name");
		sendrequest = false;
		return;
	}else if(itemprice === ""){
		alert("Please enter Item Price");
		sendrequest = false;
		return;
	}else if(itemstock === ""){
		alert("Please enter Item Stock");
		sendrequest = false;
		return;
	}else if(parseInt(itemstock) < 1){
		alert("Item Stock must be at least 1");
		sendrequest = false;
		return;
	}else{//else if all data is filled in then checks if the new item name is a duplicate and warns the user
		let supplies = currentVendor.supplies;
		//For each category in the supply list
		Object.keys(supplies).forEach(key => {//checks if item is duplicate
			//For each item in the category
			Object.keys(supplies[key]).forEach(id => {
				item = supplies[key][id];
				if (item.name === itemname){
					alert("Item is already in the Store.");
					sendrequest = false;
					return;
				}
			});
		});
	}

	if(sendrequest){//if send request is a go then pass in the new item data as an array to the request function
		let sendnewitem = [];
		sendnewitem.push(currentVendor.id);//0
		sendnewitem.push(selectedcat);//1
		sendnewitem.push(itemname);//2
		sendnewitem.push(parseFloat(itemprice).toFixed(2));//3
		sendnewitem.push(parseInt(itemstock));//4
		postnewitem(sendnewitem);
	}
}
function postnewitem(sendnewitem){//sends request to server to add in the new item and sends new item data
	xhttp = new XMLHttpRequest();
		//This is only going to get called when readyState changes
	xhttp.onreadystatechange = function() {
		//If the response is available and was successful
		if(this.readyState==4 && this.status==200){
			getSelectVendor();//updates page to reset once successful new item add
		}
	}
	xhttp.open("POST", `http://localhost:3000/addnewitem`);
	xhttp.setRequestHeader("Content-Type", "application/json");//sets content type of data sent
	xhttp.send(JSON.stringify(sendnewitem));
}
//Given a vendor object, produces the supplies HTML for the middle column
function getSuppliesHTML(vend) {
	let supplies = vend.supplies;
	let result = "";
	//For each category in the supply list
	Object.keys(supplies).forEach(key => {
		result += `<b>${key}</b><a name="${key}"></a><br>`;
		//For each item in the category
		Object.keys(supplies[key]).forEach(id => {
			item = supplies[key][id];
			result += `${item.name} (\$${item.price}, stock=${item.stock}) <img src='add.png' style='height:20px;vertical-align:bottom;' onclick='addItem(${item.stock}, ${id})'/> <br>`;
			result += item.description + "<br><br>";
		});
	});
	return result;
}

//Responsible for adding one of the items with given id to the order, updating the summary, and alerting if "Out of stock"
function addItem(stock, id) {
	if ((order.hasOwnProperty(id) && (stock == order[id])) || stock == 0){//added case if stock is 0 then out of stock as well
		alert("Out if stock!");
		return;
	} else if (order.hasOwnProperty(id)) {
		order[id] += 1;
	} else {
		order[id] = 1;
	}
	updateOrder();
}

//Responsible for removing one of the items with given id from the order and updating the summary
function removeItem(id) {
	if (order.hasOwnProperty(id)) {
		order[id] -= 1;
		if (order[id] <= 0) {
			delete order[id];
		}
	}
	updateOrder();
}

//Reproduces new HTML containing the order summary and updates the page
//This is called whenever an item is added/removed in the order
function updateOrder() {
	let result = "";
	let subtotal = 0;

	//For each item ID currently in the order
	Object.keys(order).forEach(id => {
		//Retrieve the item from the supplies data using helper function
		//Then update the subtotal and result HTML
		let item = getItemById(id);
		subtotal += (item.price * order[id]);
		result += `${item.name} x ${order[id]} (${(item.price * order[id]).toFixed(2)}) <img src='remove.png' style='height:15px;vertical-align:bottom;' onclick='removeItem(${id})'/><br>`;
	});

	//Add the summary fields to the result HTML, rounding to two decimal places
	result += `<br>Subtotal: \$${subtotal.toFixed(2)}<br>`;
	result += `Tax: \$${(subtotal * 0.1).toFixed(2)}<br>`;
	result += `Delivery Fee: \$${currentVendor.delivery_fee.toFixed(2)}<br>`;
	total = subtotal + (subtotal * 0.1) + currentVendor.delivery_fee;//design changed so its globaly defined and not just locally in this function
	result += `Total: \$${total.toFixed(2)}<br>`;

	//Decide whether to show the Submit Order button or the "Order X more" label
	if (subtotal >= currentVendor.min_order) {
		result += `<button type="button" id="submit" onclick="putsubmitOrder()">Submit Order</button>`
	} else {
		result += `Add \$${(currentVendor.min_order - subtotal).toFixed(2)} more to your order.`;
	}

	document.getElementById("right").innerHTML = result;
}

//Simulated submitting the order
//For A2, you will likely make an XMLHttpRequest here
function submitOrder() {
	alert("Order placed!");
	order = {};
	getSelectVendor();//resets page of the current vendor after orders been submitted
}
function putsubmitOrder(){//sends request to server to order these items and sends order data
	xhttp = new XMLHttpRequest();
    //This is only going to get called when readyState changes
	xhttp.onreadystatechange = function() {
        //If the response is available and was successful
		if(this.readyState==4 && this.status==200){
			submitOrder();//once orders been placed in the server then call this to update the client
		}
	}
	
	let datasend = {};//sets data to send as the an object
	datasend[currentVendor.id] = order;//current vendor id information as the key and value as the order object
	datasend["total"] = total.toFixed(2);//total as the key and value as total for this order for server access

	xhttp.open("PUT", `http://localhost:3000/submitOrder`);
	xhttp.setRequestHeader("Content-Type", "application/json");//sets content type of data sent
	xhttp.send(JSON.stringify(datasend));
}

//Helper function. Given an ID of an item in the current vendors' supply list, returns that item object if it exists.
function getItemById(id) {
	let categories = Object.keys(currentVendor.supplies);
	for (let i = 0; i < categories.length; i++) {
		if (currentVendor.supplies[categories[i]].hasOwnProperty(id)) {
			return currentVendor.supplies[categories[i]][id];
		}
	}
	return null;
}