// Return true if the given username and password are in the "database",
// false otherwise.
function validCredentials(enteredUsername, enteredPassword) {

    // "Database" of usernames and passwords
    let usernames = ["smith", "tron", "ace", "ladyj", "anon"];
    let passwords = ["qwerty", "EndOfLine", "year1942", "ladyj123", "PASSWORD"];

    // Search the usernames array for enteredUsername 
    let checkUser = usernames.indexOf(enteredUsername); 
    //console.log(checkUser, passwords.indexOf(enteredPassword)); errorchecking
    if (checkUser == -1){//if theres no error finding
        return false;
    }
    // same location in passwords is enteredPassword
    if (passwords.indexOf(enteredPassword) !== checkUser || enteredPassword !== passwords[checkUser]){
        return false;//checks if enteredpassword location is the in diff as user location, or if entered pass is wrong
        //if pass is right it but wrong loc then false, if right loc but wrong pass then false 
    }
    // Only return true if the enteredUsername is in username, and the
    return true;
}


console.log("Login for ladyj: " + validCredentials("ladyj", "ladyj123"));  // true
console.log("Login for ace: " + validCredentials("ace", "wrong"));  // false
console.log("Login for jake: " + validCredentials("jake", "???"));  // false
