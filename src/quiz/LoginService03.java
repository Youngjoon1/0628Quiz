package quiz;

import java.util.Scanner;

public class LoginService03 extends TimeService{
	LoginDTO03 login;
	MyFrame myFrame;
	MemberServiceImpl member;
	public LoginService03() {
		login = new LoginDTO03();
		myFrame = new MyFrame();
		member = new MemberServiceImpl();
	}
	public void display() {
		Scanner input = new Scanner(System.in);
		String inputId, inputPwd;
		int num;
		while(true ) {
			System.out.println("1.로그인");
			System.out.println("2.회원가입");
			System.out.println("3.탈퇴");
			System.out.println("4.종료");
			num = input.nextInt();
			switch( num ) {
			case  1:
				if( login.getId() == null ) {
					System.out.println("회원가입 먼저하세요!!");
					break;
				}
				System.out.println("인증 id 입력");
				inputId = input.next();
				System.out.println("인증 pwd 입력");
				inputPwd = input.next();
				
				if( inputId.equals( login.getId() ) ) {
					if(inputPwd.equals( login.getPwd() ) ) {
						System.out.println("인증 통과!!");
						setStartTime();
						myFrame.start();
						member.display();
						
					}else {
						System.out.println("!비밀번호가 틀렸습니다!");
					}
				}else {
					System.out.println("존재하지 않는 아이디입니다!!");
				}
				break;
			case  2:
				if( login.getId() == null ) {
					System.out.println("저장 아이디 입력");
					inputId = input.next();
					System.out.println("저장 비밀번호 입력");
					inputPwd = input.next();
					login.setId(inputId);
					login.setPwd(inputPwd);
					System.out.println("등록 성공!!!");
				}else {
					System.out.println("사용자가 존재합니다!!! 탈퇴진행..");
				}
				break;
			case  3:
				if(login.getId() == null) {
					System.out.println("회원가입 먼저하세요");
				}else {
					login.setId( null );
					login.setPwd( null );
					System.out.println("탈퇴 성공!!!");
				}
				break;
			case  4:
				setEndTime();
				System.out.println( getResultTime() );
				myFrame.setFlag(false);
				myFrame.setLable( getResultTime() );
				return ;
			}
		}
	}
}















