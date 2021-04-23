package User;

import java.util.ArrayList;
import java.util.List;

import Exception.IsDupliUser;
import Exception.NotUser;
import Role.Role;

public class UserService{
	
	List<User> userList = new ArrayList<>();
	
	// 회원가입
	public void registerMember(User user) {
		try {
			if(findMemberById(user.getUserId())!=null) {
				throw new IsDupliUser("회원중복");
			}
			userList.add(user);
			System.out.println("회원가입 완료");
			
			//System.out.println(user);
		
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	//회원검색
	public User findMemberById(String userId) {
		for(User u: userList) {
			if(u.getUserId().equals(userId)) {
				return u;
			}
		}
		return null;
	}
//	public User findMemberByName(String userName) {
//		for(User u: userList) {
//			if(u.getUserName().equals(userName)) {
//				return u;
//			}
//		}
//		return null;
//	}
	
	// 회원정보수정
	public void editMember(String userId, String userPw, String userName, String sex, String age, String address, String tel,Role role) {
		try {
			if(findMemberById(userId) == null) { // 입력한 유저입력값을 찾아서 목록에 없을 경우
				throw new NotUser("없는 회원입니다.");
			}
//			if(!findMemberById(userId).equals(userId)) {
//				throw new NotUser("아이디를 바꿀 순 없습니다.");	
//			}
			userList.remove(findMemberById(userId)); // 입력한 유저입력값을 삭제
			userList.add(new User(userId,userPw,userName,sex,age,address,tel,role)); // 해당 정보를 새로 등록
			System.out.println("수정 완료");
				
			//System.out.println(userList);
		
		} catch (Exception e) {
			e.getStackTrace();
		}
	
	}
	
	// 회원리스트보기
	public void printAllMember() {
		if(userList.isEmpty()) { // userList값이 없을때
				System.out.println("회원이 없습니다.");
				return;
		}
		System.out.println(userList); // userList의 값을 출력
	}
	
	// 회원탈퇴
	public void delectMember(String userId) {
		if(findMemberById(userId) == null) { // 입력한 유저입력값을 찾아서 목록에 없을 경우
			System.out.println("없는 회원 입니다.");
			return;
		}
		userList.remove(findMemberById(userId));// 입력한 유저입력값을 삭제
		System.out.println("삭제 완료");
	}

	
	//유저의 권한 체크
	public Role isPermissions(String userId) {
		if(findMemberById(userId) == null) { // 입력한 유저 입력값을 찾아서 목록에 없을 경우
			System.out.println("없는 회원 입니다.");
			return null;
		}
		return findMemberById(userId).getRole(); // 유저의 Role 값을 리턴
	}
	
	
	
	
//	//유저의 Role 값을 세팅
//	public void setUserRole(String userName, String setRole) {
//		
//		if(findMemberByName(userName) == null) {
//			System.out.println("없는 회원 입니다.");
//			return;
//		}
//		if(setRoleCode != 1 & setRoleCode != 2 & setRoleCode != 3) {
//			System.out.println("올바른 형식의 입력값이 아닙니다.");
//		}
//		userList.remove(findMemberByName(userName));
//		User userInfo = findMemberByName(userName);
//		Role.
//		userList.add(new User(userInfo,Role.setRole));
//		
//	}
	
}