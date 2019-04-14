package unittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unittest.data.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
