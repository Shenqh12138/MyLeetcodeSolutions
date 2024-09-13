package org.solution49;

import org.junit.Test;

import java.util.*;

public class Solution49 {
    /*给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
    示例 1:
    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

    示例 2:
    输入: strs = [""]
    输出: [[""]]

    示例 3:
    输入: strs = ["a"]
    输出: [["a"]]

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] 仅包含小写字母
     */
    public List<List<String>> groupAnagrams(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : args) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public String hash(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Test
    public void test(){
        String[] args = {"abc","cba","abd","acd"};
        List<List<String>> list = groupAnagrams(args);
        System.out.println(list);
    }
}
