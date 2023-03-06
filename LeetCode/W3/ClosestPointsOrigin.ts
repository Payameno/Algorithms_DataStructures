function kClosest(points: number[][], k: number): number[][] {

  let distances: number[] = [];

  points.forEach(element => {
    const x = element[0];
    const y = element[1];
    const dist = Math.sqrt(x^2 + y^2);
    distances.push(dist);
  });

  //store them in an object {key: value}
  //retirve k items from object and push to an array, rturn it

}; 

//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
// Output: [[3,3],[-2,4]]