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
import tech.muyoung.k7tm.classs.domain.Classs;
import tech.muyoung.k7tm.classs.service.ClasssService;
import tech.muyoung.k7tm.classs.service.dto.ClasssQueryCriteria;
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
 * @date 2020-08-16
 */
@Api(tags = "班级管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classs")
public class ClasssController {

    private final ClasssService classsService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @PreAuthorize("@el.check('classs:list')")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, ClasssQueryCriteria criteria) throws IOException {
        classsService.download(classsService.queryAll(criteria), response);
    }

    @Log("查询班级")
    @ApiOperation("查询班级")
    @PreAuthorize("@el.check('classs:list')")
    @GetMapping
    public ResponseEntity<Object> query(ClasssQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(classsService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增班级")
    @ApiOperation("新增班级")
    @PreAuthorize("@el.check('classs:add')")
    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody Classs resources){
        return new ResponseEntity<>(classsService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改班级")
    @ApiOperation("修改班级")
    @PreAuthorize("@el.check('classs:edit')")
    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody Classs resources){
        classsService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除班级")
    @ApiOperation("删除班级")
    @PreAuthorize("@el.check('classs:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        classsService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}