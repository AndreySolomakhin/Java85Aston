package example.gradle.bigproject.ui;

import example.gradle.bigproject.handlerresponse.*;

import javax.swing.*;

public class UserInterface {

    static String[] optionsToRead = {"Вручную", "Из списка", "Рандомом", "Выйти из программы"};
    public static boolean isWork = true;

    public static int getChoose() {

        return JOptionPane.showOptionDialog(null,
                "Какой вариант заполнения списка выберите?",
                "Варианты заполнения списка",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, optionsToRead, optionsToRead[0]);
    }

    public static void handleChoose(int indexChooseToReadFile) {
        switch (indexChooseToReadFile) {
            //Место для вставки ссылок на Reader от Полины в зависимости от типа загрузки
            case 0 -> new ManuallyHandler().handleResponse();
            case 1 -> new FromFileHandler().handleResponse();
            case 2 -> new RandomHandler().handleResponse();
            case 3 -> new ExitHandler().handleResponse();
        }
    }

}
