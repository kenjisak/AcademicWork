function landscape() {
  let result = "";
  let hilltop = "";
  
  function flat(size) {
    for (let count = 0; count < size; count++){
      hilltop += " "
      result += "_";
    }
  }
  
  function hill(size) {
    result += "/";
    hilltop += " ";
    for (let count = 0; count < size; count++){
      hilltop += "_";
      result += " ";

    }
    hilltop += " ";
    result += "\\";
  }

  //START BUILD SCRIPT (do not change this part)
  flat(3);
  hill(4);
  flat(6);
  hill(1);
  flat(1);
  //END BUILD SCRIPT
  result = hilltop + "\n" + result;
  return result;

}

console.log("");
console.log(landscape());
