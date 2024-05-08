package br.com.victorbarros.curso_dev.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorbarros.curso_dev.exceptions.CourseNotFoundException;
import br.com.victorbarros.curso_dev.modules.courses.CourseRepository;

@Service
public class DeleteCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public void execute(UUID id) {
    var course = this.courseRepository.findById(id)
        .orElseThrow(() -> {
          throw new CourseNotFoundException();
        });

    this.courseRepository.delete(course);
  }

}
