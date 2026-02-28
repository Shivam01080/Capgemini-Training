package Capg;

import java.util.ArrayList;
import java.util.List;

public class MatrixAdd extends Thread {
	int[][] arr1;
	int[][] arr2;
	int[][] result;
	int row;
	public MatrixAdd(int[][] arr1, int [][] arr2, int[][] result,int row) {
		this.arr1 = arr1;
		this.arr2 = arr2;
		this.result = result;
		this.row = row;
	}
	public void run(){
		this.add();
	}
	void add() { 
		for (int j = 0; j < arr1[row].length; j++) {
            result[row][j] = arr1[row][j] + arr2[row][j];
		}
	}
	public static void main(String[] args) throws InterruptedException {
		int [][] array1= {{1,2,3},{4,5,6},{7,8,9}}; 
		int [][] array2= {{8,8,0},{4,9,6},{6,9,1}};
		int[][] result = new int[array1.length][array1[0].length];
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            MatrixAdd t = new MatrixAdd(array1, array2, result, i);
            list.add(t);
            t.start();
        }
        for (Thread t : list) {
            t.join();
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
		
	}

}
