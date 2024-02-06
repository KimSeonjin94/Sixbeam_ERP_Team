-- 회원정보 --
INSERT INTO `hr_empinfo_tb` VALUES ('1990-01-01','2024-02-01','2024-02-01',_binary '',0,NULL,NULL,NULL,'123-456-0000','Address 0','Bank 0','employee0@example.com',NULL,'20241000','임호진','123-456-0000','0',NULL),('1991-01-01','2024-02-01','2024-03-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0001','Address 1','Bank 1','employee1@example.com',NULL,'20241001','이상효','123-456-0001','1',NULL),('1992-01-01','2024-02-01','2024-04-01',_binary '',0,NULL,NULL,NULL,'123-456-0002','Address 2','Bank 2','employee2@example.com',NULL,'20241002','김선진','123-456-0002','2',NULL),('1993-01-01','2024-02-01','2024-05-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0003','Address 3','Bank 3','employee3@example.com',NULL,'20241003','임지환','123-456-0003','3',NULL),('1994-01-01','2024-02-01','2024-06-01',_binary '',0,NULL,NULL,NULL,'123-456-0004','Address 4','Bank 4','employee4@example.com',NULL,'20241004','김영훈','123-456-0004','4',NULL),('1995-01-01','2024-02-01','2024-07-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0005','Address 5','Bank 5','employee5@example.com',NULL,'20241005','박종현','123-456-0005','5',NULL),('1996-01-01','2024-02-01','2024-08-01',_binary '',0,NULL,NULL,NULL,'123-456-0006','Address 6','Bank 6','employee6@example.com',NULL,'20241006','박주성','123-456-0006','6',NULL),('1997-01-01','2024-02-01','2024-09-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0007','Address 7','Bank 7','employee7@example.com',NULL,'20241007','문성빈','123-456-0007','7',NULL),('1998-01-01','2024-02-01','2024-10-01',_binary '',0,NULL,NULL,NULL,'123-456-0008','Address 8','Bank 8','employee8@example.com',NULL,'20241008','천준호','123-456-0008','8',NULL),('1999-01-01','2024-02-01','2024-11-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0009','Address 9','Bank 9','employee9@example.com',NULL,'20241009','서준하','123-456-0009','9',NULL);

-- 거래처 db --  
INSERT INTO ac_account_tb (account_acnb, account_add, account_bank, account_cd, account_etc, account_nb, account_nm, account_pic, account_rep, account_sectors)
values
('685-0473786985', '서울시 광진구', '카카오뱅크', 'CPN0831580507', null, '0831580507', '롯데', '임지환', '신격호', '유통'),
('783-6930006568', '경기도 성남시', '하나은행', 'CPN0896202274', null, '0896202274', '소니', '김선진', '모리타아키오', '제조'),
('033-4551844212', '서울시 구로구', '하나은행', 'CPN1203760813', null, '1203760813', 'NAVER', '임호진', '이해진', 'IT'),
('483-1484534403', '서울시 영등포구', '하나은행', 'CPN3058270672', null, '3058270672', 'POSCO', '임호진', '박태준', '제조'),
('098-7663007851', '서울시 강서구', '신한은행', 'CPN3184469866', null, '3184469866', '카카오', '임호진', '김범수', 'IT'),
('553-3530031122', '서울시 용산구', '신한은행', 'CPN4244014868', null, '4244014868', 'GS', '박종현', '허만정', '유통'),
('919-6316264851', '서울시 서초구', '하나은행', 'CPN5221945160', null, '5221945160', 'KT', '김영훈', '김영섭', '통신'),
('656-8255128990', '서울시 도봉구', '농협은행', 'CPN5431051314', null, '5431051314', 'APPLE', '이상효', '스티브잡스', 'IT'),
('145-3669839433', '서울시 관악구', '국민은행', 'CPN5593852744', null, '5593852744', 'SKT', '김영훈', '유영상', '통신'),
('951-3479499431', '서울시 중구', '우리은행', 'CPN6234714473', null, '6234714473', '두산', '박종현', '박승직', '건설'),
('973-4812556890', '서울시 종로구', '카카오뱅크', 'CPN6357090862', null, '6357090862', 'CJ', '박종현', '이병철', '유통'),
('012-0516866831', '서울시 금천구', '농협은행', 'CPN7551487293', null, '7551487293', 'NCsoft', '김영훈', '김택진', 'IT'),
('310-4668131524', '경기도 용인시', '우리은행', 'CPN8641151763', null, '8641151763', '대한통운', '김선진', '강신호', '유통'),
('859-4026701001', '서울시 동작구', '신한은행', 'CPN9769359992', null, '9769359992', 'LGU', '김영훈', '황현식', '통신'),
('673-7705371755', '서울시 노원구', '신한은행', 'CPN0764320143', '구매처', '0764320143', 'BRAVOTEC', '이상효', '김영진', '제조'),
('540-9279534862', '서울시 성북구', '국민은행', 'CPN1029807529', '구매처', '1029807529', 'AMD', '이상효', '제리샌더스', '제조'),
('226-6876859474', '서울시 성동구', '국민은행', 'CPN1173291319', '구매처', '1173291319', 'GIGABYTE', '임지환', '예페이청', '제조'),
('074-3127136659', '경기도 김포시', '하나은행', 'CPN1856927584', '구매처', '1856927584', '웨스턴디지털', '김선진', '앨빈필립스', '제조'),
('888-9898204726', '서울시 송파구', '농협은행', 'CPN2266939105', '구매처', '2266939105', '로지텍', '임지환', '다니엘보렉', '제조'),
('821-8168143276', '서울시 강동구', '우리은행', 'CPN4282222263', '구매처', '4282222263', '삼성전자', '임지환', '이건희', '제조'),
('703-1720820252', '서울시 마포구', '하나은행', 'CPN4308575449', '구매처', '4308575449', '애즈락', '박종현', '쉬스창', '제조'),
('067-6986366840', '서울시 동대문구', '카카오뱅크', 'CPN5277628939', '구매처', '5277628939', '인텔', '임지환', '고든무어', '제조'),
('517-5649280480', '서울시 강남구', '우리은행', 'CPN5836847354', '구매처', '5836847354', '마이크로닉스', '김영훈', '김종원', '제조'),
('025-9153541675', '경기도 하남시', '농협은행', 'CPN6543637212', '구매처', '6543637212', 'SEASONIC', '김선진', '칼벤츠', '제조'),
('098-4649694312', '서울시 강북구', '신한은행', 'CPN6814402423', '구매처', '6814402423', 'ZOTAC', '이상효', '김성표', '유통'),
('249-8986691231', '서울시 서대문구', '하나은행', 'CPN7422636804', '구매처', '7422636804', '다크플래시', '박종현', '민희진', '제조'),
('112-7155262063', '서울시 은평구', '국민은행', 'CPN8766713365', '구매처', '8766713365', '아수스', '임호진', '테드수', '제조'),
('875-3926701002', '경기도 안양시', '카카오뱅크', 'CPN8769359993', '구매처', '8769359993', '한성컴퓨터', '임호진', '한동열', '제조'),
('151-3927322602', '서울시 양천구', '농협은행', 'CPN8956377612', '구매처', '8956377612', 'EMTEK', '임호진', '박민규', '유통'),
('887-3826701003', '경기도 군포시', '카카오뱅크', 'CPN9469359994', '구매처', '9469359994', '레이저', '임호진', '로버트크라코프', '유통'),
('081-7901698385', '서울시 중랑구', '신한은행', 'CPN6287772501', '구매처 ', '6287772501', 'SK하이닉스', '이상효', '곽노정', '제조'),
('642-0290265811', '경기도 수원시 ', '우리은행', 'RTS1010101010', '소매매출', '8832918761', '개인거래', '김선진', 'CUSTOMER', '소매');

