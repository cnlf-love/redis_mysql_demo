package com.cn.service.serviceImpl;

import com.cn.mapper.StudentMapper;
import com.cn.pojo.Student;
import com.cn.service.StudentService;
import com.cn.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 拾荒者
 * @Date 2022/4/17 0:32
 * @Version 1.0
 * test
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> queryAllStudent(Student student) {
        return studentMapper.queryAllStudent(student.getId(),student.getStudentName(),student.getDepartment());
    }

    @Override
    public RespBean addStudent(Student student) {
        int result = studentMapper.addStudent(student);
        if (result > 0){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @Override
    public RespBean deleteStudentById(int id) {
        int result = studentMapper.deleteStudentById(id);
        if (result > 0){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @Override
    public RespBean updateStudentById(Student student) {
        student.setIsCheck(1);
        int result = studentMapper.updateStudentById(student);
        if (result > 0){
            return RespBean.success("修改"+student.getStudentName()+"个人信息成功");
        }
        return RespBean.error("修改失败");
    }
}
