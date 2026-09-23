package com.office.samplepjt.member;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

    final private String CLASS_NAME = "[MemberDao] ";


    public void insertNewMember(MemberDto memberDto) {
        System.out.println(CLASS_NAME.concat("insertNewMember()"));

        System.out.println("memberDto : " + memberDto);
        System.out.println("memberDto getM_id : " + memberDto.getM_id());
        System.out.println("memberDto getM_pw : " + memberDto.getM_pw());
        System.out.println("memberDto getM_mail : " + memberDto.getM_mail());


    }
}
