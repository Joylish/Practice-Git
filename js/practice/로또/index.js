var 바디 = document.body;

var 로또번호제목 = document.createElement("div");
var 로또번호영역 = document.createElement("div");

var 보너스번호제목 = document.createElement("div");
var 보너스번호영역 = document.createElement("div");

로또번호제목.textContent = "★ 로또번호 ★";
로또번호제목.style.textAlign = "center";
로또번호제목.style.fontSize = "3em";

로또번호영역.style.display = "flex";
로또번호영역.style.width = "50%";
로또번호영역.style.marginRight = "auto";
로또번호영역.style.marginLeft = "auto";

보너스번호제목.textContent = "★ 뽀너스번호 ★";
보너스번호제목.style.textAlign = "center";
보너스번호제목.style.fontSize = "3em";
보너스번호제목.style.marginTop = "1em";

보너스번호영역.style.display = "flex";
보너스번호영역.style.width = "6em";
보너스번호영역.style.marginRight = "auto";
보너스번호영역.style.marginLeft = "auto";

바디.appendChild(로또번호제목);
바디.appendChild(로또번호영역);
바디.appendChild(보너스번호제목);
바디.appendChild(보너스번호영역);

var 공만들기 = function (번호, 보너스체크) {
  var 로또번호 = document.createElement("div");
  로또번호.textContent = 번호;
  로또번호.style.width = "5em";
  로또번호.style.height = "5em";
  로또번호.style.lineHeight = "5em";
  로또번호.style.borderRadius = "50%";
  로또번호.style.fontSize = "15px";
  로또번호.style.textAlign = "center";

  if (번호 <= 10) {
    // 노랑
    로또번호.style.background = "#fff44f";
  } else if (번호 <= 20) {
    // 파랑
    로또번호.style.background = "#0088ff";
    로또번호.style.color = "white";
  } else if (번호 <= 30) {
    // 빨강
    로또번호.style.background = "#e40750";
    로또번호.style.color = "white";
  } else if (번호 <= 40) {
    // 검정인데 보라색함
    로또번호.style.background = "#8b00ff";
    로또번호.style.color = "white";
  } else if (번호 <= 45) {
    로또번호.style.background = "green";
    로또번호.style.color = "white";
  }

  if (보너스체크) {
    보너스번호영역.appendChild(로또번호);
  } else {
    로또번호.style.marginRight = "1.5em";
    로또번호영역.appendChild(로또번호);
  }
};

var 로또번호들 = new Array(6).fill(undefined).map((_, index) => {
  setTimeout(() => {
    공만들기(Math.ceil(Math.random() * 45), false);
  }, 1000 * index);
});

setTimeout(() => {
  공만들기(Math.ceil(Math.random() * 45), true);
}, 6000);
