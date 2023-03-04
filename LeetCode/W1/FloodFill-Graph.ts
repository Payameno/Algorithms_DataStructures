function floodFill(image: number[][], sr: number, sc: number, color: number): number[][] {
  const oldColor = image[sr][sc];

  if (oldColor === color) {
    return image;
  }

  fill(image, sr, sc, oldColor, color);
  return image;
};

function fill(_image, _sr, _sc, _oldColor, _color) {

  if (_sr < 0 || _sr >= _image.length || _sc < 0 || _sc >= _image[0].length || _image[_sr][_sc] !== _oldColor) {
    return
  }
  
  _image[_sr][_sc] = _color;

  fill(_image, _sr + 1, _sc, _oldColor, _color);
  fill(_image, _sr - 1, _sc, _oldColor, _color);
  fill(_image,_sr, _sc + 1, _oldColor, _color);
  fill(_image,_sr, _sc - 1, _oldColor, _color);

}


// function floodFill(image: number[][], sr: number, sc: number, newColor: number): number[][] {
//   const oldColor = image[sr][sc];
  
//   if (oldColor === newColor) {
//       return image;
//   }
  
//   fill(image, sr, sc, oldColor, newColor);
  
//   return image;
// }

// function fill(image: number[][], row: number, col: number, oldColor: number, newColor: number) {
//   if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] !== oldColor) {
//       return;
//   }
  
//   image[row][col] = newColor;
  
//   fill(image, row + 1, col, oldColor, newColor);
//   fill(image, row - 1, col, oldColor, newColor);
//   fill(image, row, col + 1, oldColor, newColor);
//   fill(image, row, col - 1, oldColor, newColor);
// }