package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceHrRepository extends JpaRepository<AttendanceHR, String> {
    Page<AttendanceHR> findByMemberCode(Pageable pageable, String memberCode);
}

