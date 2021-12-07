package day4.exo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayFourExoOne {

    public void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\day4\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        List<Integer> numbersPlayed = new ArrayList<>();
        List<BingoBoard> bingoBoards = new ArrayList<>();

        int x = 0;

        int lineOfBoard = 0;
        int numBoard = -1;

        while ((st = br.readLine()) != null) {
            /* System.out.println(st); */
            // ******** NUMBERS OF BINGO ***********
            if (x == 0) {
                String[] nb = st.split(",");

                // Insert into list numbers of bingo
                for (String n : nb) {
                    numbersPlayed.add(Integer.parseInt(n));
                }

                x = 1;
                continue;
                // ******** Creating board ***********
            } else {
                if (st.trim().isEmpty()) {
                    bingoBoards.add(new BingoBoard());
                    lineOfBoard = 0;
                    numBoard++;
                    continue;
                }
            }

            if (!st.trim().isEmpty()) {
                String[] lineBoard = st.split(" ");

                int columnBoard = 0;
                for (String line : lineBoard) {
                    if (!line.trim().isEmpty()) {
                        BingoBoard currentBoard = bingoBoards.get(numBoard);
                        currentBoard.getBoard()[lineOfBoard][columnBoard] = new NumberBingo(Integer.parseInt(line),
                                false);
                        columnBoard++;
                    }
                }
                lineOfBoard++;
            }
        }

        outer: for (Integer num : numbersPlayed) {
            System.out.println("NUMERO JOUE : " + num);
            for (BingoBoard board : bingoBoards) {
                board.markNumberIfSorted(num);
                if (board.isWin()) {
                    System.out.println(board.calcule(num));
                    break outer;
                }
            }
        }

    }

    public class BingoBoard {

        NumberBingo[][] board;

        public BingoBoard() {
            this.board = new NumberBingo[5][5];
        }

        public void markNumberIfSorted(int number) {
            for (int i = 0; i < this.board.length; i++) {
                for (int j = 0; j < this.board[i].length; j++) {
                    if (board[i][j].getNumber() == number) {
                        board[i][j].setMarked(true);
                    }
                }
            }
        }

        public boolean isWin() {

            int inRowMarked = 0;
            int index = 0;
            // Verify each column
            while (index < 5) {
                for (int i = 0; i < this.board.length; i++) {
                    if (this.board[i][index].marked) {
                        inRowMarked++;
                    }
                }
                if (inRowMarked == 5) {
                    return true;
                }
                inRowMarked = 0;
                index++;
            }

            index = 0;
            inRowMarked = 0;
            // Verify each row
            while (index < 5) {
                for (int i = 0; i < this.board.length; i++) {
                    if (this.board[index][i].marked) {
                        inRowMarked++;
                    }
                }
                if (inRowMarked == 5) {
                    return true;
                }
                inRowMarked = 0;
                index++;
            }

            return false;
        }

        public int calcule(int number) {

            int sumMarkedNumber = 0;

            for (int i = 0; i < this.board.length; i++) {
                for (int j = 0; j < this.board[i].length; j++) {
                    if (!board[i][j].isMarked()) {
                        System.out.println(board[i][j].getNumber());
                        sumMarkedNumber += board[i][j].getNumber();
                    }
                }
            }

            return sumMarkedNumber * number;
        }

        public NumberBingo[][] getBoard() {
            return board;
        }
    }

    public class NumberBingo {
        int number;
        boolean marked;

        public NumberBingo(int number, boolean marked) {
            this.marked = marked;
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isMarked() {
            return marked;
        }

        public void setMarked(boolean marked) {
            this.marked = marked;
        }
    }

}
