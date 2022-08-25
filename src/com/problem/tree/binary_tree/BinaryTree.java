package com.problem.tree.binary_tree;

import java.util.ArrayList;
import java.util.List;

import com.problem.tree.binary_search_tree.TreeNode;
import com.problem.tree.model.TreeNodePosition;
import com.problem.tree.model.TreeView;


public class BinaryTree<T> {

    private TreeNode<T> root;
    private long size;

    public TreeNode<T> insert(TreeNode<T> baseNode, T data, TreeNodePosition position) {
        TreeNode<T> node = new TreeNode<>(data);
        if(root == null) {
            root = node;
        }
        else {
            switch(position) {
                case LEFT -> baseNode.setLeft(node);
                case RIGHT -> baseNode.setRight(node);
            }
        }
        size++;
        return node;
    }

    public TreeNode<T> remove(T data) {
        return null;
    }
    // ************************************************

    public List<TreeNode<T>> visitTree(TreeView treeView) {
        final List<TreeNode<T>> list = new ArrayList<>();
        switch(treeView) {
            case PREORDER -> visit_preorder(root, list);
            case INORDER -> visit_inorder(root, list);
            case POSTORDER -> visit_postorder(root, list);
        }
        return list;
    }

    private void visit_preorder(TreeNode<T> node, List<TreeNode<T>> list) {
        if(node == null) {
            return;
        }
        if(list == null) {
            list = new ArrayList<>();
        }
        // preorder
        list.add(node);
        visit_preorder(node.getLeft(), list);
        visit_preorder(node.getRight(), list);
    }

    private void visit_inorder(TreeNode<T> node, List<TreeNode<T>> list) {
        if(node == null) {
            return;
        }
        if(list == null) {
            list = new ArrayList<>();
        }
        // inorder
        visit_inorder(node.getLeft(), list);
        list.add(node);
        visit_inorder(node.getRight(), list);
    }

    private void visit_postorder(TreeNode<T> node, List<TreeNode<T>> list) {
        if(node == null) {
            return;
        }
        if(list == null) {
            list = new ArrayList<>();
        }
        // postorder
        visit_postorder(node.getLeft(), list);
        visit_postorder(node.getRight(), list);
        list.add(node);
    }
    
    
}

