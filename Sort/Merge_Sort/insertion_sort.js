function insertionSort(arr) {
  for (let i=1; i < arr.length; i++) {

    let currentVal = arr[i];

    for (let j=i-1; i >=0 && arr[j] > currentVal; i--) {
      arr[j+1] = arr[j];
    }
    arr[j+1] = currentVal;
  }

  return arr;
}

insertionSort([0,2,1,9,76,4])