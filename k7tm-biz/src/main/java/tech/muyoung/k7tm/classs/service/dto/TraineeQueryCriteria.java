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
import java.util.List;
import me.zhengjie.annotation.Query;

/**
 *
 * @author Charles7c
 * @date 2020-08-19
 */
@Data
public class TraineeQueryCriteria {

    /** 精确 */
    @Query
    private Long schoolId;

    /** 精确 */
    @Query
    private Long classId;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String phone;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String email;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String identityCard;

    /** 精确 */
    @Query
    private Integer gender;

    /** 精确 */
    @Query
    private Long courseId;

    /** 精确 */
    @Query
    private Integer learningStatus;

    /** 精确 */
    @Query
    private Integer education;
    /** 精确 */
    @Query
    private Integer source;

    @Query(type = Query.Type.INNER_LIKE)
    private String advisoryTeacher;

    @Query
    private Integer needEmployment;

    @Query
    private Integer needEdu;

    /** BETWEEN */
    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> registrationTime;
    /** BETWEEN */
    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
    /** BETWEEN */
    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> updateTime;
}