모델 2 / MVC 패턴

controlelr - View - Model

Servlet - Controller 역할
- 화면 구성은 거의 안함
- 브라우저의 요청을 처리함 
- 서비스(고객의 요구사항이 반영됨)를 통해서 필요한 데이터를 구성
- 뷰로 전달하는 역할 / 제어

JSP - view
- 출력용
- EL / JSTL
- 복잡한 로직은 적용하지 않는다

데이터 전달 / forward

데이터 전달
- 브라우저에서 서버로 데이터 전달
GET/POSt

- 서버 내부에서 데이터 전달
RequestDispatcher
setAttribute(이름, 값)

RequestDispatcher
: 전달자
: 서버 내부 메신저 역할 - forward(), include() 절대 쓸일 없지만 - 레이아웃 설계에 쓰임

JSP vs Servlet
- HTML 많고 JAVA 작으면 => JSP
- JAVA 많고 HTML 작으면 => Servlet
  ->  Servlet 많이 쓴다. 

(*) Context 
: 문맥, 영역
: 어떤 작업이 실행될 때 그 작업을 이해하거나 처리하기 위한 배경 정보

쓰레드(Thread)
: 하나의 프로그램 (프로세스) 안에서 동시에 여러 작업을 처리할 수 있도록 해주는 작은 실행 단위

JSTL
: 제어문 / 루프

setAttribute()
: 짐을 싣는다.

XSS 공격
: 크로스 사이트 스크립팅 (XSS)은 웹사이트에 악성 클라이언트 사이드 코드를 삽입하는 공격

<c:out >
: <c:out > 으로 감싸야 안전함
