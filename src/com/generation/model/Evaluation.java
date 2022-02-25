package com.generation.model;

import java.util.Map;

public interface Evaluation
{
    //changed from List to Map for easy access
    Map<String, Course>  findPassedCourses();

    Map<String, Course> getEnrolledCourses();
}
