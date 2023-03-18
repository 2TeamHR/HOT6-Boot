package com.hotsix.titans.electronicApproval.entity;

import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "TBL_EA_LOA")
@DiscriminatorValue("휴직신청")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
public class EaLoa extends EaDocument {

    @Column(name = "LOA_DATE")
    private LocalDate loaDate;

    @ManyToOne
    @JoinColumn(name = "LEAVE_CATEGORY_CODE")
    private LeaveCategory leaveCategory;

}