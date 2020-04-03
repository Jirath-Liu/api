package com.kelab.api.service;

import cn.wzy.verifyUtils.annotation.Verify;
import com.kelab.info.base.JsonAndModel;
import com.kelab.info.base.constant.StatusMsgConstant;
import com.kelab.info.context.Context;
import com.kelab.info.experiment.info.ExperimentClassInfo;
import com.kelab.info.experiment.info.ExperimentStudentInfo;
import com.kelab.info.experiment.query.ExperimentStudentQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "service-experiment")
@RequestMapping("/experiment")
public interface ExperimentCenterService {
    /**
     * 查询所有班级
     */
    @GetMapping("/experiment/class.do")
    JsonAndModel queryPage(@RequestParam Map<String, Object> param);

    /**
     * 开设班级
     */
    @PostMapping("/experiment/class.do")
    JsonAndModel createExperimentClass(@RequestParam Map<String, Object> param,
                                       @RequestBody ExperimentClassInfo record);

    /**
     * 更新班级信息
     */
    @PutMapping("/experiment/class.do")
    JsonAndModel updateExperimentClass(@RequestParam Map<String, Object> param,
                                       @RequestBody ExperimentClassInfo record);

    /**
     * 删除班级
     */
    @DeleteMapping("/experiment/class.do")
    JsonAndModel deleteExperimentClass(@RequestParam Map<String, Object> param);

    /**
     * 查询班级学生
     */
    @GetMapping("/experiment/class/student.do")
    JsonAndModel queryStudentPage(@RequestParam Map<String, Object> param);

    /**
     * 申请加班
     */
    @PostMapping("/experiment/class/student.do")
    JsonAndModel applyClass(@RequestParam Map<String, Object> param);

    /**
     * 教师审核学生
     */
    @PutMapping("/experiment/class/student.do")
    JsonAndModel reviewStudentApply(@RequestParam Map<String, Object> param,
                                  @RequestBody ExperimentStudentInfo record);
}
