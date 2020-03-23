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
			}//���ǻس���س����о����ַ�
			br.close();
			fr.close();//�ر���
			System.out.println("���ļ��ַ���Ϊ"+num);
		}catch (IOException e) {
			System.out.println("���ļ�������,����������!");
		}
	} 
	public static void lineNum(String inPath) {
		String line= null;
		int lineNum=0;
		try {
			FileReader fr = new FileReader(inPath);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine())!=null) {
					lineNum++;//���ĵ�����һ��
				}
			br.close();
			fr.close();
			System.out.println("���ļ�����Ϊ"+lineNum);
		} catch (IOException e) {
			System.out.println("���ļ�������,����������!");
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
							wordNum++;//����Ǹ������һ���ַ�����Ӣ����ĸ�򵥴���+1
						}
						if((c>='a'&&c<='z')||(c>='A'&&c<='Z')) {
							continue;//����Ӣ����ĸ�����
						}else {
							wordNum++;
						}
					}
				}
			br.close();
			fr.close();
			System.out.println("���ļ�������Ϊ"+wordNum);
		} catch (IOException e) {
			System.out.println("���ļ�������,����������!");
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
			}//�ݹ鴦��
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
			System.out.println("���ļ���ע����Ϊ"+commentLines);
			System.out.println("���ļ��Ŀհ���Ϊ"+blankLines);
			System.out.println("���ļ��Ĵ�����Ϊ"+codeLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        
	}  	
}
