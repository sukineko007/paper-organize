package edu.nwafu.paper.controller;

import edu.nwafu.paper.beans.Teacher;
import edu.nwafu.paper.beans.User;
import edu.nwafu.paper.module.ResponseBody;
import edu.nwafu.paper.service.TeacherService;
import edu.nwafu.paper.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class TeacherController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(String username, String password) {
        User user = userService.login(username, password);
        return user;
    }
}
