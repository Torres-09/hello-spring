# Spring Boot introduction<br>
### 해당 repository는 Spring Boot Study입니다.
***
- 프로젝트 환경설정
- 스프링 웹 개발 기초 ( 정적 컨텐츠, MVC와 템플릿 엔진, API )
  ![img_4.png](img_4.png)
  ![img_5.png](img_5.png)
  ![img_6.png](img_6.png)
  
  
- 회원 관리 예제 - 백 엔드 개발
  ![img_7.png](img_7.png)
    - 비즈니스 요구사항 정리
    - 회원 도메인과 리포지토리 만들기
    - 회원 리포지토리 테스트 케이스 작성
    - 회원 서비스 개발
    - 회원 서비스 테스트
- 스프링 빈과 의존관계
    - 컴포넌트 스캔과 자동 의존관계 설정
  ![img.png](img.png)
      ![img_1.png](img_1.png)
      ![img_2.png](img_2.png)
      ![img_3.png](img_3.png)
    - 자바 코드로 직접 스프링 빈 등록하기
      ![img_8.png](img_8.png)
      ![img_9.png](img_9.png)
- 회원 관리 예제 - 웹 MVC 개발
    - 홈 화면 추가
        - 컨트롤러가 정적 파일보다 우선순위가 높다. ( 같은 매핑을 사용할 경우 컨트롤러가 우선이다. )
    - 회원 웹 기능 - 등록
        - Post , Get 메소드, Form 태그
    - 회원 웹 기능 - 조회
      - Get method 이용하여 조회
- 스프링 DB 접근 기술
    - H2 데이터베이스 설치
        - MySQL을 보통 씀
    - 순수 JDBC
        - ![img_10.png](img_10.png)
        - OCP 개방 폐쇄 원칙 (Open-Closed Principle) : 확장에는 열려 있고, 수정, 변경에는 닫혀 있다.
        - 스프링의 DI를 사용하여 코드 수정을 하지 않고, 설정 만으로 구현 클래스를 변경 할 수 있다.
    - Spring 통합 테스트
        - ![img_11.png](img_11.png)
        - Spring 환경에서 테스트 하기 + DB에 영향을 주지 않는 테스트 ( 통합테스트 )
        - 스프링 컨테이너를 사용하지 않고 할 수 있는 단위 테스트 역시 중요하다.
    - Spring JdbcTemplate
        - 순수 JDBC 에서 JdbcTemplate 라이브러리 등을 사용하여 반복코드를 대부분 제거한다.
        - 그러나 SQL 은 여전히 직접 작성해야 한다. ( JPA 에서 이를 해결 가능 ) 
    - JPA
        - JPA 는 기본적인 SQL 을 만들어서 실행해준다.
        - JPA 기술은 SQL과 데이터 중심에서 객체 중심의 설계로 패러다임을 전환하는 기술이다.
        - JPA 기술은 개발 생산성을 크게 높일 수 있다.
        - ![img_12.png](img_12.png)
        - Spring config
            - ![img_13.png](img_13.png)
    - 스프링 데이터 JPA
        - 인터페이스 만으로 기본 CRUD 기능을 제공한다.
        - 스프링 데이터 JPA 는 JPA를 편리하게 사용할 수 있도록 도와주는 라이브러리
        - JPA와 스프링 데이터 JPA 를 기본으로 사용, 동적 쿼리는 Querydsl 라이브러리를 사용한다.
        - 이 조합으로 해결이 어려운 것은 JPA 에서 제공하는 네이티브 쿼리를 사용하거나 JdbcTemplate 사용하면 된다.
    - AOP ( 관점 지향 프로그래밍 )
        - 공통 관심 사항 ( cross-cutting concern )
        - 핵심 관심 사항 ( core concern )
        - 시간 측정과 같은 공통 관심 사항을 핵심 관심 사항과 분리하여 별도로 관리한다.
        - 프록시 기술을 이용해서 실제 객체가 아니라 가짜 객체를 먼저 수행하고 jointPoint.proceed()가 호출되면 실제 객체가 실행된다.
        - ![img_14.png](img_14.png)
        - 이와 같은 작업은 유지 보수에 매우 효과적이다.