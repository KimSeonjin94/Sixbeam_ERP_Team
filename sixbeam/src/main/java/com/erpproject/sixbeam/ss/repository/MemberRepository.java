package com.erpproject.sixbeam.ss.repository;

import com.erpproject.sixbeam.ss.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,String> {
}
