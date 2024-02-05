use sixbeam_erp;


INSERT INTO `hr_empinfo_tb` VALUES ('1990-01-01','2024-02-01','2024-02-01',_binary '',0,NULL,NULL,NULL,'123-456-0000','Address 0','Bank 0','employee0@example.com',NULL,'20241000','임호진','123-456-0000','0',NULL),('1991-01-01','2024-02-01','2024-03-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0001','Address 1','Bank 1','employee1@example.com',NULL,'20241001','이상효','123-456-0001','1',NULL),('1992-01-01','2024-02-01','2024-04-01',_binary '',0,NULL,NULL,NULL,'123-456-0002','Address 2','Bank 2','employee2@example.com',NULL,'20241002','김선진','123-456-0002','2',NULL),('1993-01-01','2024-02-01','2024-05-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0003','Address 3','Bank 3','employee3@example.com',NULL,'20241003','임지환','123-456-0003','3',NULL),('1994-01-01','2024-02-01','2024-06-01',_binary '',0,NULL,NULL,NULL,'123-456-0004','Address 4','Bank 4','employee4@example.com',NULL,'20241004','김영훈','123-456-0004','4',NULL),('1995-01-01','2024-02-01','2024-07-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0005','Address 5','Bank 5','employee5@example.com',NULL,'20241005','박종현','123-456-0005','5',NULL),('1996-01-01','2024-02-01','2024-08-01',_binary '',0,NULL,NULL,NULL,'123-456-0006','Address 6','Bank 6','employee6@example.com',NULL,'20241006','박주성','123-456-0006','6',NULL),('1997-01-01','2024-02-01','2024-09-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0007','Address 7','Bank 7','employee7@example.com',NULL,'20241007','문성빈','123-456-0007','7',NULL),('1998-01-01','2024-02-01','2024-10-01',_binary '',0,NULL,NULL,NULL,'123-456-0008','Address 8','Bank 8','employee8@example.com',NULL,'20241008','천준호','123-456-0008','8',NULL),('1999-01-01','2024-02-01','2024-11-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0009','Address 9','Bank 9','employee9@example.com',NULL,'20241009','서준하','123-456-0009','9',NULL);

