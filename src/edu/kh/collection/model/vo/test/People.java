package edu.kh.collection.model.vo.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

public class People {

	Scanner sc = new Scanner(System.in);
	
	private List<Student>studentList = new ArrayList<Student>();
	
	public void displayMenu() {
		int menuNum = 0;
		do {
			System.out.println("===== 학생 관리 프로그램 =====");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("선택 >> : ");
			
			try {
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("프로그램 종료");break;
				}
				
				
			}catch(InputMismatchException e) {
				
			}
			
			
			
		}while(menuNum != 0);
	}
	
}
