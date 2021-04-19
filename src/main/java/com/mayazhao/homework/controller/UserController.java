package com.mayazhao.homework.controller;

import com.mayazhao.homework.model.vo.request.LoginVO;
import com.mayazhao.homework.model.vo.request.RegisterVO;
import com.mayazhao.homework.model.vo.response.ResultVO;
import com.mayazhao.homework.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Project Name: homework-management-system-back-end
 * File Name: UserController
 * Package Name: com.mayazhao.homework.controller
 *
 * @author yipple
 * @date 2020/6/17
 * @since 0.0.1
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResultVO login(@Validated @RequestBody LoginVO loginVO) {
        String userId = loginVO.getUserId();
        String password = loginVO.getPassword();
        Integer userType = loginVO.getUserType();

        return userService.login(userId, password, userType);
    }

    @RequestMapping("/login/status")
    public ResultVO getLoginStatus() {
        return userService.getLoginStatus();
    }

    @PostMapping("/register")
    public ResultVO register(@Validated @RequestBody RegisterVO registerVO) {
        String userId = registerVO.getUserId();
        String username = registerVO.getUsername();
        String password = registerVO.getPassword();
        Integer userType = registerVO.getUserType();

        return userService.register(userId, username, password, userType);
    }

    @RequestMapping("/logout")
    public ResultVO logout() {
        return userService.logout();
    }

}
