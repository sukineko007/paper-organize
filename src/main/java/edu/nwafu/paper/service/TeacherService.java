package edu.nwafu.paper.service;

import edu.nwafu.paper.beans.Teacher;

public interface TeacherService {

    Teacher checkLogin(String username, String password);
}