INSERT INTO `ac_account_tb` VALUES ('673-7705371755','서울시 노원구','신한은행','CPN0764320143',NULL,'0764320143','마이크로소프트','이상효','빌게이츠','IT'),('685-0473786985','서울시 광진구','카카오뱅크','CPN0831580507',NULL,'0831580507','롯데','임지환','신격호','유통'),('783-6930006568','경기도 성남시','하나은행','CPN0896202274',NULL,'0896202274','소니','김선진','모리타아키오','제조'),('540-9279534862','서울시 성북구','국민은행','CPN1029807529',NULL,'1029807529','SM엔터','이상효','이수만','엔터테인먼트'),('226-6876859474','서울시 성동구','국민은행','CPN1173291319',NULL,'1173291319','하이브','임지환','방시혁','엔터테인먼트'),('033-4551844212','서울시 구로구','하나은행','CPN1203760813',NULL,'1203760813','NAVER','임호진','이해진','IT'),('074-3127136659','경기도 김포시','하나은행','CPN1856927584',NULL,'1856927584','금호아시아나','김선진','박인천','항공'),('888-9898204726','서울시 송파구','농협은행','CPN2266939105',NULL,'2266939105','현대중공업','임지환','정주영','제조'),('483-1484534403','서울시 영등포구','하나은행','CPN3058270672',NULL,'3058270672','POSCO','임호진','박태준','제조'),('098-7663007851','서울시 강서구','신한은행','CPN3184469866',NULL,'3184469866','카카오','임호진','김범수','IT'),('553-3530031122','서울시 용산구','신한은행','CPN4244014868',NULL,'4244014868','GS','박종현','허만정','유통'),('821-8168143276','서울시 강동구','우리은행','CPN4282222263',NULL,'4282222263','삼성전자','임지환','이건희','제조'),('703-1720820252','서울시 마포구','하나은행','CPN4308575449',NULL,'4308575449','한국화약','박종현','김종희','제약'),('919-6316264851','서울시 서초구','하나은행','CPN5221945160',NULL,'5221945160','KT','김영훈','김영섭','통신'),('067-6986366840','서울시 동대문구','카카오뱅크','CPN5277628939',NULL,'5277628939','어도어','임지환','민희진','엔터테인먼트'),('656-8255128990','서울시 도봉구','농협은행','CPN5431051314',NULL,'5431051314','APPLE','이상효','스티브잡스','IT'),('145-3669839433','서울시 관악구','국민은행','CPN5593852744',NULL,'5593852744','SKT','김영훈','유영상','통신'),('517-5649280480','서울시 강남구','우리은행','CPN5836847354',NULL,'5836847354','기아차','김영훈','김철호','제조'),('951-3479499431','서울시 중구','우리은행','CPN6234714473',NULL,'6234714473','두산','박종현','박승직','건설'),('081-7901698385','서울시 중랑구','신한은행','CPN6287772501',NULL,'6287772501','YG엔터','이상효','양현석','엔터테인먼트'),('973-4812556890','서울시 종로구','카카오뱅크','CPN6357090862',NULL,'6357090862','CJ','박종현','이병철','유통'),('025-9153541675','경기도 하남시','농협은행','CPN6543637212',NULL,'6543637212','구글','김선진','세르게이브린','IT'),('098-4649694312','서울시 강북구','신한은행','CPN6814402423',NULL,'6814402423','아마존','이상효','제프베이조스','유통'),('249-8986691231','서울시 서대문구','하나은행','CPN7422636804',NULL,'7422636804','신세계','박종현','이명희','유통'),('012-0516866831','서울시 금천구','농협은행','CPN7551487293',NULL,'7551487293','NCsoft','김영훈','김택진','IT'),('310-4668131524','경기도 용인시','우리은행','CPN8641151763',NULL,'8641151763','대한통운','김선진','강신호','유통'),('112-7155262063','서울시 은평구','국민은행','CPN8766713365',NULL,'8766713365','당근','임호진','김용현','유통'),('642-0290265811','경기도 수원시 ','우리은행','CPN8832918761',NULL,'8832918761','대한항공','김선진','조중훈','항공'),('151-3927322602','서울시 양천구','농협은행','CPN8956377612',NULL,'8956377612','DAUM','임호진','이재웅','IT'),('859-4026701001','서울시 동작구','신한은행','CPN9769359992',NULL,'9769359992','LGU','김영훈','황현식','통신');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (800000, 'F1001', 'ASSEMBLE-PC', 'PC-DESKTOP');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (850000, 'F1002', 'ASSEMBLE-PC', 'PC-DESKTOP');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (500000, 'F1003', 'ASSEMBLE-PC', 'PC-DESKTOP');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (1000000, 'F1004', 'ASSEMBLE-PC', 'PC-DESKTOP');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (1500000, 'F1005', 'ASSEMBLE-PC', 'PC-DESKTOP');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (410000, 'R1001', 'INTEL-CPU', 'CPU-I5-13600K');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (510000, 'R1002', 'AMD-CPU', 'CPU-R7-G5');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (55000, 'R1003', 'SAMSUNG-RAM', 'RAM-DDR5-16GB');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (29000, 'R1004', 'SKHYNIX-RAM', 'RAM-DDR4-8GB');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (98000, 'R1005', 'ASUS-MAINBOARD', 'MAINBOARD-H610M');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (170000, 'R1006', 'ASROCK-MAINBOARD', 'MAINBOARD-B760M');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (269000, 'R1007', 'GIGABYTE-MAINBOARD', 'MAINBOARD-B650M');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (403000, 'R1008', 'ASUS-VGA', 'VGA-RTX4060');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (791000, 'R1009', 'ZOTAC-VGA', 'VGA-RTX4070');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (538000, 'R1010', 'EMTEK-VGA', 'VGA-RTX4060TI');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (128000, 'R1011', 'SKHYNIX-SSD', 'SSD-1TB');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (115000, 'R1012', 'WESTERNDIGITAL-HDD', 'HDD-4TB');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (68000, 'R1013', 'SAMSUNG-SSD', 'SSD-512GB');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (98000, 'R1014', 'DARKFLASH-CASE', 'CASE-ITX');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (45000, 'R1015', 'BRAVOTEC-CASE', 'CASE-MATX');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (126000, 'R1016', 'SEASONIC-POWER', 'POWER-750W');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (54500, 'R1017', 'MICRONICS-POWER', 'POWER-500W');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (77500, 'R1018', 'LOGITECH-KEYBOARD', 'KEYBOARD-T');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (189000, 'R1019', 'HANSUNG-KEYBOARD', 'KEYBOARD-TL');
INSERT INTO sixbeam_erp.pd_item_tb (item_up, item_cd, item_nm, item_stnd) VALUES (72900, 'R1020', 'RAZER-MOUSE', 'MOUSE-WL');

