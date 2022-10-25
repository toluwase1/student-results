package com.example.school.endpoints;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentResultController {
//    private final StudentResultServiceImplementation resultServiceImplementation;
//
//    @PostMapping("/result")
//    public ResponseEntity<Result> createStudentResult(@RequestBody ResultDto result) throws Exception {
//        System.out.println("##########" + result.toString());
//        Result response = resultServiceImplementation.createStudentResult(result);
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
////@RequestParam(value="brand", defaultValue = "") String brand, @RequestParam(value="model", defaultValue="") String model
//    @GetMapping("/result")
//    public ResponseEntity<Result> getStudentResultByTeacherController(
//            @RequestParam(value = "id", defaultValue = "") Long id,
//            @RequestParam(value = "studentClass", defaultValue = "") String studentClass,
//            @RequestParam(value = "term", defaultValue = "") String term,
//            @RequestParam(value = "subjects", defaultValue = "") List<Subject> subjects
//    ) {
//        Result result = new Result();
////        var response = resultServiceImplementation.retrieveResultsByTeacher(result);
////        return ResponseEntity.status(HttpStatus.OK).body(response);
//        return ResponseEntity.status(HttpStatus.OK).body(null);
//    }
}
