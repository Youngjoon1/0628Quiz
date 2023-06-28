package quiz;

import java.util.Scanner;

public class MemberServiceImpl implements MemberService {

	Scanner sc = new Scanner(System.in);
	MemberDTO dto = new MemberDTO();

	@Override
	public void display() {

		boolean flag = true;
		while(flag) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1. 정보 등록");
			System.out.println("2. 정보 보기");
			System.out.println("3. 정보 삭제");
			System.out.println("4. 정보 수정");
			System.out.println("5. 종료");
			System.out.printf(">>>>>>>>>>>");
			int num = sc.nextInt();

			switch(num) {
			case 1 :
				save();
				break;
			case 2 :
				view();
				break;
			case 3 :
				del();
				break;
			case 4 :
				change();
				break;
			case 5 :
				flag = false;
			}
		}
	}

	@Override
	public void save() {

		System.out.println("개인정보를 입력해주세요.");
		System.out.println("이름 : ");
		dto.setName(sc.next());
		System.out.println("주소 : ");
		dto.setAddr(sc.next());
		System.out.println("나이 : ");
		dto.setAge(sc.nextInt());

		System.out.println("등록완료");

	}



	@Override
	public void view() {
		if(dto.getName() == null) {
			System.out.println("등록부터 해주세요");
			return;
		}else {
			System.out.println("회원정보");
			System.out.println("이름 : " + dto.getName());
			System.out.println("주소 : " + dto.getAddr());
			System.out.println("나이 : " + dto.getAge());
			
		}
	}

	@Override
	public void del() {
		dto.setAddr(null);
		dto.setName(null);
		dto.setAge(0);
	}

	@Override
	public void change() {
		if(dto.getName() == null) {
			System.out.println("등록부터 해주세요");
			return;
		}else {
			System.out.println("이름 : " + dto.getName());
			System.out.println("주소 : " + dto.getAddr());
			System.out.println("나이 : " + dto.getAge());
			System.out.println("변경할 값을 넣어주세요.");
			System.out.println("이름 : ");
			dto.setName(sc.next());
			System.out.println("주소 : ");
			dto.setAddr(sc.next());
			System.out.println("나이 : ");
			dto.setAge(sc.nextInt());
		}



	}



}
