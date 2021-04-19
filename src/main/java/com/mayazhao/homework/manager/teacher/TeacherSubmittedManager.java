package com.mayazhao.homework.manager.teacher;

import com.mayazhao.homework.dao.StudentHomeworkDAO;
import com.mayazhao.homework.manager.BaseManager;
import com.mayazhao.homework.model.entity.StudentHomework;
import com.mayazhao.homework.model.vo.response.table.StudentHomeworkItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Name: homework-management-system-back-end
 * File Name: TeacherSubmittedManager
 * Package Name: com.mayazhao.homework.manager.teacher
 *
 * @author yipple
 * @date 2020/6/18
 * @since 0.0.1
 */
@Service
public class TeacherSubmittedManager extends BaseManager {

    private final StudentHomeworkDAO studentHomeworkDAO;

    public TeacherSubmittedManager(StudentHomeworkDAO studentHomeworkDAO) {
        this.studentHomeworkDAO = studentHomeworkDAO;
    }

    public Boolean updateStudentHomework(StudentHomework studentHomework) {
        return studentHomeworkDAO.updateById(studentHomework) > 0;
    }

    public StudentHomeworkItemVO getStudentHomework(Long studentHomeworkId) {
        StudentHomework studentHomework = studentHomeworkDAO.selectById(studentHomeworkId);
        return studentHomeworkDAO.getStudentHomeworkVO(studentHomework.getStudentId(), studentHomework.getHomeworkId());
    }

    public Integer getPageCount(Long teacherId, Long homeworkId, String homeworkTitle, Long studentId, String studentName) {
        int count = studentHomeworkDAO.count(teacherId, homeworkId, homeworkTitle, studentId, studentName);
        return calculatePageNum(count, StudentHomeworkDAO.PAGE_SIZE);
    }

    public List<StudentHomeworkItemVO> getPage(Integer index, Long teacherId, Long homeworkId, String homeworkTitle, Long studentId, String studentName) {
        return studentHomeworkDAO.getPage(index, teacherId, homeworkId, homeworkTitle, studentId, studentName);
    }
}
