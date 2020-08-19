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

package tech.muyoung.k7tm.classs.rest;

import me.zhengjie.annotation.Log;
import tech.muyoung.k7tm.classs.domain.Trainee;
import tech.muyoung.k7tm.classs.service.TraineeService;
import tech.muyoung.k7tm.classs.service.dto.TraineeQueryCriteria;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Charles7c
 * @date 2020-08-19
 */
@Api(tags = "学员管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainee")
public class TraineeController {

    private final TraineeService traineeService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @PreAuthorize("@el.check('trainee:list')")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, TraineeQueryCriteria criteria) throws IOException {
        traineeService.download(traineeService.queryAll(criteria), response);
    }

    @Log("查询学员")
    @ApiOperation("查询学员")
    @PreAuthorize("@el.check('trainee:list')")
    @GetMapping
    public ResponseEntity<Object> query(TraineeQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(traineeService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增学员")
    @ApiOperation("新增学员")
    @PreAuthorize("@el.check('trainee:add')")
    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody Trainee resources){
        return new ResponseEntity<>(traineeService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改学员")
    @ApiOperation("修改学员")
    @PreAuthorize("@el.check('trainee:edit')")
    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody Trainee resources){
        traineeService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除学员")
    @ApiOperation("删除学员")
    @PreAuthorize("@el.check('trainee:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        traineeService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}