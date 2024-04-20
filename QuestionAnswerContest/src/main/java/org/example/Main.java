package org.example;

import static org.example.Service.MenuService.startApp;

public class Main {
    public static void main(String[] args) {
        try{
            startApp();
        }catch (Exception e){
            System.out.println("Error general: "+e.getMessage());
        }
    }
}