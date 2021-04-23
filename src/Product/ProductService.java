package Product;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Exception.NotAdmin;
import Exception.NotParameter;
import Exception.NotPermissions;
import Exception.NotUser;
import Role.Role;
import User.UserService;

public class ProductService extends UserService{
	
	List<Product> proList = new ArrayList<>();
	List<ProductBuy> buyList = new ArrayList<>();
	
	//상품 등록
	public void addProduct(String userId, Product product) {
		
		try {
			if(product == null) {
				throw new NotParameter("상품등록에 product 값이 없습니다.");
			}
			if(isPermissions(userId) != Role.ADMIN) {
				throw new NotPermissions("권한이 없습니다.");
			}
			proList.add(new Product(product.getProductName(),product.getCost(),product.getStock()));
			System.out.println("등록완료");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	//상품 조회
	public Product findProduct(String productName) {
		for(int i=0;i<proList.size();i++) {
			if(proList.get(i).getProductName().equals(productName)) {
				System.out.println(proList.get(i));
				return proList.get(i);
			}
			/*
			 * if(proList.get(i).getProductName() != productName) {
			 * System.out.println("상품이 없습니다."); return null; }
			 */
		}
		System.out.println("상품이 없습니다.");
		return null;
	}
	
	//상품 구매
	public void buyProduct(String userId, String productName, int quantity) {
		
		ProductBuy productBuy = new ProductBuy();
		
		try {
			Product findProduct = findProduct(productName);
			if(findProduct == null) { // 상품이 없을 경우
				throw new NotParameter("해당 상품이 없습니다.");
			}
			if(findProduct.getStock() < quantity) {
				throw new NotParameter("해당 상품의 재고가 없습니다");
			}
			if(isPermissions(userId) == Role.GUEST) {
				throw new NotPermissions("권한이 없습니다.");
			}
			productBuy.setTotalFee(findProduct.getCost() * quantity); // 총 구매 금액을 설정
			productBuy.setProductName(productName); // 이름을 설정
			productBuy.setQuantity(quantity); // 수량 설정
			productBuy.setUserId(userId); // 고객아이디을 설정
			findProduct.setStock(findProduct.getStock() - quantity); // 상품 재고를 마이너스 함
			buyList.add(productBuy); // productBuy의 list에 값을 입력
			System.out.println("구매완료");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	//구매리스트조회
	public void printAllBuyList(String userId) {
		
		for(int i = 0; i < buyList.size(); i++) {
			if(buyList.get(i).getUserId().equals(userId)) {
				System.out.println(buyList.get(i));
				return;
			}
		}
		System.out.println("유저가 없습니다");
	}
	
}
