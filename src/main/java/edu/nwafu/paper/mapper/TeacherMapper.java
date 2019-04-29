package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.Teacher;

public interface TeacherMapper {

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher checkLogin(String username, String password);
}