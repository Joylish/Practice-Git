## 👽 문제
함수 makeUser는 객체를 반환합니다.

이 객체의 ref에 접근하면 어떤 결과가 발생하고, 그 이유는 뭘까요?

```javascript
function makeUser() {
  return {
    name: "John",
    ref: this
  };
};

let user = makeUser();

console.log( user.ref.name );
```

## ☺ 내가 생각한 답안
"John"

user는 makeUser 참조값을 갖는다. makeUser 객체는 함수로, 객체를 return한다. user.ref 는 반환된 객체를 가르킨다. user.ref.name 은 user.name과 동일하다. 따라서 John이 출력된다. 



