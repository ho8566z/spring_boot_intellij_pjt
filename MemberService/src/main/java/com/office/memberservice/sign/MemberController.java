package com.office.memberservice.sign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    final private String CLASS_NAME = "[MemberController] ";

    final private MemberService memberService;
    private final MemberDao memberDao;

    public MemberController(MemberService memberService, MemberDao memberDao) {
        this.memberService = memberService;
        this.memberDao = memberDao;
    }

    @GetMapping("/member/sign_up")
    public String sign_up() {
        System.out.println(CLASS_NAME.concat("sign_up()"));

        String nextPage = "member/sign_up";

        return nextPage;

    }

    @PostMapping("/member/sign_up_confirm")
    public String sign_up_confirm(MemberDto memberDto) {
        System.out.println(CLASS_NAME.concat("sign_up_confirm()"));

        String nextPage = "member/sign_up_ok";

        memberService.sign_up_confirm(memberDto);

        return nextPage;

    }

    @GetMapping("/member/sign_in")
    public String sign_in() {
        System.out.println(CLASS_NAME.concat("sign_in()"));

        String nextPage = "member/sign_in";

        return nextPage;

    }

    @PostMapping("/member/sign_in_confirm")
    public String sign_in_confirm(MemberDto memberDto) {
        System.out.println(CLASS_NAME.concat("sign_in_confirm()"));

        String nextPage = "member/sign_in_ok";

        memberService.sign_in_confirm(memberDto);

        return nextPage;

    }

}
