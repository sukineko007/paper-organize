package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.Teacher;
import edu.nwafu.paper.mapper.TeacherMapper;
import edu.nwafu.paper.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseTeacherService implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher checkLogin(String username, String password) {
        Teacher teacher = teacherMapper.checkLogin(username, password);
        return teacher;
    }
}
