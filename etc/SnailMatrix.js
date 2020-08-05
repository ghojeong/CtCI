for (var i = 1; i < 26; i++) {
  printSnailMatrix(i);
  console.log("\n\n");
}

function printSnailMatrix(input) {
  var xPos = 0;
  var yPos = 0;
  var minX = 0;
  var maxY = 0;
  var dir = 0;
  var sideLen = 1;
  var sideItr = 0;
  var snailCo = new Array();
  snailCo[input] = { xPos: 0, yPos: 0 };
  for (var val = input - 1; val > 0; val--) {
    if (dir == 0) {
      xPos--;
    } else if (dir == 1) {
      yPos--;
    } else if (dir == 2) {
      xPos++;
    } else if (dir == 3) {
      yPos++;
    }

    if (minX > xPos) {
      minX = xPos;
    }
    if (maxY < yPos) {
      maxY = yPos;
    }
    snailCo[val] = { xPos, yPos };

    if (sideLen <= ++sideItr) {
      if (dir % 2 == 1) {
        sideLen++;
      }
      sideItr = 0;
      dir = (dir + 1) % 4;
    }
  }

  var matrix = new Array();
  for (var val = 1; val <= input; val++) {
    var co = snailCo[val];
    if (!matrix[-co.yPos + maxY]) {
      matrix[-co.yPos + maxY] = new Array();
    }
    matrix[-co.yPos + maxY][co.xPos - minX] = val;
  }
  for (var i = 0; i < matrix.length; i++) {
    var arrStr = "";
    for (var j = 0; j < matrix[i].length; j++) {
      if (!matrix[i][j]) {
        arrStr += "    ";
      } else if (matrix[i][j] < 10) {
        arrStr += "  " + matrix[i][j] + " ";
      } else {
        arrStr += " " + matrix[i][j] + " ";
      }
    }
    console.log(arrStr + "\n");
  }
}