SET SQL_SAFE_UPDATES = 0;
UPDATE sixbeam_erp.SS_ESTIMATE_TB
SET
    ESTIMATE_SP = ESTIMATE_AMT * ESTIMATE_UP,
    ESTIMATE_VAT = ESTIMATE_SP / 10,
    ESTIMATE_TAMT = ESTIMATE_SP + ESTIMATE_VAT;
SET SQL_SAFE_UPDATES = 1;

INSERT INTO sixbeam_erp.SS_ESTIMATE_TB (
estimate_cd,
empinfo_id,
account_cd,
item_cd,
check_dt,
ESTIMATE_DT,
ESTIMATE_NM,
ESTIMATE_AMT,
ESTIMATE_UP,
ESTIMATE_ETC)
VALUES
('ES2024-02-02-101',20241001,'CPN9769359992','F1001',null,'20240131', '김철수', 5, 800000, '더미 텍스트'),
('ES2024-02-02-102',20241005,'CPN8956377612','F1002',null,'20240201', '이영희', 8, 850000,  '더미 텍스트'),
('ES2024-02-02-103',20241007,'CPN8832918761','F1003',null,'20240215', '박민준', 3, 500000,  '더미 텍스트'),
('ES2024-02-02-104',20241001,'CPN8766713365','F1004',null,'20240302', '정지수', 10, 1000000,  '더미 텍스트'),
('ES2024-02-02-105',20241005,'CPN8641151763','F1005',null,'20240320','최영호', 7, 1500000,  '더미 텍스트'),
('ES2024-02-02-106',20241007,'CPN7551487293','R1001',null,'20240812', '김하늘', 6, 410000,  '더미 텍스트'),
('ES2024-02-02-107',20241001,'CPN7422636804','R1002',null,'20240825', '이태양', 9, 510000, '더미 텍스트'),
('ES2024-02-02-108',20241005,'CPN6814402423','R1003',null,'20240903', '박소은', 4, 55000,  '더미 텍스트'),
('ES2024-02-02-109',20241007,'CPN6543637212','R1004',null,'20240918', '정우진', 12, 29000,  '더미 텍스트'),
('ES2024-02-02-110',20241001,'CPN6357090862','R1005',null,'20240930', '최민서', 8, 98000,  '더미 텍스트'),
('ES2024-02-02-111',20241005,'CPN6287772501','R1006',null,'20240930', '아저씨', 10, 170000, '더미 텍스트'),
('ES2024-02-02-112',20241007, 'CPN6234714473', 'R1007', null, '20241001', '홍길동', 15, 269000,  '더미 텍스트'),
('ES2024-02-02-113',20241001, 'CPN5836847354', 'R1008', null, '20241015', '이순신', 20, 403000,  '더미 텍스트'),
('ES2024-02-02-114',20241005, 'CPN5593852744', 'R1009', null, '20241101', '김영희', 12, 791000,  '더미 텍스트'),
('ES2024-02-02-115',20241007, 'CPN5431051314', 'R1010', null, '20241115', '이철수', 18, 538000,  '더미 텍스트'),
('ES2024-02-02-116',20241001, 'CPN5277628939', 'R1011', null, '20241201', '박민준', 10, 128000,  '더미 텍스트'),
('ES2024-02-02-117',20241005, 'CPN5221945160', 'R1012', null, '20241215', '정우진', 15, 115000,  '더미 텍스트'),
('ES2024-02-02-118',20241007, 'CPN4308575449', 'R1013', null, '20250101', '김하늘', 8, 68000,  '더미 텍스트'),
('ES2024-02-02-119',20241001, 'CPN4282222263', 'R1014', null, '20250115', '이태양', 25, 98000,  '더미 텍스트'),
('ES2024-02-02-120',20241005, 'CPN4244014868', 'R1014', null, '20250201', '박소은', 14, 98000, '더미 텍스트'),
('ES2024-02-02-121',20241007, 'CPN3184469866', 'R1015', null, '20250215', '최영호', 20, 45000, '더미 텍스트'),
('ES2024-02-02-122',20241001, 'CPN3058270672', 'R1016', null, '20250301', '홍길순', 10, 126000,  '더미 텍스트'),
('ES2024-02-02-123',20241005, 'CPN2266939105', 'R1017', null, '20250315', '김철수', 12, 54500,  '더미 텍스트'),
('ES2024-02-02-124',20241007, 'CPN1856927584', 'R1018', null, '20250825', '송중기', 19, 77500, '더미 텍스트'),
('ES2024-02-02-125',20241001, 'CPN1203760813', 'R1019', null, '20250910', '한예슬', 14, 189000,  '더미 텍스트'),
('ES2024-02-02-126',20241005, 'CPN1173291319', 'R1020', null, '20250925', '송혜교', 16, 72900,  '더미 텍스트'),
('ES2024-02-02-127',20241007, 'CPN1029807529', 'R1020', null, '20251010', '이민호', 10, 72900,  '더미 텍스트'),
('ES2024-02-02-128',20241001, 'CPN0896202274', 'R1020', null, '20251025', '손예진', 22, 72900,  '더미 텍스트'),
('ES2024-02-02-129',20241005, 'CPN0831580507', 'R1020', null, '20251110', '조정석', 16, 72900,  '더미 텍스트'),
('ES2024-02-02-130',20241007, 'CPN0764320143', 'R1020', null, '20251125', '한가인', 20, 72900,  '더미 텍스트'),
('ES2024-02-02-131',20241001, 'CPN0764320143', 'R1020', null, '20251210', '김소현', 14, 72900,  '더미 텍스트'),
('ES2024-02-02-132',20241005, 'CPN0764320143', 'R1020', null, '20251225', '서현진', 18, 72900,  '더미 텍스트'),
('ES2024-02-02-133',20241007, 'CPN0764320143', 'R1020', null, '20260110', '이동욱', 15, 72900,  '더미 텍스트');

