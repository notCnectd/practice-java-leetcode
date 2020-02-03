package com.bsdl.medium._0127;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        set.add(beginWord);
        List<String> toBeRemoved = new ArrayList<>();
        for (String str : wordList) {
            if (isOneLetterDiff(beginWord, str)) {
                que.offer(str);
                set.add(str);
                toBeRemoved.add(str);
            }
        }
        wordList.removeAll(toBeRemoved);
        toBeRemoved.clear();
        int dist = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            while(size > 0) {
                String cur = que.poll();
                if (cur.equals(endWord)) {
                    dist++;
                    return dist;
                }

                for (String word : wordList) {
                    if (!set.contains(word) && isOneLetterDiff(cur, word)) {
                        set.add(word);
                        que.offer(word);
                        toBeRemoved.add(word);
                    }
                }
                wordList.removeAll(toBeRemoved);
                toBeRemoved.clear();
                size--;
            }
            dist++;
        }
        return set.contains(endWord) ? dist : 0;
    }

    private boolean isOneLetterDiff(String beginword, String endWord) {
        int count = 0;
        for (int i = 0; i < beginword.length(); i++) {
            if (beginword.charAt(i) != endWord.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

}
