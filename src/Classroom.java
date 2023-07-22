import java.util.ArrayList;
import java.util.List;


public class Classroom {
    private List<StudentGrade> studentGrades;

    public Classroom(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public List<Integer> getGradesForDiscipline(String discipline) {
        List<Integer> grades = new ArrayList<>();
        for(StudentGrade studentGrade : studentGrades) {
            if(studentGrade.getDiscipline().equals(discipline)) {
                grades.add(studentGrade.getGrade());
            }
        }
        return grades;
    }

    public List<Integer> getGradesForStudent(String student) {
        List<Integer> grades = new ArrayList<>();
        for(StudentGrade studentGrade : studentGrades) {
            if(studentGrade.getName().equals(student)) {
                grades.add(studentGrade.getGrade());
            }
        }
        return grades;
    }

    public StudentGrade getMaxGrade(String discipline) {
        StudentGrade maxGradeStudent = null;
        int maxGrade = Integer.MIN_VALUE;

        for (StudentGrade studentGrade : studentGrades) {
            if (discipline == null || studentGrade.getDiscipline().equals(discipline)) {
                if (studentGrade.getGrade() > maxGrade) {
                    maxGrade = studentGrade.getGrade();
                    maxGradeStudent = studentGrade;
                }
            }

        }
        return maxGradeStudent;
    }

    public StudentGrade getMaxGrade() {
        return getMaxGrade(null);
    }

    public Integer getAverageGrade(String discipline) {
        List<Integer> grades = getGradesForDiscipline(discipline);
        if (grades.isEmpty()) {
            return null;
        } else {
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        }
    }

    public Integer getAveragePerAll() {
        List<Integer> grades = new ArrayList<>();
        for(StudentGrade studentGrade : studentGrades) {
                grades.add(studentGrade.getGrade());
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public StudentGrade getWorstGrade(String discipline) {
        int minGrade = Integer.MAX_VALUE;
        StudentGrade minGradeStudent = null;
        for (StudentGrade studentGrade : studentGrades) {
            if (discipline == null || studentGrade.getDiscipline().equals(discipline)) {
                if (studentGrade.getGrade() < minGrade) {
                    minGrade = studentGrade.getGrade();
                    minGradeStudent = studentGrade;
                }
            }
        }
        return minGradeStudent;
    }

    public StudentGrade getWorstGrade() {
        return getWorstGrade(null);
    }
}
