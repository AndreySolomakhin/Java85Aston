package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.model.Student;

import javax.swing.*;

public class OutputAllStudentsConsoleStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        getAllStudents();
    }

    private static void getAllStudents() {
        if (Student.studentList.size() == 0) {
            JOptionPane.showMessageDialog(null, "Список студентов пуст.");
            return;
        }

        StringBuilder sb = new StringBuilder("Список студентов:\n\n");
        for (Student s : Student.studentList) {
            sb.append(s.toString()).append("\n");
            System.out.println(s); // Оставляем вывод в консоль для отладки
        }

        // Создаем прокручиваемую область для большого списка
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Текущая база студентов", JOptionPane.PLAIN_MESSAGE);
    }
}
