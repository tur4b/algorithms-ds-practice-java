package com.problem.tree.binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.problem.tree.model.VisitOrder;

// use for Comparable data
public class BinarySearchTree<T> {

    private TreeNode<T> root;
    private long size;

    public TreeNode<T> insert(T data) {
        if(!(data instanceof Comparable)) {
            throw new IllegalArgumentException("requires Comparable data for binary search tree implementation");
        }

        TreeNode<T> node = new TreeNode<>(data);
        if(root == null) {
            root = node;
        }
        else {
            TreeNode<T> current = root;
            while(current != null) {
                Comparable c = (Comparable) current.getData();
                if(c.compareTo(data) > 0) {
                    if(current.getLeft() == null) {
                        current.setLeft(node);
                        break;
                    }
                    current = current.getLeft();
                }
                else {
                    if(current.getRight() == null) {
                        current.setRight(node);
                        break;
                    }
                    current = current.getRight();
                }
            }
        }
        size++;
        return node;
    }

    public int getDepthOfTree() {
        throw new UnsupportedOperationException("get depth of tree not implemented yet!");
    }

    public Optional<TreeNode<T>> findByData(T data) {
        TreeNode<T> current = root;
        while(current != null) {
            final Comparable c = (Comparable) current.getData();
            final int compareNodes = c.compareTo(data);

            if(compareNodes == 0) {
                return Optional.of(current);
            }
            else if(compareNodes > 0) {
                if(current != null) {
                    current = current.getLeft();
                }
            }
            else {
                if(current != null) {
                    current = current.getRight();
                }
            }
        }
        return Optional.empty();
    }

    private TreeNode<T> removeLeafNode() {
       throw new UnsupportedOperationException("Remove leaf node not implemented yet!");
    }
   
    // ************************************************

    public List<TreeNode<T>> visitTree(VisitOrder visitOrder) {
        final List<TreeNode<T>> list = new ArrayList<>();
        switch(visitOrder) {
            case PREORDER -> visit_preorder(root, list);
            case INORDER -> visit_inorder(root, list);
            case POSTORDER -> visit_postorder(root, list);
        }
        return list;
    }

    private void visit_preorder(TreeNode<T> node, List<TreeNode<T>> list) {
        Objects.requireNonNull(list, "List for storing nodes can't be null!");
        if(node == null) {
            return;
        }
        // preorder
        list.add(node);
        visit_preorder(node.getLeft(), list);
        visit_preorder(node.getRight(), list);
    }

    private void visit_inorder(TreeNode<T> node, List<TreeNode<T>> list) {
        Objects.requireNonNull(list, "List for storing nodes can't be null!");
        if(node == null) {
            return;
        }
        // inorder
        visit_inorder(node.getLeft(), list);
        list.add(node);
        visit_inorder(node.getRight(), list);
    }

    private void visit_postorder(TreeNode<T> node, List<TreeNode<T>> list) {
        Objects.requireNonNull(list, "List for storing nodes can't be null!");
        if(node == null) {
            return;
        }
        // postorder
        visit_postorder(node.getLeft(), list);
        visit_postorder(node.getRight(), list);
        list.add(node);
    }

    
}
