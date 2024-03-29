package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EA_CERT")
@DiscriminatorValue("증명서 신청")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EACert extends EADocument {

    @Column(name = "CERT_CATEGORY")
    private String certCategory;

    @Column(name = "CERT_REQUIRE_COUNT")
    private Integer certRequireCount;
}
