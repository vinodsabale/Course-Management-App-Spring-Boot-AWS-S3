package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}