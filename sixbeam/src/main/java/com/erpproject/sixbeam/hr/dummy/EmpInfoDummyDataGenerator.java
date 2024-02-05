package com.erpproject.sixbeam.hr.dummy;

import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.repository.DepartRepository;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.hr.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Component
//public class EmpInfoDummyDataGenerator {
//
//    @Autowired
//    private EmpInfoRepository empInfoRepository;
//    @PostConstruct
//    public void generateDummyData() {
//        List<EmpInfoEntity>dummyEmpInfo = createDummyEmpInfo();
//        empInfoRepository.saveAll(dummyEmpInfo);
//    }
//    private List<EmpInfoEntity> createDummyEmpInfo(){
//        List<EmpInfoEntity>empInfos = new ArrayList<>();
//        String[]name = {"임호진","천준호","임지환","이상효","김선진","이동규","서준하","김예은","김영훈","박종현"};
//        for (int i = 0; i < 10; i++) {
//            EmpInfoEntity empInfoDummy = new EmpInfoEntity();
//            empInfoDummy.setEmpInfoPw(""+i);
//            empInfoDummy.setEmpInfoNm(name[i]);
//            empInfoDummy.setEmpInfoSex(i % 2 == 0);  // 간단한 방법으로 성별 alternating
//            empInfoDummy.setEmpInfoBirth(LocalDate.of(1990 + i, 1, 1));
//            empInfoDummy.setEmpInfoAddr("수원시 권선구");
//            empInfoDummy.setEmpInfoPhone("123-456-" + String.format("%04d", i));
//            empInfoDummy.setEmpInfoEmail("employee" + i+1 + "@example.com");
//            empInfoDummy.setEmpInfoJoinDt(LocalDate.now());
//            empInfoDummy.setEmpInfoQuitDt(LocalDate.now().plusMonths(i)); // 퇴사일을 현재일로부터 i개월 후로 설정
//            empInfoDummy.setEmpInfoBank("Bank " + i);
//            empInfoDummy.setEmpInfoAccountNo("123-456-" + String.format("%04d", i+1));
//            empInfos.add(empInfoDummy);
//        }
//        return empInfos;
//    }
//
//}
@Component
public class EmpInfoDummyDataGenerator {

    @Autowired
    private EmpInfoRepository empInfoRepository;

    @Autowired
    private DepartRepository departRepository;

    @Autowired
    private PositionRepository positionRepository;

    @PostConstruct
    public void generateDummyData() {
        // Create dummy departments and positions first
        DepartEntity departEntity = new DepartEntity();
        departEntity.setDepartNm("인사");
        departRepository.save(departEntity);

        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setPositionNm("사원");
        positionRepository.save(positionEntity);

        // Create dummy employees with references to the departments and positions
        List<EmpInfoEntity> dummyEmpInfo = createDummyEmpInfo(departEntity, positionEntity);
        empInfoRepository.saveAll(dummyEmpInfo);
    }

    private List<EmpInfoEntity> createDummyEmpInfo(DepartEntity departEntity, PositionEntity positionEntity) {
        List<EmpInfoEntity> empInfos = new ArrayList<>();
        String[] name = {"임호진", "천준호", "임지환", "이상효", "김선진", "이동규", "서준하", "김예은", "김영훈", "박종현","서주완","박주성",
                "김태일","김가을","서예성","조현주","황정은","김세중","이충현","박박박"};
        for (int i = 0; i < 20; i++) {
            EmpInfoEntity empInfoDummy = new EmpInfoEntity();
            empInfoDummy.setEmpInfoPw("" + i);
            empInfoDummy.setEmpInfoNm(name[i]);
            empInfoDummy.setEmpInfoSex(i % 2 == 0);
            empInfoDummy.setEmpInfoBirth(LocalDate.of(1990 + i, 1, 1));
            empInfoDummy.setEmpInfoAddr("수원시 권선구");
            empInfoDummy.setEmpInfoPhone("123-456-" + String.format("%04d", i));
            empInfoDummy.setEmpInfoEmail("employee" + (i + 1) + "@example.com");
            empInfoDummy.setEmpInfoJoinDt(LocalDate.now());
            empInfoDummy.setEmpInfoQuitDt(LocalDate.now().plusMonths(i));
            empInfoDummy.setEmpInfoBank("Bank " + i);
            empInfoDummy.setEmpInfoAccountNo("123-456-" + String.format("%04d", i + 1));
            empInfoDummy.setDepartEntity(departEntity);
            empInfoDummy.setPositionEntity(positionEntity);
            empInfos.add(empInfoDummy);
        }
        return empInfos;
    }
}