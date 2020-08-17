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

package tech.muyoung.k7tm.base.rest;

import me.zhengjie.annotation.Log;
import tech.muyoung.k7tm.base.domain.Course;
import tech.muyoung.k7tm.base.service.CourseService;
import tech.muyoung.k7tm.base.service.dto.CourseQueryCriteria;
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
 * @date 2020-08-17
 */
@Api(tags = "课程管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @PreAuthorize("@el.check('course:list')")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, CourseQueryCriteria criteria) throws IOException {
        courseService.download(courseService.queryAll(criteria), response);
    }

    @Log("查询课程")
    @ApiOperation("查询课程")
    @PreAuthorize("@el.check('course:list')")
    @GetMapping
    public ResponseEntity<Object> query(CourseQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(courseService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增课程")
    @ApiOperation("新增课程")
    @PreAuthorize("@el.check('course:add')")
    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody Course resources){
        return new ResponseEntity<>(courseService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改课程")
    @ApiOperation("修改课程")
    @PreAuthorize("@el.check('course:edit')")
    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody Course resources){
        courseService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除课程")
    @ApiOperation("删除课程")
    @PreAuthorize("@el.check('course:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        courseService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}