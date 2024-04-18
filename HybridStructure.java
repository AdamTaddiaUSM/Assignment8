package AccidentPack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class HybridStructure {
	//this first array list has 50 vals for each state, the second has 365 for each date
	ArrayList<StateSubStructure> statetreemaps;
	
	//more than 20 lines, but I think it's excusable
	public void generateStates() {
		this.statetreemaps = new ArrayList<StateSubStructure>();
		this.statetreemaps.add( new StateSubStructure("AK"));
		this.statetreemaps.add( new StateSubStructure("AL"));
		this.statetreemaps.add( new StateSubStructure("AR"));
		this.statetreemaps.add( new StateSubStructure("AZ"));
		this.statetreemaps.add( new StateSubStructure("CA"));
		this.statetreemaps.add( new StateSubStructure("CO"));
		this.statetreemaps.add( new StateSubStructure("CT"));
		this.statetreemaps.add( new StateSubStructure("DE"));
		this.statetreemaps.add( new StateSubStructure("FL"));
		this.statetreemaps.add( new StateSubStructure("GA"));
		this.statetreemaps.add( new StateSubStructure("HI"));
		this.statetreemaps.add( new StateSubStructure("IA"));
		this.statetreemaps.add( new StateSubStructure("ID"));
		this.statetreemaps.add( new StateSubStructure("IL"));
		this.statetreemaps.add( new StateSubStructure("IN"));
		this.statetreemaps.add( new StateSubStructure("KS"));
		this.statetreemaps.add( new StateSubStructure("KY"));
		this.statetreemaps.add( new StateSubStructure("LA"));
		this.statetreemaps.add( new StateSubStructure("MA"));
		this.statetreemaps.add( new StateSubStructure("MD"));
		this.statetreemaps.add( new StateSubStructure("ME"));
		this.statetreemaps.add( new StateSubStructure("MI"));
		this.statetreemaps.add( new StateSubStructure("MN"));
		this.statetreemaps.add( new StateSubStructure("MO"));
		this.statetreemaps.add( new StateSubStructure("MS"));
		this.statetreemaps.add( new StateSubStructure("MT"));
		this.statetreemaps.add( new StateSubStructure("NC"));
		this.statetreemaps.add( new StateSubStructure("ND"));
		this.statetreemaps.add( new StateSubStructure("NE"));
		this.statetreemaps.add( new StateSubStructure("NH"));
		this.statetreemaps.add( new StateSubStructure("NJ"));
		this.statetreemaps.add( new StateSubStructure("NM"));
		this.statetreemaps.add( new StateSubStructure("NV"));
		this.statetreemaps.add( new StateSubStructure("NY"));
		this.statetreemaps.add( new StateSubStructure("OH"));
		this.statetreemaps.add( new StateSubStructure("OK"));
		this.statetreemaps.add( new StateSubStructure("OR"));
		this.statetreemaps.add( new StateSubStructure("PA"));
		this.statetreemaps.add( new StateSubStructure("RI"));
		this.statetreemaps.add( new StateSubStructure("SC"));
		this.statetreemaps.add( new StateSubStructure("SD"));
		this.statetreemaps.add( new StateSubStructure("TN"));
		this.statetreemaps.add( new StateSubStructure("TX"));
		this.statetreemaps.add( new StateSubStructure("UT"));
		this.statetreemaps.add( new StateSubStructure("VA"));
		this.statetreemaps.add( new StateSubStructure("VT"));
		this.statetreemaps.add( new StateSubStructure("WA"));
		this.statetreemaps.add( new StateSubStructure("WI"));
		this.statetreemaps.add( new StateSubStructure("WV"));
		this.statetreemaps.add( new StateSubStructure("WY"));
	}
	
	public int getReportsAfterDate(String state, MyDate md) {
		int reportsAfterDate = 0;
		StateSubStructure tree = new StateSubStructure(null);
		for (int i = 0; i < 50; i ++) {
			if (this.statetreemaps.get(i).state.equals(state)) {
				tree = this.statetreemaps.get(i);
			}
		}
		
		for(int i = 0; i < tree.reportsByDate.size(); i ++) {
			System.out.println(tree.reportsByDate.size());
			tree.reportsByDate.get(i).root.data.print();//FIXME get to first
			if(tree.reportsByDate.get(i).root.data.getDate().compareTo(md) >= 0) {
				reportsAfterDate += tree.reportsByDate.get(i).getSize();
			}
		}
		return reportsAfterDate;
	}

	public static HybridStructure createHS(Scanner scn, int reportCount) {
		
		HybridStructure HS = new HybridStructure();
		HS.generateStates();
		
		for (int i = 0; i < reportCount; i ++) {
			Report r = Report.createReport(scn);
			for(int j = 0; j < 50; j++) {
				if(r.getState().equals(HS.statetreemaps.get(j).state)) {
					HS.statetreemaps.get(j).add(r);
				}
			}
		}
		return HS;
		}
	
	
	
}
