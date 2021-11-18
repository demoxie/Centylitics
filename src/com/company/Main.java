package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(numberOfDaysToCompleteUpdate(new int[][]{{1,0,0},{0,0,1},{0,0,1}}));
    }
    public static int numberOfDaysToCompleteUpdate (int[][] serverStates) {
        int no_of_days = 0;
        int[][] temp = new int[serverStates.length][serverStates[0].length];
        int noOfStatesToUpdate = Arrays.stream(serverStates).mapToInt(arr -> (int) Arrays.stream(arr).filter(a -> a == 0).count()).sum();
        while (noOfStatesToUpdate > 0) {
            for (int i = 0; i < serverStates.length; i++) {
                int j = 0;
                while (j < serverStates[0].length) {
                    //Check Current Value
                    if (serverStates[i][j] == 1) {
                        if (temp[i][j] != 1) {
                            temp[i][j] = 1;
                        }
                        // check forward
                        if (j < serverStates[0].length-1 && serverStates[i][j+1] == 0) {
                            if (temp[i][j+1] != 1) {
                                temp[i][j + 1] = 1;
                                noOfStatesToUpdate--;
                            }
                        }
                        // check backward
                        if (j > 0 && serverStates[i][j-1] == 0) {
                            if (temp[i][j-1] != 1) {
                                temp[i][j - 1] = 1;
                                noOfStatesToUpdate--;
                            }
                        }
                        // check downward
                        if (i < serverStates.length-1 && serverStates[i+1][j] == 0) {
                            if (temp[i+1][j] != 1) {
                                temp[i + 1][j] = 1;
                                noOfStatesToUpdate--;
                            }
                        }
                        // check upward
                        if (i > 0 && serverStates[i-1][j] == 0) {
                            if (temp[i-1][j] != 1) {
                                temp[i - 1][j] = 1;
                                noOfStatesToUpdate--;
                            }
                        }
                    }
                    j++;
                }
            }
            System.out.println(Arrays.deepToString(temp));
            serverStates = temp;
            temp = new int[serverStates.length][serverStates[0].length];
            no_of_days++;
        }
        return no_of_days;
    }
}
