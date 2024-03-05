package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, String> {
    @Query("SELECT MAX(r.releaseCd) FROM ReleaseEntity r WHERE r.releaseDt = :releaseDate")
    String getMaxReleaseCd(@Param("releaseDate") LocalDate releaseDate);

    List<ReleaseEntity> findByReleaseCd(String releaseCd);

}
