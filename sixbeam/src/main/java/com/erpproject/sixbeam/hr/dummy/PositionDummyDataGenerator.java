package com.erpproject.sixbeam.hr.dummy;


import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

@Component
public class PositionDummyDataGenerator {



    @Autowired
    private PositionRepository positionRepository;

    @PostConstruct
    public void generateDummyData() {
        List<PositionEntity> dummyPositions = createDummyPositions();
        positionRepository.saveAll(dummyPositions);
    }
    private List<PositionEntity> createDummyPositions() {
        List<PositionEntity> positions = new ArrayList<>();
        List<String>frog = new ArrayList<>();
        frog.add("사원");
        frog.add("주임");
        frog.add("대리");
        frog.add("과장");
        frog.add("차장");
        frog.add("부장");
        Random random = new Random();
        for (int i = 0; i < frog.size(); i++) {
            PositionEntity position = new PositionEntity();
            position.setPositionNm(frog.get(i));
            positions.add(position);
        }
        return positions;
    }
}
