package br.com.victorbarros.curso_dev.modules.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorbarros.curso_dev.exceptions.CourseNameFoundException;
import br.com.victorbarros.curso_dev.modules.courses.CourseEntity;
import br.com.victorbarros.curso_dev.modules.courses.CourseRepository;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(CourseEntity courseEntity) {
    this.courseRepository.findByName(courseEntity.getName())
        .ifPresent((name) -> {
          throw new CourseNameFoundException();
        });

    return this.courseRepository.save(courseEntity);
  }
}
