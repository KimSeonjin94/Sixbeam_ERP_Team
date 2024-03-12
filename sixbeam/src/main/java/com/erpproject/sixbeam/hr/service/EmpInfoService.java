package com.erpproject.sixbeam.hr.service;


import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpInfoService {
    private final EmpInfoRepository empInfoRepository;

    public List<EmpInfoEntity> getList() {
        return this.empInfoRepository.findAll();
    }

    public void deleteEmployee(List<Long> empInfoIds) {
        for (Long empInfoId : empInfoIds) {
            this.empInfoRepository.deleteById(empInfoId);
        }
    }

    public void createEmployee(
            String empInfoPw,
            String empInfoNm,
            boolean empInfoSex,
            LocalDate empInfoBirth,
            String empInfoAddr,
            String empInfoPhone,
            String empInfoEmail,
            LocalDate empInfoJoinDt,
            LocalDate empInfoQuitDt,
            PositionEntity positionCd,
            DepartEntity departCd,
            String empInfoBank,
            String empInfoAccountNo,
            String empInfoQr,
            int empInfoTotalnoy,
            String empInfoEtc) {

        EmpInfoEntity empInfoEntity = new EmpInfoEntity();

        // 설정할 값들을 세팅
        empInfoEntity.setEmpInfoPw(empInfoPw);
        empInfoEntity.setEmpInfoNm(empInfoNm);
        empInfoEntity.setEmpInfoSex(empInfoSex);
        empInfoEntity.setEmpInfoBirth(empInfoBirth);
        empInfoEntity.setEmpInfoAddr(empInfoAddr);
        empInfoEntity.setEmpInfoPhone(empInfoPhone);
        empInfoEntity.setEmpInfoEmail(empInfoEmail);
        empInfoEntity.setEmpInfoJoinDt(empInfoJoinDt);
        empInfoEntity.setEmpInfoQuitDt(empInfoQuitDt);
        empInfoEntity.setPositionEntity(positionCd);
        empInfoEntity.setDepartEntity(departCd);
        empInfoEntity.setEmpInfoBank(empInfoBank);
        empInfoEntity.setEmpInfoAccountNo(empInfoAccountNo);
        empInfoEntity.setEmpInfoQr(empInfoQr);
        empInfoEntity.setEmpInfoTotalnoy(empInfoTotalnoy);
        empInfoEntity.setEmpInfoEtc(empInfoEtc);
        empInfoRepository.save(empInfoEntity);
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
            PositionEntity positionCd,
            DepartEntity departCd,
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
        empInfoEntity.setPositionEntity(positionCd);
        empInfoEntity.setDepartEntity(departCd);
        empInfoEntity.setEmpInfoBank(empInfoBank);
        empInfoEntity.setEmpInfoAccountNo(empInfoAccountNo);
        empInfoEntity.setEmpInfoQr(empInfoQr);
        empInfoEntity.setEmpInfoTotalnoy(empInfoTotalnoy);
        empInfoEntity.setEmpInfoEtc(empInfoEtc);
        empInfoRepository.save(empInfoEntity);
    }
    public String findEmpInfoPasswordById(Long empInfoId) {
        // 해당 아이디에 대한 비밀번호 조회 로직
        EmpInfoEntity emp = empInfoRepository.findByEmpInfoId(empInfoId).orElse(null);
        return (emp != null) ? emp.getEmpInfoPw() : null;
    }
    public void changeEmpInfoPasswordById(Long empInfoId, String newPassword){
        Optional<EmpInfoEntity>empInfoEntity = empInfoRepository.findByEmpInfoId(empInfoId);
        empInfoEntity.ifPresent(empInfo->{
            empInfo.setEmpInfoPw(newPassword);
            empInfoRepository.save(empInfo);
        });
    }
}
