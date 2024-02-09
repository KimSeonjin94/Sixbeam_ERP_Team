package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.dto.EmpInfoDto;
import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpInfoService {
    private final EmpInfoRepository empInfoRepository;

    public List<EmpInfoEntity> getList(){
        return this.empInfoRepository.findAll();
    }
    public void updateEmployee(
            Long empInfoId,
            String empInfoPw,
            String empInfoNm,
            boolean empInfoSex,
            LocalDate empInfoBirth,
            String empInfoAddr,
            String empInfoPhone,
            String empInfoEmail,
            LocalDate empInfoJoinDt,
            LocalDate empInfoQuitDt,
//            PositionEntity positionNm,
//            DepartEntity departNm,
            String empInfoBank,
            String empInfoAccountNo,
            String empInfoQr,
            int empInfoTotalnoy,
            String empInfoEtc) {

        EmpInfoEntity empInfoEntity = empInfoRepository.findById(empInfoId)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + empInfoId + " not found"));

        // 업데이트 로직을 수행하고 저장
        empInfoEntity.setEmpInfoPw(empInfoPw);
        empInfoEntity.setEmpInfoNm(empInfoNm);
        empInfoEntity.setEmpInfoSex(empInfoSex);
        empInfoEntity.setEmpInfoBirth(empInfoBirth);
        empInfoEntity.setEmpInfoAddr(empInfoAddr);
        empInfoEntity.setEmpInfoPhone(empInfoPhone);
        empInfoEntity.setEmpInfoEmail(empInfoEmail);
        empInfoEntity.setEmpInfoJoinDt(empInfoJoinDt);
        empInfoEntity.setEmpInfoQuitDt(empInfoQuitDt);
//        empInfoEntity.setPositionEntity(positionEntity);
//        empInfoEntity.setDepartEntity(departEntity);
        empInfoEntity.setEmpInfoBank(empInfoBank);
        empInfoEntity.setEmpInfoAccountNo(empInfoAccountNo);
        empInfoEntity.setEmpInfoQr(empInfoQr);
        empInfoEntity.setEmpInfoTotalnoy(empInfoTotalnoy);
        empInfoEntity.setEmpInfoEtc(empInfoEtc);

        empInfoRepository.save(empInfoEntity);
    }


}
