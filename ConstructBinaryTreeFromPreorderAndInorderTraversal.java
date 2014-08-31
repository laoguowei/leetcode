package com.leetcode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreeFromPreorderAndInorderTraversal t = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int []pos = {4,5,2,7,3,1};
		int []in = {4,2,5,1,3,7};
		t.buildTree2(in , pos);
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
         return root;
    }
	
    public TreeNode buildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
    	if(preBegin > preEnd) {
    		return null;
    	}
        if(preBegin == preEnd) {
        	return new TreeNode(preorder[preEnd]);
        }
        int root = preorder[preBegin];
        int i;
        for(i = inBegin; i <= inEnd; i++) {
        	if(inorder[i] == root) break;
        }
        TreeNode r = new TreeNode(root);
        int leftNum = i - inBegin;
        r.left = buildTree(preorder, inorder, preBegin + 1, preBegin + leftNum, inBegin, i - 1);
        r.right = buildTree(preorder, inorder, preBegin + 1 + leftNum, preEnd, i + 1, inEnd);
        return r;
    }
    
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        TreeNode root = buildTree2(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
        return root;
   }
	
   public TreeNode buildTree2(int[] postorder, int[] inorder, int posBegin, int posEnd, int inBegin, int inEnd) {
   	if(posBegin > posEnd) {
   		return null;
   	}
       if(posBegin == posEnd) {
       	return new TreeNode(postorder[posEnd]);
       }
       int root = postorder[posEnd];
       int i;
       for(i = inBegin; i <= inEnd; i++) {
       	if(inorder[i] == root) break;
       }
       TreeNode r = new TreeNode(root);
       int leftNum = i - inBegin;
       r.left = buildTree2(postorder, inorder, posBegin, posBegin + leftNum -1, inBegin, i - 1);
       r.right = buildTree2(postorder, inorder, posBegin + leftNum, posEnd - 1, i + 1, inEnd);
       return r;
   }

}
