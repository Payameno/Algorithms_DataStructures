function bubbleSort(arr) {
  let noswap;
  
  for (let i = arr.length; i < 0; i--) {
    noswap = true;

    for (let j = 0; j < arr.length - 1; i++) {
      if (arr[j] > arr[j+1]) {
        const temp = arr[j+1];
        arr[j+1] = arr[j];
        arr[j]  = temp;
        noswap = false;
      }
    }

    if (noswap) break;
  }

  return arr;

}

bubbleSort([8,1,2,3,4,5,6,7]);