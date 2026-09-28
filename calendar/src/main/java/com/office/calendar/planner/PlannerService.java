package com.office.calendar.planner;

import com.office.calendar.planner.jpa.PlannerEntity;
import com.office.calendar.planner.jpa.PlannerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlannerService {

    final public int PLAN_REGISTE_SUCCESS = 1;
    final public int PLAN_REGISTE_FAIL = 0;

    final private PlannerRepository plannerRepository;

    // 일정 등록
    public Map<String, Object> writePlan(PlannerDto plannerDto) {
        log.info("writePlan()");

        Map<String, Object> resultMap = new HashMap<>();

        int result = PLAN_REGISTE_FAIL;
        plannerDto.setOri_owner_id(plannerDto.getOwner_id());
        PlannerEntity savedPlannerEntity = plannerRepository.save(plannerDto.toEntity());
        if (savedPlannerEntity != null) {
            savedPlannerEntity.setPlanOriNo(savedPlannerEntity.getPlanNo());
            plannerRepository.save(savedPlannerEntity);

            log.info("INSERT NEW PLAN SUCCESS!!");
            result = PLAN_REGISTE_SUCCESS;

        } else {
            log.info("INSERT NEW PLAN FAIL!!");

        }

        resultMap.put("result", result);

        return resultMap;

    }

    public Map<String, Object> getPlans(Map<String, Object> reqData) {
        log.info("getPlans()");

        Map<String, Object> resultMap = new HashMap<>();

        List<PlannerEntity> plannerEntities = plannerRepository.findByPlanYearAndPlanMonthAndPlanOwnerId(
                Integer.valueOf(String.valueOf(reqData.get("year"))),
                Integer.valueOf(String.valueOf(reqData.get("month"))),
                String.valueOf(reqData.get("owner_id"))
        );

        List<PlannerDto> plannerDtos = plannerEntities.stream()
                .map(PlannerEntity::toDto)
                .collect(Collectors.toList());

        resultMap.put("plans", plannerDtos);

        return resultMap;

    }

    public Map<String, Object> getPlan(Map<String, Object> reqData) {
        log.info("getPlan()");

        Map<String, Object> resultMap = new HashMap<>();

        PlannerDto plannerDto =
                plannerRepository.findByPlanNo(Integer.valueOf(String.valueOf(reqData.get("no")))).toDto();

        resultMap.put("plan", plannerDto);

        return resultMap;

    }
}
