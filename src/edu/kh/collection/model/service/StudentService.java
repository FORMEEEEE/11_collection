package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

public class StudentService {
	//필드
	private Scanner sc = new Scanner(System.in);
	
	
	//학생 정보를 저장할 List를 생성(객체배열 upgrade버전)
	
	
	//java.util.List 인터페이스 : List에 반드시 필요한 기능을 모아둔 인터페이스
	// * 인터페이스는 객체 생성 X, 부모 참조 변수 O
	
	// java.util.ArrayList : 배열 형태의 List(가장 대표적인 List 자식 클래스)
	
	// ArrayList() 기본생성자 : 기본 크기 10짜리 리스트 생성
	// 						리스트 크기가 늘었다 줄었다 하기 때문에 큰 의미 없음
	
	// ArrayList(용량) : 용량 만큼의 리스트 생성
	// 					큰 값을 작성하면 메모리 많이 소모
		
	// List studentList = new ArrayList();
	private List<Student> studentList = new ArrayList<Student>(); //(검색)조회 효율적
	// List<Student> studentList = new LinkedList<Student>(); // 추가 수정 삭제 효율적
	// Student로 저장되는 타입이 제한된 리스트 생성
	// 
	
	public StudentService() {
		studentList.add(new Student("홍길동", 25, "서울시 중구", 'M', 90));
		studentList.add(new Student("고영희", 23, "경기도 안산시", 'F', 100));
		studentList.add(new Student("김아지", 30, "서울시 강남구", 'M', 80));
		studentList.add(new Student("오미나", 27, "충북 청주시", 'F', 90));
		studentList.add(new Student("박주희", 24, "서울 서대문구", 'F', 70));
	}

	
	
	public void ex() {
		// List 테스트
		
		// List.add(object e) : 리스트에 객체를 추가
		// *매개변수 타입이 object == 모든 객체를 매개변수로 전달 할 수 있음
		// (매개변수 object == 최상위 부모 참조 변수 == 다형성 적용 가능)
		
		studentList.add(new Student()); // 0번 인덱스
		//studentList.add(sc); // 1
		//studentList.add("문자열"); // 2
		//studentList.add(new Object()); //3
		// -> 컬렉션 특징 : 여러타입 데이터 저장 가능
		
		
		//(반환형)
		// List.get(index i) : 리스트에서 i번째 인덱스에 있는 객체(object)를 반환
		// 반환형이 object == 모든 객체를 반환할 수 있다
		
		System.out.println(studentList.get(0).toString());
		
		// [Student의 이름만 얻어오기]
		// Student 객체가 맞는지 instanceof로 확인
		// 다운캐스팅을 해야 (get(int index)메소드가 반환형이 object 최상위 부모이기 때문에)
		// Student 기능을 사용할 수 있다
		if(studentList.get(0) instanceof Student) {
			System.out.println(((Student)studentList.get(0)).getName());
		}
		
		// -> 길고 복잡함
		// -> 컬렉션의 장점인 여러 객체 저장이 방해됨
		
		// ******제네릭스(Generics)*******
		// <>
		// -> 컬렉션에 저장되는 객체 타입을 한 가지로 제한
		
		System.out.println(studentList.get(0).getName());
		
		
		
		
		
	}
	