-- 재무상태표 db --  
INSERT INTO `ac_bs_tb` VALUES (200000000,250000000,10000000,0,100000000,0,200000000,260000000,0,0,'Balancesh2023Q4');


-- 창고등록 DB --
insert into sixbeam_erp.st_whregist_tb (whregist_cd, whregist_nm) values("WHR1001","본사창고");
insert into sixbeam_erp.st_whregist_tb (whregist_cd, whregist_nm) values("WHR1002","생산창고");
insert into sixbeam_erp.st_whregist_tb (whregist_cd, whregist_nm) values("WHR1003","자재창고");


-- 창고이동 DB --
insert into sixbeam_erp.st_whmove_tb (whmove_amt,whmove_dt,empinfo_id,item_cd,whmove_cd,whmove_gb,whregist_cd) values
(1	,"2024-01-02"	,"20241009"	,"F1001"	,"WHM2024-10001"	,"출고"	,"WHR1002"),
(1	,"2024-01-04"	,"20241008"	,"F1001"	,"WHM2024-10002"	,"입고"	,"WHR1003"),
(2	,"2024-01-03"	,"20241009"	,"F1002"	,"WHM2024-10003"	,"출고"	,"WHR1002"),
(2	,"2024-01-05"	,"20241008"	,"F1002"	,"WHM2024-10004"	,"입고"	,"WHR1003"),
(5	,"2024-01-03"	,"20241009"	,"F1001"	,"WHM2024-10005"	,"출고"	,"WHR1002"),
(5	,"2024-01-05"	,"20241008"	,"F1001"	,"WHM2024-10006"	,"입고"	,"WHR1003"),
(4	,"2024-01-04"	,"20241007"	,"F1004"	,"WHM2024-10007"	,"출고"	,"WHR1002"),
(4	,"2024-01-08"	,"20241008"	,"F1004"	,"WHM2024-10008"	,"입고"	,"WHR1003"),
(10	,"2024-01-05"	,"20241009"	,"F1005"	,"WHM2024-10009"	,"출고"	,"WHR1002"),
(10	,"2024-01-08"	,"20241008"	,"F1005"	,"WHM2024-10010"	,"입고"	,"WHR1003"),
(20	,"2024-01-09"	,"20241007"	,"R1001"	,"WHM2024-10011"	,"출고"	,"WHR1002"),
(20	,"2024-01-11"	,"20241008"	,"R1001"	,"WHM2024-10012"	,"입고"	,"WHR1003"),
(15	,"2024-01-10"	,"20241007"	,"R1002"	,"WHM2024-10013"	,"출고"	,"WHR1002"),
(15	,"2024-01-12"	,"20241008"	,"R1002"	,"WHM2024-10014"	,"입고"	,"WHR1003"),
(13	,"2024-01-11"	,"20241009"	,"R1003"	,"WHM2024-10015"	,"출고"	,"WHR1002"),
(13	,"2024-01-15"	,"20241008"	,"R1003"	,"WHM2024-10016"	,"입고"	,"WHR1003"),
(7	,"2024-01-15"	,"20241007"	,"R1004"	,"WHM2024-10017"	,"출고"	,"WHR1002"),
(7	,"2024-01-17"	,"20241008"	,"R1004"	,"WHM2024-10018"	,"입고"	,"WHR1003"),
(8	,"2024-01-18"	,"20241009"	,"R1005"	,"WHM2024-10019"	,"출고"	,"WHR1002"),
(8	,"2024-01-19"	,"20241008"	,"R1005"	,"WHM2024-10020"	,"입고"	,"WHR1003"),
(8	,"2024-01-22"	,"20241007"	,"R1006"	,"WHM2024-10021"	,"출고"	,"WHR1002"),
(8	,"2024-01-24"	,"20241008"	,"R1006"	,"WHM2024-10022"	,"입고"	,"WHR1003"),
(3	,"2024-01-23"	,"20241009"	,"R1007"	,"WHM2024-10023"	,"출고"	,"WHR1002"),
(3	,"2024-01-25"	,"20241008"	,"R1007"	,"WHM2024-10024"	,"입고"	,"WHR1003"),
(2	,"2024-01-24"	,"20241007"	,"R1008"	,"WHM2024-10025"	,"출고"	,"WHR1002"),
(2	,"2024-01-26"	,"20241008"	,"R1008"	,"WHM2024-10026"	,"입고"	,"WHR1003"),
(3	,"2024-01-29"	,"20241008"	,"F1001"	,"WHM2024-10027"	,"출고"	,"WHR1003"),
(3	,"2024-01-31"	,"20241004"	,"F1001"	,"WHM2024-10028"	,"입고"	,"WHR1001"),
(7	,"2024-02-01"	,"20241008"	,"F1003"	,"WHM2024-10029"	,"출고"	,"WHR1003"),
(7	,"2024-02-02"	,"20241004"	,"F1003"	,"WHM2024-10030"	,"입고"	,"WHR1001"),
(5	,"2024-01-02"	,"20241001"	,"R1001"	,"WHM2024-10031"	,"입고"	,"WHR1003"),
(20	,"2024-01-09"	,"20241006"	,"R1001"	,"WHM2024-10032"	,"입고"	,"WHR1003"),
(13	,"2024-01-04"	,"20241003"	,"R1002"	,"WHM2024-10033"	,"입고"	,"WHR1003"),
(17	,"2024-01-09"	,"20241006"	,"R1002"	,"WHM2024-10034"	,"입고"	,"WHR1003"),
(10	,"2024-01-02"	,"20241001"	,"R1003"	,"WHM2024-10035"	,"입고"	,"WHR1003"),
(36	,"2024-01-09"	,"20241006"	,"R1003"	,"WHM2024-10036"	,"입고"	,"WHR1003"),
(50	,"2024-01-08"	,"20241005"	,"R1004"	,"WHM2024-10037"	,"입고"	,"WHR1003"),
(45	,"2024-01-09"	,"20241006"	,"R1004"	,"WHM2024-10038"	,"입고"	,"WHR1003"),
(20	,"2024-01-04"	,"20241003"	,"R1005"	,"WHM2024-10039"	,"입고"	,"WHR1003"),
(15	,"2024-01-08"	,"20241005"	,"R1005"	,"WHM2024-10040"	,"입고"	,"WHR1003"),
(36	,"2024-01-09"	,"20241006"	,"R1005"	,"WHM2024-10041"	,"입고"	,"WHR1003"),
(16	,"2024-01-05"	,"20241004"	,"R1006"	,"WHM2024-10042"	,"입고"	,"WHR1003"),
(25	,"2024-01-08"	,"20241005"	,"R1006"	,"WHM2024-10043"	,"입고"	,"WHR1003"),
(31	,"2024-01-09"	,"20241006"	,"R1006"	,"WHM2024-10044"	,"입고"	,"WHR1003"),
(17	,"2024-01-05"	,"20241004"	,"R1007"	,"WHM2024-10045"	,"입고"	,"WHR1003"),
(23	,"2024-01-09"	,"20241006"	,"R1007"	,"WHM2024-10046"	,"입고"	,"WHR1003"),
(13	,"2024-01-05"	,"20241004"	,"R1008"	,"WHM2024-10047"	,"입고"	,"WHR1003"),
(18	,"2024-01-09"	,"20241006"	,"R1008"	,"WHM2024-10048"	,"입고"	,"WHR1003"),
(20	,"2024-01-09"	,"20241006"	,"R1009"	,"WHM2024-10049"	,"입고"	,"WHR1003"),
(20	,"2024-01-09"	,"20241006"	,"R1010"	,"WHM2024-10050"	,"입고"	,"WHR1003"),
(7	,"2024-01-03"	,"20241002"	,"R1011"	,"WHM2024-10051"	,"입고"	,"WHR1003"),
(9	,"2024-01-03"	,"20241002"	,"R1012"	,"WHM2024-10052"	,"입고"	,"WHR1003"),
(15	,"2024-01-03"	,"20241002"	,"R1013"	,"WHM2024-10053"	,"입고"	,"WHR1003"),
(25	,"2024-01-08"	,"20241005"	,"R1014"	,"WHM2024-10054"	,"입고"	,"WHR1003"),
(30	,"2024-01-08"	,"20241005"	,"R1015"	,"WHM2024-10055"	,"입고"	,"WHR1003"),
(25	,"2024-01-08"	,"20241005"	,"R1016"	,"WHM2024-10056"	,"입고"	,"WHR1003"),
(35	,"2024-01-08"	,"20241005"	,"R1017"	,"WHM2024-10057"	,"입고"	,"WHR1003"),
(30	,"2024-01-08"	,"20241005"	,"R1018"	,"WHM2024-10058"	,"입고"	,"WHR1003"),
(37	,"2024-01-08"	,"20241005"	,"R1019"	,"WHM2024-10059"	,"입고"	,"WHR1003"),
(40	,"2024-01-08"	,"20241005"	,"R1020"	,"WHM2024-10060"	,"입고"	,"WHR1003"),
(5	,"2024-01-31"	,"20241001"	,"F1001"	,"WHM2024-10061"	,"출고"	,"WHR1001"),
(8	,"2024-02-01"	,"20241005"	,"F1002"	,"WHM2024-10062"	,"출고"	,"WHR1001"),
(3	,"2024-02-15"	,"20241007"	,"F1003"	,"WHM2024-10063"	,"출고"	,"WHR1001"),
(10	,"2024-03-02"	,"20241001"	,"F1004"	,"WHM2024-10064"	,"출고"	,"WHR1001"),
(7	,"2024-03-20"	,"20241005"	,"F1005"	,"WHM2024-10065"	,"출고"	,"WHR1001"),
(6	,"2024-08-12"	,"20241007"	,"R1001"	,"WHM2024-10066"	,"출고"	,"WHR1001"),
(9	,"2024-08-25"	,"20241001"	,"R1002"	,"WHM2024-10067"	,"출고"	,"WHR1001"),
(4	,"2024-09-03"	,"20241005"	,"R1003"	,"WHM2024-10068"	,"출고"	,"WHR1001"),
(12	,"2024-09-18"	,"20241007"	,"R1004"	,"WHM2024-10069"	,"출고"	,"WHR1001"),
(8	,"2024-09-30"	,"20241001"	,"R1005"	,"WHM2024-10070"	,"출고"	,"WHR1001"),
(10	,"2024-09-30"	,"20241005"	,"R1006"	,"WHM2024-10071"	,"출고"	,"WHR1001"),
(15	,"2024-09-30"	,"20241007"	,"R1007"	,"WHM2024-10072"	,"출고"	,"WHR1001"),
(20	,"2024-09-30"	,"20241001"	,"R1008"	,"WHM2024-10073"	,"출고"	,"WHR1001"),
(12	,"2024-09-30"	,"20241005"	,"R1009"	,"WHM2024-10074"	,"출고"	,"WHR1001"),
(18	,"2024-09-30"	,"20241007"	,"R1010"	,"WHM2024-10075"	,"출고"	,"WHR1001"),
(10	,"2024-09-30"	,"20241001"	,"R1011"	,"WHM2024-10076"	,"출고"	,"WHR1001"),
(15	,"2024-09-30"	,"20241005"	,"R1012"	,"WHM2024-10077"	,"출고"	,"WHR1001"),
(8	,"2024-09-30"	,"20241007"	,"R1013"	,"WHM2024-10078"	,"출고"	,"WHR1001"),
(25	,"2024-09-30"	,"20241001"	,"R1014"	,"WHM2024-10079"	,"출고"	,"WHR1001"),
(14	,"2024-09-30"	,"20241005"	,"R1014"	,"WHM2024-10080"	,"출고"	,"WHR1001"),
(20	,"2024-09-30"	,"20241007"	,"R1015"	,"WHM2024-10081"	,"출고"	,"WHR1001"),
(10	,"2024-09-30"	,"20241001"	,"R1016"	,"WHM2024-10082"	,"출고"	,"WHR1001"),
(12	,"2024-09-30"	,"20241005"	,"R1017"	,"WHM2024-10083"	,"출고"	,"WHR1001"),
(19	,"2024-09-30"	,"20241007"	,"R1018"	,"WHM2024-10084"	,"출고"	,"WHR1001"),
(14	,"2024-09-30"	,"20241001"	,"R1019"	,"WHM2024-10085"	,"출고"	,"WHR1001"),
(16	,"2024-09-30"	,"20241005"	,"R1020"	,"WHM2024-10086"	,"출고"	,"WHR1001"),
(10	,"2024-09-30"	,"20241007"	,"R1020"	,"WHM2024-10087"	,"출고"	,"WHR1001"),
(22	,"2024-09-30"	,"20241001"	,"R1020"	,"WHM2024-10088"	,"출고"	,"WHR1001"),
(16	,"2024-09-30"	,"20241005"	,"R1020"	,"WHM2024-10089"	,"출고"	,"WHR1001"),
(20	,"2024-09-30"	,"20241007"	,"R1020"	,"WHM2024-10090"	,"출고"	,"WHR1001");



