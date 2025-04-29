package org.blitmatthew;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.blitmatthew.entity.Student;
import org.blitmatthew.wrapper.StudentWrapper;

import java.io.File;
import java.util.List;

public class student_data {

    public static List<Student> loadStudents() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/student_data.json");


            StudentWrapper wrapper = mapper.readValue(file, StudentWrapper.class);
            return wrapper.getStudents();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
