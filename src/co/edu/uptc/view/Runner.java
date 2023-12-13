package co.edu.uptc.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.uptc.controller.AdministratorController;

public class Runner {

    public static void main(String[] args) {
        AdministratorController administratorController = new AdministratorController();
        InterfazAdmin interfazAdmin = new InterfazAdmin();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int option = 0;
        do {
            try {
                if (option >= 0 && option < 5) {
                    do {
                        System.out.println("\n hello person " + "\n Choose how you identify\n" +
                                "1. Administrator\n" +
                                "2. User\n" +
                                "3. Visitor\n" +
                                "4. Leave");
                        option = sc.nextInt();
                        switch (option) {
                            case 1:
                                InterfazAdmin.main(args);
                                option = 0;
                                break;
                            case 2:
                                InterfazUser.validationUser();
                                break;
                            case 3:
                                InterfazVisitor.interfaz();
                                break;
                            case 4:
                                break;

                        }
                    } while (option != 4);
                    flag = true;
                } else {
                    System.out.println("............ Invalid option ............");
                    flag = false;
                }

            } catch (InputMismatchException e) {
                System.out.println(
                        "............ Error, no characters accepted, please enter a correct answer ............\n");
                flag = false;
                sc.nextLine();
            }
        } while (!flag);
    }

}
