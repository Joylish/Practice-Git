// test
describe("1) pow", function () {
  it("주어진 숫자의 n 제곱", function () {
    assert.equal(pow(2, 3), 8);
    assert.equal(pow(3, 4), 81);
  });
});
describe("2) pow", function () {
  it("2를 세 번 곱하면 8입니다.", function () {
    assert.equal(pow(2, 3), 8);
  });

  it("3을 네 번 곱하면 81입니다.", function () {
    assert.equal(pow(3, 4), 81);
  });
});

describe("3-1) pow", function () {
  function makeTest(x) {
    let expected = x * x * x;
    it(`${x}을/를 세 번 곱하면 ${expected}입니다.`, function () {
      assert.equal(pow(x, 3), expected);
    });
  }

  for (let x = 1; x <= 5; x++) {
    makeTest(x);
  }
});

describe("3-2) pow-중첩describe", function () {
  describe("x를 세 번 곱합니다.", function () {
    function makeTest(x) {
      let expected = x * x * x;
      it(`${x}을/를 세 번 곱하면 ${expected}입니다.`, function () {
        assert.equal(pow(x, 3), expected);
      });
    }

    for (let x = 1; x <= 5; x++) {
      makeTest(x);
    }
  });
});

// describe("4) before/after와 beforeEach/afterEach", function () {
//   this.timeout(200000);

//   before(() => alert("테스트를 시작합니다 - 테스트가 시작되기 전"));
//   after(() => alert("테스트를 종료합니다 - 테스트가 종료된 후"));

//   beforeEach(() => alert("단일 테스트를 시작합니다 - 각 테스트 시작 전"));
//   afterEach(() => alert("단일 테스트를 종료합니다 - 각 테스트 종료 후"));

//   it("test 1", () => alert("test 1"));
//   it("test 2", () => alert("test 2"));
// });

describe("5) task 과제: 잘못된 점 찾기", function () {
  it("5를 1 제곱하면 5", function () {
    assert.equal(pow(5, 1), 5);
  });

  it("5를 2 제곱하면 25", function () {
    assert.equal(pow(5, 2), 25);
  });

  it("5를 3 제곱하면 125", function () {
    assert.equal(pow(5, 3), 125);
  });
});
