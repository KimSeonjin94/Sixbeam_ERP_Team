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

-- 창고이동 DB --
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