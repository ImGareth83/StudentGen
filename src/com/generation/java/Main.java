package com.generation.java;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//Complete Option 2-7 except for Option 1, 6 & 8 are completed


public class Main
{
    public static void main( String[] args )
            throws ParseException
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        //Load test data - start
        Student a = new Student("111","aaa","aaa@aaa.com",new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01"));
        Student b = new Student("222","bbb","bbb@bbb.com",new SimpleDateFormat("yyyy-MM-dd").parse("1990-02-02"));

        Module module = new Module( "INTRO-CS", "Introduction to Computer Science",
                "Introductory module for the generation technical programs" );

        a.enrollToCourse(new Course( "INTRO-CS-1", "Introduction to Computer Science", 9, module ) );
        a.enrollToCourse(new Course( "INTRO-CS-2", "Introduction to Algorithms", 9, module ) );
        a.setGrade("INTRO-CS-1",3.5F);

        b.enrollToCourse(new Course( "INTRO-CS-2", "Introduction to Algorithms", 9, module ) );
        b.enrollToCourse(new Course( "INTRO-CS-3", "Algorithm Design and Problem Solving - Introduction ", 9, module ) );

        studentService.subscribeStudent(a);
        studentService.subscribeStudent(b);
        //Load test data - end

        Scanner scanner = new Scanner( System.in );
        int option;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showPassedCourses( studentService, scanner );
                    break;
            }
        }
        while ( option != 8 );
    }

    private static void enrollCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );
        System.out.println(student.getEnrolledCourses().values().toString());

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        if (!studentService.showSummary())
        {
            System.out.println("No Student Yet");
        }
    }

    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {

        Student student = getStudentInformation( studentService, scanner );
        System.out.println( "Enrolled course:"+student.getName() );

        //TODO
        if(student.getEnrolledCourses().isEmpty()) {
            System.out.println(student.getName()+" has no course enrolled ");
            return;
        }
        for(Course c : student.getEnrolledCourses().values()){
            System.out.println(c.toString());
        }
        System.out.println("Insert course ID to be graded:");
        String courseID = scanner.next();

        if(!student.getEnrolledCourses().containsKey(courseID)){
            System.out.println("Invalid Course ID, please re-enter from the start");
            return;
        }

        System.out.println("Insert course grade for:");
        String gradeStr = scanner.next();
        float grade = Float.parseFloat(gradeStr);

        student.setGrade(courseID,grade);
        System.out.println(courseID+" has been graded "+grade);
    }


    private static Student getStudentInformation( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        return student;
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        Student student = getStudentInformation( studentService, scanner );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
    }

    private static void registerStudent( StudentService studentService, Scanner scanner )  {
       Student student = PrinterHelper.createStudentMenu( scanner );
       studentService.subscribeStudent( student );
    }

    private static void showPassedCourses(StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        else
        {
            if (student.findPassedCourses().isEmpty())
            {
                System.out.println( "No passed courses available" );
            }
           else
            {
                System.out.println(student.findPassedCourses());
            }
        }
    }
}
