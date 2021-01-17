(function start() {
  const opening = document.createElement("div");
  opening.textContent =
    "나는 원래 죽으려고 했다. 하지만 오늘 살기 위해 이곳을 나간다.";
  opening.classList.add("opening");
  setTimeout(function () {
    opening.style.transition = "opacity " + 5 + "s";
    opening.style.opacity = 0;
    opening.addEventListener("transitionend", function () {
      opening.style.display = "none";
      showTitle();
    });
  }, 5000);
  document.body.append(opening);
})();

function showTitle() {
  const title = document.createElement("img");
  title.src = "../public/images/logo.png";
  title.classList.add("fade-in");
  setTimeout(function () {
    // title.style.transition = "opacity " + 5 + "s";
    // title.style.opacity = 0;
    // title.addEventListener("transitionend", function () {
    //   title.style.display = "none";
    //   toHome();
    // });
    toHome();
  }, 5000);
  document.body.append(title);
}

function toHome() {
  window.location = "../home/index.html";
}
