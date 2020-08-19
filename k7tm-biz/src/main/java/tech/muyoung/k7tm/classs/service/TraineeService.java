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
package tech.muyoung.k7tm.classs.service;

import tech.muyoung.k7tm.classs.domain.Trainee;
import tech.muyoung.k7tm.classs.service.dto.TraineeDto;
import tech.muyoung.k7tm.classs.service.dto.TraineeQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Charles7c
 * @date 2020-08-19
 */
public interface TraineeService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(TraineeQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<TraineeDto>
    */
    List<TraineeDto> queryAll(TraineeQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return TraineeDto
     */
    TraineeDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return TraineeDto
    */
    TraineeDto create(Trainee resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(Trainee resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<TraineeDto> all, HttpServletResponse response) throws IOException;
}