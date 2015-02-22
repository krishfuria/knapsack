/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author krishfuria
 */
public class Knapsack {

    public static void main(String[] args) throws Exception {
        int n = 0;
        ArrayList<Integer> wi = new ArrayList();
        ArrayList<Integer> v = new ArrayList();
        BufferedReader fis = new BufferedReader(new FileReader("midterm_problem.txt"));
        String str = fis.readLine();
        int w = Integer.parseInt(str);
        str = fis.readLine();
        while (str != null) {
            String str1[] = str.split(" ");
            wi.add(Integer.parseInt(str1[0]));
            v.add(Integer.parseInt(str1[1]));
            str = fis.readLine();
            n++;
        }

        int[][] opt = new int[n + 1][w + 1];
        for (int i = 0; i <= w; i++) {
            opt[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            opt[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wi.get(i - 1) > j) {
                    opt[i][j] = opt[i - 1][j];
                } else {
                    int k = j - wi.get(i - 1);
                    int z = v.get(i - 1) + opt[i][k];
                    opt[i][j] = Math.max(opt[i - 1][j], z);
                }

            }
        }
        for(int i=0;i<=w;i++)
        {
            System.out.println(i+": "+opt[n][i]);
        }
    }

}
