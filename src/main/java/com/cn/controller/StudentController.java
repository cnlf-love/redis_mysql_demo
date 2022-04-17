package com.cn.controller;

import com.cn.config.RedisUtils;
import com.cn.pojo.Student;
import com.cn.service.StudentService;
import com.cn.vo.RespBean;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @Author 拾荒者
 * @Date 2022/4/17 0:46
 * @@Version 1.0
 * 123
 */
@RestController
@RequestMapping("/student")
@EnableSwagger2
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value ="根据用户名或者院系查找student",httpMethod = "GET")
    @GetMapping("/queryAllStudent")
    public List<Student> queryStudentByNameOrDepart(Student student){
        return studentService.queryAllStudent(student);
    }

    @ApiOperation(value ="添加 student",httpMethod = "POST")
    @PostMapping(value ="/addStudent")
    public RespBean addStudent(Student student){
        return studentService.addStudent(student);
    }

    @ApiOperation(value ="通过 id 删除学生",httpMethod = "GET")
    @GetMapping(value = "/deleteStudentById")
    public RespBean deleteStudentById(int id){
        return studentService.deleteStudentById(id);
    }

    @ApiOperation(value ="通过id修改student个人信息",httpMethod = "POST")
    @PostMapping(value ="/updateStudentById")
    public RespBean updateStudentById(Student student){
        return studentService.updateStudentById(student);
    }

    @ApiOperation(value = "入队",httpMethod = "POST")
    @PostMapping(value ="/rpush")
    public RespBean rpush(Student student){
        boolean flag = redisUtils.rpush("student:key",new Gson().toJson(student));
        if (flag){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value ="取出队列中的所有student",httpMethod = "GET")
    @GetMapping("/listAll")
    public List<Student> listAll(){
        List<Student> students = new Gson().fromJson(redisUtils.listAll("student:key")+"",List.class);
        return students;
    }

    @ApiOperation(value ="出队",httpMethod = "GET")
    @GetMapping(value ="/lpop")
    public Student lpop(){
        Student student = new Gson().fromJson(redisUtils.lpop("student:key")+"",Student.class);
        return student;
    }

    @GetMapping("/test")
    public String test(){
        return "成功";
    }
}
