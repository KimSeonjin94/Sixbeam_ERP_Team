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
    }
}
