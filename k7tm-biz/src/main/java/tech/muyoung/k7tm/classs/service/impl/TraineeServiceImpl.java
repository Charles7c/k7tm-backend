/*
 *  Copyright 2020 Charles7c
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package tech.muyoung.k7tm.classs.service.impl;

import tech.muyoung.k7tm.classs.domain.Trainee;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import tech.muyoung.k7tm.classs.repository.TraineeRepository;
import tech.muyoung.k7tm.classs.service.TraineeService;
import tech.muyoung.k7tm.classs.service.dto.TraineeDto;
import tech.muyoung.k7tm.classs.service.dto.TraineeQueryCriteria;
import tech.muyoung.k7tm.classs.service.mapstruct.TraineeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Charles7c
 * @date 2020-08-19
 */
@Service
@RequiredArgsConstructor
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepository traineeRepository;
    private final TraineeMapper traineeMapper;

    @Override
    public Map<String,Object> queryAll(TraineeQueryCriteria criteria, Pageable pageable){
        Page<Trainee> page = traineeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(traineeMapper::toDto));
    }

    @Override
    public List<TraineeDto> queryAll(TraineeQueryCriteria criteria){
        return traineeMapper.toDto(traineeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public TraineeDto findById(Long id) {
        Trainee trainee = traineeRepository.findById(id).orElseGet(Trainee::new);
        ValidationUtil.isNull(trainee.getId(),"Trainee","id",id);
        return traineeMapper.toDto(trainee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TraineeDto create(Trainee resources) {
        return traineeMapper.toDto(traineeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Trainee resources) {
        Trainee trainee = traineeRepository.findById(resources.getId()).orElseGet(Trainee::new);
        ValidationUtil.isNull( trainee.getId(),"Trainee","id",resources.getId());
        trainee.copy(resources);
        traineeRepository.save(trainee);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            traineeRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<TraineeDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TraineeDto trainee : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("学号(未开放)", trainee.getUuid());
            map.put("姓名", trainee.getName());
            map.put("手机号", trainee.getPhone());
            map.put("邮箱", trainee.getEmail());
            map.put("身份证号", trainee.getIdentityCard());
            map.put("性别", trainee.getGender());
            map.put("出生日期", trainee.getBornDate());
            map.put("籍贯省份", trainee.getProvinceId());
            map.put("籍贯城市", trainee.getCityId());
            map.put("了解渠道", trainee.getSource());
            map.put("推荐学员", trainee.getReferrerStu());
            map.put("推荐老师", trainee.getReferrerTeacher());
            map.put("报名时间", trainee.getRegistrationTime());
            map.put("报名课程", trainee.getCourseId());
            map.put("缴费金额", trainee.getPayAmount());
            map.put("费用来源", trainee.getCostSource());
            map.put("家长称谓", trainee.getContactName());
            map.put("家长电话", trainee.getContactPhone());
            map.put("需要就业", trainee.getNeedEmployment());
            map.put("期望就业城市", trainee.getEmploymentIntentionsCity());
            map.put("所在校区(部门)", trainee.getSchoolId());
            map.put("所在班级", trainee.getClassId());
            map.put("进班时间", trainee.getEnterClassTime());
            map.put("学习状态", trainee.getStatus());
            map.put("剩余课时(一对一)", trainee.getClassHour());
            map.put("最高学历", trainee.getEducation());
            map.put("毕业院校", trainee.getGraduateInstitutions());
            map.put("学历专业", trainee.getMajor());
            map.put("英语水平", trainee.getEnglishLevel());
            map.put("需要学历", trainee.getNeedEdu());
            map.put("专业基础情况", trainee.getBasisStatus());
            map.put("咨询老师", trainee.getAdvisoryTeacher());
            map.put("学员描述", trainee.getTraineeDesc());
            map.put("学前工作经历", trainee.getWorkHistory());
            map.put("特殊承诺", trainee.getSpecialCommitment());
            map.put("学历照片", trainee.getDegreeInPhoto());
            map.put("身份证正面", trainee.getIdentityCardPhotoFront());
            map.put("身份证反面", trainee.getIdentityCardPhotoBack());
            map.put("结课时间", trainee.getGraduateTime());
            map.put("资料完善度", trainee.getDataIntegrity());
            map.put("访谈状态", trainee.getInterviewStatus());
            map.put("最后访谈时间", trainee.getLastInterviewTime());
            map.put("微信号", trainee.getWechatId());
            map.put("QQ号", trainee.getQqId());
            map.put("创建者", trainee.getCreateBy());
            map.put("更新者", trainee.getUpdateBy());
            map.put("创建时间", trainee.getCreateTime());
            map.put("更新时间", trainee.getUpdateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}