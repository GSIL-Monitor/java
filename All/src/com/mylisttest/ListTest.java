package com.mylisttest;

import java.util.*;

public class ListTest {
    public ArrayList<Course> courses = new ArrayList<Course>();

    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.courseAdd();
        //lt.studentAdd();
        Student s = new Student("1", "jack");
        Scanner scan = new Scanner(System.in);
		outer:
        for (int i = 0; i < 5; i++) {
            System.out.println("plese enter couse id you wana select: ");
            String courseId = scan.next();
            for (Course cr : lt.courses) {
                if (cr.id.equals(courseId)) {
                    s.coursesT.add(cr);
                    System.out.println("have and added");
					break outer;

                }
            }
        }
    }


    public void courseAdd() {

        Scanner input = new Scanner(System.in);
        System.out.println("plese input the id and name of the course you wana add: ");
        Course newCourse = new Course(input.next(), input.next());
        courses.add(newCourse);
        for (Course c : courses) {
            System.out.println("course list: " + c.id + " " + c.name);
        }


    }

//    public void studentAdd() {
//        Set<Student> students = new HashSet<Student>();
//        Scanner input = new Scanner(System.in);
//        System.out.println("plese input the id and name of the student you wana add: ");
//        Student newStudent = new Student(input.next(), input.next());
//        students.add(newStudent);
//        for (Student s : students) {
//            System.out.println("student list: " + s.id + " " + s.name);
//        }
//    }

    }

