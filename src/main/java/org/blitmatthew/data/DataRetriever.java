package org.blitmatthew.data;
import org.blitmatthew.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.blitmatthew.entity.Car;
import org.blitmatthew.entity.Student;
import org.blitmatthew.wrapper.CarWrapper;
import org.blitmatthew.wrapper.StudentWrapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataRetriever {
    public static List<Student> getStudents() {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            StudentWrapper studentDataWrapper = objectMapper.readValue(
                    new File("src/main/java/org/blitmatthew/student_data.json"),
                    StudentWrapper.class
            );

            // Get the list of students
            List<Student> students = studentDataWrapper.getStudents();
            return students;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Car> getCars() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            CarWrapper carDataWrapper = objectMapper.readValue(
                    new File("src/main/java/org/blitmatthew/car_data.json"),
                    CarWrapper.class
            );

            // Get the list of cars
            return carDataWrapper.getCars();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
