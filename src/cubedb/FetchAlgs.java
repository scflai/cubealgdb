package cubedb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FetchAlgs {
	public static void main(String [] args)throws FileNotFoundException {
		importAlgs();
	}
	public static void importAlgs()throws FileNotFoundException {
		Scanner s = new Scanner(new File("C:\\Users\\sampc\\Documents\\cubealgdb\\algs.txt"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.nextLine());
		}
		s.close();
		
		ArrayList<String> newList = new ArrayList<String>();
		
		for(String alg: list) {
			String algorithm = "";
			for(int j = 0; j < alg.length(); j++) {
				if (alg.charAt(j) == '\'') {
					algorithm += "\'\'";
				} else {
					algorithm += alg.charAt(j);
				}
			} newList.add(algorithm);
		}
	}
}
