package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.Form.BomForm;
import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.repository.BomRepository;
import com.erpproject.sixbeam.pd.repository.FitemRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.RitemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BomService {

    private final BomRepository bomRepository;
    private final ItemRepository itemRepository;
    private final FitemRepository fitemRepository;
    private final RitemRepository ritemRepository;
    private final ItemService itemService;

    // 모든 품목을 가져오는 메서드
    public List<BomEntity> getList() {

        return bomRepository.findAll();
    }

    public List<BomEntity> getIdList(String id) {

        return bomRepository.findByFitemEntity_ItemCd(id);
    }

    public Optional<ItemEntity> getItemCd(String id) {

        return itemRepository.findById(id);
    }

    public void getBomList(Model model) {

        BomForm bomForm = new BomForm();
        // 데이터 가져오기
        List<BomEntity> getbomEntity = getList();
        List<ItemEntity> getitemEntity = this.itemService.getList();
        // form 데이터 입력란 추가
        bomForm.getBomDtos().add(new BomDto());
        // 모델에 데이터 등록
        model.addAttribute("bomlist", getbomEntity);
        model.addAttribute("getitemlist", getitemEntity);
        // 모든 데이터 뷰페이지 반환
    }


    public void readyBomForm(Model model) {

        BomForm bomForm = new BomForm();

        List<ItemEntity> cpus = this.itemService.getCPU();
        List<ItemEntity> mbs = this.itemService.getMB();
        List<ItemEntity> vgas = this.itemService.getVGA();
        List<ItemEntity> rams = this.itemService.getRAM();
        List<ItemEntity> ssds = this.itemService.getSSD();
        List<ItemEntity> hdds = this.itemService.getHDD();
        List<ItemEntity> powers = this.itemService.getPOWER();
        List<ItemEntity> cases = this.itemService.getCASE();
        // 새로운 폼 생성(폼 페이지의 한 행)
        bomForm.getBomDtos().add(new BomDto());
        // 빈 BomDto를 생성하여 모델에 추가
        model.addAttribute("cpu", cpus);
        model.addAttribute("MB", mbs);
        model.addAttribute("vga", vgas);
        model.addAttribute("ram", rams);
        model.addAttribute("ssd", ssds);
        model.addAttribute("hdd", hdds);
        model.addAttribute("power", powers);
        model.addAttribute("case", cases);
        model.addAttribute("bomForm", bomForm);
        // 저장 후 목록 페이지로 리다이렉트
    }

    public void create(List<BomDto> bomDtos) {

        List<BomEntity> bomEntities = new ArrayList<>();

        for (BomDto bomDto : bomDtos) {

            FitemEntity fitemEntity = fitemRepository.findById(bomDto.getFitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Fitem not found"));
            RitemEntity ritemEntity = ritemRepository.findById(bomDto.getRitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Ritem not found"));

            bomDto.setFitemEntity(fitemEntity);
            bomDto.setRitemEntity(ritemEntity);

            BomEntity bomEntity = bomDto.toEntity();

            bomEntities.add(bomEntity);
        }
        bomRepository.saveAll(bomEntities);
    }

    public void updateAll(List<BomDto> bomDtos) {

        for (BomDto bomDto : bomDtos) {

            FitemEntity fitemEntity = fitemRepository.findById(bomDto.getFitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Fitem not found"));
            RitemEntity ritemEntity = ritemRepository.findById(bomDto.getRitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Ritem not found"));

            bomDto.setFitemEntity(fitemEntity);
            bomDto.setRitemEntity(ritemEntity);

            BomEntity bomEntity = bomDto.toEntity();

            bomRepository.save(bomEntity);
        }
    }

    public ResponseEntity<?> createBomDto(@ModelAttribute BomForm bomForm) {

        List<BomDto> bomDtos = bomForm.getBomDtos();

        try {
            create(bomDtos);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("redirctUrl", "/pd/item/itemlist"));
        } catch (Exception e) {

            Map<String, Object> errorResponse = new HashMap<>();

            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다. 입력화면으로 돌아갑니다");
            errorResponse.put("redirectUrl", "/pd/item/new");

            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    public ResponseEntity<List<BomEntity>> getBomDetails(String itemCd) {

        List<BomEntity> bomEntities = getIdList(itemCd);

        return ResponseEntity.status(HttpStatus.OK).body(bomEntities);
    }

    public void updateBomList(BomForm bomForm) {

        List<BomDto> bomDtos = bomForm.getBomDtos();

        for (BomDto bomDto : bomDtos) {

            FitemEntity fitemEntity = fitemRepository.findById(bomDto.getFitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Fitem not found"));
            RitemEntity ritemEntity = ritemRepository.findById(bomDto.getRitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Ritem not found"));

            bomDto.setFitemEntity(fitemEntity);
            bomDto.setRitemEntity(ritemEntity);

            BomEntity bomEntity = bomDto.toEntity();

            bomRepository.save(bomEntity);
        }
    }
}