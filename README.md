# ERP-Project-
스프링 부트 ERP SYSTEM 프로젝트


## 🖥️ 프로젝트 소개
이카운트를 참고하여 제작된 소형 회사의 ERP 홈페이지 입니다.
<br>

## 🕰️ 개발 기간
* 24.01.02일 - 24.03.20일 (총 78일 WD 54일)

### 🧑‍🤝‍🧑 맴버구성
- 팀장 : 이상효 - 구매 파트(CRUD) 및 프론트
- 팀원 : 임호진 - 회계 파트(CRUD) 및 프론트
- 팀원 : 김영훈 - 생산 파트(CRUD) 및 프론트
- 팀원 : 김선진 - 재고 파트(CRUD) 및 프론트
- 팀원 : 임지환 - 판매 파트(CRUD) 및 프론트
- 팀원 : 박종현 - 인사 파트(CRUD) 및 프론트

### ⚙️ 개발 환경
- **Language** : Java jdk-17 
- **IDE** : IteliJ
- **Framework** : Springboot(3.x)
- **Database** : Mysql 
- **ORM** : JPA
- **MARKUP** : Html5 , Css , JavaScript

### 공지
- 우리 깃허브가 많이 아파요 화이팅입니다.

## Git-Flow 규칙
- origin (master를 이름 변경하여 백업하는 브랜치)

- master (개발 완료된 기능들을 버전으로 만들어 관리하는 브랜치)

- develop (각자의 작업 사항을 반영하는 개발 브랜치)

- feature/ **{기능명}** (각자의 작업을 보관하는 브랜치)

1. 내가 작업한 기능은 feature 브랜치에 계속 반영한다. 

2. 작업전 develop 기준으로 각자가 수정한 것들을 pull해서(땡겨서) 최신화 한다. 

3. merge 진행후 다른사람은 develop에서 pull 해서 변경 사항 최신화 하기

### 커밋 규칙

- Title: 날짜 {기능명} 작업명
- subject: 변경점 및 문제점 표기

### 머지 규칙

- 1명 이상의 코드 리뷰 후 머지 진행하기(오류 나면 항시 두명 이상에게 확인 후 작업 할것!!)


## 네이밍 규칙

**Class(클래스)**
- 파스칼 표기법을 사용한다.
- 명사로 시작한다.
- Ex) EmpEntity, EmpRepogitory 등

**Methods(메서드)**
- 카멜 표기법을 사용한다.
- 동사로 시작한다.
- Ex) setMyName, isMyName 등

**Variable(변수)**
- 소문자로 시작한다.
- 카멜 표기법을 사용한다.
- Ex) empEntity , empRepogitory 등

**FileName(파일명)**
- 클래스를 제외한 파일명은 소문자를 사용한다.
- 스네이크을 사용해 '_'로 구분한다.
- Ex) emp_list , emp_form 등

##  주요 기능

#### CRUD
-  작성, 읽기, 수정, 삭제(CRUD)

#### 순차적 데이터 삽입 
- 데이터 테이블 등록시 상관관계에 있는 데이터의 수정 및 보완

 