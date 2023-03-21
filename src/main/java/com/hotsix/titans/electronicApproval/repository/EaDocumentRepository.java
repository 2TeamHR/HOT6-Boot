package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaApproverInfo;
import com.hotsix.titans.electronicApproval.entity.EaDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaDocumentRepository extends JpaRepository <EaDocument, String>{

    List<EaDocument> findAllByOrderByEaCodeDesc();

    EaDocument findByEaCode(String eaCode);

    List<EaDocument> findByEaStatusCodeAndMemberCode(String eaStatusCode, String memberCode);

    List<EaDocument> findAllByMemberCode (String memberCode);

    List<EaDocument> findAllByEaStatusCodeAndEaCodeIn(String eaStatusCode, List<String> eaCodes);
}
