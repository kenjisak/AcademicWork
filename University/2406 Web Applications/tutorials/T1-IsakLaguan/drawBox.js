// Convert into a drawBox function

function drawBox(numRows,numCols,boxChar = "X"){
    for (let r = 0; r < numRows; r++) {
        let line = "";
        for (let c = 0; c < numCols; c++) {
            line += boxChar;
        }
        console.log(line);
    }
}

drawBox(5,4,"!");
drawBox(2,6);