package dtcc.itn261;

import java.io.*;
import java.util.ArrayList;

/**
 * The {@code LoadRoster} class extends {@code ArrayList<Student>} to represent a list of students loaded from a file.
 * It provides methods to load student data from a specified file into the roster,
 * retrieve students by their program of study, and search for students by name or ID.
 */
public class LoadRoster extends ArrayList<Student> {

    private final File STUDENT_FILE_LOCATION = new File("src/main/resources/student_list1.txt");// need to test on another computer

    /**
     * Constructs a new {@code LoadRoster} and initializes it by loading student data from the file located at {@code STUDENT_FILE_LOCATION}.
     *
     * @throws IOException If there is an error reading the file.
     */
    public LoadRoster() throws IOException {
        if (!STUDENT_FILE_LOCATION.exists()) {
            throw new FileNotFoundException("File not found: " + STUDENT_FILE_LOCATION); // ask to create file? nested if/else
        }
        // try with resources will close automatically if it utilizes catch block or not
        try (FileInputStream studentFile = new FileInputStream(STUDENT_FILE_LOCATION)) {
            BufferedReader readFromFile = new BufferedReader(new InputStreamReader(studentFile));
            String eachStudent; // will be reassigned to studentInformation

            while ((eachStudent = readFromFile.readLine()) != null) {  // creating students and grades by reading each element
                String[] studentInformation = eachStudent.split(","); // creates a string list comma separating each element

                if (studentInformation.length >= 4) {  // parsing logic if the length of the list is greater than or equal to 4
                    int id = Integer.parseInt(studentInformation[0].trim()); // parse to run to string? look up again
                    ProgramOfStudy programOfStudy = ProgramOfStudy.valueOf(studentInformation[1].trim());
                    String firstName = studentInformation[2].trim();
                    String lastName = studentInformation[3].trim();

                    ArrayList<Double> studentGrades = new ArrayList<>();
                    for (int i = 4; i < studentInformation.length; i++) {
                        Double grade = Double.parseDouble(studentInformation[i].trim());
                        studentGrades.add(grade);
                    }

                    this.add(new Student(id, programOfStudy, firstName, lastName, studentGrades));
                }
            }
        }
    }

    public ArrayList<Student> GetStudentsByProgramOfStudy(ProgramOfStudy program) {
        // When all is selected
        if (program == ProgramOfStudy.ALL) {
            return new ArrayList<Student>(this); // return ArrayList of students
        }
        // keeps track is subset of ALL list returning students by selected standing
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : this) {
            // When specific class is selected
            if (student.getProgramOfStudy() == program) {
                result.add(student);
            }
        }
        return result;
    }

    public ArrayList<Student> searchForStudent(String query) { // used with search bar
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : this) {
            if (student.getFullName().toLowerCase().contains(query.toLowerCase()) ||
                    String.valueOf(student.getId()).contains(query) ||
                    student.getProgramOfStudy().toString().toLowerCase().contains(query.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    /*    public ArrayList<Student> GetStudentsByClassStanding(ClassStanding standing) {
        // When all is selected
        if (standing == ClassStanding.ALL) {
            return new ArrayList<Student>(this);
        }

        //Why new ArrayList here?? -> keeps track is subset of full list returning students by selected standing
        ArrayList<Student> result = new ArrayList<>();

        for (Student student : this) {
            // When specific class is selected
            if (student.getStanding() == standing) {
                result.add(student);
            }
        }
        return result;
    }*/
}
