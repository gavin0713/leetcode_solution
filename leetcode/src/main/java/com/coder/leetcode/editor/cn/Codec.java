package com.coder.leetcode.editor.cn;

import com.coder.leetcode.editor.cn.basic.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kougavin on 11/10/2021.
 */
public class Codec {
    List<Integer> list;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        pre(root, -1);
        return list.toString();
    }

    void pre(TreeNode root, int level) {
        if (root != null) {
            list.add(root.val);
            pre(root.left, level - 1);
            list.add(level);
            pre(root.right, level - 1);
        }
    }

    TreeNode getTree(List<Integer> list, int start, int end, int level) {
        TreeNode root = new TreeNode(list.get(start));
        for (int i = start; i <= end; i++) {
            if (list.get(i) == level) {
                root.left = getTree(list, start+1, i - 1, level -1);
                root.right = getTree(list, i+1, end, level -1);
            }
        }
        return root;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        list = Arrays.stream(data.substring(1, data.length() - 1).split(",")).map(Integer::valueOf).collect(Collectors.toList());

        return getTree(list, 0, list.size()-1, -1);

    }
}
