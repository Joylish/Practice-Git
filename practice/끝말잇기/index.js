var 바디 = document.body;

var 단어 = document.createElement("div");
var 폼 = document.createElement("form");
var 입력창 = document.createElement("input");
var 버튼 = document.createElement("button");
var 결과창 = document.createElement("div");
var 기록물 = document.createElement("ul");

단어.textContent = "베개";
버튼.textContent = "제출";

document.body.append(단어);
document.body.append(폼);
폼.append(입력창);
폼.append(버튼);
document.body.append(결과창);
document.body.append(기록물);

폼.addEventListener("submit", function (이벤트) {
  // 나는 콜백함수이자 익명함수

  // 이벤트는 브라우저가 넣어준다.

  // 기본동작은 새로고침
  // 기본동작을 방지하는 코드
  이벤트.preventDefault();

  if (단어.textContent[단어.textContent.length - 1] == 입력창.value[0]) {
    // div-textContent와 input-value
    var 기록 = document.createElement("li");
    기록.textContent = 입력창.value;
    기록물.append(기록);
    결과창.textContent = "딩동댕";
    단어.textContent = 입력창.value;
    입력창.value = "";
    입력창.focus();
  } else {
    결과창.textContent = "틀렸는데요?";
    입력창.value = "";
    입력창.focus();
  }
});

function 더하기(숫자1, 숫자2) {
  console.log(숫자1, 숫자2);
}
더하기(3, 5);
