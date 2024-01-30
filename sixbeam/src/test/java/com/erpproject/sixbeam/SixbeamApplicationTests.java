package com.erpproject.sixbeam;

import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SixbeamApplicationTests {

	@Autowired
	private WhregistRepository whregistRepository;

	@Test
	void testwhregist() {
		WhregistEntity add1 = new WhregistEntity();
		add1.setwhregistCd("00001");
		add1.setwhregistNm("재무/회계");
		this.whregistRepository.save(add1);
		WhregistEntity add2 = new WhregistEntity();
		add2.setwhregistCd("00002");
		add2.setwhregistNm("인사");
		this.whregistRepository.save(add2);
		WhregistEntity add3 = new WhregistEntity();
		add3.setwhregistCd("00003");
		add3.setwhregistNm("IT");
		this.whregistRepository.save(add3);
		WhregistEntity add4 = new WhregistEntity();
		add4.setwhregistCd("00004");
		add4.setwhregistNm("마케팅");
		this.whregistRepository.save(add4);
		WhregistEntity add5 = new WhregistEntity();
		add5.setwhregistCd("00005");
		add5.setwhregistNm("영업");
		this.whregistRepository.save(add5);
		WhregistEntity add6 = new WhregistEntity();
		add6.setwhregistCd("00006");
		add6.setwhregistNm("생산");
		this.whregistRepository.save(add6);
		WhregistEntity add7 = new WhregistEntity();
		add7.setwhregistCd("00007");
		add7.setwhregistNm("물류");
		this.whregistRepository.save(add7);

	}

}
