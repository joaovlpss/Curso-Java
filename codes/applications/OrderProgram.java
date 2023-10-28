package applications;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class OrderProgram {

	public static void main(String[] args) {

		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
		
		OrderStatus os1 = OrderStatus.DELIVERED;
		// Sometimes there will be the need to convert Strings to enum values
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		
		System.out.println(os1);
		System.out.println(os2);
	}
}