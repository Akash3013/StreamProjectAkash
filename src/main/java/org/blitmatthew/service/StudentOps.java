package org.blitmatthew.service;
import org.blitmatthew.entity.Student;

import org.blitmatthew.data.DataRetriever;
import org.blitmatthew.entity.Student;

import java.util.List;

public class StudentOps {
    private List<Student> students = DataRetriever.getStudents();

    public Integer getStudentCount() {
        return students.size();
    }
}
