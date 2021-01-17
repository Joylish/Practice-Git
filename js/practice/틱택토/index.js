var 바디 = document.body;
var 테이블 = document.createElement("table");
var 순서창 = document.createElement("div");
var 줄들 = [];
var 칸들 = [];
var 턴 = "X";

var 게임마무리 = function () {
  alert(`${턴}님이 이겼습니다!`);
  칸들.forEach(function (줄) {
    줄.forEach(function (칸) {
      칸.textContent = " ";
    });
  });
};

// 들여쓰기 깊이가 3이상이면,
// 따로 분리하는 것을 추천한다.
var 비동기콜백 = function (event) {
  let 몇줄 = 줄들.indexOf(event.target.parentNode);
  let 몇칸 = 칸들[몇줄].indexOf(event.target);
  let 타겟 = 칸들[몇줄][몇칸];

  if (타겟.textContent === "") {
    타겟.textContent = 턴;

    var 가로확인 =
      칸들[몇줄][0].textContent === 턴 &&
      칸들[몇줄][1].textContent === 턴 &&
      칸들[몇줄][2].textContent === 턴;
    var 세로확인 =
      칸들[0][몇칸].textContent === 턴 &&
      칸들[1][몇칸].textContent === 턴 &&
      칸들[2][몇칸].textContent == 턴;

    console.log(몇줄 - 몇칸 === 0 || Math.abs(몇줄 - 몇칸) === 2);
    console.log(
      칸들[0][0].textContent === 턴 &&
        칸들[1][1].textContent === 턴 &&
        칸들[2][2].textContent === 턴
    );
    var 대각선확인 =
      (몇줄 - 몇칸 === 0 || Math.abs(몇줄 - 몇칸) === 2) &&
      ((칸들[0][0].textContent === 턴 &&
        칸들[1][1].textContent === 턴 &&
        칸들[2][2].textContent === 턴) ||
        (칸들[0][2].textContent === 턴 &&
          칸들[1][1].textContent === 턴 &&
          칸들[2][0].textContent === 턴));

    if (가로확인 || 세로확인 || 대각선확인) {
      게임마무리();
    }

    // ## 턴바꾸기
    // 비동기 콜백함수 내에 선언된 변수는
    // 콜백함수가 실행 완료되면 사라진다.
    // 즉, 여러 콜백함수끼리 변수를 공유하지 못한다.
    if (턴 === "X") {
      턴 = "O";
    } else {
      턴 = "X";
    }

    순서창.textContent = `${턴}님 차례입니다.`;
  }
};

for (var i = 0; i < 3; i += 1) {
  var 줄 = document.createElement("tr");
  줄들.push(줄);
  칸들.push([]);
  for (var j = 0; j < 3; j += 1) {
    var 칸 = document.createElement("td");
    칸.addEventListener("click", 비동기콜백);
    칸.textContent = "";
    칸.style.width = "10em";
    칸.style.height = "10em";
    칸.style.textAlign = "center";
    칸.style.fontSize = "1em";
    칸.style.border = "1px solid black";

    칸들[i].push(칸);

    줄.appendChild(칸);
  }
  테이블.appendChild(줄);
}
바디.appendChild(테이블);
순서창.textContent = `${턴}님 차례입니다.`;
바디.appendChild(순서창);
