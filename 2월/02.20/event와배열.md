배열 - Application
: let arr = [item1, item2 ...];

- push(...items) : items를 배열 끝에 더해줌
- pop( ) : 배열 끝 요소를 제거하고, 제거한 요소를 반환
- shift( ) : 배열 처음 요소를 제거하고, 제거한 요소를 반환
- unshift(...items) : items를 배열 처음에 더해줌

배열의 생성 및 조작
배열 메서드 (push, pop, shift, unshift, forEach, map, filter, reduce 등)
생성 - [ ]
추가 - push, 전개 연산자 (...)
조작 - splice( ) 1-offset, 2-삭제 몇개 0, 3-추가
다차원 배열

JavaScript의 이벤트
: 무언가 일어났다는 신호

- click

stopPropagation( ) : 이벤트 전파 방지
privenDefault( ) : 기본 동작 막기 - a, form

버블링, 캡처링 - 이벤트 전파방식
버블링 : 연못에 돌 던지기
캡처링 : 국경선 통과

이벤트 리스너(핸들러) 함수 - 첫번째 파라미터는 무조건 event다

다만 JS의 함수는 오버

이벤트 위임 (delegation) 
: 이벤트 리스너 등록 대상, 실제 이벤트의 처리 대상이 다름 
: 중복적인 이벤트 등록을 줄이기도 하고, 안전하게 이벤트 추가하기 위해서 사용