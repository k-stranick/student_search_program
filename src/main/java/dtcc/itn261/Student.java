package dtcc.itn261;

import java.util.ArrayList;
import java.util.stream.Collectors;

// what does a student have?? this should answer that

public class Student {
    //private final ClassStanding standing;
    private final long id;
    private final ProgramOfStudy programOfStudy;
    private final Object firstName;
    private final String lastName;
    private final ArrayList<Double> grades; //final to not create another instance

    // constructor for student
    public Student(long id, ProgramOfStudy programOfStudy, String firstName, String lastname, ArrayList<Double> grades) {
        this.id = id;
        this.programOfStudy = programOfStudy;
        //this.standing = standing;
        this.firstName = firstName;
        this.lastName = lastname;
        this.grades = grades;
    }

    public ProgramOfStudy getProgramOfStudy() {
        return programOfStudy;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    // emergent property
    public double getAverage() {
        double sum = 0; // accumulator
        for (double grade : grades) {
            // math logic
            sum += grade;
        }

        return sum / grades.size();
    }

    public String getStudentGradesAsString() {
        // https://www.baeldung.com/java-list-to-string
        return this.grades.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return "Student ID: " + id + "  Program of Study: " + programOfStudy + "  First Name: " + firstName + "  Last Name: " + lastName + "  Grades: " + getStudentGradesAsString();
    }

    /*
    for use with search bar functionality
    public ClassStanding getStanding() {
    return standing;
    }*/
}
