package com.mayazhao.homework.manager.student;

import com.mayazhao.homework.dao.HomeworkDAO;
import com.mayazhao.homework.dao.StudentHomeworkDAO;
import com.mayazhao.homework.manager.BaseManager;
import com.mayazhao.homework.model.entity.StudentHomework;
import com.mayazhao.homework.model.vo.request.UpdateStudentHomeworkItemVO;
import com.mayazhao.homework.model.vo.response.table.StudentHomeworkItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Project Name: homework-management-system-back-end
 * File Name: StudentSubmittedManager
 * Package Name: com.mayazhao.homework.manager.student
 *
 * @author yipple
 * @date 2020/6/18
 * @since 0.0.1
 */
@Component
public class StudentSubmittedManager extends BaseManager {

    private final StudentHomeworkDAO studentHomeworkDAO;

    public StudentSubmittedManager(StudentHomeworkDAO studentHomeworkDAO) {
        this.studentHomeworkDAO = studentHomeworkDAO;
    }

    public Boolean updateStudentHomework(StudentHomework studentHomework) {
        StudentHomework originalStudentHomework = studentHomeworkDAO.selectById(studentHomework.getStudentHomeworkId());

        if (originalStudentHomework.getTeacherComment() != null) {
            return false;
        }

        return studentHomeworkDAO.updateById(studentHomework) > 0;
    }

    public Boolean updateStudentHomeworkByVO(UpdateStudentHomeworkItemVO updateStudentHomeworkItemVO) {
        StudentHomework updatedStudentHomework = new StudentHomework();
        updatedStudentHomework.setStudentHomeworkId(updateStudentHomeworkItemVO.getStudentHomeworkId());
        updatedStudentHomework.setStudentId(updateStudentHomeworkItemVO.getStudentId());
        updatedStudentHomework.setHomeworkId(updateStudentHomeworkItemVO.getHomeworkId());
        updatedStudentHomework.setTitle(updateStudentHomeworkItemVO.getTitle());
        updatedStudentHomework.setContent(updateStudentHomeworkItemVO.getContent());

        return updateStudentHomework(updatedStudentHomework);
    }

    public StudentHomeworkItemVO getStudentHomework(Long studentId, Long homeworkId) {
        return studentHomeworkDAO.getStudentHomeworkVO(studentId, homeworkId);
    }

    public Integer getPageCount(Long homeworkId, String homeworkTitle, Long studentId) {
        int count = studentHomeworkDAO.countWithoutTeacherComment(homeworkId, homeworkTitle, studentId, null);
        return calculatePageNum(count, HomeworkDAO.PAGE_SIZE);
    }

    public List<StudentHomeworkItemVO> getPage(Integer index, Long homeworkId, String homeworkTitle, Long studentId) {
        return studentHomeworkDAO.getPageWithoutTeacherComment(index, homeworkId, homeworkTitle, studentId, null);
    }

}
