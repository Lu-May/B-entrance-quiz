package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    public List<Student> studentList = initStudentList();

    private List<Student> initStudentList() {
        String[] student = new String[]{
               "成吉思汗", "鲁班七号", "太乙真人",
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
}
