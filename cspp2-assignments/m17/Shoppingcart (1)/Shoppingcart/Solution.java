import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
class Item {
	private String productname;
	private int quantity;
	private float price;
	private boolean flag;
	Item(String productname1, int quantity1, float price1) {
		this.productname = productname1;
		this.quantity = quantity1;
		this.price = price1;
		this.flag = true;
	}
	Item(String productname2, int quantity2) {
		this.productname = productname2;
		this.quantity = quantity2;
		// this.flag = false;
	}
	// System.out.println(quantity);
	String getproductname() {
		return productname;
	}
	int getquantity() {
		return quantity;
	}
	float getprice() {
		return price;
	}
	public String toString() {
		if (flag){
			return productname + " " + quantity + " " + price;
		}
		return productname + " " + quantity;
	}

	public void setquantity(int item1) {
		this.quantity = item1;
	}
	public float setPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
class ShoppingCart {
	ArrayList<Item> cataloglist;
	ArrayList<Item> cartlist;
	String[] arr = {"IND10", "IND20", "IND30", "IND50"};
	private ArrayList<String> couponCodes = new ArrayList<>(Arrays.asList(arr));
	private float coupon = 0.0f;
	private boolean cflag = false;
	ShoppingCart() {
		cataloglist = new ArrayList<>();
		cartlist = new ArrayList<>();

	}
	public void addToCatalog(Item item) {
		cataloglist.add(item);
		// System.out.println(itemlist.get(0).getprice());
	}
	public void addToCart(Item item) {
		for (Item e : cataloglist) {
			if (e.getproductname().equals(item.getproductname())) {
				for (Item g : cartlist) {
					if (g.getproductname().equals(item.getproductname())) {
						g.setquantity(g.getquantity() + item.getquantity());
						return;
					}
				}
				cartlist.add(item);
				return;
			}
		}
		
	}
	public void print() {
		for (Item e : cataloglist) {
			System.out.println(e);
		}
	}
	public void showcart() {
		for (Item e : cartlist) {
			System.out.println(e);
		}
	}
	public float gettotalamount() {
		float amount = 0;
		for (Item e: cartlist) {
			amount += e.getquantity() * getPrice(e.getproductname());
		
		}
		return amount;
	}
	public float getPrice(String item) {
		for (Item e : cataloglist) {
			if (e.getproductname().equals(item)) {
				return e.getprice();
			}
		}
		return 0.0f;
	}

	public float getPayableAmount() {
		// System.out.println("hi");
		float dsc = 0.01f * coupon;
		return (gettotalamount() * (1f - dsc)) * 1.15f;

	}
	public void applyCoupon(String couponCode) {
		// System.out.println("---------------------");
		if (couponCodes.contains(couponCode)) {
			// System.out.println(cflag + "----Flag");
			if (!cflag) {
				coupon = Integer.parseInt(couponCode.substring(3));
				cflag = true;
			}
			return;
		}
		System.out.println("Invalid coupon");
	}
	public void removeFromCart(Item item) {
		for (Item e : cartlist) {
			if (e.getproductname().equals(item.getproductname())) {
				if (e.getquantity() == item.getquantity()) {
					cartlist.remove(e);
					return;
				}
				e.setquantity(e.getquantity() - item.getquantity());
				return;
			}
		}
	}
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (Item e : cartlist) {
			System.out.println(e.getproductname() + " " + e.getquantity() + " " + getPrice(e.getproductname()));
		}
		float total = gettotalamount();
		System.out.println("Total: " + total);
		System.out.println("Disc%:" + 0.01 * coupon * total);
		System.out.println("Tax:" + ((int)((total * (1f - (0.01f * coupon)) * 0.15f) * 10)) / 10.0);
		System.out.println("Payable amount: " + ((int)(getPayableAmount() * 10)) / 10.0);

	}





}
public class Solution {
	public static void main(String[] args) {
		ShoppingCart s = new ShoppingCart();
		Scanner inp = new Scanner(new BufferedInputStream(System.in));
		while (inp.hasNext()) {
			String line = inp.nextLine();
			String[] tokens = line.split(" ");
			switch(tokens[0]) {
				case "Item":
					if (tokens.length > 1) {
						String[] t = tokens[1].split(",");
						int t1= Integer.parseInt(t[1]);
						// System.out.println(t[0] + t[1] + t[2]);
						int t2 = Integer.parseInt(t[2]);
						s.addToCatalog(new Item(t[0], t1, t2));
					}
					break;
				case "add":
					if (tokens.length > 1) {
						String[] a = tokens[1].split(",");
						int a2 = Integer.parseInt(a[1]);
						s.addToCart(new Item(a[0], a2));
					}
					break;
				case "catalog":
					s.print();
					break;
				case "show":
					s.showcart();
					break;
				case "totalAmount":
					System.out.println("totalAmount: " + s.gettotalamount());
				 	break;
				case "payableAmount":
					System.out.println("Payable amount: " + ((int)(s.getPayableAmount() * 10)) / 10.0);
					break;
				case "remove":
					if (tokens.length > 1) {
						String[] r = tokens[1].split(",");
						int r1 = Integer.parseInt(r[1]);
						s.removeFromCart(new Item(r[0], r1));
						break;
					}
					break;
				case "print":
					s.printInvoice();
					break;
				case "coupon":
					if (tokens.length > 1) {
						String coupon = tokens[1];
						s.applyCoupon(coupon);
						break;
					}
					break;
			}

		}
	}
}
