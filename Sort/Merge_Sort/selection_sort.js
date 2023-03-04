function selectionSort(arr) {

  function swap(indx1, indx2, arr) {
    [arr[indx1], arr[indx2]] = [arr[indx2], arr[indx1]];
  }

  for (let i =0; i < arr.length; i++) {
    let lowestIndx = i;

    for (let j=i+1; j < arr.length; j++) {
      if (arr[lowestIndx] > arr[j]) {
        lowestIndx = j;
      }
    }
    if (lowestIndx !== i) swap(i, lowestIndx, arr);
  }

  return arr;
}

selectionSort([1,19,34,22,10,2,0]);