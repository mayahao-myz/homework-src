package com.mayazhao.homework.model.vo.response.table;

import lombok.Data;

/**
 * Project Name: homework-management-system-back-end
 * File Name: StudentHomeworkItemVO
 * Package Name: com.mayazhao.homework.model.vo.table
 *
 * @author yipple
 * @date 2020/6/17
 * @since 0.0.1
 */
@Data
public class StudentHomeworkItemVO {

    private Long studentHomeworkId;

    private Long studentId;

    private String studentName;

    private Long homeworkId;

    private String homeworkTitle;

    private String homeworkContent;

    private Long teacherId;

    private String teacherName;

    private String title;

    private String content;

    private String teacherComment;

}