-- item db --  
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

-- 견적 컬럼설정 --  
SET SQL_SAFE_UPDATES = 0;
UPDATE sixbeam_erp.SS_ESTIMATE_TB
SET
    ESTIMATE_SP = ESTIMATE_AMT * ESTIMATE_UP,
    ESTIMATE_VAT = ESTIMATE_SP / 10,
    ESTIMATE_TAMT = ESTIMATE_SP + ESTIMATE_VAT;
SET SQL_SAFE_UPDATES = 1;

-- 견적 db--  
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
('ES2024-02-02-103',20241007,'CPN9769359992','F1003',null,'20240215', '박민준', 3, 500000,  '더미 텍스트'),
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
('ES2024-02-02-131',20241001, 'RTS1010101010', 'R1020', null, '20251210', '김소현', 14, 72900,  '더미 텍스트'),
('ES2024-02-02-132',20241005, 'RTS1010101010', 'R1020', null, '20251225', '서현진', 18, 72900,  '더미 텍스트'),
('ES2024-02-02-133',20241007, 'RTS1010101010', 'R1020', null, '20260110', '이동욱', 15, 72900,  '더미 텍스트');

-- 판매 db --  
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

-- 멤버 db --  
INSERT INTO sixbeam_erp.SS_MEMBER_TB (ESTIMATE_CD,MEMBER_ID, MEMBER_NM, MEMBER_PHONE, MEMBER_ADDR)
VALUES
('ES2024-02-02-133','email1@example.com', '김철수', '010-1234-5678', '서울시 강남구'),
('ES2024-02-02-131','email2@example.com', '이영희', '010-2345-6789', '서울시 강서구'),
('ES2024-02-02-132','email3@example.com', '박민준', '010-3456-7890', '서울시 송파구');
-- (null,'email4@example.com', '정지수', '010-4567-8901', '서울시 강북구'),
-- (null,'email5@example.com', '최영호', '010-5678-9012', '서울시 강동구'),
-- (null,'email6@example.com', '김하늘', '010-6789-0123', '서울시 서초구'),
-- (null,'email7@example.com', '이태양', '010-7890-1234', '서울시 동작구'),
-- (null,'email8@example.com', '박소은', '010-8901-2345', '서울시 마포구'),
-- (null,'email9@example.com', '정우진', '010-9012-3456', '서울시 은평구'),
-- (null,'email10@example.com', '최민서', '010-0123-4567', '서울시 강남구'),
-- (null,'email11@example.com', '아저씨', '010-1234-5678', '서울시 중랑구'),
-- (null,'email12@example.com', '김수현', '010-2345-6789', '서울시 종로구'),
-- (null,'email13@example.com', '이지훈', '010-3456-7890', '서울시 중구'),
-- (null,'email14@example.com', '박해진', '010-4567-8901', '서울시 성북구'),
-- (null,'email15@example.com', '정재훈', '010-5678-9012', '서울시 강남구'),
-- (null,'email16@example.com', '김태리', '010-6789-0123', '서울시 송파구'),
-- (null,'email17@example.com', '유승호', '010-7890-1234', '서울시 서대문구'),
-- (null,'email18@example.com', '박보영', '010-8901-2345', '서울시 강서구'),
-- (null,'email19@example.com', '이성민', '010-9012-3456', '서울시 강남구'),
-- (null,'email20@example.com', '김지원', '010-0123-4567', '서울시 강동구'),
-- (null,'email21@example.com', '한지민', '010-1234-5678', '서울시 강북구'),
-- (null,'email22@example.com', '송중기', '010-2345-6789', '서울시 강남구'),
-- (null,'email23@example.com', '한예슬', '010-3456-7890', '서울시 송파구'),
-- (null,'email24@example.com', '송혜교', '010-4567-8901', '서울시 서초구'),
-- (null,'email25@example.com', '이민호', '010-5678-9012', '서울시 동작구'),
-- (null,'email26@example.com', '손예진', '010-6789-0123', '서울시 마포구'),
-- (null,'email27@example.com', '조정석', '010-7890-1234', '서울시 은평구'),
-- (null,'email28@example.com', '한가인', '010-8901-2345', '서울시 강서구'),
-- (null,'email29@example.com', '김소현', '010-9012-3456', '서울시 강동구'),
-- (null,'email30@example.com', '서현진', '010-0123-4567', '서울시 서초구');


