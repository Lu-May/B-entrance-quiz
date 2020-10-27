package api;

import dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    public static List<Student> studentList = new ArrayList<>();

    public StudentController() {
        initStudentList();
    }

    private void initStudentList() {
        String[] student = new String[]{
               "成吉思汗", "鲁班七号", "太乙真人",
                "钟无艳", "花木兰", "雅典娜",
                "芈月", "白起", "刘婵",
                "庄周", "马超", "刘备",
                "哪吒", "大乔", "蔡文姬"
        };
        for (String studentName : student) {
            studentList.add(new Student(studentName));
        }
    }

    @GetMapping("/student/list")
    public ResponseEntity<List<Student>> getStudentList() {
        return ResponseEntity.ok(studentList);
    }
}
