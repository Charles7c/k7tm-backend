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
import java.math.BigDecimal;
import java.io.Serializable;

/**
 *
 * @author Charles7c
 * @date 2020-08-19
 */
@Entity
@Data
@Table(name="k7tm_classs_trainee")
public class Trainee extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "学号(未开放)")
    private String uuid;

    @Column(name = "name",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "姓名")
    private String name;

    @Column(name = "phone",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @Column(name = "identity_card",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "身份证号")
    private String identityCard;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    private Timestamp bornDate;

    @ApiModelProperty(value = "籍贯省份")
    private Long provinceId;

    @ApiModelProperty(value = "籍贯城市")
    private Long cityId;

    @ApiModelProperty(value = "了解渠道")
    private Integer source;

    @ApiModelProperty(value = "推荐学员")
    private String referrerStu;

    @ApiModelProperty(value = "推荐老师")
    private String referrerTeacher;

    @ApiModelProperty(value = "报名时间")
    private Timestamp registrationTime;

    @ApiModelProperty(value = "报名课程")
    private Long courseId;

    @ApiModelProperty(value = "缴费金额")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "是否为定金")
    private Integer earnestFlag;

    @ApiModelProperty(value = "补全时间")
    private Timestamp completionTime;

    @ApiModelProperty(value = "费用来源")
    private Integer costSource;

    @ApiModelProperty(value = "家长称谓")
    private String contactName;

    @ApiModelProperty(value = "家长电话")
    private String contactPhone;

    @Column(name = "need_employment",nullable = false)
    @NotNull
    @ApiModelProperty(value = "需要就业")
    private Integer needEmployment;

    @ApiModelProperty(value = "期望就业城市")
    private String employmentIntentionsCity;

    @ApiModelProperty(value = "所在校区(部门)")
    private Long schoolId;

    @ApiModelProperty(value = "所在班级")
    private Long classId;

    @ApiModelProperty(value = "进班时间")
    private Timestamp enterClassTime;

    @Column(name = "learning_status",nullable = false)
    @NotNull
    @ApiModelProperty(value = "学习状态")
    private Integer learningStatus;

    @ApiModelProperty(value = "剩余课时(一对一)")
    private Integer classHour;

    @ApiModelProperty(value = "最高学历")
    private Integer education;

    @ApiModelProperty(value = "毕业院校")
    private String graduateInstitutions;

    @ApiModelProperty(value = "学历专业")
    private String major;

    @ApiModelProperty(value = "英语水平")
    private String englishLevel;

    @Column(name = "need_edu",nullable = false)
    @NotNull
    @ApiModelProperty(value = "需要学历")
    private Integer needEdu;

    @ApiModelProperty(value = "专业基础情况")
    private Integer basisStatus;

    @ApiModelProperty(value = "生活状态")
    private Integer status;

    @Column(name = "advisory_teacher",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "咨询老师")
    private String advisoryTeacher;

    @ApiModelProperty(value = "学员描述")
    private String traineeDesc;

    @ApiModelProperty(value = "学前工作经历")
    private String workHistory;

    @ApiModelProperty(value = "特殊承诺")
    private String specialCommitment;

    @ApiModelProperty(value = "学历照片")
    private String degreeInPhoto;

    @ApiModelProperty(value = "身份证正面")
    private String identityCardPhotoFront;

    @ApiModelProperty(value = "身份证反面")
    private String identityCardPhotoBack;

    @ApiModelProperty(value = "结课时间")
    private Timestamp graduateTime;

    @ApiModelProperty(value = "资料完善度")
    private Integer dataIntegrity;

    @ApiModelProperty(value = "访谈状态")
    private Integer interviewStatus;

    @ApiModelProperty(value = "最后访谈时间")
    private Timestamp lastInterviewTime;

    @ApiModelProperty(value = "微信号")
    private String wechatId;

    @ApiModelProperty(value = "QQ号")
    private String qqId;

    public void copy(Trainee source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}