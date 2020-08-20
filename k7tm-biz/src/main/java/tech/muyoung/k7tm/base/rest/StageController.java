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
import tech.muyoung.k7tm.base.domain.Stage;
import tech.muyoung.k7tm.base.service.StageService;
import tech.muyoung.k7tm.base.service.dto.StageQueryCriteria;
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
 * @author Mr_Li
 * @date 2020-08-20
 */
@Api(tags = "阶段管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stage")
public class StageController {

    private final StageService StageService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @PreAuthorize("@el.check('stage:list')")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, StageQueryCriteria criteria) throws IOException {
        StageService.download(StageService.queryAll(criteria), response);
    }

    @Log("查询阶段")
    @ApiOperation("查询阶段")
    @PreAuthorize("@el.check('stage:list')")
    @GetMapping
    public ResponseEntity<Object> query(StageQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(StageService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增阶段")
    @ApiOperation("新增阶段")
    @PreAuthorize("@el.check('stage:add')")
    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody Stage resources){
        return new ResponseEntity<>(StageService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改阶段")
    @ApiOperation("修改阶段")
    @PreAuthorize("@el.check('stage:edit')")
    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody Stage resources){
        StageService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除阶段")
    @ApiOperation("删除阶段")
    @PreAuthorize("@el.check('stage:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        StageService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}