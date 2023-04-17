function init(){
    listinit();//lists init function called
    
    document.getElementById("addbtn").addEventListener("click",function(){//event handler for add item button
        additem(document.getElementById("iteminput").value);//calls additem function and passes in the user input value
    });
    document.getElementById("removebtn").addEventListener("click",removeitem);//event handler for remove item button
    document.getElementById("highlightbtn").addEventListener("click",highlightitem);//event handler for highlight item button
    document.getElementById("sortbtn").addEventListener("click",sortitem);//event handler for sort item button
}
let itemlist = [];

function listinit(){
    result = '<input type="checkbox" id="clean car"><label id="clean car label">clean car</label><br>';//example for init() so theres at least 1 item displayed onload
    itemlist.push("clean car");//adds item to item array
    document.getElementById("itemlist").innerHTML = result;//adds html of item to innerhtml of itemlist ul
}

function additem(itemname){
    
    if(itemname.length >= 1 && !(itemlist.includes(itemname))){//checks if length of input is at least 1 character and is not already in item array, doesnt allow duplicate items
        itemlist.push(itemname);//adds item to item array
        document.getElementById("itemlist").innerHTML += `<input type="checkbox" id="${itemname}"><label id="${itemname} label">${itemname}</label><br>`;//adds html of item to innerhtml of the itemlist ul
        document.getElementById("iteminput").value = "";//resets input box to empty
    }else if(itemlist.includes(itemname)){//else if item is already in the item array then notify user cant add them and reset input value
        confirm("Item is already in List");
        document.getElementById("iteminput").value = "";
    }else{//else the input is empty and user is alerted
        confirm("Input needs to be at least 1 character long");
    }
}

function removeitem(){
    itemlist = [];//resets item list

    for(let itemstay of document.querySelectorAll('input[type="checkbox"]:not(:checked)')){//those not selected to be removed are added back into list
        itemlist.push(itemstay.id);//adds back the items that arent removed to the array
    }
    
    result = "";
    
    for(let item of document.querySelectorAll('input[type="checkbox"]')){//gets all checkbox elements and iterates through them
        itemlabel = document.getElementById(item.id + " label");//finds label of the items checkbox
        
        if (itemlabel.hasAttribute("style") && itemlist.includes(item.id)){//if item label is highlighted and is in item list then add html with highlight to result
            result += `<input type="checkbox" id="${item.id}"><label id="${item.id} label" style="background-color: yellow;">${item.id}</label><br>`;
        }else if(!(itemlabel.hasAttribute("style")) && itemlist.includes(item.id)){//else if item is in list but doesnt contain highlight add without it to result
            result += `<input type="checkbox" id="${item.id}"><label id="${item.id} label">${item.id}</label><br>`;
        }else{//else this is the item that needs to be removed
            //dont add element back in
        }
    }
    document.getElementById("itemlist").innerHTML = result;//sets innerhtml of ul with readded items that stays
}

function highlightitem(){
    for(let itemremove of document.querySelectorAll('input[type="checkbox"]:checked')){//gets all checked elements and iterates through them
        itemlabel = document.getElementById(itemremove.id + " label");//grabs the item label for that checkedbox
        
        if (itemlabel.hasAttribute("style")){//if the label is highlighted then unhighlight it by removing the attribute
            itemlabel.removeAttribute("style");
        }else{//else give label the attribute and highlight it
            itemlabel.style.backgroundColor = "yellow";
        }
    }
}

function sortitem(){
    itemlistul = document.getElementById("itemlist");
    itemlist.sort();//sorts item array
    result = "";
    
    for(let itemname of itemlist){//iterates through item array and populates result 
        
        if(document.getElementById(itemname + " label").hasAttribute("style")){//if the label for this item is highlighted then add this html to result
            result += `<input type="checkbox" id="${itemname}"><label id="${itemname} label" style="background-color: yellow;">${itemname}</label><br>`;
        }else{//else its not highlighted and add without style tag
            result += `<input type="checkbox" id="${itemname}"><label id="${itemname} label">${itemname}</label><br>`;
        }
    }
    
    itemlistul.innerHTML = result;//sets innerhtml of the ul to repopulated sorted items with highlights
}