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
package tech.muyoung.k7tm.system.service.impl;

import tech.muyoung.k7tm.system.domain.AreaDict;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import tech.muyoung.k7tm.system.repository.AreaDictRepository;
import tech.muyoung.k7tm.system.service.AreaDictService;
import tech.muyoung.k7tm.system.service.dto.AreaDictDto;
import tech.muyoung.k7tm.system.service.dto.AreaDictQueryCriteria;
import tech.muyoung.k7tm.system.service.mapstruct.AreaDictMapper;
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
 * @date 2020-08-20
 */
@Service
@RequiredArgsConstructor
public class AreaDictServiceImpl implements AreaDictService {

    private final AreaDictRepository areaDictRepository;
    private final AreaDictMapper areaDictMapper;

    @Override
    public Map<String,Object> queryAll(AreaDictQueryCriteria criteria, Pageable pageable){
        Page<AreaDict> page = areaDictRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(areaDictMapper::toDto));
    }

    @Override
    public List<AreaDictDto> queryAll(AreaDictQueryCriteria criteria){
        return areaDictMapper.toDto(areaDictRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public AreaDictDto findById(Long id) {
        AreaDict areaDict = areaDictRepository.findById(id).orElseGet(AreaDict::new);
        ValidationUtil.isNull(areaDict.getId(),"AreaDict","id",id);
        return areaDictMapper.toDto(areaDict);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AreaDictDto create(AreaDict resources) {
        return areaDictMapper.toDto(areaDictRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AreaDict resources) {
        AreaDict areaDict = areaDictRepository.findById(resources.getId()).orElseGet(AreaDict::new);
        ValidationUtil.isNull( areaDict.getId(),"AreaDict","id",resources.getId());
        areaDict.copy(resources);
        areaDictRepository.save(areaDict);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            areaDictRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<AreaDictDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (AreaDictDto areaDict : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("名称", areaDict.getName());
            map.put("父区域编号", areaDict.getParentId());
            map.put("拼音首字母", areaDict.getInitial());
            map.put(" initials",  areaDict.getInitials());
            map.put("拼音", areaDict.getPinyin());
            map.put(" extra",  areaDict.getExtra());
            map.put("后缀", areaDict.getSuffix());
            map.put("行政代码", areaDict.getCode());
            map.put("区号 ", areaDict.getAreaCode());
            map.put("排序", areaDict.getSort());
            map.put("创建者", areaDict.getCreateBy());
            map.put("更新者", areaDict.getUpdateBy());
            map.put("创建时间", areaDict.getCreateTime());
            map.put("更新时间", areaDict.getUpdateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}