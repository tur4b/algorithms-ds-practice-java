package com.problem.tree.binary_search_tree;

public class TreeNode<T> {

    private final T data;
    private TreeNode<T> parent;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this(data, null, null, null);
    }

    public TreeNode(T data, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }
      
    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public boolean hasEitherLeftOrRight() {
        return (left != null && right == null) || (left == null && right != null);
    }

    @Override
    public String toString() {
        return "TreeNode [data=" + data + "]";
    }

}
