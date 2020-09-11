# `sort` 함수 커스터마이징

### 1. sort 함수 동작 방식

> 1. Array의 각 원소를 문자열로 만든다.
> 2. `UTF-16` 코드 유닛 값을 기준으로 순서를 정렬

따라서 Array의 원소가 **숫자**일 경우 sort함수를 이용해서 제대로 정렬하기 위해서 sort 함수 커스터마이징이 필요하다.



### 2. sort 함수 기본 문법

sort 함수는 콜백함수인 비교함수가 필요하다. 우리는 비교함수로 sort함수를 커스터마이징하는 것이다.

**`Array.sort([비교함수])`**



#### sort함수 에서 비교함수(Compare Function)

비교함수는 2개 인자 next, prev를 전달받는다. 

```javascript
(next, prev)=>{
...
}
```

기본적으로 비교함수 반환값에 따라 오름차순/ 내림차순이 정해진다.  

* 반환값 **-1**: 새로운 값 next가 기존 값 prev 앞에 온다. 

  **위치변경있음[ ... next, prev] **

* 반환값 **0**: 새로운 값 next와 기존 값 prev 순서를 변경하지 않는다.

* 반환값 **1**: 새로운 값 next가 기존 값 prev 후에 온다.

  **위치변경있음[ ... prev, next] **

next보다 prev가 크면 순서를 바꾼다. 오름차순 정렬

`(next, prev)=> next < prev? -1: (prev > next? 1 : 0)`



#### localeCompare 함수

> **referenceString**.localeCompare(**compareString**[, locales[, options]])

* referenceString이 compareString보다 앞에 있으면 -1 

* referenceString이 compareString이 같으면 0

* referenceString이 compareString보다 뒤에 있으면 1

```javascript
'a'.localeCompare('b') // -1 , 
'b'.localeCompare('a') // 1
'c'.localeCompare('c') // 0
```

