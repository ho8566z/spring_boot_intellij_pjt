package com.office.calendar.planner;

import com.office.calendar.planner.jpa.PlannerEntity;
import com.office.calendar.planner.jpa.PlannerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.generic.LocalVariableGen;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlannerService {

    final public int PLAN_REGISTE_SUCCESS   = 1;
    final public int PLAN_REGISTE_FAIL      = 0;

    final private PlannerRepository plannerRepository;

    // 일정 등록하기
    public Map<String, Object> writePlan(PlannerDto plannerDto) {
        log.info("writePlan()");

        Map<String, Object> resultMap = new HashMap<>();

        int result = PLAN_REGISTE_FAIL;
        plannerDto.setOri_owner_id(plannerDto.getOwner_id());
        PlannerEntity savedPlannerEntity = plannerRepository.save(plannerDto.toEntity());
        if (savedPlannerEntity != null) {
            savedPlannerEntity.setPlanOriNo(savedPlannerEntity.getPlanNo());
            plannerRepository.save(savedPlannerEntity);

            log.info("INSERT NEW PLAN SUCCESS");
            result = PLAN_REGISTE_SUCCESS;
        } else {
            log.info("INSERT NEW PLAN FAIL");
            resultMap.put
        }




        return resultMap;
    }
}
