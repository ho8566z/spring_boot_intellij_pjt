package com.office.memberservice.sign;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

    final private String CLASS_NAME = "[MemberDao] ";

    public void insert_new_member(MemberDto memberDto) {
        System.out.println(CLASS_NAME.concat("insert_new_member()"));

        System.out.println("memberDto : " + memberDto);
        System.out.println("memberDto getMember_id : " + memberDto.getMember_id());
        System.out.println("memberDto getMember_pw : " + memberDto.getMember_pw());
        System.out.println("memberDto getMember_name : " + memberDto.getMember_name());
        System.out.println("memberDto getMember_mail : " + memberDto.getMember_mail());

    }

    public void select_member(MemberDto memberDto) {
        System.out.println(CLASS_NAME.concat("select_member()"));

        System.out.println("memberDto : " + memberDto);
        System.out.println("memberDto getMember_id : " + memberDto.getMember_id());
        System.out.println("memberDto getMember_pw : " + memberDto.getMember_pw());

    }

}
