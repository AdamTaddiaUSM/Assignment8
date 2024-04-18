package AccidentPack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {

		File f = new File(args[0]);
		Scanner scnr1 = new Scanner(f);
		int reportCount = Report.findReportCount(scnr1);
		scnr1.close();
		Scanner scnr2 = new Scanner(f);
		scnr2.nextLine();
		HybridStructure HS = HybridStructure.createHS(scnr2, reportCount);
		String dateAsString = args[2];
		int year = Integer.parseInt(dateAsString.substring(0,4));
		int month = Integer.parseInt(dateAsString.substring(5,7));
		int day = Integer.parseInt(dateAsString.substring(8,10));
		MyDate md = new MyDate(year, month, day);
		int reportsAfterMD = HS.getReportsAfterDate(args[1], md);
		System.out.println(reportsAfterMD + " reports after " + md.year + "/" + md.month + "/" + md.day);
	}
}
