package example.day03._과제3.controller;

import example.day03._과제3.model.dto.CourseDto;
import example.day03._과제3.model.dto.StudentDto;
import example.day03._과제3.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/day03/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/course")
    // http://localhost:8080/day03/task/course
    // { "cname" : "수학" }
    public boolean saveCourse(@RequestBody CourseDto courseDto ){
        System.out.println("TaskController.saveCourse");
        System.out.println("courseDto = " + courseDto);
        return taskService.saveCourse( courseDto );
    }
    // 2. 과정 전체조회
    @GetMapping("/course") // http://localhost:8080/day03/task/course
    public List<CourseDto> findAll(){
        System.out.println("TaskController.findAll");
        return taskService.findAll();
    }

    //3. 학생등록
    @PostMapping
    public boolean saveStudent(@RequestBody StudentDto studentDto) {
        return taskService.saveStudent(studentDto);
    }

    // 4. 특정한 과정에 학생 전체 조회
    @GetMapping("/student")
    public List<StudentDto> findAllStudent( @RequestParam int cno ){
        return taskService.findAllStudent( cno );
    }
}
