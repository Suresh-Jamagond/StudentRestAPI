package com.school.student.Log;

import com.school.student.model.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {

    Student student;
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(public * com.school.student.controller.HomeController.getAllStudents())")
    public void getAllStudents() {
        LOGGER.info("Fetching All Students");
    }

    @AfterReturning("execution(public * com.school.student.controller.HomeController.getAllStudents())")
    public void getAllStudentsLog() {
        LOGGER.info("Received All Students");
    }

    @AfterReturning("execution(public * com.school.student.controller.HomeController.getStudent(..)) && args (id)")
    public void getStudentLog(int id) {
        LOGGER.info("Student Returned with ID = " + id);
    }

    @AfterThrowing("execution(public * com.school.student.controller.HomeController.getStudent(..)) && args (id)")
    public void getStudentLogAfterThrow(int id) {
        LOGGER.info("STUDENT NOT IN THE DATABASE");
    }

    @AfterReturning("execution(public * com.school.student.controller.HomeController.updateStudent(..)) && args (student)")
    public void getStudentUpdateLog(Student student) {
        int id = student.getStudentId();
        LOGGER.info("Updated Student with ID = " + id);
    }

    @AfterReturning("execution(public * com.school.student.controller.HomeController.deleteStudent(..)) && args (id)")
    public void getStudentDeleteLog(int id) {
        LOGGER.info("Deleted Student with ID = " + id);
    }

    @AfterReturning("execution(public * com.school.student.controller.HomeController.addStudent(..)) && args (student)")
    public void addStudentLog(Student student) {
        String name = student.getStudentName();
        String studentClass = student.getStudentClass();
        int id = student.getStudentId();
        LOGGER.info("New student added Details - ID : " + id + ", NAME : " + name + ", CLASS : " + studentClass);
    }
}
