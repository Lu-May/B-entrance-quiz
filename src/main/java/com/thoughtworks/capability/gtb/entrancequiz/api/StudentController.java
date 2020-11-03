package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    //TODO GTB-知识点: - StudentController.java:13 数据相关操作，不输入controller职责，应该属于repository的职责
    public List<Student> studentList = initStudentList();

    private List<Student> initStudentList() {
        String[] student = new String[]{
                "", "成吉思汗", "鲁班七号", "太乙真人",
                "钟无艳", "花木兰", "雅典娜",
                "芈月", "白起", "刘婵",
                "庄周", "马超", "刘备",
                "哪吒", "大乔", "蔡文姬"
        };
        List<Student> list = new ArrayList<>();
        for (String studentName : student) {
            list.add(new Student(studentName));
        }
        return list;
    }

    @GetMapping("/student/list")
    public ResponseEntity<List<Student>> getStudentList() {
        return ResponseEntity.ok(studentList);
    }

    //TODO GTB-知识点: - StudentController.java:36 path命名不符合restful实践，path中应该不包含动词
    @PostMapping("/student/add")
    //TODO GTB-知识点: - StudentController.java:38 了解下@ResponseStatus
    public ResponseEntity<Object> addStudent(@RequestBody String studentName) {
        //TODO GTB-知识点: - StudentController.java:38 业务流程相关操作，应该属于service的职责
        studentList.add(new Student(studentName));
        return ResponseEntity.created(null).build();
    }
}
