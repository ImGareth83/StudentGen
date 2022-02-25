package com.generation.model;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{

    float PASS_MIN_GRADE = 3.0f;

    private HashMap<String, Course> enrolledCourses = new HashMap<String, Course>();

    //set the student's grade(s) in student class
    private HashMap<String,Float> gradeCourse = new HashMap<String, Float>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO
        enrolledCourses.put(course.getCode(),course);
    }

    @Override
    public Map<String, Course>findPassedCourses()
    {
        //TODO
        //returns empty if there is no course graded
        if(gradeCourse.isEmpty()) return Collections.emptyMap();

        Map<String, Course> passedCourses = new HashMap<String, Course>();

        //assume setGrade is invoked to update the student's grade before findPassedCourses
        //find the passed course(s) based on the student's grade(s)
        gradeCourse.forEach((courseId,grade)->{
            if(grade>=3.0F) passedCourses.put(courseId,enrolledCourses.get(courseId));
        });

        return passedCourses;
    }

    public Course findCourseById( String courseId )
    {
        //TODO
       return enrolledCourses.get(courseId);
    }

    @Override
    public Map<String, Course> getEnrolledCourses()
    {
        //TODO
        return enrolledCourses;
    }

    //update the student's grade to a particular course id
    public void setGrade(String courseID, float grade){
        gradeCourse.put(courseID,grade);
    }

    public Map<String, Float> getGrade(){
        return gradeCourse;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
