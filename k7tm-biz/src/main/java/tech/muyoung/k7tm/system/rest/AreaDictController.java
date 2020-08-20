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

package tech.muyoung.k7tm.system.rest;

import me.zhengjie.annotation.Log;
import tech.muyoung.k7tm.system.domain.AreaDict;
import tech.muyoung.k7tm.system.service.AreaDictService;
import tech.muyoung.k7tm.system.service.dto.AreaDictQueryCriteria;
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
 * @date 2020-08-20
 */
@Api(tags = "区域字典管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/areaDict")
public class AreaDictController {

    private final AreaDictService areaDictService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @PreAuthorize("@el.check('areaDict:list')")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, AreaDictQueryCriteria criteria) throws IOException {
        areaDictService.download(areaDictService.queryAll(criteria), response);
    }

    @Log("查询区域字典")
    @ApiOperation("查询区域字典")
    @PreAuthorize("@el.check('areaDict:list')")
    @GetMapping
    public ResponseEntity<Object> query(AreaDictQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(areaDictService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增区域字典")
    @ApiOperation("新增区域字典")
    @PreAuthorize("@el.check('areaDict:add')")
    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody AreaDict resources){
        return new ResponseEntity<>(areaDictService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改区域字典")
    @ApiOperation("修改区域字典")
    @PreAuthorize("@el.check('areaDict:edit')")
    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody AreaDict resources){
        areaDictService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除区域字典")
    @ApiOperation("删除区域字典")
    @PreAuthorize("@el.check('areaDict:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        areaDictService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}