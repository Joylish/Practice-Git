let calculator = {
  read: function () {
    this.num1 = parseInt(prompt("첫 번째 숫자를 입력해주세요 (범위: 0-100)"));
    this.num2 = parseInt(prompt("두 번째 숫자를 입력해주세요 (범위: 0-100)"));
  },
  sum: function () {
    return this.num1 + this.num2;
  },
  mul: function () {
    return this.num1 * this.num2;
  },
};

calculator.read();
// alert(calculator.sum());
// alert(calculator.mul());
