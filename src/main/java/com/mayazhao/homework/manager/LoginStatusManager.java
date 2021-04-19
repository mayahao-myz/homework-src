package com.mayazhao.homework.manager;

import com.mayazhao.homework.model.bo.LoginStatusBO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Project Name: homework-management-system-back-end
 * File Name: LoginStatusManager
 * Package Name: com.mayazhao.homework.manager
 *
 * @author yipple
 * @date 2020/6/16
 * @since 0.0.1
 */
@Component
public class LoginStatusManager extends BaseManager {

    private static final String SESSION_USER_STATUS = "user_status";

    public void setLoginStatus(HttpSession httpSession, LoginStatusBO loginStatusBO) {
        httpSession.setAttribute(SESSION_USER_STATUS, loginStatusBO);
    }

    public LoginStatusBO getLoginStatus(HttpSession httpSession) {
        LoginStatusBO loginStatusBO = (LoginStatusBO) httpSession.getAttribute(SESSION_USER_STATUS);
        LoginStatusBO loginStatus = loginStatusBO;
        if (loginStatus == null) {
            loginStatusBO = new LoginStatusBO();
            setLoginStatus(httpSession, loginStatusBO);
        }

        return loginStatusBO;
    }

}
