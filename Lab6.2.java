import java.util.*;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
class Item{
	String itemName;
	int itemStock;
	Item(String name,int stock){
		this.itemName=name;
		this.itemStock=stock;
	}
	String getItemName(){
		return itemName;
	}
	int getItemQty(){
		return itemStock;
	}
}
class Order{
	String orderedItem;
	int orderedrQty;
	String orderStatus;
	static int orders=0;
	int orderId;
	Order(String item,int qty){
		this.orderedItem=item;
		this.orderedrQty=qty;
		this.orderStatus="Placed";
		this.orderId=orders+1;
		orders+=1;
	}
	int getOrderId(){
		return orderId;
	}
	String getStatus(){
		return orderStatus;
	}
}
class OutOfStock extends Exception{
	OutOfStock(String str){
		super(str);
	}
}
class WorkerThread implements Runnable{
	EnhancedOrderFulfillmentSystem eofs;
	int id;
	Order executingorder;
	Item executionitem;
	WorkerThread(int id,EnhancedOrderFulfillmentSystem eofs1){
		this.eofs=eofs1;
		this.id=id;
	}
	void checkInventoryAvailability() throws OutOfStock{	
		if(executingorder.orderedrQty<=executionitem.itemStock){}
		else{
			throw new OutOfStock("Insufficient Stock, one of the ordered cancelled");
		}
	}
	void updateInventory(){
		executionitem.itemStock-=executingorder.orderedrQty;
		executingorder.orderStatus="Completed";
	}
	public void run(){
		for(Order order:eofs.orders){
			if(order.getOrderId()==id){
				this.executingorder=order;
			}
		}
		for(Item item:eofs.items){
			if(item.getItemName().equals(executingorder.orderedItem)){
				this.executionitem=item;
			}
		}
		try 
		{
			checkInventoryAvailability();
			updateInventory();
		}
		catch(OutOfStock oos)
		{
			System.out.println(oos);
			executingorder.orderStatus="Cancelled";
		}
	}
}
class EnhancedOrderFulfillmentSystem{
	List<Item> items;
	List<Order> orders;
	EnhancedOrderFulfillmentSystem(){
		this.items=new ArrayList<>();
		this.orders=new ArrayList<>();
	}
	void addItem(Item item){
		items.add(item);
	}
	void placeOrder(Order order){
		orders.add(order);
	}
	List<Item> getItems(){
		return items;
	}
	List<Order> getOrders(){
		return orders;
	}
	void getInventory(){
		for(Item item:items){
			System.out.println("Item Name:"+item.getItemName());
			System.out.println("In Stock Qty:"+item.getItemQty());
			System.out.println("_______________________________");
		}
	}
	void startProcessing(EnhancedOrderFulfillmentSystem eofs){
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(Order order:orders){
			Runnable worker=new WorkerThread(order.orderId,eofs);
			executor.execute(worker);
		}
		executor.shutdown();
		waitForCompletion();
	}
	void waitForCompletion(){
		System.out.println("All orders are processed");
	}
}
class Lab6Program2{
	static Order findOrderByOrderId(int id,List<Order> orders){
		for(Order order:orders){
			if(order.getOrderId()==id){
				return order;
			}
		}
		return null;
	}
	static Item findItemByItemName(String name,List<Item> items){
		for(Item item:items){
			if(item.getItemName().equals(name)){
				return item;
			}
		}
		return null;
	}
	static void trackOrderStatus(int id,EnhancedOrderFulfillmentSystem eofs){
		Order order=findOrderByOrderId(id,eofs.getOrders());
		if(order!=null){
			System.out.println("Current Status:Order "+order.getStatus());
		}
		else{
			System.out.println("Order not found");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EnhancedOrderFulfillmentSystem eofs=new EnhancedOrderFulfillmentSystem();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		System.out.println("Enter the number of items");
		int numItems=sc.nextInt();
		for(int i=0;i<numItems;i++){
			sc.nextLine();
			System.out.println("Enter Item Name for item "+(i+1)+":");
			String name=sc.nextLine();
			System.out.println("Enter Qty:");
			int qty=sc.nextInt();
			Item item=new Item(name,qty);
			eofs.addItem(item);
		}
		System.out.println("Enter number of orders:");
		int numOrder=sc.nextInt();
		for(int i=0;i<numOrder;i++){
			sc.nextLine();
			System.out.println("Enter item name for order "+(i+1)+":");
			String name=sc.nextLine();
			System.out.println("Enter qty:");
			int qty=sc.nextInt();
			Order orders=new Order(name,qty);
			eofs.placeOrder(orders);
		}
		System.out.println("Items and orders placed");
		while(true){
			System.out.println("Choose:\n1.Execute All orders\n2.Get status of an order\n3.Get Inventory\n4.Exit\n");
			int choice=sc.nextInt();
			switch(choice){
				case 1: eofs.startProcessing(eofs);
						break;
				case 2: System.out.println("Enter Order ID:");
						int id=sc.nextInt();
						trackOrderStatus(id,eofs);
						break;
				case 3: eofs.getInventory();
						break;
				case 4: System.out.println("Thank You");
						sc.close();
						System.exit(0);
				default: System.out.println("Invalid Choice");
			}
		}
	}
}