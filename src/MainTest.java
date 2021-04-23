import Product.Product;
import Product.ProductService;
import Role.Role;
import User.User;
import User.UserService;

public class MainTest {

	public static void main(String[] args) {		
		
		ProductService pro = new ProductService();
//		pro.addProduct(new Product("과자", 100, 100, Role.ADMIN));
//		pro.addProduct(new Product("과자3", 100, 100, Role.ADMIN));
//		pro.findProduct("과자");
//		pro.findProduct("과자2");
//		pro.addProduct(new Product("과자2", 100, 100, Role.ADMIN));
//		pro.findProduct("과자2");
//		pro.buyProduct("재익", "과자", 1);
//		pro.printAllBuyList("재익");
//		
		
		
		// 회원 가입 & 정보 수정 테스트
		System.out.println("=========================회원 가입 & 정보 수정(재익님 수정) 테스트============================");
		pro.printAllMember();
		pro.registerMember(new User("leeji0922","1234","이재익","남성","25","목동","010", Role.ADMIN));
		System.out.println("회원 중복 테스트");
		pro.registerMember(new User("leeji0922","2222","김유진","여성","23","강서","011", Role.USER));
		pro.printAllMember();
		System.out.println("변경 테스트");
		pro.editMember("leeji0922","1234","이재익","남성","25","목4동","010", Role.ADMIN);
		pro.printAllMember();
		
		// 탈퇴 테스트
		System.out.println("=========================회원 탈퇴 테스트============================");
		pro.registerMember(new User("kim3922","2222","김유진","여성","23","강서","011", Role.USER));
		pro.printAllMember();
		pro.delectMember("leeji0922");
		pro.printAllMember();
		
		
		//상품 등록 테스트
		System.out.println("=========================상품 등록 테스트============================");
		pro.addProduct("leeji0922", new Product("과자",100,100));
		pro.registerMember(new User("leeji0922","1234","이재익","남성","25","목동","010", Role.ADMIN));
		pro.addProduct("leeji0922", new Product("과자",100,100));
		pro.findProduct("과자");
		pro.addProduct("leeji3922", new Product("과자2",200,500));
		pro.findProduct("과자");
		pro.findProduct("과자2");
		pro.addProduct("leeji0922", new Product("과자2",200,100));
		
		//상품 구매 테스트
		System.out.println("=========================상품 구매 테스트============================");
		pro.registerMember(new User("park1234","1234","박누구","중성","45","평양","001", Role.GUEST));
		pro.buyProduct("leeji0922", "과자", 3);
		pro.buyProduct("leeji3922", "과자", 4);
		pro.buyProduct("park1234", "과자", 5);
		pro.findProduct("과자");
		
		//재고 테스트
		System.out.println("=========================상품 재고 테스트============================");
		pro.buyProduct("leeji0922", "과자2", 100);
		pro.buyProduct("leeji3922", "과자2", 1);
		pro.findProduct("과자2");
		
		//상품 구매 목록 조회 테스트
		System.out.println("=========================상품 구매 목록 조회 테스트============================");
		pro.printAllBuyList("leeji0922");
		pro.printAllBuyList("leeji3922");
		pro.printAllBuyList("park1234");
		
		//상품 수정 테스트
		System.out.println("=========================상품 수정 테스트============================");
		pro.editProdcut("kim3922",new Product("과자2",2999,4));
		pro.findProduct("과자2");
		pro.editProdcut("leeji0922", new Product("과자2",50000,5));
		pro.findProduct("과자2");
		
		//상품 삭제 테스트
		System.out.println("=========================상품 삭제 테스트============================");
		pro.deletProduct("kim3922", "과자2");
		pro.findProduct("과자2");
		pro.deletProduct("leeji0922", "과자2");
		pro.findProduct("과자2");
	}

}
