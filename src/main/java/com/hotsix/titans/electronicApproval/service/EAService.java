package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.electronicApproval.dto.EADocumentDTO;
import com.hotsix.titans.electronicApproval.dto.EALeaveDTO;
import com.hotsix.titans.electronicApproval.dto.EASalaryDTO;
import com.hotsix.titans.electronicApproval.dto.EALoaDTO;
import com.hotsix.titans.electronicApproval.entity.EADocument;
import com.hotsix.titans.electronicApproval.entity.EALeave;
import com.hotsix.titans.electronicApproval.entity.EALoa;
import com.hotsix.titans.electronicApproval.entity.EASalary;
import com.hotsix.titans.electronicApproval.repository.EADocumentRepository;
import com.hotsix.titans.electronicApproval.repository.EALeaveRepository;
import com.hotsix.titans.electronicApproval.repository.EALoaRepository;
import com.hotsix.titans.electronicApproval.repository.EASalaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EAService {

    private final EADocumentRepository eaDocumentRepository;
    private final EASalaryRepository eaSalaryRepository;
    private final EALeaveRepository eaLeaveRepository;
    private final EALoaRepository eaLoaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EAService(EADocumentRepository eaDocumentRepository, EASalaryRepository eaSalaryRepository, EALeaveRepository eaLeaveRepository, EALoaRepository eaLoaRepository, ModelMapper modelMapper) {
        this.eaDocumentRepository = eaDocumentRepository;
        this.eaSalaryRepository = eaSalaryRepository;
        this.eaLeaveRepository = eaLeaveRepository;
        this.eaLoaRepository = eaLoaRepository;
        this.modelMapper = modelMapper;
    }


    /**
     * 전자결재 전체 목록 조회하는 메소드
     */
    public Object selectAllDocument() {
        List<EADocument> eaList = eaDocumentRepository.findAll();
        return eaList.stream().map(eaDocument -> modelMapper.map(eaDocument, EADocumentDTO.class)).collect(Collectors.toList());
    }


    /**
     * 전자결재 휴가신청 전체 목록 조회하는 메소드
     */
    public Object selectAllLeave() {
        List<EALeave> eaLeaveList = eaLeaveRepository.findAll();
        return eaLeaveList.stream().map(eaLeave -> modelMapper.map(eaLeave, EALeaveDTO.class)).collect(Collectors.toList());
    }


    /**
     * 전자결재 단일 건을 조회하는 메소드
     *
     * @param eaCode 전자결재 pk값
     * @return
     */
    public Object selectDocumentCode(String eaCode) {
        EADocument eaDocument = eaDocumentRepository.findByEaCode(eaCode);

        return modelMapper.map(eaDocument, EADocumentDTO.class);
    }


    /**
     * 전자결재 급여정정 전체 목록 조회하는 메소드
     * @return
     */
    public Object selectAllSalary() {
        List<EASalary> eaSalaryList = eaSalaryRepository.findAll();
        return eaSalaryList.stream().map(eaSalary -> modelMapper.map(eaSalary, EASalaryDTO.class)).collect(Collectors.toList());
    }


    /**
     * 전자결재 급여정정 개별 조회하는 메소드
     * @param eaCode
     * @return
     */
    public Object selectSalary(String eaCode) {
        EASalary eaSalary = eaSalaryRepository.findByEaCode(eaCode);
        return modelMapper.map(eaSalary, EASalaryDTO.class);
    }


    /**
     * 전자결재 휴가신청 기안하는 메소드
     * @param eaLeaveDTO
     * @return
     */
    @Transactional
    public Object insertLeave(EALeaveDTO eaLeaveDTO) {
        EALeave eaLeave = new EALeave();
        eaLeave.setEaCode(eaLeaveDTO.getEaCode());
        eaLeave.setMemberDraft(eaLeaveDTO.getMemberDraft());
        eaLeave.setMemberMiddleSigner(eaLeaveDTO.getMemberMiddleSigner());
        eaLeave.setMemberFinalSigner(eaLeaveDTO.getMemberFinalSigner());
        eaLeave.setEaSubject(eaLeaveDTO.getEaSubject());
        eaLeave.setEaDetail(eaLeaveDTO.getEaDetail());
        eaLeave.setEaCategory(eaLeaveDTO.getEaCategory());
        eaLeave.setEaDate(eaLeaveDTO.getEaDate());
        eaLeave.setEaDraftStatus(eaLeaveDTO.getEaDraftStatus());
        eaLeave.setEaMiddleStatus(eaLeaveDTO.getEaMiddleStatus());
        eaLeave.setEaMiddleComment(eaLeaveDTO.getEaMiddleComment());
        eaLeave.setEaFinalStatus(eaLeaveDTO.getEaFinalStatus());
        eaLeave.setEaFinalComment(eaLeaveDTO.getEaFinalComment());
        eaLeave.setEaDocuStatus(eaLeaveDTO.getEaDocuStatus());
        eaLeave.setIsDeleted(eaLeaveDTO.getIsDeleted());
        
        eaLeave.setLeaveStartDate(eaLeaveDTO.getLeaveStartDate());
        eaLeave.setLeaveEndDate(eaLeaveDTO.getLeaveEndDate());

        eaLeaveRepository.save(eaLeave);

        int result = 1;
        return result;
    }


    /**
     * 전자결재 급여정정 기안하는 메소드
     * @param eaSalaryDTO
     * @return
     */
    @Transactional
    public Object insertSalary(EASalaryDTO eaSalaryDTO) {
        EASalary eaSalary = new EASalary();
        eaSalary.setEaCode(eaSalaryDTO.getEaCode());
        eaSalary.setMemberDraft(eaSalaryDTO.getMemberDraft());
        eaSalary.setMemberMiddleSigner(eaSalaryDTO.getMemberMiddleSigner());
        eaSalary.setMemberFinalSigner(eaSalaryDTO.getMemberFinalSigner());
        eaSalary.setEaSubject(eaSalaryDTO.getEaSubject());
        eaSalary.setEaDetail(eaSalaryDTO.getEaDetail());
        eaSalary.setEaCategory(eaSalaryDTO.getEaCategory());
//        eaSalary.setEaType(eaSalaryDTO.getEaType());
        eaSalary.setEaDate(eaSalaryDTO.getEaDate());
        eaSalary.setEaDraftStatus(eaSalaryDTO.getEaDraftStatus());
        eaSalary.setEaMiddleStatus(eaSalaryDTO.getEaMiddleStatus());
        eaSalary.setEaMiddleComment(eaSalaryDTO.getEaMiddleComment());
        eaSalary.setEaFinalStatus(eaSalaryDTO.getEaFinalStatus());
        eaSalary.setEaFinalComment(eaSalaryDTO.getEaFinalComment());
        eaSalary.setEaDocuStatus(eaSalaryDTO.getEaDocuStatus());
        eaSalary.setIsDeleted(eaSalaryDTO.getIsDeleted());

        eaSalary.setSalCorrectionDate(eaSalaryDTO.getSalCorrectionDate());

        eaSalaryRepository.save(eaSalary);
        int result = 1;
        return result;
    }


    /**
     * 전자결재 휴가신청 개별 조회하는 메소드
     * @param eaCode
     * @return
     */
    public Object selectLeave(String eaCode) {
        EALeave eaLeave = eaLeaveRepository.findByEaCode(eaCode);
        return modelMapper.map(eaLeave,EALeaveDTO.class);
    }

    public Object selectAllLoa() {
        List<EALoa> eaLoaList = eaLoaRepository.findAll();
        return eaLoaList.stream().map(eaLoa -> modelMapper.map(eaLoa, EALoaDTO.class)).collect(Collectors.toList());
    }
}
