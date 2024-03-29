package com.hotsix.titans.member.dto;

import com.hotsix.titans.attendanceHR.dto.AttendanceHrDTO;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.entity.Salary;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberSalaryDTO implements UserDetails {

    private String memberCode;
    private String memberName;
    private RankDTO rank;
    private TeamDTO team;
    private Long basicSalary;
    private Long mealSalary;
    private Long incomTax;
    private Long healthTax;
    private Long nationalTax;
    private Long totalTax;
    private Long afterSalary;
    private Salary salary;
    private Long beforeSalary;
    private int totalTime;
    private List<SalaryDTO> salaryList;
    private List<AttendanceHrDTO> attendanceHRList;

    /* 이하 코드들을 UserDetails로부터 물려받는 추상메소드들을 오버라이딩 한 것이다.(필요한 것만 작성하자) */
    /* MemberDTO는 Member와 매핑 될 DTO이자 UserDetails로써 속성을 추가로 가짐 */
    private Collection<GrantedAuthority> authorities;

    /* setter 추가할 것 */
    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "MemberSalaryDTO{" +
                "memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", rank=" + rank +
                ", team=" + team +
                ", attendanceHRList=" + attendanceHRList +
                ", authorities=" + authorities +
                '}';
    }
}
