package com.tts;
import java.util.*;
public class TicTacToe {
    static ArrayList<Integer> playerPosition=new ArrayList<>();
    static ArrayList<Integer> cpuPosition=new ArrayList<>();
    public static void printGameBoard(char[][] board){
        for(char[] row:board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void fillPostion(int postion,char[][] gameBoard,String user){
        char Symbol=' ';
        if(user.equals("player")) {
            Symbol = 'X';
            playerPosition.add(postion);
        }
        else if(user.equals("cpu")){
            Symbol = 'O';
            cpuPosition.add(postion);
        }
        switch (postion){
            case 1:
                gameBoard[0][0]=Symbol;
                break;
            case 2:
                gameBoard[0][2]=Symbol;
                break;
            case 3:
                gameBoard[0][4]=Symbol;
                break;
            case 4:
                gameBoard[2][0]=Symbol;
                break;
            case 5:
                gameBoard[2][2]=Symbol;
                break;
            case 6:
                gameBoard[2][4]=Symbol;
                break;
            case 7:
                gameBoard[4][0]=Symbol;
                break;
            case 8:
                gameBoard[4][2]=Symbol;
                break;
            case 9:
                gameBoard[4][4]=Symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner(){
        boolean win=false;
        List topRow= Arrays.asList(1,2,3);
        List midRow= Arrays.asList(4,5,6);
        List botRow= Arrays.asList(7,8,9);
        List leftCol= Arrays.asList(1,4,7);
        List midCol= Arrays.asList(2,5,8);
        List rightCol= Arrays.asList(3,6,9);
        List cross1= Arrays.asList(1,5,9);
        List cross2= Arrays.asList(7,5,3);
        List<List> winningPosition=new ArrayList<>();
        winningPosition.add(topRow);
        winningPosition.add(midRow);
        winningPosition.add(botRow);
        winningPosition.add(leftCol);
        winningPosition.add(rightCol);
        winningPosition.add(midCol);
        winningPosition.add(cross1);
        winningPosition.add(cross2);
        for(List l:winningPosition){
            if(playerPosition.containsAll(l)) {
                return  "Congratulations you won! :)";
            }
            else if(cpuPosition.containsAll(l)){
                return  "CPU wins! Sorry :(" ;
            }
            else if(playerPosition.size()+cpuPosition.size()>9){
                return "TIE";
            }}
        return "";
    }
    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        Scanner scanner = new Scanner(System.in);
        //boolean playAgin=true;
        while (true) {
            System.out.println("Enter your placement (1-9)");
            int playerPos = scanner.nextInt();
            while (playerPosition.contains(playerPos) || cpuPosition.contains(playerPosition)) {
                System.out.println("Postion taken! Enter a correct position");
                playerPos = scanner.nextInt();
            }
            fillPostion(playerPos, gameBoard, "player");
            String result = checkWinner();
            if (result.length()>0) {
                System.out.println("****************************************************");
                System.out.println("                "+result);
                System.out.println("****************************************************");
                break;
            }
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            System.out.println(cpuPos);
            fillPostion(cpuPos, gameBoard, "cpu");
            printGameBoard(gameBoard);
            result = checkWinner();
            if (result.length()>0) {
                System.out.println("****************************************************");
                System.out.println("                 "+result);
                System.out.println("****************************************************");
                break;
            }
        }
    }}
