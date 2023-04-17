let starNum = 5;
function init(){
    //loads stars in
    let starsP = "<strong>Rating:</strong>";
    let starsButton = "";
    for (let i = 1; i <= starNum; i++){
        starsP +='<span id="rating'+ i +'">&#9733;</span>';//creates stars
        starsButton +='<button type="buttons" onclick="updateRating('+ i +')">Rate '+ i +'</button>';//creates buttons
    }

    document.getElementById("stars").innerHTML = starsP;
    document.getElementById("buttons").innerHTML = starsButton;
}
function updateRating(newRating) {
    for (let i = 1; i <= newRating; i++){//start first index to make blue
        document.getElementById('rating'+ i +'').style.color = "blue";
        }
    for (let i = 1; i <= starNum - newRating; i++){//5 - 1 = 4 to make grey
        let count = newRating + i;//start at index after blue stars
        document.getElementById('rating' + count +'').style.color = "lightgray";
    }
}
