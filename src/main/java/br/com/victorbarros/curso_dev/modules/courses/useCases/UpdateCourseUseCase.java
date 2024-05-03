package br.com.victorbarros.curso_dev.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorbarros.curso_dev.exceptions.CourseNotFoundException;
import br.com.victorbarros.curso_dev.modules.courses.CourseEntity;
import br.com.victorbarros.curso_dev.modules.courses.CourseRepository;

@Service
public class UpdateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(UUID id, CourseEntity courseEntity) {
    var course = this.courseRepository.findById(id)
        .orElseThrow(() -> {
          throw new CourseNotFoundException();
        });

    course.setName(courseEntity.getName());
    course.setCategory(courseEntity.getCategory());

    this.courseRepository.save(course);

    return course;
  }
}
