package com.bsdl.medium._0079;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()) {
            return false;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = i; j < board[0].length; j++) {
                if(search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int k) {
        if(k == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        board[i][j] -= 128;
        boolean res = search(board, word, i - 1, j, k + 1) || search(board, word, i, j + 1, k + 1) ||
                search(board, word, i + 1, j, k + 1) || search(board, word, i, j - 1, k + 1);
        board[i][j] += 128;
        return res;
    }
}