-- 발주 db --  
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (5, 2050000, 2091000, 410000, 41000, str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-02', '%Y-%m-%d'), str_to_date('2023-12-27', '%Y-%m-%d'), 'CPN5277628939', '20241001', 'R1001', 'OR240102-0001', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (20, 8200000, 8241000, 410000, 41000, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN5277628939', '20241006', 'R1001', 'OR240109-0001', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (13, 6630000, 6681000, 510000, 51000, str_to_date('2024-01-11', '%Y-%m-%d'), str_to_date('2024-01-04', '%Y-%m-%d'), str_to_date('2024-01-02', '%Y-%m-%d'), 'CPN1029807529', '20241003', 'R1002', 'OR240104-0001', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (17, 8670000, 8721000, 510000, 51000, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN1029807529', '20241006', 'R1002', 'OR240109-0002', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (10, 550000, 555500, 55000, 5500, str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-02', '%Y-%m-%d'), str_to_date('2023-12-28', '%Y-%m-%d'), 'CPN4282222263', '20241001', 'R1003', 'OR240102-0002', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (36, 1980000, 1985500, 55000, 5500, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN4282222263', '20241006', 'R1003', 'OR240109-0003', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (50, 1450000, 1452900, 29000, 2900, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN6287772501', '20241005', 'R1004', 'OR240108-0005', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (45, 1305000, 1307900, 29000, 2900, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN6287772501', '20241006', 'R1004', 'OR240109-0004', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (20, 1960000, 1969800, 98000, 9800, str_to_date('2024-01-11', '%Y-%m-%d'), str_to_date('2024-01-04', '%Y-%m-%d'), str_to_date('2024-01-03', '%Y-%m-%d'), 'CPN8766713365', '20241003', 'R1005', 'OR240104-0002', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (15, 1470000, 1479800, 98000, 9800, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN8766713365', '20241005', 'R1005', 'OR240108-0009', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (36, 3528000, 3537800, 98000, 9800, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN8766713365', '20241006', 'R1005', 'OR240109-0005', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (16, 2720000, 2737000, 170000, 17000, str_to_date('2024-01-12', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), str_to_date('2024-01-04', '%Y-%m-%d'), 'CPN4308575449', '20241004', 'R1006', 'OR240105-0001', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (25, 4250000, 4267000, 170000, 17000, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN4308575449', '20241005', 'R1006', 'OR240108-0010', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (31, 5270000, 5287000, 170000, 17000, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN4308575449', '20241006', 'R1006', 'OR240109-0006', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (17, 4573000, 4599900, 269000, 26900, str_to_date('2024-01-12', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), str_to_date('2024-01-04', '%Y-%m-%d'), 'CPN1173291319', '20241004', 'R1007', 'OR240105-0002', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (23, 6187000, 6213900, 269000, 26900, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN1173291319', '20241006', 'R1007', 'OR240109-0007', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (13, 5239000, 5279300, 403000, 40300, str_to_date('2024-01-12', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), str_to_date('2024-01-04', '%Y-%m-%d'), 'CPN8766713365', '20241004', 'R1008', 'OR240105-0003', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (18, 7254000, 7294300, 403000, 40300, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN8766713365', '20241006', 'R1008', 'OR240109-0008', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (20, 15820000, 15899100, 791000, 79100, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN6814402423', '20241006', 'R1009', 'OR240109-0009', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (20, 10760000, 10813800, 538000, 53800, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-09', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), 'CPN8956377612', '20241006', 'R1010', 'OR240109-0010', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (7, 896000, 908800, 128000, 12800, str_to_date('2024-01-10', '%Y-%m-%d'), str_to_date('2024-01-03', '%Y-%m-%d'), str_to_date('2024-01-02', '%Y-%m-%d'), 'CPN6287772501', '20241002', 'R1011', 'OR240103-0001', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (9, 1035000, 1046500, 115000, 11500, str_to_date('2024-01-10', '%Y-%m-%d'), str_to_date('2024-01-03', '%Y-%m-%d'), str_to_date('2024-01-02', '%Y-%m-%d'), 'CPN1856927584', '20241002', 'R1012', 'OR240103-0002', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (15, 1020000, 1026800, 68000, 6800, str_to_date('2024-01-10', '%Y-%m-%d'), str_to_date('2024-01-03', '%Y-%m-%d'), str_to_date('2024-01-02', '%Y-%m-%d'), 'CPN4282222263', '20241002', 'R1013', 'OR240103-0003', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (25, 2450000, 2459800, 98000, 9800, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN7422636804', '20241005', 'R1014', 'OR240108-0001', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (30, 1350000, 1354500, 45000, 4500, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN0764320143', '20241005', 'R1015', 'OR240108-0002', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (25, 3150000, 3162600, 126000, 12600, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN6543637212', '20241005', 'R1016', 'OR240108-0003', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (35, 1907500, 1912950, 54500, 5450, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN5836847354', '20241005', 'R1017', 'OR240108-0004', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (30, 2325000, 2332750, 77500, 7750, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN2266939105', '20241005', 'R1018', 'OR240108-0006', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (37, 6993000, 7011900, 189000, 18900, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN8769359993', '20241005', 'R1019', 'OR240108-0007', '');
insert into pur_orinput_tb (orinput_amt, orinput_sp, orinput_sum, orinput_up, orinput_vat, orinputdlvy_dt, orinputor_dt, orinputreq_dt, account_cd, empinfo_id, item_cd, orinput_cd, orinput_etc) values (40, 2916000, 2923290, 72900, 7290, str_to_date('2024-01-15', '%Y-%m-%d'), str_to_date('2024-01-08', '%Y-%m-%d'), str_to_date('2024-01-05', '%Y-%m-%d'), 'CPN9469359994', '20241005', 'R1020', 'OR240108-0008', '');

-- 구입 db --  
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-02', '%Y-%m-%d'), null, 0, '대기중', 'PUR240102-0001', 'OR240102-0001', 'WHM2024-10031');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-02', '%Y-%m-%d'), null, 0, '대기중', 'PUR240102-0002', 'OR240102-0002', 'WHM2024-10035');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-03', '%Y-%m-%d'), null, 0, '대기중', 'PUR240103-0001', 'OR240103-0001', 'WHM2024-10051');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-03', '%Y-%m-%d'), null, 0, '대기중', 'PUR240103-0002', 'OR240103-0002', 'WHM2024-10052');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-03', '%Y-%m-%d'), null, 0, '대기중', 'PUR240103-0003', 'OR240103-0003', 'WHM2024-10053');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-04', '%Y-%m-%d'), null, 0, '대기중', 'PUR240104-0001', 'OR240104-0001', 'WHM2024-10033');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-04', '%Y-%m-%d'), null, 0, '대기중', 'PUR240104-0002', 'OR240104-0002', 'WHM2024-10039');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-05', '%Y-%m-%d'), null, 0, '대기중', 'PUR240105-0001', 'OR240105-0001', 'WHM2024-10042');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-05', '%Y-%m-%d'), null, 0, '대기중', 'PUR240105-0002', 'OR240105-0002', 'WHM2024-10045');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-05', '%Y-%m-%d'), null, 0, '대기중', 'PUR240105-0003', 'OR240105-0003', 'WHM2024-10047');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0001', 'OR240108-0001', 'WHM2024-10054');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0002', 'OR240108-0002', 'WHM2024-10055');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0003', 'OR240108-0003', 'WHM2024-10056');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0004', 'OR240108-0004', 'WHM2024-10057');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0005', 'OR240108-0005', 'WHM2024-10037');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0006', 'OR240108-0006', 'WHM2024-10058');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0007', 'OR240108-0007', 'WHM2024-10059');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0008', 'OR240108-0008', 'WHM2024-10060');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0009', 'OR240108-0009', 'WHM2024-10040');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-08', '%Y-%m-%d'), null, 0, '대기중', 'PUR240108-0010', 'OR240108-0010', 'WHM2024-10043');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0001', 'OR240109-0001', 'WHM2024-10032');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0002', 'OR240109-0002', 'WHM2024-10034');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0003', 'OR240109-0003', 'WHM2024-10036');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0004', 'OR240109-0004', 'WHM2024-10038');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0005', 'OR240109-0005', 'WHM2024-10041');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0006', 'OR240109-0006', 'WHM2024-10044');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0007', 'OR240109-0007', 'WHM2024-10046');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0008', 'OR240109-0008', 'WHM2024-10048');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0009', 'OR240109-0009', 'WHM2024-10049');
insert into pur_input_tb (input_dt, inputsi_dt, inputsi_fl, inputprg_st, inputpur_cd, orinput_cd, whmove_cd) values (str_to_date('2024-01-09', '%Y-%m-%d'), null, 0, '대기중', 'PUR240109-0010', 'OR240109-0010', 'WHM2024-10050');

