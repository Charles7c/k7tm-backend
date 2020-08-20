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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.zhengjie.base.BaseDTO;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 *
 * @author Charles7c
 * @date 2020-08-19
 **/
@Data
public class TraineeDto extends BaseDTO implements Serializable {

    /** ID */
    private Long id;

    /** 学号(未开放) */
    private String uuid;

    /** 姓名 */
    private String name;

    /** 手机号 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 身份证号 */
    private String identityCard;

    /** 性别 */
    private Integer gender;

    /** 出生日期 */
    private Timestamp bornDate;

    /** 籍贯省份 */
    private Long provinceId;

    /** 籍贯城市 */
    private Long cityId;

    /** 了解渠道 */
    private Integer source;

    /** 推荐学员 */
    private String referrerStu;

    /** 推荐老师 */
    private String referrerTeacher;

    /** 报名时间 */
    private Timestamp registrationTime;

    /** 报名课程 */
    private Long courseId;

    /** 缴费金额 */
    private BigDecimal payAmount;

    private Integer earnestFlag;

    private Timestamp completionTime;

    /** 费用来源 */
    private Integer costSource;

    /** 家长称谓 */
    private String contactName;

    /** 家长电话 */
    private String contactPhone;

    /** 需要就业 */
    private Integer needEmployment;

    /** 期望就业城市 */
    private String employmentIntentionsCity;

    /** 所在校区(部门) */
    private Long schoolId;

    /** 所在班级 */
    private Long classId;

    /** 进班时间 */
    private Timestamp enterClassTime;

    /** 学习状态 */
    private Integer learningStatus;

    /** 剩余课时(一对一) */
    private Integer classHour;

    /** 最高学历 */
    private Integer education;

    /** 毕业院校 */
    private String graduateInstitutions;

    /** 学历专业 */
    private String major;

    /** 英语水平 */
    private String englishLevel;

    /** 需要学历 */
    private Integer needEdu;

    /** 专业基础情况 */
    private Integer basisStatus;

    /** 生活状态 */
    private Integer status;

    /** 咨询老师 */
    private String advisoryTeacher;

    /** 学员描述 */
    private String traineeDesc;

    /** 学前工作经历 */
    private String workHistory;

    /** 特殊承诺 */
    private String specialCommitment;

    /** 学历照片 */
    private String degreeInPhoto;

    /** 身份证正面 */
    private String identityCardPhotoFront;

    /** 身份证反面 */
    private String identityCardPhotoBack;

    /** 结课时间 */
    private Timestamp graduateTime;

    /** 资料完善度 */
    private Integer dataIntegrity;

    /** 访谈状态 */
    private Integer interviewStatus;

    /** 最后访谈时间 */
    private Timestamp lastInterviewTime;

    /** 微信号 */
    private String wechatId;

    /** QQ号 */
    private String qqId;

}