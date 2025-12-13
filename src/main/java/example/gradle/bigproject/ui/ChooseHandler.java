package example.gradle.bigproject.ui;

import javax.swing.*;

public class ChooseHandler {

    static String[] optionsToRead = {"Вручную", "Из списка", "Рандомом", "Выйти из программы"};
    public static boolean isWork = true;

    public static int getChoose() {
        int indexChooseToReadFile = JOptionPane.showOptionDialog(null,
                "Какой вариант заполнения списка выберите?",
                "Варианты заполнения списка",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, optionsToRead, optionsToRead[0]);

        System.out.println(indexChooseToReadFile);

        return indexChooseToReadFile;
    }

    public static void handleChoose(int indexChooseToReadFile) {
        switch (indexChooseToReadFile) {
            //Место для вставки ссылок на Reader от Полины в зависимости от типа загрузки
            case 0 -> System.out.println(optionsToRead[indexChooseToReadFile]);
            case 1 -> System.out.println(optionsToRead[indexChooseToReadFile]);
            case 2 -> System.out.println(optionsToRead[indexChooseToReadFile]);
            case 3 -> isWork = false;
        }
    }

}
