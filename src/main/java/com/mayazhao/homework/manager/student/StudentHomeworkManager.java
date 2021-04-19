package com.mayazhao.homework.manager.student;

import com.mayazhao.homework.dao.HomeworkDAO;
import com.mayazhao.homework.dao.StudentHomeworkDAO;
import com.mayazhao.homework.manager.BaseManager;
import com.mayazhao.homework.model.entity.StudentHomework;
import com.mayazhao.homework.model.vo.response.table.HomeworkItemVO;
import com.mayazhao.homework.model.vo.response.table.StudentHomeworkItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Project Name: homework-management-system-back-end
 * File Name: StudentHomeworkManager
 * Package Name: com.mayazhao.homework.manager.student
 *
 * @author yipple
 * @date 2020/6/17
 * @since 0.0.1
 */
@Component
public class StudentHomeworkManager extends BaseManager {

    private final HomeworkDAO homeworkDAO;

    private final StudentHomeworkDAO studentHomeworkDAO;

    public StudentHomeworkManager(HomeworkDAO homeworkDAO, StudentHomeworkDAO studentHomeworkDAO) {
        this.homeworkDAO = homeworkDAO;
        this.studentHomeworkDAO = studentHomeworkDAO;
    }

    public Boolean submitStudentHomework(StudentHomeworkItemVO studentHomeworkItemVO) {
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(studentHomeworkItemVO.getStudentId());
        studentHomework.setHomeworkId(studentHomeworkItemVO.getHomeworkId());
        studentHomework.setTitle(studentHomeworkItemVO.getTitle());
        studentHomework.setContent(studentHomeworkItemVO.getContent());

        return studentHomeworkDAO.insert(studentHomework) > 0;
    }

    public HomeworkItemVO getHomework(Long homeworkId) {
        return homeworkDAO.getHomeworkItemVO(homeworkId);
    }

    public Integer getPageCount(Long studentId, Long homeworkId, String homeworkTitle) {
        int count = homeworkDAO.countStudentRestHomework(studentId, homeworkId, homeworkTitle);
        return calculatePageNum(count, HomeworkDAO.PAGE_SIZE);
    }

    public List<HomeworkItemVO> getPage(Integer index, Long studentId, Long homeworkId, String homeworkTitle) {
        return homeworkDAO.getStudentRestHomeworkPage(index, studentId, homeworkId, homeworkTitle);
    }

}
