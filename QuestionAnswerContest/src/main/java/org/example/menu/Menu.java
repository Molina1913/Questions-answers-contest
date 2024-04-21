package org.example.menu;

import static org.example.menu.ConstantesMenu.CONTINUE_MENU;
import static org.example.menu.ConstantesMenu.DIFFICULTY_MENU;

public class Menu {
    public static void startGameMenu(){
        System.out.println(ConstantesMenu.MENU_START_GAME);

    }
    public static void setUpOptions(){
        System.out.println(ConstantesMenu.MENU_SET_UP_GAME);
    }
    public static void difficultyMenu(){
        System.out.println(DIFFICULTY_MENU);
    }
    public static void continueMenu(){
        System.out.println(CONTINUE_MENU);
    }
}
