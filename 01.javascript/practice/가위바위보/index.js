var 바디 = document.body;

var 게임영역 = document.createElement("div");
var 결과영역 = document.createElement("div");
var 사진영역 = document.createElement("div");
var 사진 = document.createElement("img");
var 버튼그룹 = document.createElement("div");

결과영역.style.height = "5em";
결과영역.style.fontWeight = "bold";
결과영역.style.fontSize = "large";
결과영역.style.textAlign = "center";
결과영역.style.marginTop = "5em";

사진.src = "https://t1.daumcdn.net/cfile/tistory/999F58425BC6E18C0F";
사진.style.width = "450px";
사진.style.position = "relative";

사진영역.appendChild(사진);
사진영역.style.overflow = "hidden";
사진영역.style.width = "150px";
사진영역.style.marginLeft = "auto";
사진영역.style.marginRight = "auto";

버튼그룹.style.marginTop = "1em";
버튼그룹.style.display = "flex";
버튼그룹.style.justifyContent = "space-between";
버튼그룹.style.width = "40%";
버튼그룹.style.marginLeft = "auto";
버튼그룹.style.marginRight = "auto";

var count = 1;
var 가위바위보 = { 가위: "-150px", 바위: "0px", 보: "-300px" };

var timerId = null;

var startInterval = () => {
  if (timerId === null) {
    timerId = setInterval(() => {
      사진.style.left = Object.values(가위바위보)[count % 3];
      count += 1;
    }, 500);
  }
};

var stopInterval = () => {
  clearInterval(timerId);
  timerId = null;
};

window.onload = function () {
  startInterval();
};

var 콜백함수 = function (event) {
  stopInterval();
  var 내가낸거, 컴퓨터가낸거;
  Object.entries(가위바위보).map(([key, value], index) => {
    if (value === 사진.style.left) 컴퓨터가낸거 = index;
    if (key === event.target.textContent) 내가낸거 = index;
  });

  var result = 0;
  if (Math.abs(내가낸거 - 컴퓨터가낸거) === 2) {
    result = 내가낸거 < 컴퓨터가낸거 ? 1 : -1;
  } else if (내가낸거 - 컴퓨터가낸거 === 0) {
    result = 0;
  } else {
    result = 내가낸거 > 컴퓨터가낸거 ? 1 : -1;
  }
  if (result === 1) {
    결과영역.textContent = "이기셨습니다!!!!!!!!!";
  } else if (result === 0) {
    결과영역.textContent = "비기셨습니다ㅋ";
  } else {
    결과영역.textContent = "졌어요 ㅠㅡㅠ";
  }
};

Object.keys(가위바위보).map((무엇) => {
  var 버튼 = document.createElement("button");
  버튼.className = "btn-grad";
  버튼.textContent = 무엇;
  버튼.addEventListener("click", 콜백함수);
  버튼그룹.appendChild(버튼);
});

var 재시작버튼 = document.createElement("button");
재시작버튼.textContent = "게임재시작";
재시작버튼.addEventListener("click", function () {
  결과영역.textContent = "";
  startInterval();
});
재시작버튼.className = "restart-btn-grad";

게임영역.appendChild(결과영역);
게임영역.appendChild(사진영역);
게임영역.appendChild(버튼그룹);
게임영역.appendChild(재시작버튼);
바디.appendChild(게임영역);
