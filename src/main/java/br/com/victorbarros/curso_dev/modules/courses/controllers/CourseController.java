package br.com.victorbarros.curso_dev.modules.courses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorbarros.curso_dev.modules.courses.CourseEntity;
import br.com.victorbarros.curso_dev.modules.courses.useCases.CreateCourseUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @PostMapping("/create")
  public CourseEntity create(@Valid @RequestBody CourseEntity courseEntity) {
    var result = this.createCourseUseCase.execute(courseEntity);

    return result;
  }
}
