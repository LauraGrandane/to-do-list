package com.companyLaura;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Lauras TO-DO LIST 'IZVĒLNE'");
        System.out.println();

        // INSERT FORM, kurai nedarbojas pogas
        InsertForm insertForm = new InsertForm(null);


        // MY FRAME, kuram nekas īsti nedarbojas
        //MyFrame frame = new MyFrame();


        // CRUD
        Scanner scanner4 = new Scanner(System.in);
        int izvēlne;
        Conn dblogic = new Conn();

        //dblogic.insert2();  //šis domāts kādai pogai "ātrā ievietošana", ja vajag tikai NAME kolonnā

        do {
            System.out.println("SĀKUMS:");
            System.out.println("Izvēlies ciparu:");
            System.out.println("1 - pievienot jaunu darāmo darbu");
            System.out.println("2 - atzīmēt izdarītu darbu");
            System.out.println("3 - izdzēst darāmo darbu");
            System.out.println("4 - apskatīties visu TO-DO LIST");
            System.out.println("5 - apskatīties tikai darāmos darbus");
            System.out.println("6 - apskatīties darbus paveikšanas secībā");
            System.out.println("7 - iziet no IZVĒLNES");

            izvēlne = scanner4.nextInt();

            switch (izvēlne) {
                case 1 -> dblogic.insert();
                case 2 -> dblogic.update();
                case 3 -> dblogic.delete();
                case 4 -> dblogic.select();
                case 5 -> dblogic.select2();
                case 6 -> dblogic.select3();
                case 7 -> System.out.println("OK. Līdz nākamajai reizei!");
                default -> System.out.println("ERROR. Nepareizs cipars.");
            }
                System.out.println();

        } while (!Objects.equals(izvēlne, 7));
    }
}
