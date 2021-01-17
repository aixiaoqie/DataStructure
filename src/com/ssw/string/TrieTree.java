package com.ssw.string;


/**
 * 字典树(前缀树)的实现
 * <p>
 * 字典树又称为前缀树或者Trie树，是处理字符串的常见数据结构。
 * <p>
 * 假设所有的组成单词的字符仅为  'a'~'z',请实现字典树结构，并包含以下4个功能。
 * <p>
 * 1.void insert(String word):添加word,可重复添加
 * 2.void delete(String word):删除word，如果word存在多个，只删除一个
 * 3.int search(String word):查找word是否在字典树中，并返回出现的次数
 * 4.int prefixNumber(String pre):返回以字符串 pre为前缀的单词数量
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    //添加操作
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] charArr = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            index = charArr[i] - 'a'; //获取下个节点位置，表示到下个节点路上有此字符
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }

    //查找操作
    public int search(String word) {
        if (word == null) {
            return 0;
        }
        char[] charArr = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            index = charArr[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    //删除操作
    public void delete(String word) {
        if (search(word) > 0) {
            char[] charArr = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < charArr.length; i++) {
                index = charArr[i] - 'a';
                if (--node.nexts[index].path == 0) {//path到0说明后面下面所连的都只在一个树杈上，即只出现一次，直接设为null即删除
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    //返回以字符串 pre为前缀的单词数量
    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        char[] charArr = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            index = charArr[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.path;
    }


    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }


}

/**
 * 前缀树节点类
 */
class TrieNode {
    public int path; //当前节点到达过几次，可以获取某个前缀出现的次数
    public int end; //构建字典树过程中，到字符串最后一个字符时end++, 可以用来获取某个字符串出现的次数
    public TrieNode[] nexts;//当前节点下面的节点路径数组，若数组位置上不为null，说明有到该字符的路

    public TrieNode() {
        path = 0;
        end = 0;
        nexts = new TrieNode[26];//长度26存储a~z的路径，不为null说明当前字符存在此路
    }
}