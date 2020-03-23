package softwareHomework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Method {
	public static void charNum(String inPath) {
		int num=0;
		try {
			FileReader fr = new FileReader(inPath);
			BufferedReader br = new BufferedReader(fr);
			int a=0;
			while((a = br.read()) !=-1) {
				if(a!='\n'&&a!='\r') {
					num++;
				}
			}//不是回车或回车换行就算字符
			br.close();
			fr.close();//关闭流
			System.out.println("该文件字符数为"+num);
		}catch (IOException e) {
			System.out.println("该文件不存在,请重新输入!");
		}
	} 
	public static void lineNum(String inPath) {
		String line= null;
		int lineNum=0;
		try {
			FileReader fr = new FileReader(inPath);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine())!=null) {
					lineNum++;//读的到就算一行
				}
			br.close();
			fr.close();
			System.out.println("该文件行数为"+lineNum);
		} catch (IOException e) {
			System.out.println("该文件不存在,请重新输入!");
		}
	}
	
	public static void wordNum(String inPath) {
		String line= "";
		int wordNum=0;
		try {
			FileReader fr = new FileReader(inPath);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine())!=null) {
					for(int i=0;i<line.length();i++) {
						char c=line.charAt(i);
						if(i==line.length()-1 && ((c>='a'&&c<='z')||(c>='A'&&c<='Z')) ){
							wordNum++;//如果是该行最后一个字符且是英文字母则单词数+1
						}
						if((c>='a'&&c<='z')||(c>='A'&&c<='Z')) {
							continue;//还是英文字母则继续
						}else {
							wordNum++;
						}
					}
				}
			br.close();
			fr.close();
			System.out.println("该文件单词数为"+wordNum);
		} catch (IOException e) {
			System.out.println("该文件不存在,请重新输入!");
		}
	}
	
	public static void recursion(File file) {
		if(file.isFile()) {
			System.out.println(file.getAbsolutePath());
			Method.charNum(file.getAbsolutePath());
			Method.lineNum(file.getAbsolutePath());
			Method.wordNum(file.getAbsolutePath());
		}else {
			File [] ff=file.listFiles();
			for(File fs:ff) {
				recursion(fs);
			}//递归处理
		}
	}
	
	public static void complexLines(String inPath) {   
		int blankLines=0;
		int commentLines=0;
		int codeLines=0;
		String line = "";
		int flag= 0;
		try {
			FileReader fr = new FileReader(inPath);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if(flag==1) {
		        	if(line.endsWith("*/")) {
		        		flag=0;
		        	}else {
		        		commentLines++;
		        	}
		        }else {
		        	if(line.startsWith("/*")){
		        		commentLines++;
                    }
		        	else if(line.startsWith("//")||line.startsWith("}//")){
		        			commentLines++;
		        	}
		        	else if(line.equals("")) {
		        		 blankLines++;
		        	}
		        	else {
		        		codeLines++;
		        	}
		        }	
		    }
			br.close();
			fr.close();
			System.out.println("该文件的注释行为"+commentLines);
			System.out.println("该文件的空白行为"+blankLines);
			System.out.println("该文件的代码行为"+codeLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        
	}  	
}
