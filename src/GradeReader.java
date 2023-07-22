import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeReader {
    public static List<StudentGrade> readGrades(String filePath) {
        List<StudentGrade> studentGrades = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");
                String name = data[0].trim();
                String discipline = data[1].trim();
                int grade = Integer.parseInt(data[2].trim());
                StudentGrade studentGrade = new StudentGrade(name, discipline, grade);
                studentGrades.add(studentGrade);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return studentGrades;
    }
}
