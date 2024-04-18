package AccidentPack;

import java.util.Comparator;



public class RedBlackTree {
	public RBTreeNode root;
	
	public RedBlackTree() {
		this.root = null;
	}
	
	public int getSize() {
		if (this.root == null) {
			return 0;
		} else {
			return getSizeHelper(this.root);
		}
	}

	public int getSizeHelper(RBTreeNode n) {
		int size = 1;
		if (n.left != null) {
			size += getSizeHelper(n.left);
		}
		
		if (n.right != null) {
			size += getSizeHelper(n.right);
		}
		
		return size;
	}

	public void add(Report data) {
		RBTreeNode newRBTreeNode = new RBTreeNode(data);
		if (root == null) {
			root = newRBTreeNode;
		} else {
			insertHelper(root, newRBTreeNode);
		}
		insert(newRBTreeNode);
	}

	private void insert(RBTreeNode RBTreeNode) {
		while (RBTreeNode != root && RBTreeNode.parent.isRed) {
			if (RBTreeNode.parent == RBTreeNode.parent.parent.left) {
				RBTreeNode uncle = RBTreeNode.parent.parent.right;
				if (uncle != null && uncle.isRed) {
					RBTreeNode.parent.isRed = false;
					uncle.isRed = false;
					RBTreeNode.parent.parent.isRed = true;
					RBTreeNode = RBTreeNode.parent.parent;
				} else {
					if (RBTreeNode == RBTreeNode.parent.right) {
						RBTreeNode = RBTreeNode.parent;
						rotateLeft(RBTreeNode);
					}
					RBTreeNode.parent.isRed = false;
					RBTreeNode.parent.parent.isRed = true;
					rotateRight(RBTreeNode.parent.parent);
				}
			} else {
				RBTreeNode uncle = RBTreeNode.parent.parent.left;
				if (uncle != null && uncle.isRed) {
					RBTreeNode.parent.isRed = false;
					uncle.isRed = false;
					RBTreeNode.parent.parent.isRed = true;
					RBTreeNode = RBTreeNode.parent.parent;
				} else {
					if (RBTreeNode == RBTreeNode.parent.left) {
						RBTreeNode = RBTreeNode.parent;
						rotateRight(RBTreeNode);
					}
					RBTreeNode.parent.isRed = false;
					RBTreeNode.parent.parent.isRed = true;
					rotateLeft(RBTreeNode.parent.parent);
				}
			}
		}
		root.isRed = false;
	}
	
	private void insertHelper(RBTreeNode root, RBTreeNode newRBTreeNode) {
		if (root.data.compareTo(newRBTreeNode.data) < 0) {//inserted node before after report
			if (root.left == null) {
				root.left = newRBTreeNode;
				newRBTreeNode.parent = root;
			} else {
				insertHelper(root.left, newRBTreeNode);
			}
		} else {//inserted node comes after report
			if (root.right == null) {
				root.right = newRBTreeNode;
				newRBTreeNode.parent = root;
			} else {
				insertHelper(root.right, newRBTreeNode);
			}
		}
	}

	private void rotateLeft(RBTreeNode a) {
		RBTreeNode b = a.right;
		a.right = b.left;
		if (b.left != null) {
			b.left.parent = a;
		}
		b.parent = a.parent;
		if (a.parent == null) {
			root = b;
		} else if (a == a.parent.left) {
			a.parent.left = b;
		} else {
			a.parent.right = b;
		}
		b.left = a;
		a.parent = b;
	}


	private void rotateRight(RBTreeNode a) {
		RBTreeNode b = a.left;
		a.left = b.right;
		if (b.right != null) {
			b.right.parent = a;
		}
		b.parent = a.parent;
		if (a.parent == null) {
			root = b;
		} else if (a == a.parent.right) {
			a.parent.right = b;
		} else {
			a.parent.left = b;
		}
		b.right = a;
		a.parent = b;
	}

}
