package com.virtualclassroom.classroom;

import com.virtualclassroom.models.Assignment;
import com.virtualclassroom.models.Student;
import java.util.*;

public class Classroom {
    private String name;
    private Map<String, Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashMap<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        System.out.println("Student " + student.getId() + " has been enrolled in " + name + ".");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + name + ".");
        } else {
            System.out.println("Students in " + name + ":");
            for (String studentId : students.keySet()) {
                System.out.println(studentId);
            }
        }
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
        System.out.println("Assignment for " + name + " has been scheduled.");
    }

    public boolean isAssignmentAvailable(String assignmentDetails) {
        for (Assignment assignment : assignments) {
            if (assignment.getDetails().equals(assignmentDetails)) {
                return true;
            }
        }
        return false;
    }
}
