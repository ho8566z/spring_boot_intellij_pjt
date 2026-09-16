package com.office.memberservice.sign;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    final private String CLASS_NAME = "[MemberService] ";

    final private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;

    }

    public void sign_up_confirm(MemberDto memberDto) {
        System.out.println(CLASS_NAME.concat("sign_up_confirm()"));

        memberDao.insert_new_member(memberDto);

    }

    public void sign_in_confirm(MemberDto memberDto) {
        System.out.println(CLASS_NAME.concat("sign_in_confirm()"));

        memberDao.select_member(memberDto);

    }

}
