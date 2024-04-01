package org.solution3;

import org.junit.Test;
import org.junit.experimental.max.MaxHistory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (hashSet.add(chars[j])) {
                    max = Math.max(max, hashSet.size());
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        int i = 0, j = 0, k = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (; k < chars.length; k++) {
            // 应该还能优化，不一定要删除这个元素，而是更具下标去做处理
            if (!hashMap.containsKey(chars[k])) {
                hashMap.put(chars[k], k);
                max = Math.max(max, hashMap.size());
            } else {
                j = hashMap.get(chars[k]);
                while (i <= j) {
                    hashMap.remove(chars[i++]);
                }
                hashMap.put(chars[k], k);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            if (hashMap.containsKey(s.charAt(i))){
                // 这里取max实际上是为了防止乱跳，如果窗口内的元素重复才会更改left的值，否则不更改。
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    @Test
    public void Test() {
        System.out.println(lengthOfLongestSubstring3("dasdsdadasqqwerczsd"));
    }
}
