package Senior_2019;

import java.util.*;

import java.util.Scanner;

public class SolvedMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] row = new String[3][3];

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String line3 = sc.nextLine();

        row[0] = line1.split(" ");
        row[1] = line2.split(" ");
        row[2] = line3.split(" ");

        boolean solved = false;
        int xCount = 0;
        boolean[][] pos = new boolean[3][3];
        int tries = 0;
        boolean coolWay;

        while (!solved) {
            coolWay = false;

            for (int i = 0; i < 3; i++) {
                xCount = 0;

                for (int j = 0; j < 3; j++) {

                    if (!(isNumber(row[i][j]))) {
                        xCount++;
                        pos[i][j] = false;
                    }
                    else
                        pos[i][j] = true;

                    if (j == 2 && xCount == 1 && !coolWay) {
                        coolWay = true;

                        if (pos[i][0] && pos[i][1]) {
                            row[i][2] = String.valueOf((Integer.parseInt(row[i][1]) + (Integer.parseInt(row[i][1]) - Integer.parseInt(row[i][0]))));
                            pos[i][2] = true;
                        } else if (pos[i][1] && pos[i][2]) {
                            row[i][0] = String.valueOf(Integer.parseInt(row[i][1]) - (Integer.parseInt(row[i][2]) - Integer.parseInt(row[i][1])));
                            pos[i][0] = true;
                        } else if (pos[i][0] && pos[i][2]) {
                            row[i][1] = String.valueOf((Integer.parseInt(row[i][0]) + ((Integer.parseInt(row[i][2]) - Integer.parseInt(row[i][0])) / 2)));
                            pos[i][1] = true;
                        }
                    } // iF 3 X's and J ==3

                } // For loop
            } // For Loop

            //SOLVE COLUMNS
            for (int y = 0; y < 3; y++) {

                xCount = 0;
                for (int q = 0; q < 3; q++) {
                    if (!(pos[q][y]))
                        xCount++;

                    if (q == 2 && xCount == 1 && !coolWay) {
                        coolWay = true;

                        if (pos[0][y] && pos[1][y]) {
                            row[2][y] = String.valueOf(( Integer.parseInt(row[1][y]) + (Integer.parseInt(row[1][y]) - Integer.parseInt(row[0][y]) ) ));
                            pos[2][y] = true;
                        } else if (pos[1][y] && pos[2][y]) {
                            row[0][y] = String.valueOf(Integer.parseInt(row[1][y]) - (Integer.parseInt(row[2][y]) - Integer.parseInt(row[1][y])));
                            pos[0][y] = true;
                        } else if (pos[0][y] && pos[2][y]) {
                            row[1][y] = String.valueOf((Integer.parseInt(row[0][y]) + ((Integer.parseInt(row[2][y]) - Integer.parseInt(row[0][y])) / 2)));
                            pos[1][y] = true;
                        }

                    } // iF 3 X's and J ==3\

                } // For Loop 2
            } // For loop 1


            String copyNum = null;

            //SITUATION WHERE MIDDLE ROW HAS TWO X'S
            xCount = 0;
            for (int l = 0; l < 3; l ++)
            {
                if (!(pos[1][l]))
                    xCount++;
                else
                    copyNum = row[1][l];
            }
            if (xCount == 2 && !coolWay)
            {
                coolWay = true;
                row[1][0] = copyNum;
                row[1][1] = copyNum;
                row[1][2] = copyNum;
                pos[1][0] = true;
                pos[1][1] = true;
                pos[1][2] = true;
            }

            //SITUATION ONE FOR ROWS
            for (int z = 0; z < 3; z ++)
            {
                xCount = 0;
                for (int c = 0; c < 3; c++)
                {
                    if (!(pos[z][c]))
                        xCount++;
                    else
                        copyNum = row[z][c];
                }

                if (xCount == 2 && !coolWay)
                {
                    coolWay = true;
                    row[z][0] = copyNum;
                    row[z][1] = copyNum;
                    row[z][2] = copyNum;
                    pos[z][0] = true;
                    pos[z][1] = true;
                    pos[z][2] = true;
                    break;
                }
            }


            //SITUATION TWO WITH COLUMNS
            for (int z = 0; z < 3; z ++)
            {
                xCount = 0;
                for (int c = 0; c < 3; c++)
                {
                    if (!(pos[c][z]))
                        xCount++;
                    else
                        copyNum = row[c][z];
                }

                if (xCount == 2 && !coolWay)
                {
                    row[0][z] = copyNum;
                    row[1][z] = copyNum;
                    row[2][z] = copyNum;
                    pos[0][z] = true;
                    pos[1][z] = true;
                    pos[2][z] = true;
                    break;
                }
            }


            //SOLVED?
            int total = (hasNumber(row[0]) + hasNumber(row[1]) + hasNumber(row[2]));
            if (total == 9)
                solved = true;

            tries++;

            if (tries == 100)
            {
                System.out.println("FAILED!");
                break;
            }

        } // While Solved

        for (int q = 0; q < 3; q ++)
        {
            System.out.println(row[q][0] + " " + row[q][1] + " " + row[q][2]);
        }

    } // Main

    public static boolean isNumber(String x) {
        try {
            int y = Integer.parseInt(x);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int hasNumber(String[] array) {
        int number = 0;
        for (int i = 0; i < 3; i++) {
            if (isNumber(array[i]))
                number++;
        }

        return number;
    }


} // Class
