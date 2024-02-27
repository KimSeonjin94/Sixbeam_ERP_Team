//package com.erpproject.sixbeam.main;
//
//import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
//import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class UserSecurityService implements UserDetailsService {
//
//    private final EmpInfoRepository empInfoRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(Long username) throws UsernameNotFoundException {
//        Optional<EmpInfoEntity> emp = this.empInfoRepository.findByEmpInfoId(username);
//        if (emp.isEmpty()) {
//            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
//        }
//        List<GrantedAuthority> authorities= new ArrayList<>();
//        EmpInfoEntity empInfoEntity = emp.get();
//        String encodedPassword = empInfoEntity.getEmpInfoPw();
//        return new User(username,encodedPassword,authorities);
//    }
//}
