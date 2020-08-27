const selectSortType = () => {
  document.getElementById("dropdown-contents").classList.toggle("show");
};


const getNumbers = () => {
  const numbers = document.getElementById("numbers").value.split(",");
  return numbers;
};

const checkNumbers = (numbers)=>{
  if (numbers.length < 2){
      alert('1개 이상 숫자를 입력해주세요.');
      return -1; //비정상
    }
    return 0 //정상
}

const createCircles = (numbers) => {
  const circles = document.getElementById("numbers");
  while (circles.hasChildNodes()) {
    circles.removeChild(circles.firstChild);
  }
  const numberList = document.createElement("ul");
  numberList.id = "numbers-list";
  numberList.className = "numbers-list";

  numbers.map((number) => {
    const numberElement = document.createElement("li");
    numberElement.className = "number";
    numberElement.innerText = number;
    numberList.appendChild(numberElement);
    return;
  });
  circles.appendChild(numberList);
};

const showNumbers = () => {
  selectSortType();
  const numbers = document.getElementById("input-numbers").value.split(",");      
  if (checkNumbers(numbers) !== 0) return;
  createCircles(numbers);
}

const swapElement = (e1, e2) =>{
  const temp = document.createElement('li');
  temp.className = "number";
  

}

const selectSort = () =>{
  console.log(document.getElementById("numbers-list").querySelectorAll("li"));
  const numberListNode = document.getElementById("numbers-list");
  const numberList = [];
  for(let node of Object.entries(numberListNode)){
    console.log(node.innerText)
    numberList.push(parseInt(node.innerText))
  }
  console.log(numberList)
  const length = numbers.length;
  for(let i=0; i<length-1; i++){
    for(j=0; j < length-1-i; j++){
      if(numbers[j]>numbers[j+1]){
        
      }
    }
  }
}

const bubbleSort = () => {
};
const insertionSort = () => {
  
};
const mergeSort = () => {
};

const startSort = (type) => {
  selectSortType();
  showNumbers();
  if (type == 1) selectSort();
  if (type == 2) bubbleSort();
  if (type == 3) insertionSort();
  if (type == 4) mergeSort();
}