package Capg;
import java.util.*;

public class SnakeGame {

    static final int SIZE = 10;
    static LinkedList<int[]> snake = new LinkedList<>();
    static int foodX, foodY;
    static char direction = 'R';
    static boolean gameOver = false;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Initial snake position
        snake.add(new int[]{5, 5});
        placeFood();

        while (!gameOver) {
            printBoard();
            System.out.print("Move (W/A/S/D): ");
            direction = sc.next().toUpperCase().charAt(0);
            moveSnake();
            checkCollision();
        }

        System.out.println("Game Over!");
    }

    static void placeFood() {
        Random r = new Random();
        foodX = r.nextInt(SIZE);
        foodY = r.nextInt(SIZE);
    }

    static void moveSnake() {
        int[] head = snake.getFirst();
        int x = head[0];
        int y = head[1];

        switch (direction) {
            case 'W': x--; break;
            case 'S': x++; break;
            case 'A': y--; break;
            case 'D': y++; break;
            default: System.out.println("Invalid move!");
        }

        int[] newHead = {x, y};

        // Eat food
        if (x == foodX && y == foodY) {
            snake.addFirst(newHead);
            placeFood();
        } else {
            snake.addFirst(newHead);
            snake.removeLast();
        }
    }

    static void checkCollision() {

        int[] head = snake.getFirst();

        // Wall collision
        if (head[0] < 0 || head[0] >= SIZE || head[1] < 0 || head[1] >= SIZE) {
            gameOver = true;
            return;
        }

        // Self collision
        for (int i = 1; i < snake.size(); i++) {
            if (head[0] == snake.get(i)[0] && head[1] == snake.get(i)[1]) {
                gameOver = true;
                return;
            }
        }
    }

    static void printBoard() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                boolean printed = false;

                // Snake
                for (int[] part : snake) {
                    if (part[0] == i && part[1] == j) {
                        System.out.print("S ");
                        printed = true;
                        break;
                    }
                }

                // Food
                if (!printed && i == foodX && j == foodY) {
                    System.out.print("F ");
                    printed = true;
                }

                if (!printed) {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    }
