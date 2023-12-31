function mergeSortedArrays(leftArray, rightArray) {
  console.log("merge " + leftArray + ' and ' + rightArray);
  let merged = [];
  let leftEl = leftArray.shift();
  let rightEl = rightArray.shift();

  outer: while (rightEl && leftEl) {

    while (leftEl <= rightEl) {

      console.log(leftEl + " is smaller than or equal to " + rightEl)
      merged.push(leftEl);
      console.log("add " + leftEl + " to merged array: [" + merged + "]")


      if (leftArray.length > 0)
        leftEl = leftArray.shift();
      else {
        leftEl = null;

        continue outer;
      }
    }
    while (rightEl <= leftEl) {
      console.log(rightEl + " is smaller than or equal to " + leftEl)
      merged.push(rightEl);
      console.log("add " + rightEl + " to merged array: [" + merged + "]")

      if (rightArray.length > 0)
        rightEl = rightArray.shift();
      else {
        rightEl = null;
        break outer;
      }


    }




  }

  if (leftEl) merged.push(leftEl)
  if (rightEl) merged.push(rightEl)

  if(rightArray.length > 0) {
    console.log("add "+rightArray + " to " + merged+": ")
   merged =merged.concat(rightArray)
   console.log("**"+merged+"**")
   }else if(leftArray > 0){
    console.log("add "+leftArray + " to " + merged+": ")
   merged =merged.concat(leftArray)
   console.log("**"+merged+"**")
  }
  console.log("MERGE METHOD RESULT:" + merged)

  return merged;
}

function divideArray(arr) {
  console.log("divide " + arr + " in two pieces");
  let leftHalf = arr.slice(0, arr.length / 2);
  let rightHalf = arr.slice(arr.length / 2);


  console.log("left array: " + leftHalf + ", right array: " + rightHalf)
  return [leftHalf, rightHalf];
}


function mergeSort(array) {
  console.log("call mergesort on " + array)
  if (array.length == 1) {
    console.log("BASE CASE: " + array)
    return array;
  } else {
    // Only change code below this line
    let halves = divideArray(array);
    let leftHalf = mergeSort(halves[0])

    let rightHalf = mergeSort(halves[1])
    console.log('left: ' + leftHalf);

    console.log("right: " + rightHalf);

    let mergedArray = mergeSortedArrays(leftHalf, rightHalf);

    console.log("MERGED: " + mergedArray);
    return mergedArray;
  }


}


mergeSort([1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 234, 92])
