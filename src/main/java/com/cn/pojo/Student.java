package com.cn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author 拾荒者
 * @Date 2022/4/17 0:29
 * @Version 1.0
 * test
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private int id;
    private Long studentNumber;
    private String studentName;
    private String department;
    private int isCheck;

}
