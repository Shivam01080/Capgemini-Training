package Capg;
import java.util.Scanner;

public class twoarray {

	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter rows and columns: ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] a = readMatrix(m, n);
        printMatrix(a);

        sumOfAllElements(a);
        rowSum(a);
        columnSum(a);
        maxMin(a);
        countEvenOdd(a);
        searchElement(a);
        printReverse(a);
        countZeros(a);

        if (m == n) {
            trace(a);
            transpose(a);
        } else {
            System.out.println("Trace & transpose need square matrix");
        }

        int[][] b = readMatrix(m, n);

        addMatrices(a, b);
        subtractMatrices(a, b);
        checkEqual(a, b);

        largestInEachRow(a);
        smallestInEachColumn(a);
    }

    // ---------- BASIC METHODS ----------

    static int[][] readMatrix(int m, int n) {
        int[][] mat = new int[m][n];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        return mat;
    }

    static void printMatrix(int[][] a) {
        System.out.println("Matrix:");
        for (int[] row : a) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    static void sumOfAllElements(int[][] a) {
        int sum = 0;
        for (int[] row : a)
            for (int val : row)
                sum += val;
        System.out.println("Sum of all elements: " + sum);
    }

    static void rowSum(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < a[i].length; j++)
                sum += a[i][j];
            System.out.println("Row " + i + " sum: " + sum);
        }
    }

    static void columnSum(int[][] a) {
        for (int j = 0; j < a[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < a.length; i++)
                sum += a[i][j];
            System.out.println("Column " + j + " sum: " + sum);
        }
    }

    static void maxMin(int[][] a) {
        int max = a[0][0], min = a[0][0];
        for (int[] row : a)
            for (int val : row) {
                if (val > max) max = val;
                if (val < min) min = val;
            }
        System.out.println("Max: " + max + " Min: " + min);
    }

    static void countEvenOdd(int[][] a) {
        int even = 0, odd = 0;
        for (int[] row : a)
            for (int val : row)
                if (val % 2 == 0) even++; else odd++;
        System.out.println("Even: " + even + " Odd: " + odd);
    }

    static void searchElement(int[][] a) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] == key) {
                    System.out.println("Found at (" + i + "," + j + ")");
                    found = true;
                }

        if (!found) System.out.println("Not found");
    }

    static void printReverse(int[][] a) {
        System.out.println("Reverse order:");
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = a[i].length - 1; j >= 0; j--)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    static void countZeros(int[][] a) {
        int count = 0;
        for (int[] row : a)
            for (int val : row)
                if (val == 0) count++;
        System.out.println("Zero count: " + count);
    }

    static void trace(int[][] a) {
        int trace = 0;
        for (int i = 0; i < a.length; i++)
            trace += a[i][i];
        System.out.println("Trace: " + trace);
    }

    static void transpose(int[][] a) {
        System.out.println("Transpose:");
        for (int j = 0; j < a[0].length; j++) {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    static void addMatrices(int[][] a, int[][] b) {
        System.out.println("Addition:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + b[i][j] + " ");
            System.out.println();
        }
    }

    static void subtractMatrices(int[][] a, int[][] b) {
        System.out.println("Subtraction:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] - b[i][j] + " ");
            System.out.println();
        }
    }

    static void checkEqual(int[][] a, int[][] b) {
        boolean equal = true;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] != b[i][j])
                    equal = false;

        System.out.println(equal ? "Matrices are equal" : "Matrices are NOT equal");
    }

    static void largestInEachRow(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            int max = a[i][0];
            for (int j = 1; j < a[i].length; j++)
                if (a[i][j] > max) max = a[i][j];
            System.out.println("Largest in row " + i + ": " + max);
        }
    }

    static void smallestInEachColumn(int[][] a) {
        for (int j = 0; j < a[0].length; j++) {
            int min = a[0][j];
            for (int i = 1; i < a.length; i++)
                if (a[i][j] < min) min = a[i][j];
            System.out.println("Smallest in column " + j + ": " + min);
        }
    }
}