	/** 메뉴 출력용 메서드
	 * alt + shift + j
	 *  @author mrryu000@naver.com
	 */
	public void displayMenu() {
		int menuNum = 0;
		do {
			System.out.println("\n==========학생 관리 프로그램==========");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			
			System.out.println("0. 프로그램 종료");
			
			System.out.print("\n메뉴 번호 선택 >>");
			
			try {
				menuNum = sc.nextInt();
				System.out.println(); //줄바꿈용도
				
				switch(menuNum) {
				case 1 : System.out.println(addStudent());break;
				case 2 : selectAll(); break;
				case 3 : System.out.println(updateStudent());break;
				case 4 : System.out.println(removeStudent());break;
				case 5 : searchName1(); break;
				case 6 : searchName2(); break;
				case 0 : System.out.println("프로그램 종료"); break;
				default : System.out.println("숫자 다시입력");
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("\n error : 입력 형식이 유효하지 않음" );
				sc.nextLine(); // 입력버퍼에 남아있는 잘못된 문자열 제거
				menuNum = -1; // 첫 반복시 잘못입력된 경우 menunum이 0이라 종료됨
								//이거 방지하려고 -1대입 아무거나 상관x
			}
			
		}while(menuNum != 0);
		
	}
		
	/**
	 * 1.학생정보 추가 메서드
	 * - 추가 성공시 "성공", 실패시 "실패"문자열 반환
	 * @author Ryu
	 * @return "성공" or "실패" 문자열 반환
	 * @throws InputMismatchException
	 */
	public String addStudent() throws InputMismatchException {
		
		System.out.println("====== 학생 정보 추가 ======");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("사는곳 : ");
		String region = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
								//String -> char
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		// Student 객체 생성 후 List 추가
		
		if( studentList.add( new Student(name, age, region, gender, score)) ) {
			
			return "성공";
		}else {
			return "실패";
		}
		
		
		
	}
	
	/** 2. 학생 전체 조회 메서드
	 *  - 추가 성공시 학생 전체 조회 실패시 "학생정보없음"출력
	 *  @author Ryu
	 */
	public void selectAll() {
		
		// List 인덱스 있음.(0~@)
		// List에 저장된 데이터 개수를 얻어오는 방법 : int List.size()
		// 배열명.length대신 사용
		
		System.out.println("====== 학생 전체 조회 ======");
		// studentList가 비어있는 경우 "학생 정보가 없습니다"출력
		
		// List가 비어있는지 확인하는법 : 
		// boolean List.isEmpty() : 비어있으면 true반환 
		
		//if(studentList.size() == 0) {
		if(studentList.isEmpty()) { //studentList가 비어있으면 true반환
			System.out.println("학생정보가 없음");
			
			return; //반환형 없는(void) return 구문은 현재 메서드를 종료하고 호출한곳으로 돌아감
					// 자동으로 else문을 쓴것과 같은 효과
		}
		// 일반 for문
		/*for(int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
			// studentList에서 i번째 인덱스 요소를 가져와 출력
		}*/
		
		// 향상된 for문 (for each문)
		// - 컬렉션, 배열의 모든 요소를 순차적으로 반복 접근할 수 있는 for문
		// (순차적 : 0번인덱스~마지막까지 인덱스를 1씩 증가)
		
		// [작성법] 
		// for(컬렉션 or 배열에서 꺼낸 한개의 요소를 저장할 변수 : 컬렉션 명 또는 배열명){ }
		int index = 0;
		for(Student std : studentList) {
			// std에는 for문 반복시 마다 0,1,2 인덱스 요소를 한번씩 저장함
			System.out.print(index++ + "번 : ");
			System.out.println(std);
		}
		
		
	}
	
	/**3. 학생 정보 수정 메서드
	 * @return
	 * @throws InputMismatchException
	 */
	public String updateStudent() throws InputMismatchException {
		//List.set(int index, Student e)
		// --> List의 index요소를 전달받은 e로 변경
		// --> 반환값 Student == 변경 전 Student객체가 담겨있음
		System.out.println("===== 학생 정보 수정 =====");
		
		System.out.println("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		// 1) 학생 정보가 studentList에 있는가?
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없음";
			// 2) 입력된 숫자가 0보다 작은가? (음수 X)
		}else if(index < 0) {
			return "음수는 입력할 수 없음";
			// + 문자열을 입력한 경우 -> throws로 예외처리
			// 3) 입력된 숫자가 studentList 범위 내 인덱스 번호인가?
		}else if(index >= studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없음";
		}else {
			
			//수정코드작성
			System.out.println(index + "번째 인덱스에 저장된 학생 정보");
			System.out.println(studentList.get(index));
			
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("사는곳 : ");
			String region = sc.nextLine();
			
			System.out.print("성별(M/F) : ");
			char gender = sc.next().charAt(0);
									//String -> char
			System.out.print("점수 : ");
			int score = sc.nextInt();
			
			// 입력받은 index번째에 새로운 학생 정보를 세팅 == 수정
			// 이때, index 번째에 있던 기존 학생 정보 반환
			
			Student temp = studentList.set(index, new Student(name, age, region, gender, score));
			
			
			
			return temp.getName() + "의 정보가 변경되었습니다";
		}
		
		
		
		
	}
	
	/**4. 학생 정보 제거 메서드
	 * @return
	 */
	/**
	 * @return
	 * @throws InputMismatchException
	 */
	public String removeStudent() throws InputMismatchException {
		
		// List.remove(int index)
		// 리스트에서 index번째 요소를 제거
		// 이때 제거된 요소가 반환된다
		// * List는 중간에 비어있는 인덱스가 없게 하기 위해서
		// remove() 동작 시 뒤쪽 요소를 한칸씩 당겨온다.
		
		System.out.println("====== 학생 정보 제거 ======");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		// 1) 학생 정보가 studentList에 있는가?
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없음";
			// 2) 입력된 숫자가 0보다 작은가? (음수 X)
		}else if(index < 0) {
			return "음수는 입력할 수 없음";
			// + 문자열을 입력한 경우 -> throws로 예외처리
			// 3) 입력된 숫자가 studentList 범위 내 인덱스 번호인가?
		}else if(index >= studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없음";
	
		}else {
			
			// 학생 정보 제거
			System.out.print("정말 삭제 할거야?(Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
					// String -> 대문자 String -> 대문자 0번째 인덱스 문자
			
			// String.toUpperCase() : 문자열을 대문자로 변경
			// String.toLowerCase() : 문자열을 소문자로 변경
			
			// char형이라 == 가능 String 형은 무조건 equals()
			if(ch == 'Y') {
			Student temp = studentList.remove(index);
			return temp.getName() + "의 정보가 제거됨";
			}else {
				
			}
		}
		return "취소";
	}
	
	/**
	 * 5. 이름이 일치하는 학생을 찾아서 조회하는 메서드
	 * 
	 */
	public void searchName1() {
		
		System.out.println("======학생 이름(이름 일치)======");
		
		System.out.print("검색할 이름 입력 : ");
		String input = sc.next();
		
		boolean flag = true; // flag가 true인 경우 ==> 검색결과가 없습니다.
		
		
		for(Student std : studentList) {
			if(input.equals(std.getName()) ) { //이름이 일치하는 경우
				System.out.println(std);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("검색결과가 없음");
		}
		
		
	}
	/**
	 * 6. 이름에 특정 문자열이 포함되는 학생을 찾아 조회하는 메서드
	 * 
	 */
	public void searchName2() {
		
System.out.println("======학생 이름(문자열 포함)======");
		
		System.out.print("이름에 포함될 문자열 입력 : ");
		String input = sc.next();
		
		boolean flag = true; // flag가 true인 경우 ==> 검색결과가 없습니다.
		
		
		for(Student std : studentList) {
			// contains : 포함
			// boolean String.contains(문자열) : String에 문자열이 포함되어있으면 true
			if(std.getName().contains(input) ) { //이름이 일치하는 경우
				System.out.println(std);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("검색결과가 없음");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
