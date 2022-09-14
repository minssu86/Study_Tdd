# TDD

## 참고자료

- [https://www.youtube.com/watch?v=tlekdB8lAlA&list=PLwouWTPuIjUj_QqgXlFsqjUwyC0-5dZ_q&index=2](https://www.youtube.com/watch?v=tlekdB8lAlA&list=PLwouWTPuIjUj_QqgXlFsqjUwyC0-5dZ_q&index=2)
- [https://00h0.tistory.com/20](https://00h0.tistory.com/20) assertJ 사용법 정리
- [https://velog.io/@new_wisdom/assertJ-공식문서와-함께하는-assertJ-정리](https://velog.io/@new_wisdom/assertJ-%EA%B3%B5%EC%8B%9D%EB%AC%B8%EC%84%9C%EC%99%80-%ED%95%A8%EA%BB%98%ED%95%98%EB%8A%94-assertJ-%EC%A0%95%EB%A6%AC)

## 테스트 주도 개발 (Test-Driven Development)

- 테스트로부터 시작하는 개발 방식
    1. (실패하는) 테스트 코드 작성
    2. 테스트를 통과시킬 만큼 구현
    3. 코드 정리(리팩토링)
    
    ![image](https://user-images.githubusercontent.com/87007109/190071386-7c512eb6-c526-4340-b857-29b060f783c4.png)
    

- 테스트 코드작성 순서
    - 쉬움 / 예외 → 어려움 / 정상
    - ex
        - null 입력, 빈 값 입력 → 예외적인 것(정상이 아닌 것)
        - 모두 충족하는 경우 → 쉬움
        - 셋 중 둘을 충족하는 경우 → 그 다음 쉬움
        - …
        - 모두 충족하지 않는 경우
- 완급 조절
    - TDD로 통과시키는 과정
        - 정해진 값을 리턴
        - 값 비교를 이용해서 정해진 값을 리턴
        - (다양한 테스트를 추가하면서) 구현을 일반화
    - 구현이 생각나면 빠르게 구현
        - 단 테스트를 통과시킬 만큼만!
        - 앞서 가지 말 것!
    - 구현이 막히면 다시 뒤로 돌아와서 천천히 진행
- 기능 설계
    - 기능의 구성 : 입력, 결과
        - ex : 로그인 기능
            - 입력 : 아이디, 암호
            - 결과 : (리턴) 일치하면 true, 일치하지 않으면 false
        - ex : 회원 가입
            - 입력 : 아이디, 암호, 이름
            - 결과 : (리턴) 회원 일련 번호, 회원 정보 DB에 저장
    - 기능 명세 → 설계로 연결
        - 이름, 파라미터, 리턴 타입 등 결정
    - TDD는 설계를 지원
    
    ![image](https://user-images.githubusercontent.com/87007109/190071460-e57b5a18-e0f0-49fd-8e74-55a4512997c4.png)
    

## F.I.R.S.T 원칙

단위 테스트 코드를 작성할 때 주의해야 하는 원칙은 5가지 이다.

- F : Fast -> 테스트 코드는 빨리 진행이 되어야 한다.
- I : Independent -> 독립적으로 실행이 가능해야 한다.
- R : Repeatable -> 반복이 가능해야 한다.
- S : Self Validating -> 테스트 코드만 실행해도 성공여부를 확인할 수 있어야 한다.
- T : Timely -> 바로 사용이 가능해야 한다.

## 테스트 구조

- 특정 상황에서 테스트 대상을 실행하면 예상된 결과가 나와야 한다.
    - 특정 상황 : Given / Arrange
    - 테스트 대상을 실행 : When / Act
    - 예상된 결과 : Then / Assert

## 의존과 대역

- 대역(double) - 실제 구현을 대신
- 테스트 대상이 실제 의존 대신에 대역을 사용하게 함
- 대역 종류
    - 스텁(stub) : 구현을 최대한 다순한 것으로 대체
    - 스파이(spy) : 호출된 내역을 기록
    - 모의(mock) 객체 : 기대한대로 상호작용하는지 행위를 검증
        - 보통 모의 객체는 스텁과 스파이 가능
    - 가짜(fake) : 기능을 구현해서 진짜와 유사하게 동작(경량 버전)
- 대역 이점
    - 의존 대상의 실제 구현 없이 테스트 가능
        - 현재 구현 대상에 집중, 병해 개발 가능
        - 의존 대상에 대한 상황 지정 가능
        - 개발 속도 향상

## TDD 실습 하기

### 예제

1. 과제 개요
    - 게시판 API
2. 필수 사용 스택
    - JAVA(Spring 또는 **Spring Boot**)
    - MySQL(**jpa** 또는 MyBatis)
3. 과제 상세 설명
    - 게시글 생성 API
4. 스키마에 정의된 필드들을 입력받아 생성한다.
5. 과제상에 파일 업로드 API는 없음으로 게시글 생성 시 목업 파일을 3개 씩 같이 생성한다. ( location 필드는 가짜 데이터를 넣어도 무방 )
    - 게시글 목록 API
        1. 아래 정보들을 응답값으로 보낸다.
            1. 게시판 이름(board.name)
            2. 게시글 제목(title)
            3. 생성 날짜(created_datetime)
            4. 게시글 생성시 업로드된 첨부파일 중 가장 처음 업로드된 파일의 경로(location)
        2. 생성 날짜를 기준으로 게시글을 가져올 수 있는 Get Query 구현
            1. 쿼리 이름
                1. 시작날짜 : startDateTime
                2. 끝 날짜 : endDateTime
            2. 게시판 이름으로 게시글을 가져올 수 있는 Get Query 구현
                1. 쿼리 이름
                    1. boardName
                2. 유의사항
                    1. 게시판명의 일부분으로도 검색이 가능해야 한다.
    - 게시글 상세 API
        1. 아래 정보들을 응답값으로 보낸다.
            1. 게시판 이름
            2. 게시글 제목
            3. 생성 날짜
            4. 게시글 생성시 업로드된 모든 첨부파일의 경로
    - 게시글 삭제 API
    - 게시글 수정 API
        1. 게시글 제목, 게시글 내용만 수정이 가능하다.
        2. 똑같은 내용을 수정요청할 시 해당 요청은 무시되어야 한다.
6. ERD
    
    ![image](https://user-images.githubusercontent.com/87007109/190071546-3e85d8ea-9307-46b0-988e-e0ea2d445c23.png)
