package com.erpproject.sixbeam.main;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final EmpInfoRepository empInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmpInfoEntity> emp = empInfoRepository.findByEmpInfoId(Long.parseLong(username));
        if (!emp.isPresent()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        EmpInfoEntity empInfoEntity = emp.get();
        String encodedPassword = empInfoEntity.getEmpInfoPw();

        // 권한 추가
        List<GrantedAuthority> authorities = new ArrayList<>();
        String departmentRole = empInfoEntity.getDepartmentRole();
        switch(departmentRole){
            case "HR":
                authorities.add(new SimpleGrantedAuthority(UserRole.HR.getDisplayName()));
                break;
            case "PRODUCTION":
                authorities.add(new SimpleGrantedAuthority(UserRole.PRODUCTION.getDisplayName()));
                break;
            case "INVENTORY":
                authorities.add(new SimpleGrantedAuthority(UserRole.INVENTORY.getDisplayName()));
                break;
            case "SALES":
                authorities.add(new SimpleGrantedAuthority(UserRole.SALES.getDisplayName()));
                break;
            case "PURCHASE":
                authorities.add(new SimpleGrantedAuthority(UserRole.PURCHASE.getDisplayName()));
                break;
            case "ACCOUNTING":
                authorities.add(new SimpleGrantedAuthority(UserRole.ACCOUNTING.getDisplayName()));
                break;
            default:
                return null;
        }
        if (departmentRole != null) {
            authorities.add(new SimpleGrantedAuthority(departmentRole));
        }
        return new User(username,encodedPassword,authorities);
    }
}
