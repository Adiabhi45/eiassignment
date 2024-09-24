package com.virtualclassroom.manager;

import com.virtualclassroom.classroom.Classroom;
import com.virtualclassroom.models.Assignment;
import com.virtualclassroom.models.Student;
import java.util.*;

public class VirtualClassroomManager {
    private Map<String, Classroom> classrooms;
    private Set<String> globalSubmissions;

    public VirtualClassroomManager() {
        this.classrooms = new HashMap<>();
        this.globalSubmissions = new HashSet<>();
    }

    public void addClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        } else {
            System.out.println("Classroom " + className + " already exists.");
        }
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.addStudent(new Student(studentId));
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.scheduleAssignment(new Assignment(assignmentDetails));
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);

        if (classroom != null) {
            if (!classroom.isAssignmentAvailable(assignmentDetails)) {
                System.out.println("Assignment does not exist for " + className + ".");
                return;
            }

            String submissionKey = studentId + "_" + assignmentDetails;

            if (globalSubmissions.contains(submissionKey)) {
                System.out.println("Duplicate submission detected. Student " + studentId + " has already submitted this assignment.");
            } else {
                globalSubmissions.add(submissionKey);
                System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.listStudents();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
