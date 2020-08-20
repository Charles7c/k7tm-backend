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

package tech.muyoung.k7tm.classs.domain;

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
 * @date 2020-08-16
 */
@Entity
@Data
@Table(name="k7tm_classs_classs")
public class Classs extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID")
    private Long id;

    @Column(name = "name",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "名称")
    private String name;

    @Column(name = "type")
    @ApiModelProperty(value = "类型")
    private Integer type;

    @Column(name = "status")
    @ApiModelProperty(value = "状态")
    private Integer status;

    @Column(name = "stu_num")
    @ApiModelProperty(value = "现有人数")
    private Integer stuNum;

    @Column(name = "class_transfer_num")
    @ApiModelProperty(value = "转班人数")
    private Integer classTransferNum;

    @Column(name = "temporary_absence_num")
    @ApiModelProperty(value = "休学人数")
    private Integer temporaryAbsenceNum;

    @Column(name = "refund_num")
    @ApiModelProperty(value = "退学人数")
    private Integer refundNum;

    @Column(name = "expel_num")
    @ApiModelProperty(value = "开除人数")
    private Integer expelNum;

    @Column(name = "course_id")
    @ApiModelProperty(value = "课程类型")
    private Long courseId;

    @Column(name = "vc_teacher",nullable = false)
    @NotNull
    @ApiModelProperty(value = "职业顾问")
    private Long vcTeacher;

    @Column(name = "ta_teacher")
    @ApiModelProperty(value = "技术顾问")
    private Long taTeacher;

    @Column(name = "pm_teacher")
    @ApiModelProperty(value = "项目经理")
    private Long pmTeacher;

    @Column(name = "class_time")
    @ApiModelProperty(value = "开班时间")
    private Timestamp classTime;

    @Column(name = "graduate_time")
    @ApiModelProperty(value = "毕业时间")
    private Timestamp graduateTime;

    @Column(name = "desc")
    @ApiModelProperty(value = "班级描述")
    private String desc;

    public void copy(Classs source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}