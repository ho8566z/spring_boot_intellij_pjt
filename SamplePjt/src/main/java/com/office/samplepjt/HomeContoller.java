package com.office.samplepjt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {

    @GetMapping({"", "/"})
    public String home() {
        System.out.println("[HomeContoller] home()");

        String nextPage = "home";

        return nextPage;

    }

}
