var 바디 = document.body;

var 폼 = document.createElement("form");
var 입력창 = document.createElement("input");
var 버튼 = document.createElement("button");
var 결과창 = document.createElement("div");
var 숫자 = get4Numbers();

입력창.type = "text";
입력창.maxLength = 4;
버튼.textContent = "제출";

document.body.append(결과창);
document.body.append(폼);
폼.append(입력창);
폼.append(버튼);

폼.addEventListener("submit", function (이벤트) {
  // 나는 콜백함수이자 익명함수
  // 콜백함수는 비동기함수
  // 브라우저

  // 이벤트는 브라우저가 넣어준다.

  // form의 submit 기본동작은 새로고침
  // 기본동작을 방지하는 코드
  이벤트.preventDefault();
  var 답 = 입력창.value;
  if (답 === 숫자) {
    결과창.textContent = "홈런!!!!";
    숫자 = get4Numbers();
    입력창.value = "";
    입력창.focus();
  } else {
    var 답배열 = 답.split();
    var 스트라이크 = 0;
    var 볼 = 0;
    var 숫자배열 = 숫자.split();
    var 틀린횟수 = 0;
    if (틀린횟수 > 10) {
      결과.textContent = `10번 넘게 틀려서 실패! 답은 ${숫자}였습니다.`;
      결과 = get4Numbers();
    } else {
      for (var i = 0; i < 3; i += 1) {
        if (답배열[i] === 숫자배열[i]) {
          볼 += 1;
        } else if (숫자배열.indexOf(답배열[i]) > -1) {
          볼 += 1;
        }
      }
      결과.textContent = `${스트라이크} 스트라이크 ${볼} 볼`;
    }

    입력창.value = "";
    입력창.focus();
  }
});

const get4Numbers = () => {
  var 숫자후보 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  var 숫자배열 = [];

  for (var i = 0; i < 4; i += 1) {
    var 뽑은것 = 숫자후보.splice(Math.ceil(Math.random * (9 - i)), 1)[0];
    숫자배열.push(뽑은것);
  }
  return 숫자배열.join();
};
