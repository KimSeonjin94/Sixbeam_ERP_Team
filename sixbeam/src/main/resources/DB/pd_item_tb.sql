create table pd_item_tb
(
    item_up   int          null,
    item_cd   varchar(255) not null
        primary key,
    item_nm   varchar(255) null,
    item_stnd varchar(255) null
);

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
