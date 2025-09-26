-- 사용자 생성 및 권한 부여
Alter session set "_ORACLE_SCRIPT"=true;
create user sboard identified by 1234;
grant connect, resource, unlimited tablespace to sboard;
-- 회원 테이블
CREATE TABLE SB_USER (
  USID       VARCHAR2(20)   PRIMARY KEY,    -- 사용자 아이디, "ID"는 Oracle 예약어이기 때문에 접두어 US 추가
  PASS       VARCHAR2(100),                 -- 비밀번호
  US_NAME    VARCHAR2(20),                  -- 이름, "NAME"은 Oracle 예약어이기 때문에 접두어 US_ 추가
  NICK       VARCHAR2(20)   UNIQUE,         -- 별명, 고유키
  EMAIL      VARCHAR2(50)   UNIQUE,         -- 이메일, 고유키, 비번 분실시 이메일 인증
  HP         CHAR(13)       UNIQUE,         -- 휴대폰
  US_ROLE    VARCHAR2(20)   DEFAULT 'USER', -- 권한 : GUEST, USER, ADMIN 등, "ROLE"는 Oracle 예약어이기 때문에 접두어 US_ 추가
  ZIP        CHAR(5),                       -- 우편번호
  ADDR1      VARCHAR2(100),                 -- 기본 주소
  ADDR2      VARCHAR2(100),                 -- 상세 주소
  REG_IP      VARCHAR2(100),                -- 회원가입 IP 주소
  REG_DATE    TIMESTAMP,                    -- 회원 가입일
  LEAVE_DATE  TIMESTAMP                     -- 회원 탈퇴일
);
-- 약관 테이블
CREATE TABLE SB_TERMS (
  NO         NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,   -- 약관번호, ALWAYS IDENTITY(항상 자동 생성, 사용자 수동 입력 불가)
  TERMS      CLOB,                                              -- 약관 내용, 대용량 텍스트 자료형(Character Large Object, 최대 4G)
  PRIVACY    CLOB                                               -- 개인정보 취급방침 내용, 대용량 텍스트 자료형(Character Large Object, 최대 4G)
);
-- 게시글 테이블
CREATE TABLE SB_ARTICLE (
  ANO           NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,   -- 글 번호, ALWAYS IDENTITY(항상 자동 생성, 사용자 수동 입력 불가)
  CATE          VARCHAR2(20)    DEFAULT 'free',                    -- 게시판 종류 : free(자유게시판), notice(공지사항) 등
  TITLE         VARCHAR2(100)   NOT NULL,                          -- 글 제목
  CONTENT       CLOB            NOT NULL,                          -- 글 내용, 대용량 텍스트 자료형(Character Large Object, 최대 4G)
  COMMENT_CNT   NUMBER          DEFAULT 0,                         -- 댓글 갯수 집계
  FILE_CNT      NUMBER(1)       DEFAULT 0,                         -- 파일 첨부 갯수
  HIT_CNT       NUMBER          DEFAULT 0,                         -- 글 조회 수
  WRITER        VARCHAR2(20)    NOT NULL,                          -- 작성자 아이디
  REG_IP        VARCHAR2(100)   NOT NULL,                          -- 글 작성자 IP 주소
  WDATE         TIMESTAMP,                                         -- 글 작성일
  FOREIGN KEY (WRITER) REFERENCES SB_USER(USID)
);
-- 댓글 테이블
CREATE TABLE SB_COMMENT (
  CNO        NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,   -- 댓글 번호, ALWAYS IDENTITY(항상 자동 생성, 사용자 수동 입력 불가)
  ANO        NUMBER          NOT NULL,                          -- 부모 게시글 번호
  CONTENT    VARCHAR2(4000)  NOT NULL,                          -- 댓글 내용
  WRITER     VARCHAR2(20)    NOT NULL,                          -- 댓글 작성자
  REG_IP     VARCHAR2(100)   NOT NULL,                          -- 댓글 작성자 IP 주소
  WDATE      TIMESTAMP,                                         -- 댓글 작성일
  FOREIGN KEY (WRITER) REFERENCES SB_USER(USID),
  FOREIGN KEY (ANO) REFERENCES SB_ARTICLE(ANO)
);
-- 파일 테이블
CREATE TABLE SB_FILE (
  FNO        NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,   -- 파일 번호, ALWAYS IDENTITY(항상 자동 생성, 사용자 수동 입력 불가)
  ANO        NUMBER          NOT NULL,                          -- 파일이 첨부된 게시글 번호
  ONAME      VARCHAR2(100)   NOT NULL,                          -- 원본 파일명
  SNAME      VARCHAR2(100)   NOT NULL,                          -- 저장 파일명
  DOWNLOAD   NUMBER          DEFAULT 0,                         -- 다운로드 횟수
  RDATE      TIMESTAMP,                                         -- 파일 등록일
  FOREIGN KEY (ANO) REFERENCES SB_ARTICLE(ANO)
);
