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

package tech.muyoung.k7tm.system.service.dto;

import lombok.Data;
import me.zhengjie.base.BaseDTO;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 *
 * @author Charles7c
 * @date 2020-08-20
 **/
@Data
public class AreaDictDto extends BaseDTO implements Serializable {

    /** 主键 */
    private Long id;

    /** 名称 */
    private String name;

    /** 父区域编号 */
    private Long parentId;

    /** 拼音首字母 */
    private String initial;

    private String initials;

    /** 拼音 */
    private String pinyin;

    private String extra;

    /** 后缀 */
    private String suffix;

    /** 行政代码 */
    private String code;

    /** 区号  */
    private String areaCode;

    /** 排序 */
    private Integer sort;

}