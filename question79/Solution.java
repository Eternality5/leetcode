package question79;

import java.util.*;

public class Solution {

    public boolean exist(char[][] board, String word) {
        Map<Character, List<List<Integer>>> characterLocations = new HashMap<>();
        ArrayList<List<Integer>> locationList;

        // Creating a board that can be queried by letter not coordinates
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if (characterLocations.get(board[i][j]) != null) {
                    characterLocations.get(board[i][j]).add(List.of(i, j));
                } else {
                    locationList = new ArrayList<>();
                    locationList.add(List.of(i, j));
                    characterLocations.put(board[i][j], locationList);
                }
            }
        }

        List<List<Integer>> currentLetters, nextLetters, potentialLetters;
        currentLetters = characterLocations.get(word.charAt(0));
        nextLetters = new ArrayList<>();

        for (int k = 0; k < word.length(); k++) {

            // Remove existing letters so they cannot be traversed again
            currentLetters.stream().forEach((letter) -> {
                board[letter.get(0)][letter.get(1)] = ' ';
            });

            for (int i = 1; i < currentLetters.size(); i++) {
                nextLetters = new ArrayList<>();
                potentialLetters = characterLocations.get(word.charAt(i));
                for (List<Integer> currentLetter : currentLetters) {
                    for (List<Integer> potentialLetter : potentialLetters) {
                        if ((((Math.abs(currentLetter.get(0) - potentialLetter.get(0))) == 1)
                                ^ ((Math.abs(currentLetter.get(1) - potentialLetter.get(1))) == 1))
                                &&
                                ((currentLetter.get(0) == potentialLetter.get(0))
                                        ^ (currentLetter.get(1) == potentialLetter.get(1)))) {
                            nextLetters.add(potentialLetter);
                        }
                    }
                }
            }

            currentLetters = nextLetters;
        }
        return !nextLetters.isEmpty();
    }
}
