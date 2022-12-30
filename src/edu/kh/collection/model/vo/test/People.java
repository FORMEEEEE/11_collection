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
				case 1 : System.out.println(addStudent());break;
				case 2 : searchStudent(); break;
				case 3 : System.out.println(reBuildStudent());break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("프로그램 종료");break;
				default : System.out.println("숫자 다시 입력");
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("\nerror 입력형식이 유효하지 않음");
				sc.nextLine();
				menuNum = -1;
			}
			
		}while(menuNum != 0);
	}
	
	public String addStudent() throws InputMismatchException{
		System.out.println("===== 학생 정보 추가=====");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("사는곳 : ");
		String region = sc.next();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		if(studentList.add(new Student(name, age, region, gender,score))) {
			return "성공";
		}else {
			return "실패";
		}
		
	  }
	
	public void searchStudent() {
		
		
		System.out.println("=====학생 전체 조회=====");
		
		if(studentList.isEmpty()) {
			System.out.println("정보추가부터 해");
			return; // 여기서 리턴쓴건 밑에꺼 실행안하고 돌아가라는거임
		}
		int index = 0;
		for(Student std : studentList) {
			System.out.print(index++ + "번쨰 학생: ");
			System.out.println(std.toString());
		}
		
		
		
		
	}
	
	public String reBuildStudent() {
		
		System.out.println("=====학생 정보 수정=====");
		
		System.out.println("학생 번호 입력 : ");
		int index = sc.nextInt();
		
		if(studentList.isEmpty()) {
			return "학생부터 추가해";
		}else if(index < 0){
			return "0이상 입력해";
		}else if(index > studentList.size()) {
			return "아니 숫자를 다시입력하쇼";
		}else
			
		System.out.println(index + "번 학생정보");
		studentList.get(index);
		
		System.out.print("학생 이름 : ");
		String name = sc.next();
		
		System.out.print("학생 나이 : ");
		int age = sc.nextInt();
		
		System.out.print("사는곳 : ");
		String region = sc.next();
		sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("성적 : ");
		int score = sc.nextInt();
			
		Student temp = studentList.set(index, new Student(name, age, region,gender,score));
		return temp.getName() + "정보 변경 완료"; 
		
		
	}
	
	
}
