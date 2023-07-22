import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "grades.txt";
        List<StudentGrade> studentGrades = GradeReader.readGrades(filePath);
        Classroom classroom = new Classroom(studentGrades);

        System.out.println("Grades for Math: " + classroom.getGradesForDiscipline("Mathematics"));
        System.out.println("Grades for Amilia Hilaria: " + classroom.getGradesForStudent("Amilia Hilaria"));

        System.out.println("Max grade for Physics: " + classroom.getMaxGrade("Physics"));
        System.out.println("Max grade overall: " + classroom.getMaxGrade());

        System.out.println("Average grade for Math: " + classroom.getAverageGrade("Mathematics"));

        System.out.println("Worst grade for Computer Science: " + classroom.getWorstGrade("Computer Science"));
        System.out.println("Worst grade overall: " + classroom.getWorstGrade());


        ReportGenerator reportGenerator = new ReportGenerator(studentGrades);
        reportGenerator.generateReport("grade-reports.out");


    }
}