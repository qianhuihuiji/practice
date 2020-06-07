package Leetcode;

import java.util.*;

public class Question126 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(findLadders(beginWord, endWord, wordList));
    }


    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(! wordList.contains(endWord)) return new ArrayList<>();

        return new ArrayList<>();
    }
}