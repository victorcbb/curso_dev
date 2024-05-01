package br.com.victorbarros.curso_dev.modules.courses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorbarros.curso_dev.modules.courses.CourseEntity;
import br.com.victorbarros.curso_dev.modules.courses.useCases.CreateCourseUseCase;
import br.com.victorbarros.curso_dev.modules.courses.useCases.ListCourseUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private ListCourseUseCase listCourseUseCase;

  @PostMapping("/create")
  public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
    try {
      var result = this.createCourseUseCase.execute(courseEntity);

      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/list")
  public ResponseEntity<Object> list(@RequestParam String name, String category) {
    try {
      var result = this.listCourseUseCase.execute(name, category);

      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
