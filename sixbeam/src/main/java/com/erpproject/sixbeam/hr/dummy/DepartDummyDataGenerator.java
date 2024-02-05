package com.erpproject.sixbeam.hr.dummy;

import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

@Component
public class DepartDummyDataGenerator {



    @Autowired
    private DepartRepository departRepository;

    @PostConstruct
    public List<DepartEntity> generateDummyData() {
        List<DepartEntity> dummyDepart = createDummyDepart();
        departRepository.saveAll(dummyDepart);
        return dummyDepart;
    }
    private List<DepartEntity> createDummyDepart() {
        List<DepartEntity> departs = new ArrayList<>();
        List<String>frog = new ArrayList<>();
        frog.add("인사");
        frog.add("생산");
        frog.add("재고");
        frog.add("영업");
        frog.add("구매");
        frog.add("회계");

        for (int i = 0; i < frog.size(); i++) {
            DepartEntity departDummy = new DepartEntity();
            departDummy.setDepartNm(frog.get(i));
            departs.add(departDummy);
        }
        return departs;
    }
}
