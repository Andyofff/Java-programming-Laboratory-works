import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Exam {
    String examName;
    int examResult;
    String teacherName;

    Exam() {
        examName = null;
        examResult = 0;
        teacherName = null;
    }

    Exam(String _examName, int _examResult, String _teacherName) {
        examResult = _examResult;
        examName = _examName;
        teacherName = _teacherName;
    }

    public void setExamName(String _examName) {
        examName = _examName;
    }

    public String getExamName() {
        return this.examName;
    }

    public void setExamResult(int _examResult) {
        examResult = _examResult;
    }

    public int getExamResult() {
        return this.examResult;
    }

    public void setTeacherName(String _teacherName) {
        teacherName = _teacherName;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void examReader(Scanner in, FileReader fr) throws IOException {
        String line = in.nextLine();
        String[] words = line.split(" ");
        String _teacherName = words[0];
        int _examResult = Integer.parseInt(words[1]);
        StringBuilder _examName = new StringBuilder();
        for (int i = 2; i < words.length; i++) {
            _examName.append(words[i].toLowerCase()).append(" ");
        }
        setExamName(_examName.toString());
        setTeacherName(_teacherName);
        setExamResult(_examResult);
    }
}
class MyComparator implements Comparator<Exam> {
    @Override
    public int compare(Exam exam1, Exam exam2) {
        return exam1.getExamName().compareTo(exam2.getExamName());
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);

        int numOfExam = Integer.parseInt(in.nextLine());

        ArrayList<Exam> exams = new ArrayList<>();

            for (int j = 0; j < numOfExam; j++) {
                Exam exam = new Exam();
                exam.examReader(in, fr);
                exams.add(exam);
            }

        // Сортировка экзаменов по имени
        Collections.sort(exams, new MyComparator());
        // Считывание искомого экзамена
        String examName = in.nextLine();
        int i = Collections.binarySearch(exams, new Exam("aat analyses", 9, "Ivan"), new MyComparator());
        if (i < 0) {
            System.out.println("Exam NOT found");
        } else {
            System.out.println(exams.get(i).examName);
        }
       /* int left = 0;
        int right = exams.size() - 1;
        while(left <= right) {
            int mid =  (left + right) / 2;
            if (exams.get(mid).getExamName().equals(examName)) {
                fw.write("Exam found");
                break;
            } else if (exams.get(mid).getExamName().compareTo(examName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }  */

        // Вывод в файл
        for (Exam exam : exams) {
            fw.write("Teacher name: " + exam.getTeacherName() + '\t' + "Exam result: "  +
                    exam.getExamResult() + '\t' + exam.getExamName() + '\n');
        }
        fw.close();
    }

}