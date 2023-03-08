package com.hotsix.titans.member.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.ProfileImageDTO;
import com.hotsix.titans.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "회원 조회 요청", description = "회원 한명이 조회됩니다.", tags = { "MemberController" })
    @GetMapping("/members/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMyMemberInfo(@PathVariable String memberCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", memberService.selectMyInfo(memberCode)));
    }

//    @PostMapping(value = "/members")
//    public ResponseEntity<ResponseDTO> registMember(@ModelAttribute MemberDTO memberDTO, MultipartFile memberImage) {
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "신규 사원 등록 성공",  memberService.registMember(memberDTO, memberImage)));
//    }



}