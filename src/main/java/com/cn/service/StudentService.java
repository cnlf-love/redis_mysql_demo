package com.cn.service;

import com.cn.pojo.Student;
import com.cn.vo.RespBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 拾荒者
 * @Date 2022/4/17 0:31
 * @Version 1.0
 */
public interface StudentService {
    // 查询所有的 student
    List<Student> queryAllStudent(Student student);

    // 添加 student
    RespBean addStudent(Student student);

    // 通过id删除student
    RespBean deleteStudentById(int id);

    // 通过id修改student信息
    RespBean updateStudentById(Student student);
}
