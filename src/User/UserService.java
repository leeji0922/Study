package User;

import java.util.ArrayList;
import java.util.List;

import Exception.IsDupliUser;
import Exception.NotPermissions;
import Exception.NotUser;
import Role.Role;

public class UserService{
	
	List<User> userList = new ArrayList<>();
	User user = new User();
	
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
	public void editMember(User user) {
		
		try {
			if(findMemberById(user.getUserId()) == null) { // 입력한 유저입력값을 찾아서 목록에 없을 경우
				throw new NotUser("없는 회원입니다.");
			}
//			if(!findMemberById(userId).equals(userId)) {
//				throw new NotUser("아이디를 바꿀 순 없습니다.");	
//			}
			if(findMemberById(user.getUserId()).getRole() != user.getRole()) { // 기존 유저의 권한이 입력한 권한 값과 다를 경우
				System.out.println("유저의 권한을 변경 할 수 없습니다.");
				return;
			}
			userList.remove(findMemberById(user.getUserId())); // 입력한 유저입력값을 삭제
			userList.add(user); // 해당 정보를 새로 등록
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
	
	//유저의 권한 세팅
	public void setUserPermissions(String setUserId, String userId, Role role) {
		
		String editUserPw; // 기존 유저 비밀번호
		String editUserName; // 기존 유저 이름
		String editUserSex; // 기존 유저 성별
		String editUserAge; // 기존 유저 나이
		String editUserAddress; // 기존 유저 주소
		String editUserTel; // 기존 유저 전화 번호
		
		System.out.println("****시도 : " + findMemberById(setUserId).getRole() + " 의 권한을 가진 "  + setUserId + "(이)가 " + userId + "의 Role 를 " + findMemberById(userId).getRole() + "에서 " + role + " 로 변경을 시도");
		
		try {
			if(isPermissions(setUserId) != Role.ADMIN) { // 유저의 권한은 체크
				throw new NotPermissions("권한이 없습니다.");
			}
			if(isPermissions(userId) == role) { // 유저의 권한 중복 체크
				System.out.println("이미 " + role +" 입니다.");
				return;
			}
			if(findMemberById(userId) == null) { // 회원 정보 값 null 체크
				throw new NotUser("없는 회원입니다.");
			}
			
			editUserPw = findMemberById(userId).getUserPw(); // 기존의 유저 비밀번호 값 보유
			editUserName = findMemberById(userId).getUserName(); // 기존의 유저 이름 값 보유
			editUserSex = findMemberById(userId).getSex(); // 기존의 유저 성별 값 보유
			editUserAge = findMemberById(userId).getAge(); // 기존의 유저 나이 값 보유
			editUserAddress = findMemberById(userId).getAddress(); // 기존의 유저 주소 값 보유
			editUserTel = findMemberById(userId).getTel(); // 기존의 유저 전화 번호 값 보유
			
			userList.remove(findMemberById(userId)); // 회원 정보 삭제
			userList.add(new User(userId,editUserPw,editUserName,editUserSex,editUserAge,editUserAddress,editUserTel,role)); // 수정된 회원 정보 추가
			System.out.println("권한이 설정 되었습니다.");
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
//	//유저의 권한 값 세팅
//	public Role editPermissions(String userId, String setUserId, Role role) {
//		try {
//			if(isPermissions(userId) != Role.ADMIN) { // 유저의 권한 체크
//				throw new NotPermissions("권한이 없습니다.");
//			}
//			if(isPermissions(setUserId) == Role.ADMIN) { // 유저의 권한 중복 체크
//				System.out.println("어드민의 권한을 변경할 수 없습니다.");
//			}
//			
//		} catch(Exception e) {
//			e.getStackTrace();
//		}
//		
//		
//		return role;
//		
//	}
	
	
	
	
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
