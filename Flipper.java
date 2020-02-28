import java.sql.SQLOutput;
import java.util.Scanner;

public class Flipper {

    static Scanner sc;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        int[] array = {1, 2, 3, 4};
        int temp1, temp2;

        String command = sc.nextLine();

        for (int i = 0; i < command.length(); i ++)
        {
            char x = command.charAt(i);

            if (x == 'H')
            {
                temp1 = array[0];
                temp2 = array[1];
                array[0] = array[2];
                array[1] = array[3];
                array[2] = temp1;
                array[3] = temp2;

            }
            else if (x == 'V')
            {
                temp1 = array[0];
                temp2 = array[2];
                array[0] = array[1];
                array[2] = array[3];
                array[1] = temp1;
                array[3] = temp2;
            }
        } // for loop

        System.out.println(array[0] + " " + array[1]);
        System.out.println(array[2] + " " + array[3]);

    } // main

}
