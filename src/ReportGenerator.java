import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {
    private List<StudentGrade> studentGrades;

    public ReportGenerator(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }


    public void generateReport(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            StudentGrade maxGradeStudent = new Classroom(studentGrades).getMaxGrade();
            StudentGrade minGradeStudent = new Classroom(studentGrades).getWorstGrade();
            Integer averageGrade = new Classroom(studentGrades).getAveragePerAll();

            writer.write("Cea mai mare nota: " + maxGradeStudent.getName() + " " + maxGradeStudent.getGrade() + "\n");
            writer.write("Nota medie: " + averageGrade + "\n");
            writer.write("Cea mai mica nota: " + minGradeStudent.getName() + " " + minGradeStudent.getGrade() + "\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
