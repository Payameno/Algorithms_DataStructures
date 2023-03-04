function pivot(arr, start , end = arr.length - 1) {

  const swap = (arr, idx1, idx2) => {
    [arr[idx1], arr[idx2]] = [arr[idx2], arr[idx1]];
  };

  let pivot = [arr[start]];
  let swpIdx = start;
  
  for (let i=start + 1; i <= end; i++) {
    if (pivot > arr[i]) {
      swpIdx++;
      swap(arr, swpIdx, i);
    }
  }
  swap(arr,start,swpIdx);
  return swpIdx;

}

function quickSort(arr, left = 0, right = arr.length - 1) {
  if (left < right) {
    let pivotIndex = pivot(arr, left, right);

    //left
    quickSort(arr, left, pivotIndex-1); 
  
    //right
    quickSort(arr, pivotIndex+1, right);
  }
  return arr;
}

quickSort([-3, -100, 12, 3, 5, 0, 40]);