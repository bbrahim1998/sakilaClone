package sakilaApp.utils;

public class FuncionsUtils {
	
	public static int provaSuma(int numA, int numB) {
		return numA+numB;
	}

	public static int provaSumaSiParells(int numA, int numB) throws Exception {
		if(numA%2==0&&numB%2==0) {
			return numA+numB;			
		}else {
			throw new Exception("numA i numB NO són parells");
		}
		
	}
}
