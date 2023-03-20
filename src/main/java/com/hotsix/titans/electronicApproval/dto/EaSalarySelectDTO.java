package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.salary.entity.Salary;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EaSalarySelectDTO extends EaDocumentDTO {

    private LocalDate salCorrectionDate;
    private Salary salary;

}