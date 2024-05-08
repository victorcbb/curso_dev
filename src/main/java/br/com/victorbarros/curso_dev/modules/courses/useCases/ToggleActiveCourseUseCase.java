package br.com.victorbarros.curso_dev.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorbarros.curso_dev.exceptions.CourseNotFoundException;
import br.com.victorbarros.curso_dev.modules.courses.CourseEntity;
import br.com.victorbarros.curso_dev.modules.courses.CourseRepository;
import br.com.victorbarros.curso_dev.types.Active;

@Service
public class ToggleActiveCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(UUID id) {
    var course = this.courseRepository.findById(id)
        .orElseThrow(() -> {
          throw new CourseNotFoundException();
        });

    if (course.getActive().equals(Active.NO)) {
      course.setActive(Active.YES);
    }
    if (course.getActive().equals(Active.YES)) {
      course.setActive(Active.NO);
    }

    this.courseRepository.save(course);

    return course;
  }
}
