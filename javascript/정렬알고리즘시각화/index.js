// const showButton = document.getElementById("showButton")

// showButton.addEventListener('click', function() {
//   const circles = document.getElementById("circles");
//   const numbers = document.getElementById('numbers').value.split(",");
//   if (numbers.length < 2){
//     alert('1개 이상 숫자를 입력해주세요.');
//     return;
//   }
//   numbers.map((number) => {
//     const numberElement = document.createElement("div");
//     numberElement.className = "circle";
//     numberElement.innerText = number;
//     circles.appendChild(numberElement);  
//     return;
//   });
//   this.removeEventListener('click', arguments.callee); //arguments.callee 를 사용하여 스스로의 함수를 지정하여 제거
// });

const showSorts = () => {
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

const selectSort = () =>{

}

const bubbleSort = () => {};
const insertionSort = () => {};
const mergeSort = () => {};