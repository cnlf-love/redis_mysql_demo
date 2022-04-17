package com.cn.mapper;

import com.cn.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 拾荒者
 * @Date 2022/4/17 0:31
 * @Version 1.0
 * test
 */
@Repository
public interface StudentMapper {

    // 查询所有的 student
    List<Student> queryAllStudent(@Param("id") int id,@Param("studentName") String studentName
            ,@Param("department") String department);

    // 添加student
    int addStudent(Student student);

    // 通过id删除student
    int deleteStudentById(int id);

    // 修改student信息
    int updateStudentById(Student student);
}
