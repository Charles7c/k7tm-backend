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
package tech.muyoung.k7tm.base.service.impl;

import tech.muyoung.k7tm.base.domain.Stage;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import tech.muyoung.k7tm.base.repository.StageRepository;
import tech.muyoung.k7tm.base.service.StageService;
import tech.muyoung.k7tm.base.service.dto.StageDto;
import tech.muyoung.k7tm.base.service.dto.StageQueryCriteria;
import tech.muyoung.k7tm.base.service.mapstruct.StageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
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
 * @author Mr_Li
 * @date 2020-08-20
 */
@Service
@RequiredArgsConstructor
public class StageServiceImpl implements StageService {

    private final StageRepository StageRepository;
    private final StageMapper StageMapper;

    @Override
    public Map<String,Object> queryAll(StageQueryCriteria criteria, Pageable pageable){
        Page<Stage> page = StageRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(StageMapper::toDto));
    }

    @Override
    public List<StageDto> queryAll(StageQueryCriteria criteria){
        return StageMapper.toDto(StageRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public StageDto findById(Long id) {
        Stage Stage = StageRepository.findById(id).orElseGet(Stage::new);
        ValidationUtil.isNull(Stage.getId(),"Stage","id",id);
        return StageMapper.toDto(Stage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public StageDto create(Stage resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setId(snowflake.nextId()); 
        return StageMapper.toDto(StageRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Stage resources) {
        Stage Stage = StageRepository.findById(resources.getId()).orElseGet(Stage::new);
        ValidationUtil.isNull( Stage.getId(),"Stage","id",resources.getId());
        Stage.copy(resources);
        StageRepository.save(Stage);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            StageRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<StageDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (StageDto Stage : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("名称", Stage.getName());
            map.put("备注", Stage.getRamark());
            map.put("排序", Stage.getSort());
            map.put("所属课程", Stage.getCourseId());
            map.put("创建人", Stage.getCreateBy());
            map.put("创建时间", Stage.getCreateTime());
            map.put("更新人", Stage.getUpdateBy());
            map.put("更新时间", Stage.getUpdateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}