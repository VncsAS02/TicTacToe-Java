package org.craftsmanship.tictactoe;
import org.craftsmanship.tictactoe.TicTacToeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

    @Test
    @DisplayName("Teste da função que inicializa o tabuleiro para garantir que todos os espaços estão vazios")
    void testStartGameBoard() {
        // Inicializa o tabuleiro
        TicTacToeClass.startGameBoard();

        // Verifica se as posições no tabuleiro estão vazias
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                Assertions.assertEquals(' ', TicTacToeClass.gameBoard[linha][coluna]);
            }
        }
    }

    @Test
    @DisplayName("Teste se o jogador X vence em qualquer linha")
    void testCheckVictoryRow() {
        // Testa todas as 3 linhas possíveis para vitória do jogador X
        for (int linha = 0; linha < 3; linha++) {
            TicTacToeClass.gameBoard[linha][0] = 'X';
            TicTacToeClass.gameBoard[linha][1] = 'X';
            TicTacToeClass.gameBoard[linha][2] = 'X';

            Assertions.assertTrue(TicTacToeClass.checkVictory());
            TicTacToeClass.startGameBoard();
        }
    }

    @Test
    @DisplayName("Teste se o jogador O vence em qualquer linha")
    void testCheckVictoryRowO() {
        // Testa todas as 3 linhas possíveis para vitória do jogador O
        for (int linha = 0; linha < 3; linha++) {
            TicTacToeClass.gameBoard[linha][0] = 'O';
            TicTacToeClass.gameBoard[linha][1] = 'O';
            TicTacToeClass.gameBoard[linha][2] = 'O';

            Assertions.assertTrue(TicTacToeClass.checkVictory());
            TicTacToeClass.startGameBoard();
        }
    }

    @Test
    @DisplayName("Teste se o jogador X vence em qualquer coluna")
    void testCheckVictoryColumn() {
        // Testa todas as 3 colunas possíveis para vitória do jogador X
        for (int coluna = 0; coluna < 3; coluna++) {
            TicTacToeClass.gameBoard[0][coluna] = 'X';
            TicTacToeClass.gameBoard[1][coluna] = 'X';
            TicTacToeClass.gameBoard[2][coluna] = 'X';

            Assertions.assertTrue(TicTacToeClass.checkVictory());
            TicTacToeClass.startGameBoard();
        }
    }

    @Test
    @DisplayName("Teste se o jogador O vence em qualquer coluna")
    void testCheckVictoryColumnO() {
        // Testa todas as 3 colunas possíveis para vitória do jogador O
        for (int coluna = 0; coluna < 3; coluna++) {
            TicTacToeClass.gameBoard[0][coluna] = 'O';
            TicTacToeClass.gameBoard[1][coluna] = 'O';
            TicTacToeClass.gameBoard[2][coluna] = 'O';

            Assertions.assertTrue(TicTacToeClass.checkVictory());
            TicTacToeClass.startGameBoard();
        }
    }

    @Test
    @DisplayName("Teste se o jogador X vence em qualquer diagonal")
    void testCheckVictoryDiagonal() {
        // Testa a diagonal da esquerda para a direita
        TicTacToeClass.gameBoard[0][0] = 'X';
        TicTacToeClass.gameBoard[1][1] = 'X';
        TicTacToeClass.gameBoard[2][2] = 'X';
        Assertions.assertTrue(TicTacToeClass.checkVictory());

        // Limpa o tabuleiro para testar a próxima diagonal
        TicTacToeClass.startGameBoard();

        // Testa a diagonal da direita para a esquerda
        TicTacToeClass.gameBoard[0][2] = 'X';
        TicTacToeClass.gameBoard[1][1] = 'X';
        TicTacToeClass.gameBoard[2][0] = 'X';
        Assertions.assertTrue(TicTacToeClass.checkVictory());
    }

    @Test
    @DisplayName("Teste se o jogador O vence em qualquer diagonal")
    void testCheckVictoryDiagonalO() {
        // Testa a diagonal da esquerda para a direita
        TicTacToeClass.gameBoard[0][0] = 'O';
        TicTacToeClass.gameBoard[1][1] = 'O';
        TicTacToeClass.gameBoard[2][2] = 'O';
        Assertions.assertTrue(TicTacToeClass.checkVictory());

        // Limpa o tabuleiro para testar a próxima diagonal
        TicTacToeClass.startGameBoard();

        // Testa a diagonal da direita para a esquerda
        TicTacToeClass.gameBoard[0][2] = 'O';
        TicTacToeClass.gameBoard[1][1] = 'O';
        TicTacToeClass.gameBoard[2][0] = 'O';
        Assertions.assertTrue(TicTacToeClass.checkVictory());
    }

    @Test
    @DisplayName("Teste que verifica um cenário onde não houve uma vitória")
    void testCheckNoVictory() {
        // Configura um cenário onde não há vitória
        TicTacToeClass.gameBoard[0][0] = 'X';
        TicTacToeClass.gameBoard[0][1] = 'O';
        TicTacToeClass.gameBoard[0][2] = 'X';

        Assertions.assertFalse(TicTacToeClass.checkVictory());
    }

    @Test
    @DisplayName("Testa a condição de empate")
    void testGameBoardFull() {
        // Preenche todo o tabuleiro para simular um empate entre os jogadores
        TicTacToeClass.gameBoard[0][0] = 'X';
        TicTacToeClass.gameBoard[0][2] = 'O';
        TicTacToeClass.gameBoard[0][1] = 'x';
        TicTacToeClass.gameBoard[1][0] = 'O';
        TicTacToeClass.gameBoard[1][2] = 'X';
        TicTacToeClass.gameBoard[1][1] = 'O';
        TicTacToeClass.gameBoard[2][0] = 'X';
        TicTacToeClass.gameBoard[2][2] = 'O';
        TicTacToeClass.gameBoard[2][1] = 'X';


        Assertions.assertTrue(TicTacToeClass.gameBoardFull());
    }

    @Test
    @DisplayName("Teste para verificar se o tabuleiro não está cheio")
    void testGameBoardNotFull() {
        // Preenche parte do tabuleiro de forma aleatória
        TicTacToeClass.gameBoard[0][0] = 'X';
        TicTacToeClass.gameBoard[0][1] = 'O';

        Assertions.assertFalse(TicTacToeClass.gameBoardFull());
    }

    @Test
    @DisplayName("Teste para verificar se posições inválidas são corretamente identificadas")
    void testInvalidPosition() {
        // Verifica posições fora dos limites
        Assertions.assertFalse(TicTacToeClass.validPosition(-2, -1));
        Assertions.assertFalse(TicTacToeClass.validPosition(4, 4));
    }
}
