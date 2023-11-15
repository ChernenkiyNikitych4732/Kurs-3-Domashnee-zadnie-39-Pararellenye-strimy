package sky.pro.course3.homework.controller;

import sky.pro.course3.homework.model.Student;
import sky.pro.course3.homework.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("add")
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @GetMapping("get/{id}")
    public Student get(@PathVariable long id) {
        return studentService.get(id);
    }

    @PutMapping("set")
    public Student set(@RequestBody Student student) {
        return studentService.set(student);
    }


    @DeleteMapping("delete/{id}")
    public Student del(@PathVariable long id) {
        return studentService.del(id);
    }

    @GetMapping("collect/{age}")
    public Collection<Student> ageCollect(@PathVariable Integer age) {
        return studentService.ageCollect(age);

    }

    @GetMapping("collect")
    public Collection<Student> ageCollect(@RequestParam int min,@RequestParam int max) {
        return studentService.ageBetween(min,max);
    }

    @GetMapping("/count")
    public int getCountStudent(){
        return studentService.getCountStudent();
    }

    @GetMapping("avgAge")
    public int getAvgAge(){
        return studentService.getAvgAge();
    }

    @GetMapping("lastFive")
    public List<Student> getLastFive(){
        return studentService.getLastFive();
    }

    @GetMapping("name-start-with-A")
    public List<String> nameStartWithA(){
        return studentService.nameStartWithA();
    }

    @GetMapping("avgAgeStream")
    public double avgAgeStream(){
        return studentService.avgAgeStream();
    }
}