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

package tech.muyoung.k7tm.classs.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 *
 * @author Charles7c
 * @date 2020-08-16
 **/
@Data
public class ClasssDto implements Serializable {

    /** ID */
    private Long classId;

    /** 名称 */
    private String name;

    /** 类型 */
    private Integer type;

    /** 状态 */
    private Integer status;

    /** 现有人数 */
    private Integer stuNum;

    /** 转班人数 */
    private Integer classTransferNum;

    /** 休学人数 */
    private Integer temporaryAbsenceNum;

    /** 退学人数 */
    private Integer refundNum;

    /** 开除人数 */
    private Integer expelNum;

    /** 课程类型 */
    private Long courseId;

    /** 职业顾问 */
    private Long vcTeacher;

    /** 技术顾问 */
    private Long taTeacher;

    /** 项目经理 */
    private Long pmTeacher;

    /** 开班时间 */
    private Timestamp classTime;

    /** 毕业时间 */
    private Timestamp graduateTime;

    /** 班级描述 */
    private String desc;

    /** 创建者 */
    private String createBy;

    /** 更新者 */
    private String updateBy;

    /** 创建日期 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;
}