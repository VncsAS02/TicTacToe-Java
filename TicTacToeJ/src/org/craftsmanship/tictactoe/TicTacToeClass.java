package org.craftsmanship.tictactoe;
import java.util.Scanner;
import java.util.Random;

public class TicTacToeClass {

    public static char[][] gameBoard = new char[3][3];
    static char whosPlaying = 'X'; // O jogo sempre começará com o jogador X
    static boolean jogo = true;

    // Este bloco de código inicializa o tabuleiro do Jogo Da Velha com espaços vazios
    public static void startGameBoard() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                gameBoard[linha][coluna] = ' ';
            }
        }
    }

    // Imprime o jogo da velha
    public static void printGameBoard() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(" " + gameBoard[linha][coluna] + " ");
                if (coluna < 2) System.out.print("|");
            }
            System.out.println();
            if (linha < 2) System.out.println("---+---+---");
        }
    }

    // Verifica se algum jogador venceu
    public static boolean checkVictory() {
        // Verifica se algum jogador ganhou nas diagonais
        if (gameBoard[0][0] == whosPlaying && gameBoard[1][1] == whosPlaying && gameBoard[2][2] == whosPlaying) {
            return true;
        }
        if (gameBoard[0][2] == whosPlaying && gameBoard[1][1] == whosPlaying && gameBoard[2][0] == whosPlaying) {
            return true;
        }

        // Verifica se algum jogador ganhou em alguma linha
        for (int linha = 0; linha < 3; linha++) {
            if (gameBoard[linha][0] == whosPlaying  && gameBoard[linha][1] == whosPlaying && gameBoard[linha][2] == whosPlaying) {
                return true;
            }
        }

        // Verifica se algum jogador ganhou em alguma coluna
        for (int coluna = 0; coluna < 3; coluna++) {
            if (gameBoard[0][coluna] == whosPlaying && gameBoard[1][coluna] == whosPlaying && gameBoard[2][coluna] == whosPlaying) {
                return true;
            }
        }

        return false;
    }

    // Verifica se o tabuleiro está cheio
    public static boolean gameBoardFull() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (gameBoard[linha][coluna] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Verifica se a posição escolhida é válida
    public static boolean validPosition(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && gameBoard[linha][coluna] == ' ';
    }

    // Faz o movimento de um jogador
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int linha, coluna;

        while (jogo) {
            printGameBoard();

            if (whosPlaying == 'X') {
                System.out.println("\nJogador X");
            } else {
                System.out.println("\nJogador O");
            }

            do {
                System.out.print("Escolha uma linha de 0-2: ");
                linha = scanner.nextInt();
                System.out.print("Escolha uma coluna de 0-2: ");
                coluna = scanner.nextInt();

                // Verifica se a posição escolhida pelo jogador X ou O é válida
                if (!validPosition(linha, coluna)) {
                    System.out.println("Posição inválida! Escolha uma linha e uma coluna válida !!!");
                }
            } while (!validPosition(linha, coluna));

            gameBoard[linha][coluna] = whosPlaying;

            // Verifica se o jogador atual venceu
            if (checkVictory()) {
                printGameBoard();
                System.out.println("O Jogador " + whosPlaying + " venceu!!!");
                jogo = false;
                return;
            }

            // Verifica se o tabuleiro está cheio e se terminou em um empate entre os jogadores
            if (gameBoardFull()) {
                printGameBoard();
                System.out.println("Empate! O tabuleiro está cheio!!!");
                jogo = false;
                return;
            }

            // Troca de jogador
            whosPlaying = (whosPlaying == 'X') ? 'O' : 'X';
        }

    }

    public static void main(String[] args) {
        // Inicializa o tabuleiro
        startGameBoard();

        // Inicia o jogo
        start();
    }
}

