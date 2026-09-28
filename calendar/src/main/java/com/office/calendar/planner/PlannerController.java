package com.office.calendar.planner;

import com.office.calendar.planner.util.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/planner")
@RequiredArgsConstructor
public class PlannerController {

    final private PlannerService plannerService;
    final private UploadFileService uploadFileService;

    @GetMapping({"", "/"})
    public String home() {
        log.info("home()");

        String nextPage = "planner/home";

        return nextPage;
    }

    @PostMapping("/plan")
    public ResponseEntity<Map<String, Object>> writePlan(
            PlannerDto plannerDto,
            @RequestParam("file") MultipartFile file,
            Principal principal) {
        log.info("writePlan()");

        String signinedMemberID = principal.getName();

        // SAVE FILE
        String savedFileName = uploadFileService.upload("gildong", file);
        if (savedFileName != null) {
            plannerDto.setImg_name(savedFileName);
            plannerDto.setOwner_id(savedFileName);

            Map<String, Object> resultMap = plannerService.writePlan(plannerDto);
            return ResponseEntity.ok(resultMap);

        } else {
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("MESSAGE", "FILE UPLOAD FAILED");
            return ResponseEntity.badRequest().body(null);
        }
    }

}
