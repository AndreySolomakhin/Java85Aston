package example.gradle.bigproject.Validators;
import example.gradle.bigproject.model.Student;

public class StudentValidator {

    public static boolean validate(Student st) {
        if (st.getGpa() > 0 &&
                st.getGpa() <= 100 &&
                st.getRecordBookNumber() > 0 &&
                !st.getStudentName().isBlank()) {
            return true;
        }
        return false;
    }
}