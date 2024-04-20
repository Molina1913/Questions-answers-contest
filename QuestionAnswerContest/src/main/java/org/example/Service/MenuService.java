package org.example.Service;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Service.QuestionOptionService.setUpGame;
import static org.example.Service.ServiceConstants.VALID_OPTION;
import static org.example.menu.Menu.startGame;

public class MenuService {
    public static void startApp() throws SQLException {
        int option;
        boolean flag = true;
        while (flag) {
            startGame();
            option = askOption();
            flag = selectOption(option, flag);
        }
    }

    private static boolean selectOption(int option, boolean flag) throws SQLException {
        switch (option) {
            case 1:
                break;
            case 2:
                setUpGame();
                break;
            case 0:
                flag = false;
                break;
            default:
                System.out.println(VALID_OPTION);
        }
        return flag;
    }

    public static int askOption() {
        Scanner scanner = new Scanner(System.in);
        int option;
        try {
            option = scanner.nextInt();
        } catch (Exception e) {
            option = 100;
            System.out.println("Error " + e.getMessage());
        }
        return option;
    }
}
