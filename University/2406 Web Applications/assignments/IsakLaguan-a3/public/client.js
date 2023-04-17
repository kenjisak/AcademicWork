let newitems = {};//initialize on vendor page load with all of vendors categories for new items

function init(){//initializes new items data for all categories for sending to put later
    xhttp = new XMLHttpRequest();
    //This is only going to get called when readyState changes
    xhttp.onreadystatechange = function() {
        //If the response is available and was successful
        if(this.readyState==4 && this.status==200){
            let vendordata = JSON.parse(this.responseText);//parses json response of vendor data
            // console.log(Object.keys(vendordata.supplies));
            Object.keys(vendordata.supplies).forEach(category =>{//init for storing any new items in each category later
                newitems[category] = {};
            });
        }
    }
    xhttp.open("GET", window.location.href);//uses current url to make a request to grab vendor data info as json
    xhttp.setRequestHeader("Accept", "application/json");//sets accept header as json
    xhttp.send();
}

function addvendor(){//called when add a vendor button is clicked to send a post request to add a new vendor
    //grabs data from textfields for the new vendor
    let name = document.getElementById("vendorname").value;
    let delfee = document.getElementById("vendordelfee").value;
    let minorder = document.getElementById("vendorminorder").value;

    xhttp = new XMLHttpRequest();
		//This is only going to get called when readyState changes
	xhttp.onreadystatechange = function() {
		//If the response is available and was successful
		if(this.readyState==4 && this.status==200){
            alert("Vendor added Successfully!");//alerts user that vendor was added
            let newvendorinfo = JSON.parse(this.responseText);//parse json request
            // console.log(newvendorinfo.id);
            window.location.href = `http://localhost:3000/vendors/` + newvendorinfo.id;//load new vendor using its id with get/vendors/:vendorsid
        }else if(this.readyState==4 && this.status==400){//else 400 response returned due to at least one of the text fields are empty
            alert("One of the fields wasn't filled out!");
        }
	}
	xhttp.open("POST", `http://localhost:3000/vendors`);
	xhttp.setRequestHeader("Content-Type", "application/json");//sets content type of data sent to json
	xhttp.send(JSON.stringify({"name": name,"delivery_fee": delfee,"min_order": minorder}));//sends vendor info on par to spec to server
}

function updatevendor(){//called when save button is clicked
    let vendorinfo = {}; //defines vendor info object to be passed later to server. and grabs its info from the text fields
    vendorinfo["name"] = document.getElementById("vendorname").value;
    vendorinfo["delivery_fee"] = document.getElementById("vendordelfee").value;
    vendorinfo["min_order"] = document.getElementById("vendorminorder").value;

    xhttp = new XMLHttpRequest();
		//This is only going to get called when readyState changes
	xhttp.onreadystatechange = function() {
		//If the response is available and was successful
		if(this.readyState==4 && this.status==200){
            alert("Vendor updated Successfully!");
            window.location.reload();//reloads the page with new updated vendor
        }else if(this.readyState==4 && this.status==404){
            alert("Vendor doesn't exist");//vendor id didnt exist in database
        }
	}
    let updateinfo = {};//creates object that contains both vendor info and new items info to be added to server
    updateinfo["vendor"] = vendorinfo;
    updateinfo["items"] = newitems;
	xhttp.open("PUT", window.location.href);//sends put request using the current url
	xhttp.setRequestHeader("Content-Type", "application/json");//sets content type of data sent to json
	xhttp.send(JSON.stringify({updateinfo}));//sends all info for vendor and new items to be added to server
}

function additem(){//called when add item button is clicked
    let ID = document.getElementById("middle").querySelectorAll("p").length;//counts how many items there are on the vendor page using the p tag since each item only has 1 p tag to display

    let newcat = document.getElementById("categoryselect");
	let selectedcat = newcat.options[newcat.selectedIndex].value;//grabs the new item category to be added to in the vendor
    //grabs values for new item from their text fields
    let name = document.getElementById("itemname").value;
    let description = document.getElementById("itemdesc").value;
    let stock = document.getElementById("itemstock").value;
    let price = document.getElementById("itemprice").value;

    if (selectedcat === ""){//if any of the fields arent filled or category isnt selected then alerts the user
		alert("Please select a Category");
	}else if (name === ""){
		alert("Please enter Item Name");
	}else if(description === ""){
		alert("Please enter Item description");
	}else if(stock === "" || stock < 1){
		alert("Item Stock must be at least 1");
    }else if(price === ""){
		alert("Please enter Item Price");
	}else{//else creates an item object to add into new items object in their respected category
        let item = {};
        
        item["name"] = name;
        item["description"] = description;
        item["stock"] = parseInt(stock);
        item["price"] = parseFloat(price);

        newitems[selectedcat][ID] = item;
        //updates the page to with new items to save locally but not to the server unless saved after
        itemhtml = `<p id=${ID}>${name} ID: ${ID} $${parseFloat(price).toFixed(2)} stock=${parseInt(stock)}</p>`;
        itemhtml += `${description}\n<br>\n<br>`;
  
        document.getElementById(selectedcat).innerHTML += itemhtml;
        alert("Item added but not saved");
	}
}