-- 출하 DB --
insert into sixbeam_erp.st_release_tb (release_dt,account_cd,empinfo_id,release_addr,release_cd,release_phone,release_rv,release_zc,whmove_cd,sale_cd) values
("2024-01-31"	,"CPN9769359992"	,"20241001"	,"서울시 강남구 역삼동 123-45"	,"REL20240131-1001"	,"010-1234-5678"	,"김철수"	,"06012"	,"WHM2024-10061"	,"SS20240202-101"),
("2024-02-01"	,"CPN8956377612"	,"20241005"	,"경기도 수원시 장안구 영통동 678-90"	,"REL20240201-1002"	,"010-9876-5432"	,"이영희"	,"16473"	,"WHM2024-10062"	,"SS20240202-102"),
("2024-02-15"	,"CPN8832918761"	,"20241007"	,"부산광역시 해운대구 송정동 56-78"	,"REL20240215-1003"	,"010-1111-2222"	,"박민준"	,"48058"	,"WHM2024-10063"	,"SS20240202-103"),
("2024-03-02"	,"CPN8766713365"	,"20241001"	,"인천광역시 남동구 만수동 12-34"	,"REL20240302-1004"	,"010-5555-6666"	,"정지수"	,"21536"	,"WHM2024-10064"	,"SS20240202-104"),
("2024-03-20"	,"CPN8641151763"	,"20241005"	,"대구광역시 중구 삼덕동 987-65"	,"REL20240320-1005"	,"010-9999-8888"	,"최영호"	,"41907"	,"WHM2024-10065"	,"SS20240202-105"),
("2024-08-12"	,"CPN7551487293"	,"20241007"	,"대전광역시 서구 둔산동 345-67"	,"REL20240812-1006"	,"010-4321-8765"	,"김하늘"	,"35247"	,"WHM2024-10066"	,"SS20240202-106"),
("2024-08-25"	,"CPN7422636804"	,"20241001"	,"광주광역시 동구 서석동 89-01"	,"REL20240825-1007"	,"010-8765-4321"	,"이태양"	,"61425"	,"WHM2024-10067"	,"SS20240202-107"),
("2024-09-03"	,"CPN6814402423"	,"20241005"	,"울산광역시 남구 삼산동 234-56"	,"REL20240903-1008"	,"010-2468-1357"	,"박소은"	,"44702"	,"WHM2024-10068"	,"SS20240202-108"),
("2024-09-18"	,"CPN6543637212"	,"20241007"	,"경북 포항시 북구 용흥동 901-23"	,"REL20240918-1009"	,"010-7890-4321"	,"정우진"	,"37856"	,"WHM2024-10069"	,"SS20240202-109"),
("2024-09-30"	,"CPN6357090862"	,"20241001"	,"전북 전주시 완산구 효자동 345-67"	,"REL20240930-1010"	,"010-6543-2109"	,"최민서"	,"55024"	,"WHM2024-10070"	,"SS20240202-110"),
("2024-09-30"	,"CPN6287772501"	,"20241005"	,"전남 목포시 용당동 789-01"	,"REL20240930-1011"	,"010-7777-8888"	,"아저씨"	,"58731"	,"WHM2024-10071"	,"SS20240202-111"),
("2024-09-30"	," CPN6234714473"	,"20241007"	,"경남 창원시 의창구 사림동 234-56"	,"REL20240930-1012"	,"010-3333-4444"	,"홍길동"	,"51402"	,"WHM2024-10072"	,"SS20240202-112"),
("2024-09-30"	," CPN5836847354"	,"20241001"	,"충북 청주시 상당구 문의동 012-34"	,"REL20240930-1013"	,"010-0000-9999"	,"이순신"	,"28645"	,"WHM2024-10073"	,"SS20240202-113"),
("2024-09-30"	," CPN5593852744"	,"20241005"	,"충남 아산시 배방읍 석정리 567-89"	,"REL20240930-1014"	,"010-5678-4321"	,"김영희"	,"31456"	,"WHM2024-10074"	,"SS20240202-114"),
("2024-09-30"	," CPN5431051314"	,"20241007"	,"강원 원주시 부론동 890-12"	,"REL20240930-1015"	,"010-1357-2468"	,"이철수"	,"26473"	,"WHM2024-10075"	,"SS20240202-115"),
("2024-09-30"	," CPN5277628939"	,"20241001"	,"경기 안양시 만안구 박달동 345-67"	,"REL20240930-1016"	,"010-8765-1234"	,"박민준"	,"13924"	,"WHM2024-10076"	,"SS20240202-116"),
("2024-09-30"	," CPN5221945160"	,"20241005"	,"인천 서구 청라동 012-34"	,"REL20240930-1017"	,"010-4444-5555"	,"정우진"	,"22658"	,"WHM2024-10077"	,"SS20240202-117"),
("2024-09-30"	," CPN4308575449"	,"20241007"	,"대전 유성구 구암동 789-01"	,"REL20240930-1018"	,"010-8888-9999"	,"김하늘"	,"34105"	,"WHM2024-10078"	,"SS20240202-118"),
("2024-09-30"	," CPN4282222263"	,"20241001"	,"광주 북구 우치로 234-56"	,"REL20240930-1019"	,"010-6666-7777"	,"이태양"	,"61472"	,"WHM2024-10079"	,"SS20240202-119"),
("2024-09-30"	," CPN4244014868"	,"20241005"	,"울산 중구 성안동 567-89"	,"REL20240930-1020"	,"010-2222-3333"	,"박소은"	,"44012"	,"WHM2024-10080"	,"SS20240202-120"),
("2024-09-30"	," CPN3184469866"	,"20241007"	,"경북 경주시 보문로 012-34"	,"REL20240930-1021"	,"010-7890-1234"	,"최영호"	,"38036"	,"WHM2024-10081"	,"SS20240202-121"),
("2024-09-30"	," CPN3058270672"	,"20241001"	,"전북 익산시 망성동 901-23"	,"REL20240930-1022"	,"010-5678-9012"	,"홍길순"	,"54629"	,"WHM2024-10082"	,"SS20240202-122"),
("2024-09-30"	," CPN2266939105"	,"20241005"	,"전남 여수시 국동 345-67"	,"REL20240930-1023"	,"010-1234-5670"	,"김철수"	,"59602"	,"WHM2024-10083"	,"SS20240202-123"),
("2024-09-30"	," CPN1856927584"	,"20241007"	,"경남 진주시 남강로 789-01"	,"REL20240930-1024"	,"010-9876-5430"	,"송중기"	,"52814"	,"WHM2024-10084"	,"SS20240202-124"),
("2024-09-30"	," CPN1203760813"	,"20241001"	,"충북 청주시 청원구 오창읍 234-56"	,"REL20240930-1025"	,"010-1111-2220"	,"한예슬"	,"28671"	,"WHM2024-10085"	,"SS20240202-125"),
("2024-09-30"	," CPN1173291319"	,"20241005"	,"충남 서산시 동문로 890-12"	,"REL20240930-1026"	,"010-5555-6660"	,"송혜교"	,"35648"	,"WHM2024-10086"	,"SS20240202-126"),
("2024-09-30"	," CPN1029807529"	,"20241007"	,"강원 춘천시 효자동 012-34"	,"REL20240930-1027"	,"010-9999-8880"	,"이민호"	,"26415"	,"WHM2024-10087"	,"SS20240202-127"),
("2024-09-30"	," CPN0896202274"	,"20241001"	,"경기 성남시 분당구 정자동 567-89"	,"REL20240930-1028"	,"010-4321-8760"	,"손예진"	,"13573"	,"WHM2024-10088"	,"SS20240202-128"),
("2024-09-30"	," CPN0831580507"	,"20241005"	,"인천 강화군 강화읍 012-34"	,"REL20240930-1029"	,"010-8765-4320"	,"조정석"	,"23021"	,"WHM2024-10089"	,"SS20240202-129"),
("2024-09-30"	," CPN0764320143"	,"20241007"	,"대전 대덕구 비래동 901-23"	,"REL20240930-1030"	,"010-2468-1350"	,"한가인"	,"34509"	,"WHM2024-10090"	,"SS20240202-130");
