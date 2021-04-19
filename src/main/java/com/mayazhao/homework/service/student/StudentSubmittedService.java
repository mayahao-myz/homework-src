package com.mayazhao.homework.service.student;

import com.mayazhao.homework.manager.student.StudentSubmittedManager;
import com.mayazhao.homework.model.vo.request.UpdateStudentHomeworkItemVO;
import com.mayazhao.homework.model.vo.response.ResultVO;
import com.mayazhao.homework.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Project Name: homework-management-system-back-end
 * File Name: StudentSubmittedService
 * Package Name: com.mayazhao.homework.service.student
 *
 * @author yipple
 * @date 2020/6/18
 * @since 0.0.1
 */
@Service
public class StudentSubmittedService extends BaseService {

    private final StudentSubmittedManager studentSubmittedManager;

    public StudentSubmittedService(StudentSubmittedManager studentSubmittedManager) {
        this.studentSubmittedManager = studentSubmittedManager;
    }

    public ResultVO updateStudentHomework(UpdateStudentHomeworkItemVO updateStudentHomeworkItemVO) {
        if (studentSubmittedManager.updateStudentHomeworkByVO(updateStudentHomeworkItemVO)) {
            return result("更新作业成功");
        } else {
            return failedResult("老师已点评，不能更新作业");
        }
    }

    public ResultVO getStudentHomework(Long homeworkId) {
        return result(studentSubmittedManager.getStudentHomework(getUserId(), homeworkId));
    }

    public ResultVO getPageCount(Long homeworkId, String homeworkTitle) {
        return result(studentSubmittedManager.getPageCount(homeworkId, homeworkTitle, getUserId()));
    }

    public ResultVO getPage(Integer index, Long homeworkId, String homeworkTitle) {
        return result(studentSubmittedManager.getPage(index, homeworkId, homeworkTitle, getUserId()));
    }

}
