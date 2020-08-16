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

import tech.muyoung.k7tm.classs.domain.Classs;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import tech.muyoung.k7tm.classs.repository.ClasssRepository;
import tech.muyoung.k7tm.classs.service.ClasssService;
import tech.muyoung.k7tm.classs.service.dto.ClasssDto;
import tech.muyoung.k7tm.classs.service.dto.ClasssQueryCriteria;
import tech.muyoung.k7tm.classs.service.mapstruct.ClasssMapper;
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
 * @date 2020-08-16
 */
@Service
@RequiredArgsConstructor
public class ClasssServiceImpl implements ClasssService {

    private final ClasssRepository classsRepository;
    private final ClasssMapper classsMapper;

    @Override
    public Map<String,Object> queryAll(ClasssQueryCriteria criteria, Pageable pageable){
        Page<Classs> page = classsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(classsMapper::toDto));
    }

    @Override
    public List<ClasssDto> queryAll(ClasssQueryCriteria criteria){
        return classsMapper.toDto(classsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ClasssDto findById(Long classId) {
        Classs classs = classsRepository.findById(classId).orElseGet(Classs::new);
        ValidationUtil.isNull(classs.getClassId(),"Classs","classId",classId);
        return classsMapper.toDto(classs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClasssDto create(Classs resources) {
        return classsMapper.toDto(classsRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Classs resources) {
        Classs classs = classsRepository.findById(resources.getClassId()).orElseGet(Classs::new);
        ValidationUtil.isNull( classs.getClassId(),"Classs","id",resources.getClassId());
        classs.copy(resources);
        classsRepository.save(classs);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long classId : ids) {
            classsRepository.deleteById(classId);
        }
    }

    @Override
    public void download(List<ClasssDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ClasssDto classs : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("名称", classs.getName());
            map.put("类型", classs.getType());
            map.put("状态", classs.getStatus());
            map.put("现有人数", classs.getStuNum());
            map.put("转班人数", classs.getClassTransferNum());
            map.put("休学人数", classs.getTemporaryAbsenceNum());
            map.put("退学人数", classs.getRefundNum());
            map.put("开除人数", classs.getExpelNum());
            map.put("课程类型", classs.getCourseId());
            map.put("职业顾问", classs.getVcTeacher());
            map.put("技术顾问", classs.getTaTeacher());
            map.put("项目经理", classs.getPmTeacher());
            map.put("开班时间", classs.getClassTime());
            map.put("毕业时间", classs.getGraduateTime());
            map.put("班级描述", classs.getDesc());
            map.put("创建者", classs.getCreateBy());
            map.put("更新者", classs.getUpdateBy());
            map.put("创建日期", classs.getCreateTime());
            map.put("更新时间", classs.getUpdateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}