package org.blitmatthew;

import org.blitmatthew.entity.Student;
import org.blitmatthew.student_data; // import your loader class

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
//import static java.util.stream.Nodes.collect;

public class Main {

    public static void main(String[] args) {
        List<Student> students = student_data.loadStudents();


        List<Student> highGpaStudents = students.stream()
                .filter(student -> student.getGpa() > 3.5)
                .toList();
        System.out.println("***Students with GPA greater than 3.5:****");


        for (Student student : highGpaStudents) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - GPA: " + student.getGpa());
        }
        System.out.println("Total number of students with GPA greater than 3.5: " + highGpaStudents.size());

        List<Student> underTwenty = students.stream().filter(student -> student.getAge() < 20)
                .toList();
        System.out.println("***Students under 20 years old:****");
        for (Student student : underTwenty) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Age: " + student.getAge());
        }
        System.out.println("Total number of students under 20 years old: " + underTwenty.size());

        List<Student> internationalStudents = students.stream().filter((student -> student.isInternational()))
                .toList();
        System.out.println("***International Students:****");
        for (Student student : internationalStudents) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
        System.out.println("Total number of international students: " + internationalStudents.size());

        List<Student> coumpuerScienceStudents = students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase("Computer Science"))
                .collect(Collectors.toList());

        System.out.println("***Computer Science Students:****");
        for (Student student : coumpuerScienceStudents) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Major: " + student.getMajor());
        }
        System.out.println("Total number of Computer Science students: " + coumpuerScienceStudents.size());

        System.out.println("*** Students from State University: ****");
        List<Student> stateUniversityStudents = students.stream()
                .filter(student -> student.getUniversity().equalsIgnoreCase("State University"))
                .collect(Collectors.toList());
        for (Student student : stateUniversityStudents) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - University: " + student.getUniversity());

        }
        System.out.println("Total number of students from State University: " + stateUniversityStudents.size());

        System.out.println("** Students with scholarships: **");
        List<Student> haveSchoolership = students.stream().filter(student -> student.isScholarshipRecipient()).toList();
        for (Student student : haveSchoolership) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Scholarship: " + student.isScholarshipRecipient());
        }
        System.out.println("Total number of students with scholarships: " + haveSchoolership.size());

        System.out.println(" Students who graduated in 2028");
        List<Student> graduationYear = students.stream().filter(student -> student.getGraduationYear() == 2028)
                .toList();
        for (Student student : graduationYear) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Graduation Year: " + student.getGraduationYear());
        }
        System.out.println("Total number of students who graduated in 2028: " + graduationYear.size());

        System.out.println("***Student who have 60 creadits:***");
        List<Student> sixtyCredit = students.stream().filter(student -> student.getCreditHours() == 60).toList();
        for (Student student : sixtyCredit) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Credit Hours: " + student.getCreditHours());
        }
        System.out.println("Total number of students who have 60 credit hours: " + sixtyCredit.size());

        System.out.println("Students GpA between 3.0 and 3.5: ");
        List<Student> compaireGpa = students.stream().filter(student -> student.getGpa() > 3.0 && student.getGpa() <= 3.5).toList();
        for (Student student : compaireGpa) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - GPA: " + student.getGpa());
        }
        System.out.println("Total number of students with GPA between 3.0 and 3.5: " + compaireGpa.size());

        System.out.println(" International Student & Steam Major: ");
        List<Student> internationalSteam = students.stream().filter(student -> student.isInternational() && student.stremMajor(student.getMajor()))
                .collect(Collectors.toList());
        for (Student student : internationalSteam) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Major: " + student.getMajor() + " - International: " + student.isInternational());

        }

        System.out.println(" Students with 90 credit hours and schoolership: ");
        List<Student> scholarshipNinetyCredit = students.stream()
                .filter(student -> student.getCreditHours() > 90 && student.isScholarshipRecipient())
                .collect(Collectors.toList());
        for (Student student : scholarshipNinetyCredit) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Credit Hours: " + student.getCreditHours() + " - Scholarship: " + student.isScholarshipRecipient());
        }

        System.out.println("** Students in top 10% of their class by GPA**");
        List<Student> topTenPercent = students.stream().sorted((student1, student2) -> Double.compare(student2.getGpa(), student1.getGpa()))
                .limit((long) (students.size() * 0.1))
                .collect(Collectors.toList());
        for (Student student : topTenPercent) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - GPA: " + student.getGpa());
        }
        System.out.println(" Student Phone number Starting with 697");

        List<Student> studentswithPhoneNumber = students.stream()
                .filter(student -> student.getPhoneNumber().startsWith("697"))
                .collect(Collectors.toList());
        for (Student student : studentswithPhoneNumber) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Phone Number: " + student.getPhoneNumber());
        }

        System.out.println(" Students Born in February: ");


        List<Integer> targetMonths = List.of(2);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        List<Student> studentsBornInMonths = students.stream()
                .filter(student -> {
                    LocalDate birthDate = LocalDate.parse(student.getDateOfBirth(), formatter);
                    int birthMonth = birthDate.getMonthValue();
                    return targetMonths.contains(birthMonth);
                })
                .collect(Collectors.toList());


        studentsBornInMonths.forEach(student ->
                System.out.println(student.getFirstName() + " " + student.getLastName() + " - Date of Birth: " + student.getDateOfBirth())
        );
        int currentYear = LocalDate.now().getYear();
        System.out.println("** Student graduating in next 2 years: **");
        List<Student> graduatingNextTwoYears = students.stream()
                .filter(student -> student.getGraduationYear() >= currentYear && student.getGraduationYear() <= currentYear + 2)
                .collect(Collectors.toList());
        for (Student student : graduatingNextTwoYears) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Graduation Year: " + student.getGraduationYear());
        }
        System.out.println("Total number of students graduating in the next 2 years: " + graduatingNextTwoYears.size());
        System.out.println(" Calculate total number of students per major");
        Map<String, Long> studentsPerMajor = students.stream().collect(groupingBy(Student::getMajor, counting()));
        for (Map.Entry<String, Long> entry : studentsPerMajor.entrySet()) {
            System.out.println("Major: " + entry.getKey() + " - Number of Students: " + entry.getValue());
        }

        System.out.println("** avarage GPA by major **");
        Map<String, Double> averageGpaByMajor = students.stream()
                .collect(groupingBy(Student::getMajor, Collectors.averagingDouble(Student::getGpa)));
        for (Map.Entry<String, Double> entry : averageGpaByMajor.entrySet()) {
            System.out.println("Major: " + entry.getKey() + " - Average GPA: " + entry.getValue());
        }

        System.out.println("** Percentage of international Students**");
        Long totalStdeunts = (long) students.size();
        long totalInternationalStudents = students.stream().filter(student -> student.isInternational()).count();
        double percentageInternationalStudents = (double) totalInternationalStudents / totalStdeunts * 100;
        System.out.println("Percentage of international students: " + percentageInternationalStudents + "%");

        System.out.println("Avarage age of students: ");
        double averageAge = students.stream()
                .collect(Collectors.averagingDouble(Student::getAge));
        System.out.println("Average age of students: " + averageAge);
        System.out.println("Find total credit hours across all students");

        int sumOfCredit = students.stream()
                .mapToInt(Student::getCreditHours)
                .sum();
        System.out.println("Total credit hours across all students: " + sumOfCredit);


        System.out.println("Compute median GPA**");
        List<Double> sortedGpas = students.stream()
                .map(Student::getGpa)
                .sorted()
                .collect(Collectors.toList());
        double medianGpa;
        int size = sortedGpas.size();
        if (size % 2 == 0) {
            medianGpa = (sortedGpas.get(size / 2 - 1) + sortedGpas.get(size / 2)) / 2.0;
        } else {
            medianGpa = sortedGpas.get(size / 2);
        }
        System.out.println("Median GPA: " + medianGpa);

        System.out.println("Find the youngest and oldest students");
        Student youngestStudent = students.stream()
                .min((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
                .orElse(null);
        Student oldestStudent = students.stream()
                .max((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
                .orElse(null);
        if (youngestStudent != null) {
            System.out.println("Youngest Student: " + youngestStudent.getFirstName() + " " + youngestStudent.getLastName() + " - Age: " + youngestStudent.getAge());
        } else {
            System.out.println("No students found.");
        }
        if (oldestStudent != null) {
            System.out.println("Oldest Student: " + oldestStudent.getFirstName() + " " + oldestStudent.getLastName() + " - Age: " + oldestStudent.getAge());
        } else {
            System.out.println("No students found.");
        }
        System.out.println("Calculate scholarship distribution percentage");
        Long StudentWithScholar = students.stream().filter(student -> student.isScholarshipRecipient()).count();
        Long StudentWithnoScholar = students.stream().filter(student -> !student.isScholarshipRecipient()).count();
        double scholarshipPercentage = (double) StudentWithScholar / totalStdeunts * 100;
        double noScholarshipPercentage = (double) StudentWithnoScholar / totalStdeunts * 100;
        System.out.println("Percentage of students with scholarships: " + scholarshipPercentage + "%");
        System.out.println("Percentage of students without scholarships: " + noScholarshipPercentage + "%");
        System.out.println("Determine gender ratio in different majors");
        Map<String, Map<String, Long>> genderRation = students.stream().
                collect(groupingBy(Student::getMajor,
                        groupingBy(Student::getGender, counting())

                ));
        for (Map.Entry<String, Map<String, Long>> entry : genderRation.entrySet()) {
            String major = entry.getKey();
            Map<String, Long> genderCount = entry.getValue();

            for (Map.Entry<String, Long> genderEntry : genderCount.entrySet()) {
                String gender = genderEntry.getKey();
                Long count = genderEntry.getValue();
                System.out.println("Major :" + major + "Gender : " + gender + " :" + count);

            }
        }
        System.out.println("Find universities with highest average GPA");
        Map<String, Double> averageByUniversity = students.stream()
                .collect(groupingBy(Student::getUniversity,
                        Collectors.averagingDouble(Student::getGpa)));
        String universityWithHighestAverageGpa = averageByUniversity.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No universities found");
        double highestAverageGpa = averageByUniversity.values().stream()
                .max(Double::compare)
                .orElse(0.0);
        System.out.println("University with highest average GPA: " + universityWithHighestAverageGpa + " - Average GPA: " + highestAverageGpa);

        System.out.println("Finding Student with multiple criteria ");
        List<Student> multiRequirements = students.stream()
                .filter(student -> student.getGpa() > 3.7
                        && student.isInternational()
                        && student.isStremMajor(student.getMajor())
                        && student.isScholarshipRecipient()).collect(Collectors.toList());
        if (multiRequirements.isEmpty()) {
            System.out.println("No students found matching the criteria.");
        } else {
            System.out.println("Students matching multiple criteria:" + multiRequirements.size());

        }
        System.out.println("Create a comprehensive student profile ranking system");
        List<Student> rankedStudents = students.stream()
                .sorted((s1, s2) -> {
                    int gpaComparison = Double.compare(s2.getGpa(), s1.getGpa());
                    if (gpaComparison != 0) {
                        return gpaComparison;
                    }
                    return Integer.compare(s2.getCreditHours(), s1.getCreditHours());
                })
                .collect(Collectors.toList());
        System.out.println("Ranked Students:");
        for (Student student : rankedStudents) {
            System.out.println(student.getFirstName() + " "
                    + student.getLastName() +
                    " - GPA: " + student.getGpa()
                    + ", Credit Hours: " + student.getCreditHours());
        }

    }

}

