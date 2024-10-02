# FreeLoad : 휴게소 웹/앱 서비스 개발
<div align="center">
  <br>

  <br><br>
  
  ![logo](https://github.com/user-attachments/assets/617e17fc-f5cf-4b3f-a64e-9ee2eaa94a49)
</div>

## ⭐️ 앱 다운로드 링크
> [다운로드 링크](https://freeload-fe.vercel.app)
<br>

## 💡 프로젝트 주제

- **공공데이터를 활용한 서비스 개발**
- **고속도로 위 휴게소 정보 서비스**

<br>

## 🏗 아키텍처
> <img width="980" alt="스크린샷 2024-06-19 오후 4 33 01" src="https://github.com/user-attachments/assets/0aca24c6-5d64-49db-97c7-f292f2eaf435">


<br>

## 📝 프로젝트 개요

- [목적] 고속도로 이용자들에게 편리한 휴게소 정보를 제공하여 휴게소 사용을 더욱 즐겁고 편안하게 만들고자
- [배경] 공공데이터를 활용한 서비스 개발

<br>
<!--
## 📝 프로젝트 목표
- 가천대학교 학생 사이에서 지속적으로 사용되는 커뮤니티 앱 개발 (일 평균 10명 이상)
- 서버 운영 비용 최소화 (AWS 청구서 기준 월 3만원 이하)
- 사용자 초기 접근성 및 인지도 강화
--!>
<br>

## 🚀 프로젝트 인원 및 기간

- **개발 인원**: FE 1명 & BE 1명
- **프로젝트 기간**: 24.04.10 ~ 24.06.26

<br>

## ⭐️ 핵심 기능

### ❗️강조하고 싶은 기능!
- [휴게소 내 도로 뷰어] : 도로뷰어 api 사용
- [영수증 인증 후 리뷰 기능] : 네이버 clova api 사용하여 영수증 인증 후 해당 휴게소 리뷰 등록
- [근처 휴게소 푸시 기능] : 사용자 위치 기반 근처 휴게소 발견시 푸시알림

<br>

### 회원

> 카카오톡, 구글 간편 로그인 <br>
> 회원가입 시 리뷰 등록 가능. <br>

### 마이페이지

> 사용자 별 작성 리뷰에 대한 리스트를 확인할 수 있다.<br>
> 로그아웃 및 회원탈퇴를 할 수 있다. <br>
> 영수증 인증 한 구매내역 확인 가능 <br>

### 리뷰

> 작성한 리뷰 수정, 삭제 가능
<br>

## ⚙️ 프로젝트 세팅

> 1. 자바 버전 : 17
> 2. 스프링부트 버전 : 3.1.4
> 3. 빌드 & 빌드 도구 : Gradle
> 4. Git 브랜치 전략 : Feature Branch → Develop Branch → Stage Branch(검증) → Main Branch(배포)

<br>

## 🛠️ 기술 스택
#### Framework
![springboot](https://img.shields.io/badge/springboot-6DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![springsecurity](https://img.shields.io/badge/springsecurity-6DB33F.svg?style=for-the-badge&logo=springsecurity&logoColor=white)

#### DB
![mysql](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

#### Library
![JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Lombok](https://img.shields.io/badge/lombok-E50005.svg?style=for-the-badge&logo=lospec&logoColor=white)
![jwt](https://img.shields.io/badge/jwt-000000.svg?style=for-the-badge&logo=jsonwebtokens&logoColor=white)

#### Communication
![notion](https://img.shields.io/badge/notion-000000.svg?style=for-the-badge&logo=notion&logoColor=white)

#### Server
![ec2](https://img.shields.io/badge/AWS_EC2-FF9900.svg?style=for-the-badge&logo=amazonec2&logoColor=white)
![centOS](https://img.shields.io/badge/CENTOS-FF9810.svg?style=for-the-badge&logo=amazonec2&logoColor=white)

<br>

## 🧑‍🤝‍🧑 조원 & 역할

| 이름   | 역할                                                                                                         |
|------ |------------------------------------------------------------------------------------------------------------|
| 박주영  | erd 설계, DB관리, 공공api 수집 및 전처리, 카테고리 도메인 개발, restApi 연결, 피그마 와이어프레임 초안 작성, 서버와 DevOps 설정관리, 서비스 기획 |
| 신태일  | 길찾기 도메인 개발, 리뷰 도메인 개발, 카테고리 도메인 개발, 휴게소 정보 도메인 개발, 영수증 api, 서비스 기획|

<br>

## 📐 ERD 설계도

<img width="984" alt="image" src="https://github.com/user-attachments/assets/9ff30ca1-7ffd-40db-b006-eef25ac4961d">
