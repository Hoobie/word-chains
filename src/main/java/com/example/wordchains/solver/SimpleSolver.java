package com.example.wordchains.solver;

import com.example.wordchains.loader.WordListLoader;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleSolver implements Solver {

    private final Set<String> wordList;
    private Set<String> checkedWords;

    public SimpleSolver(WordListLoader loader) {
        wordList = loader.load();
    }

    @Override
    public List<String> buildChain(String startWord, String endWord) {
        checkedWords = new HashSet<>();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(startWord);
        DefaultTreeModel tree = new DefaultTreeModel(root);

        Enumeration<DefaultMutableTreeNode> firstLevel = Collections.enumeration(Collections.singletonList(root));
        fillTree(firstLevel, endWord);

        TreeNode[] shortestChain = findShortestChain(root, tree, endWord);

        return Arrays.stream(shortestChain)
                .map(TreeNode::toString)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    private void fillTree(Enumeration<DefaultMutableTreeNode> level, String endWord) {
        while (level.hasMoreElements()) {
            DefaultMutableTreeNode node = level.nextElement();

            for (String possibleNext : getPossibleNextWords(node.toString(), endWord)) {
                node.add(new DefaultMutableTreeNode(possibleNext));
            }

            fillTree(node.children(), endWord);
        }
    }

    private List<String> getPossibleNextWords(String current, String endWord) {
        List<String> possibleNextWords = new ArrayList<>();

        for (int i = 0; i < endWord.length(); i++) {
            char[] chars = current.toCharArray();
            if (current.charAt(i) == endWord.charAt(i)) {
                continue;
            }
            chars[i] = endWord.charAt(i);
            String possibleNext = String.valueOf(chars);
            if (wordList.contains(possibleNext)) {
                possibleNextWords.add(possibleNext);
            }
        }

        for (int i = 0; i < endWord.length(); i++) {
            char[] chars = current.toCharArray();
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (current.charAt(i) == letter) {
                    continue;
                }
                chars[i] = letter;
                String possibleNext = String.valueOf(chars);
                if (wordList.contains(possibleNext) && !checkedWords.contains(possibleNext)) {
                    checkedWords.add(possibleNext);
                    possibleNextWords.add(possibleNext);
                }
            }
        }

        return possibleNextWords;
    }

    @SuppressWarnings("unchecked")
    private TreeNode[] findShortestChain(DefaultMutableTreeNode root, DefaultTreeModel tree, String endWord) {
        Enumeration<DefaultMutableTreeNode> nodes = root.depthFirstEnumeration();
        TreeNode[] shortestChain = new TreeNode[0];
        int minChainSize = Integer.MAX_VALUE;
        while (nodes.hasMoreElements()) {
            MutableTreeNode node = nodes.nextElement();
            if (node.isLeaf() && node.toString().equals(endWord)) {
                TreeNode[] chain = tree.getPathToRoot(node);
                if (chain.length < minChainSize) {
                    minChainSize = chain.length;
                    shortestChain = chain;
                }
            }
        }
        return shortestChain;
    }
}
