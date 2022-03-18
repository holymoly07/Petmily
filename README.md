# Petmily
# 팀원
* 조장(윤세종)
* 팀원(김진하)
* 팀원(송욱진)
* 팀원(이산하)
* 팀원(원선영)
* 팀원(차현)
<br><br>
# 역할
### 윤세종<br> 
  ### Product Page
  - 전체적인 JSP 구성 설계 및 구현<br> 
  - Product 전체상품 조회 페이징 처리<br>
  - Product 특정상품 조회<br> 
  - Product 특정상품 댓글 CRUD 페이징 처리<br>
  - Product 특정상품별 아임포트 Api를 이용한 결제 기능<br> 
  ### Login,Join Page
  - 회원가입,로그인 JSP 구성 및 기능 구현<br> 
  - 다음 우편번호 Api를 사용하여 회원가입시 주소 처리<br> 
  - 회원가입시 JavaMailSender를 이용한 회원가입 WelComeMail기능 구현<br><br>

### 김진하<br> 
  ### Admin Page
 - JSP 디자인<br>
 - Admin Page 검색, 페이징 처리<br>
 - 회원가입 User 관리<br>
 - 상품 등록 및 수정/삭제 관리 (CRUD)<br>
 - 결제된 상품 재고 리스트 관리<br>
 - 주문 처리 된 상품에 대한 관리<br>
 - 정기배송 주문상품에 대한 배송처리 관리<br>
 - 구독권 결제 / 재고 처리<br>
 - 마이페이지 구독 탈퇴 기능 구현<br><br>

### 송욱진<br> 
  ### Admin Page
 - JSP 디자인<br>
 - Admin Page 검색, 페이징 처리<br>
 - 회원가입 User 관리<br>
 - 상품 등록 및 수정/삭제 관리 (CRUD)<br>
 - 결제된 상품 재고 리스트 관리<br>
 - 주문 처리 된 상품에 대한 관리<br>
 - 정기배송 주문상품에 대한 배송처리 관리<br>
 - 구독권 결제 / 재고 처리<br>
 - 마이페이지 구독 탈퇴 기능 구현<br><br>

### 이산하<br> 
  ### Cart Page
 - JSP 디자인<br>
 - 장바구니에 담기 및 상품 조회<br>
 - 상품 수량 변경/삭제 및 총 금액 변경<br>
  ### Cart payment Page
 - JSP 디자인<br>
 - 결제할 상품 목록 조회 및 삭제 기능<br>
 - 주문자 정보 조회<br>
 - API를 활용한 결제 기능<br>
 - 결제 완료 시 장바구니 비우기<br><br>

### 원선영<br> 
  ### MyPage
 - MyPage JSP 디자인<br>
 - 나의 정보 조회, 나의 정보 수정 업데이트 처리<br>
 - 주문 내역 정보 조회, 주문 내역 페이징 처리<br>
 - 구독 내역 정보 조회<br>
 - 배송지 관리 부분 배송지 정보 조회<br>
 - 배송지 수정 업데이트 처리<br>
  ### Front(index,구독권)
 - Index 내의 이미지, 내용 수정<br>
 - 구독권 이미지 수정<br><br>

### 차현<br> 
  ### MyPage
 - MyPage JSP 디자인<br>
 - 나의 정보 조회, 나의 정보 수정 업데이트 처리<br>
 - 주문 내역 정보 조회, 주문 내역 페이징 처리<br>
 - 구독 내역 정보 조회<br>
 - 배송지 관리 부분 배송지 정보 조회<br>
 - 배송지 수정 업데이트 처리<br>
  ### 기타
 - Cart 아임포트 API를 이용한 결제시스템 구현<br>
 - 메인페이지 인기상품 TOP3 보여주기(조회수 기준)<br>
 - 스토어 단품 조회수 상승 구현<br><br>
<br><br>
# 기술스택
- Spring
- JSP
- MySQL
- Apache Tomcat
- Daum Address API
- I'mport
<br><br>
# 구현범위 (사용자)
 ### 회원
 - 회원 가입<br>
 - 로그인<br>
 - 회원 정보 조회( 주문내역, 구독내역/구독탈퇴, 배송지 )<br><br>
 ### 스토어
 - 전체 상품 조회<br>
 - 상세 상품 조회<br>
 - 리뷰<br>
 - 결제( 수량, 금액 )<br><br>
 ### 구독권
 - 구독권 조회<br>
 - 구독권 결제<br>
 ### 장바구니
 - 상품 담기<br>
 - 담은 상품 조회<br>
 - 수량 변경 및 삭제에 따른 총금액 변경<br><br>
  ### 결제
 - 주문 할 상품 조회<br>
 - 주문자 정보 조회<br>
 - 결제<br><br>
