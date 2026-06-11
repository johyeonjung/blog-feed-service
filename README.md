# Blog Feed Service

Spring Boot 기반의 블로그/피드 서비스입니다.

## 프로젝트 소개

사용자가 회원가입 후 게시글을 작성하고 댓글을 남길 수 있는 웹 서비스입니다.

JWT 인증 및 OAuth2 로그인을 지원하며, 게시글·댓글·이미지 업로드 기능을 제공합니다.

사용자 경험과 서비스 확장성을 고려하여 검색, 좋아요, 태그 기능을 지속적으로 개발하고 있습니다.

## 기술 스택

* Java 21
* Spring Boot
* Spring Security
* JWT
* OAuth2
* MyBatis
* MySQL
* Maven

## 주요 기능

### 회원 기능

* 회원가입
* 로그인
* JWT 인증
* OAuth2 로그인
*  비회원

### 게시글 기능

* 게시글 작성
* 게시글 조회
* 게시글 수정
* 게시글 삭제
* 이미지 업로드

### 댓글 기능

* 댓글 작성
* 대댓글 작성
* 댓글 조회

## 프로젝트 구조

src
├─ controller
├─ service
├─ mapper
├─ entity
├─ dto
├─ security
└─ config

## 개선 예정 기능

* 게시글 검색
* 페이징
* 좋아요 기능
* 태그 기능

