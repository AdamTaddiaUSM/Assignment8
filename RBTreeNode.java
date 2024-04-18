package AccidentPack;

class RBTreeNode {
	Report data;
	RBTreeNode left;
	RBTreeNode right;
	RBTreeNode parent;
	boolean isRed;

	RBTreeNode(Report data) {
		this.data = data;
		this.isRed = true;
	}
}
