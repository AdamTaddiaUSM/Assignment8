package AccidentPack;

import java.util.ArrayList;
import java.util.TreeSet;

public class StateSubStructure {

	public String state;
	// all of the treesets in this list occured on different days, in the same
	// state. One date is one treeset.
	ArrayList<RedBlackTree> reportsByDate;

	public StateSubStructure(String state) {
		this.state = state;
		this.reportsByDate = new ArrayList<RedBlackTree>();
	}

	// THIS METHOD WORKS AS INTENDED; DO NOT TRY TO FIX IT
	public boolean containsDate(MyDate md) {
		if (this.reportsByDate.isEmpty()) {
			return false;// good
		} else {
			// goes over every tree in reportsByDate
			for (int i = 0; i < this.reportsByDate.size(); i++) {
				// the "first" report (not necessarily the root) is checked, but it doesn't need
				// to be any specific report.
				// it could be any report checked because they are all on the same date
				if (reportsByDate.get(i).getSize() != 0) {// checks to make sure the tree is not empty
					if (reportsByDate.get(i).root.data.getDate().compareTo(md) == 0) {
						return true;
					}
				}
			}

			return false;
		}
	}

	public void swapTrees(int index1, int index2) {

		RedBlackTree index1clone = this.reportsByDate.get(index1);
		this.reportsByDate.set(index1, this.reportsByDate.get(index2));
		this.reportsByDate.set(index2, index1clone);
	}

	// THIS WORKS; DON'T TRY TO FIX IT
	public void sortDateTrees() {
		for (int i = 0; i < this.reportsByDate.size() - 1; i++) {

			int smallestPos = i;
			for (int j = i + 1; j < this.reportsByDate.size(); j++) {
				if (this.reportsByDate.get(j).root.data.compareTo(this.reportsByDate.get(smallestPos).root.data) > 0)																											
					smallestPos = j;
			}

			swapTrees(i, smallestPos);
		}
	}

	// this should be working
	public void add(Report r) {
		r.print();
		// if a tree with a matching date is found
		if (this.containsDate(r.getDate())) {
			for (int i = 0; i < this.reportsByDate.size(); i++) {
				if (this.reportsByDate.get(i).root.data.getDate().compareTo(r.getDate()) == 0) {// if the date of the first
																								// report in the tree
																								// (all reports in a
																								// tree
					this.reportsByDate.get(i).add(r); 

				}
			}

			// if no matching date is found
		} else { // this definitely works
			// new tree is created
			RedBlackTree newTree = new RedBlackTree();
			// this tree is added to reportsByDate
			// this report is added to the tree
			newTree.add(r);
			this.reportsByDate.add(newTree);
			// the trees are sorted
			this.sortDateTrees();

		}
	}

}
