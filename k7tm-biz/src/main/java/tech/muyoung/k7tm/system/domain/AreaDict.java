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

package tech.muyoung.k7tm.system.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import me.zhengjie.base.BaseEntity;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 *
 * @author Charles7c
 * @date 2020-08-20
 */
@Entity
@Data
@Table(name="k7tm_sys_area_dict")
public class AreaDict extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "主键")
    private Long id;

    @Column(name = "name",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "名称")
    private String name;

    @Column(name = "parent_id",nullable = false)
    @NotNull
    @ApiModelProperty(value = "父区域编号")
    private Long parentId;

    @Column(name = "initial")
    @ApiModelProperty(value = "拼音首字母")
    private String initial;

    @Column(name = "initials")
    @ApiModelProperty(value = "initials")
    private String initials;

    @Column(name = "pinyin",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "拼音")
    private String pinyin;

    @Column(name = "extra")
    @ApiModelProperty(value = "extra")
    private String extra;

    @Column(name = "suffix")
    @ApiModelProperty(value = "后缀")
    private String suffix;

    @Column(name = "code")
    @ApiModelProperty(value = "行政代码")
    private String code;

    @Column(name = "area_code")
    @ApiModelProperty(value = "区号 ")
    private String areaCode;

    @Column(name = "sort",nullable = false)
    @NotNull
    @ApiModelProperty(value = "排序")
    private Integer sort;

    public void copy(AreaDict source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}