# 구현범위 (관리자)
 ### 회원 관리
 - 전체 회원 정보 조회<br><br>
 ### 구독 회원 관리
 - 구독중인 회원 정보 조회<br>
 - 구독권 배송 처리 <br><br>
 ### 단품 상품 등록 관리
 - 단품 상품 조회, 단품 상품 등록 및 삭제<br><br>
 ### 상품 재고 관리
 - 결제 후 상품 재고 관리<br>
 - 재고 추가<br><br>
 ### 상품 주문 관리
 - 단품 품목에 대한 전체 주문 내역 관리<br>
 - 상품 배송 처리<br><br>
 ### 배송조회(단품/구독)
 - 배송 처리된 내역 조회<br><br>
# DB설계
```
CREATE TABLE `product`
(
    `prod_num`           int          NOT NULL,
    `prod_img`           varchar(255) NULL,
    `prod_title`         varchar(30)  NULL,
    `prod_category`      varchar(10)  NULL,
    `prod_name`          varchar(50)  NULL,
    `prod_price`         int          NULL,
    `prod_solo`          int          NULL,
    `prod_silver`        int          NULL,
    `prod_gold`          int          NULL,
    `prod_create_date`   datetime     NULL,
    `prod_update_date`   datetime     NULL,
    `prod_modified_date` datetime     NULL,
    `prod_view_cnt`      int          NULL,
    `prod_content`       varchar(255) NULL,
    `prod_allamount`     int          NULL,
    `remain_amount`      int          NULL,
    `prod_amount`        int          NULL
);

CREATE TABLE `Membership`
(
    `user_id`          varchar(15) NULL,
    `mem_grade`        varchar(20) NULL,
    `mem_start_date`   datetime    NULL,
    `mem_restart_date` datetime    NULL,
    `mem_next_date`    datetime    NULL,
    `mem_last_date`    datetime    NULL
);

CREATE TABLE `review`
(
    `review_num`           int          NOT NULL,
    `prod_num`             int          NOT NULL,
    `review_content`       varchar(255) NULL,
    `review_rate`          varchar(10)  NULL,
    `review_create_date`   datetime     NULL,
    `review_modified_date` datetime     NULL,
    `review_title`         varchar(15)  NOT NULL
);

CREATE TABLE `user`
(
    `user_id`         varchar(15)  NULL,
    `user_pwd`        varchar(20)  NULL,
    `user_name`       varchar(15)  NULL,
    `user_nickname`   varchar(20)  NULL,
    `user_email`      varchar(30)  NULL,
    `user_address1`   varchar(100) NULL,
    `user_address2`   varchar(100) NULL,
    `user_zipcode`    varchar(15)  NULL,
    `user_totaddress` varchar(200) NULL,
    `user_phone`      varchar(20)  NULL,
    `user_type`       varchar(10)  NULL
);

CREATE TABLE `Order`
(
    `Order_num`    int         NOT NULL,
    `user_id`      varchar(15) NULL,
    `prod_num`     int         NOT NULL,
    `Order_status` varchar(20) NULL,
    `Order_count`  int         NULL,
    `Order_date`   datetime    NULL
);

CREATE TABLE `Cart`
(
    `Cart_amount` int         NOT NULL COMMENT '' df '',
    `user_id`     varchar(15) NULL,
    `prod_num`    int         NOT NULL,
    `cart_num`    int         NULL
);

ALTER TABLE `product`
    ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
                                             `prod_num`
        );

ALTER TABLE `review`
    ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
                                            `review_num`
        );

ALTER TABLE `user`
    ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                          `user_id`
        );

ALTER TABLE `Order`
    ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
                                           `Order_num`
        );

ALTER TABLE `Cart`
    ADD CONSTRAINT `PK_CART` PRIMARY KEY (
                                          `Cart_amount`
        );


```
<br><br>
# 사이트 시연 영상(사용자)
[![Video Label](https://user-images.githubusercontent.com/89058176/158616270-fe89b217-90d9-4b82-85e7-5e50081a7aca.jpg)](https://www.youtube.com/watch?v=teV65V_MJAk)
### 사진을 누르시면 유튜브로 이동됩니다.
