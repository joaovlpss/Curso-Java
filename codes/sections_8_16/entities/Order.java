package sections_8_16.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import sections_8_16.entities.enums.OrderStatus;

public class Order {

	private Integer id;
	private LocalDateTime moment;
	private OrderStatus status;
	private List<OrderItem> lsOrder = new ArrayList<OrderItem>();
	private Client client;

	public Order() {
	}

	public Order(Integer id, LocalDateTime moment, OrderStatus status, Client client) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment(){
		return moment;
	}
	public Integer getId() {
		return id;
	}

	public Client getClient(){
		return client;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item){
		lsOrder.add(item);
	}

	public void removeItem(OrderItem item){
		lsOrder.remove(item);
	}

	public List<OrderItem> getOrderItems(){
		return lsOrder;
	}
	
	public double total(){
		double accumulator = 0.00;

		for (OrderItem i : lsOrder){
			accumulator += i.subTotal();
		}

		return accumulator;
	}

	@Override
	public String toString() {
		return "Order [id = " + id + ", moment = " + moment + ", status = " + status + "]";
	}
}