INSERT INTO sixbeam_erp.SS_SALE_TB (
    SALE_UPLOAD_DT,
    SALE_BILLING_DT,
    SALE_BILLING_ST,
    SALE_PAYMENT_DT,
    SALE_SHIPPING_ST,
    SALE_SHIPPING_DT,
    SALE_CD,
    ESTIMATE_CD,
    release_cd
)
VALUES
('20240131', '20240131', false, null, '판매대기중', '20240131', 'SS2024-02-02-101', 'ES2024-02-02-101', null),
('20240201', '20240201', false, null, '판매대기중', '20240201', 'SS2024-02-02-102', 'ES2024-02-02-102',null),
('20240215', '20240215', false, null, '판매대기중', '20240215', 'SS2024-02-02-103', 'ES2024-02-02-103', null),
('20240302', '20240302', false, null, '판매대기중', '20240302', 'SS2024-02-02-104', 'ES2024-02-02-104', null),
('20240320', '20240320', false, null, '판매대기중', '20240320', 'SS2024-02-02-105', 'ES2024-02-02-105', null),
('20240812', '20240812', false, null, '판매대기중', '20240812', 'SS2024-02-02-106', 'ES2024-02-02-106', null),
('20240825', '20240825', false, null, '판매대기중', '20240825', 'SS2024-02-02-107', 'ES2024-02-02-107', null),
('20240903', '20240903', false, null, '판매대기중', '20240903', 'SS2024-02-02-108', 'ES2024-02-02-108', null),
('20240918', '20240918', false, null, '판매대기중', '20240918', 'SS2024-02-02-109', 'ES2024-02-02-109', null),
('20240930', '20240930', false,null, '판매대기중', '20240930', 'SS2024-02-02-110', 'ES2024-02-02-110', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-111', 'ES2024-02-02-111', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-112', 'ES2024-02-02-112', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-113', 'ES2024-02-02-113', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-114', 'ES2024-02-02-114', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-115', 'ES2024-02-02-115', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-116', 'ES2024-02-02-116', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-117', 'ES2024-02-02-117', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-118', 'ES2024-02-02-118', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-119', 'ES2024-02-02-119', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-120', 'ES2024-02-02-120', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-121', 'ES2024-02-02-121', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-122', 'ES2024-02-02-122', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-123', 'ES2024-02-02-123', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-124', 'ES2024-02-02-124', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-125', 'ES2024-02-02-125', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-126', 'ES2024-02-02-126', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-127', 'ES2024-02-02-127', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-128', 'ES2024-02-02-128', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-129', 'ES2024-02-02-129', null),
('20240930', '20240930', false, null, '판매대기중', '20240930', 'SS2024-02-02-130', 'ES2024-02-02-130', null);

INSERT INTO sixbeam_erp.SS_MEMBER_TB (ESTIMATE_CD,MEMBER_ID, MEMBER_NM, MEMBER_PHONE, MEMBER_ADDR)
VALUES
(null,'email1@example.com', '김철수', '010-1234-5678', '서울시 강남구'),
(null,'email2@example.com', '이영희', '010-2345-6789', '서울시 강서구'),
(null,'email3@example.com', '박민준', '010-3456-7890', '서울시 송파구'),
(null,'email4@example.com', '정지수', '010-4567-8901', '서울시 강북구'),
(null,'email5@example.com', '최영호', '010-5678-9012', '서울시 강동구'),
(null,'email6@example.com', '김하늘', '010-6789-0123', '서울시 서초구'),
(null,'email7@example.com', '이태양', '010-7890-1234', '서울시 동작구'),
(null,'email8@example.com', '박소은', '010-8901-2345', '서울시 마포구'),
(null,'email9@example.com', '정우진', '010-9012-3456', '서울시 은평구'),
(null,'email10@example.com', '최민서', '010-0123-4567', '서울시 강남구'),
(null,'email11@example.com', '아저씨', '010-1234-5678', '서울시 중랑구'),
(null,'email12@example.com', '김수현', '010-2345-6789', '서울시 종로구'),
(null,'email13@example.com', '이지훈', '010-3456-7890', '서울시 중구'),
(null,'email14@example.com', '박해진', '010-4567-8901', '서울시 성북구'),
(null,'email15@example.com', '정재훈', '010-5678-9012', '서울시 강남구'),
(null,'email16@example.com', '김태리', '010-6789-0123', '서울시 송파구'),
(null,'email17@example.com', '유승호', '010-7890-1234', '서울시 서대문구'),
(null,'email18@example.com', '박보영', '010-8901-2345', '서울시 강서구'),
(null,'email19@example.com', '이성민', '010-9012-3456', '서울시 강남구'),
(null,'email20@example.com', '김지원', '010-0123-4567', '서울시 강동구'),
(null,'email21@example.com', '한지민', '010-1234-5678', '서울시 강북구'),
(null,'email22@example.com', '송중기', '010-2345-6789', '서울시 강남구'),
(null,'email23@example.com', '한예슬', '010-3456-7890', '서울시 송파구'),
(null,'email24@example.com', '송혜교', '010-4567-8901', '서울시 서초구'),
(null,'email25@example.com', '이민호', '010-5678-9012', '서울시 동작구'),
(null,'email26@example.com', '손예진', '010-6789-0123', '서울시 마포구'),
(null,'email27@example.com', '조정석', '010-7890-1234', '서울시 은평구'),
(null,'email28@example.com', '한가인', '010-8901-2345', '서울시 강서구'),
(null,'email29@example.com', '김소현', '010-9012-3456', '서울시 강동구'),
(null,'email30@example.com', '서현진', '010-0123-4567', '서울시 서초구');






