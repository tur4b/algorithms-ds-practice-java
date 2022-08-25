package com.problem.tree.binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.problem.tree.model.TreeView;

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
                final Comparable<T> c = (Comparable<T>) current.getData();
                if(c.compareTo(data) > 0) {
                    if(current.getLeft() == null) {
                        node.setParent(current);
                        current.setLeft(node);
                        break;
                    }
                    current = current.getLeft();
                }
                else {
                    if(current.getRight() == null) {
                        node.setParent(current);
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
            final Comparable<T> c = (Comparable) current.getData();
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

    public TreeNode<T> remove(T data) {

        System.out.println("--------------------------------------------");

        final TreeNode<T> current = findByData(data)
            .orElseThrow(() -> new RuntimeException("node can't be found with data: " + data));

        final boolean isLeft = isLeftOfParent(current);

        // case 1 - no children
        if(!current.hasLeft() && !current.hasRight()) {
            removeNodeIfHasNoChild_(current, isLeft);
        }
        // case 2 - one child
        else if(current.hasEitherLeftOrRight()) {
            removeNodeIfHasOnlyOneChild_(current, isLeft);
        }

        // case 3 - two children
        else {
            removeNodeIfHasTwoChildren_(current, isLeft);
        }

        size--;
        System.out.println("node deleted with data: " + data);

        System.out.println("--------------------------------------------");
            
        return current;
     }

    private boolean isLeftOfParent(TreeNode<T> current) {
        TreeNode<T> parent = current.getParent();
        TreeNode<T> left;
        return parent == null || ((left = parent.getLeft()) != null && left == current);
    }

    // case1
    private void removeNodeIfHasNoChild_(TreeNode<T> current, boolean isLeft) {
        System.out.println("-> case1: node has not any child!");
        if(current == root) {
            root = null;
        }
        else {
            if(isLeft) {
                current.getParent().setLeft(null);
            }
            else {
                current.getParent().setRight(null);
            }
        }
    }

    // case2
    private void removeNodeIfHasOnlyOneChild_(TreeNode<T> current, boolean isLeft) {
        System.out.println("-> case2: node has only one child!");
        if(current == root) {
            if(current.hasLeft()) {
                root = root.getLeft();
            }
            else {
                root = root.getRight();
            }
        }
        else {
            if(isLeft) {
                if(current.hasLeft()) {
                    current.getParent().setLeft(current.getLeft());
                }
                else {
                    current.getParent().setLeft(current.getRight());
                }
            }
            else {
                if(current.hasLeft()) {
                    current.getParent().setRight(current.getLeft());
                }
                else {
                    current.getParent().setRight(current.getRight());
                }
            }
        }
    }
   
    // case3 - TODO: implement this method
    private void removeNodeIfHasTwoChildren_(TreeNode<T> current, boolean isLeft) {
        System.out.println("-> case3: node has two children!");
        throw new UnsupportedOperationException("this method not implemented yet!");
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
