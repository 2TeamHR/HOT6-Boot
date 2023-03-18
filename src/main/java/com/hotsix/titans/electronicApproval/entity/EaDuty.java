package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("예비군 신청")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_DUTY")
@DynamicInsert
public class EaDuty extends EaDocument {

    @Column(name = "DUTY_START_DATE")
    private LocalDate dutyStartDate;

    @Column(name = "DUTY_END_DATE")
    private LocalDate dutyEndDate;

}