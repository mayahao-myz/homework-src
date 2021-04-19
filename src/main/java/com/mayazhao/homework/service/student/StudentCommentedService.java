package com.mayazhao.homework.service.student;

import com.mayazhao.homework.manager.student.StudentCommentedManager;
import com.mayazhao.homework.model.vo.response.ResultVO;
import com.mayazhao.homework.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Project Name: homework-management-system-back-end
 * File Name: StudentCommentedService
 * Package Name: com.mayazhao.homework.service.student
 *
 * @author yipple
 * @date 2020/6/19
 * @since 0.0.1
 */
@Service
public class StudentCommentedService extends BaseService {

    private final StudentCommentedManager studentCommentedManager;

    public StudentCommentedService(StudentCommentedManager studentCommentedManager) {
        this.studentCommentedManager = studentCommentedManager;
    }

    public ResultVO getPageCount(Long homeworkId, String homeworkTitle) {
        return result(studentCommentedManager.getPageCount(homeworkId, homeworkTitle, getUserId()));
    }

    public ResultVO getPage(Integer index, Long homeworkId, String homeworkTitle) {
        return result(studentCommentedManager.getPage(index, homeworkId, homeworkTitle, getUserId()));
    }

}
