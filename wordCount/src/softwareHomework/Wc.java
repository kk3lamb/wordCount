package softwareHomework;

import java.io.File;
import java.util.Scanner;

public class Wc {
	public static void main(String[] args){
		int flag=1;
		Scanner sc = new Scanner(System.in);
		String inStr="aaa";
		File file=null;
		while(flag==1){
			System.out.println("请输入命令 ");
			if(sc.hasNextLine()){
				inStr = sc.nextLine();
			}
			String[] path = inStr.split(" ");
				if(path.length>1) {
					file = new File(path[1]);
				}
				switch(path[0]) 
				{
					case"-c":
						Method.charNum(path[1]);
						break;
					case"-w":
						Method.wordNum(path[1]);
						break;
					case"-l":
						Method.lineNum(path[1]);
						break;
					case"-s":
						Method.recursion(file);
						break;
					case"-e":
						flag=0;
						break;
					case"-a":
						Method.complexLines(path[1]);
						break;
					default:
						System.out.println("格式错误,请重新输入!");
				}
			} 
	}
}
