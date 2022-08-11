package com.problem.tree.binary_tree;

import java.util.ArrayList;

import com.problem.tree.binary_search_tree.TreeNode;
import com.problem.tree.model.TreeNodePosition;
import com.problem.tree.model.VisitOrder;

public class Main {
    
    public static void main(String[] args) {
        
        BinaryTree<String> tree = new BinaryTree<>();
        TreeNode<String> node1 = tree.insert(null, "+", null);

        TreeNode<String> node2 = tree.insert(node1, "*", TreeNodePosition.LEFT);
        TreeNode<String> node2_l = tree.insert(node2, "A", TreeNodePosition.LEFT);
        TreeNode<String> node2_r = tree.insert(node2, "-", TreeNodePosition.RIGHT);
        TreeNode<String> node2_r_l = tree.insert(node2_r, "B", TreeNodePosition.LEFT);
        TreeNode<String> node2_r_r = tree.insert(node2_r, "C", TreeNodePosition.RIGHT);

        TreeNode<String> node3 = tree.insert(node1, "+", TreeNodePosition.RIGHT);
        TreeNode<String> node3_l = tree.insert(node3, "D", TreeNodePosition.LEFT);
        TreeNode<String> node3_r = tree.insert(node3, "E", TreeNodePosition.RIGHT);

        tree.visitTree(tree.getRoot(), VisitOrder.POSTORDER)
            .forEach(node -> {
                System.out.print(node.getData() + " ");
            });
    }

    public static void practice() {
        

    }

}
