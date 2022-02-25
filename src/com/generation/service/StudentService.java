package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        //TODO
        return students.get( studentId );
    }

    public boolean showSummary()
    {
        //TODO
        if(students.isEmpty())return false;

        for (Student s : students.values()) {
            System.out.println("***Start***");
            System.out.println(s);

            if(s.getEnrolledCourses().isEmpty()) {
                System.out.println("No course enrolled");
                continue;
            }

            for (Course c : s.getEnrolledCourses().values()) {
                System.out.println(c);
            }
            System.out.println("***End***");
        }

        return true;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO
        findStudent(studentId).enrollToCourse(course);
    }
}
