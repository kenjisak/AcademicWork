function checkForm() {
   //test cases for pass words
   // aaaaaaaaaaaaaaa all lower
   // AAAAAAAAAAAAAAA all upper
   // aaaaaaaaaaaaaaA lower and upper
   // aaaaaaaaaaaaaa1 lower with digit
   // AAAAAAAAAAAAAA1 upper with digit
   // aaaaaaaaaaaaaA1 lower and upper with digit

   let name = document.getElementById("fullName").value
   let email = document.getElementById("email").value
   let password = document.getElementById("password").value
   let passwordConfirm = document.getElementById("passwordConfirm").value

   let regname = /^[a-zA-Z]+\s[a-zA-Z]+$/; //starts with any letter one or more times, followed by space, then ends with any letter one or more times.
   let regemail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,5}$/;
   let regpasswordlower = /[a-z]/;
   let regpasswordupper = /[A-Z]/;
   let regpassworddigit =/[0-9]/; 
   
   document.getElementById("formErrors").innerHTML = '<ul id="errorlist"></ul>'
   /////////////////////////////////////////////////////
   if(regname.test(name)){// if true/valid
      if(document.getElementById("errorname") != null){//checks if null since the error can not be created yet
         document.getElementById("errorlist").removeChild(document.getElementById("errorname"));//removes the error in ul by removing it as a child
      }
      document.getElementById("fullName").removeAttribute("class");//removes class attribute to get rid of red outline of input field
   }else{
      document.getElementById("errorlist").innerHTML += '<li id="errorname">Missing full name.</li>';
      document.getElementById("fullName").className = "error"
   }
   /////////////////////////////////////////////////////
   if(regemail.test(email)){
      if(document.getElementById("erroremail") != null){
         document.getElementById("errorlist").removeChild(document.getElementById("erroremail")); 
      }
      document.getElementById("email").removeAttribute("class");
   }else{
      document.getElementById("errorlist").innerHTML += '<li id="erroremail">Invalid or missing email address.</li>';
      document.getElementById("email").className = "error"
   }
   /////////////////////////////////////////////////////
   if(password.length >= 10 && password.length <= 20){
      if(document.getElementById("errorpasslength") != null){
         document.getElementById("errorlist").removeChild(document.getElementById("errorpasslength")); 
      }
      document.getElementById("password").removeAttribute("class");
   }else{
      document.getElementById("errorlist").innerHTML += '<li id="errorpasslength">Password must be between 10 and 20 characters.</li>';
      document.getElementById("password").className = "error"
   }
   /////////////////////////////////////////////////////
   if(regpasswordlower.test(password)){
      if(document.getElementById("errorpasslower") != null){
         document.getElementById("errorlist").removeChild(document.getElementById("errorpasslower")); 
      }
      document.getElementById("password").removeAttribute("class");
   }else{
      document.getElementById("errorlist").innerHTML += '<li id="errorpasslower">Password must contain at least one lowercase character.</li>';
      document.getElementById("password").className = "error"
   }
   /////////////////////////////////////////////////////
   if(regpasswordupper.test(password)){
      if(document.getElementById("errorpassupper") != null){
         document.getElementById("errorlist").removeChild(document.getElementById("errorpassupper")); 
      }
      document.getElementById("password").removeAttribute("class");
   }else{
      document.getElementById("errorlist").innerHTML += '<li id="errorpassupper">Password must contain at least one uppercase character.</li>';
      document.getElementById("password").className = "error"
   }
   /////////////////////////////////////////////////////
   if(regpassworddigit.test(password)){
      if(document.getElementById("errorpassdigit") != null){
         document.getElementById("errorlist").removeChild(document.getElementById("errorpassdigit")); 
      }
      document.getElementById("password").removeAttribute("class");
   }else{
      document.getElementById("errorlist").innerHTML += '<li id="errorpassdigit">Password must contain at least one digit.</li>';
      document.getElementById("password").className = "error"
   }
   /////////////////////////////////////////////////////
   if(password == passwordConfirm){
      if(document.getElementById("errorpassconfirm") != null){
         document.getElementById("errorlist").removeChild(document.getElementById("errorpassconfirm")); 
      }
      document.getElementById("passwordConfirm").removeAttribute("class");
   }else{
      document.getElementById("errorlist").innerHTML += "<li id='errorpassconfirm'>Password and confirmation password don't match.</li>";
      document.getElementById("passwordConfirm").className = "error"
   }
   /////////////////////////////////////////////////////
   if(document.getElementById("errorlist").hasChildNodes()){//if there are errors then show
      document.getElementById("formErrors").removeAttribute("class");
   }else{//if there arent any errors then hide
      document.getElementById("formErrors").className = "hide";
   }
   /////////////////////////////////////////////////////
}

document.getElementById("submit").addEventListener("click", function(event) {
   checkForm();

   // Prevent default form action. DO NOT REMOVE THIS LINE
   event.preventDefault();
});