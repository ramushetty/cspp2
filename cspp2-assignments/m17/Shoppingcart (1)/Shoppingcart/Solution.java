import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for item.
 */
class Item {
	/**
	 * { product name}.
	 */
	private String productname;
	/**
	 * { quantity }.
	 */
	private int quantity;
	/**
	 * { price }.
	 */
	private float price;
	/**
	 * { flag }.
	 */
	private boolean flag;
	/**
	 * Constructs the object.
	 *
	 * @param      productname1  The productname 1
	 * @param      quantity1     The quantity 1
	 * @param      price1        The price 1
	 */
	Item(String productname1, int quantity1, float price1) {
		this.productname = productname1;
		this.quantity = quantity1;
		this.price = price1;
		this.flag = true;
	}
	/**
	 * Constructs the object.
	 *
	 * @param      productname2  The productname 2
	 * @param      quantity2     The quantity 2
	 */
	Item(String productname2, int quantity2) {
		this.productname = productname2;
		this.quantity = quantity2;
		// this.flag = false;
	}
	/**
	 * { returns product name }.
	 *
	 * @return     { returns name }
	 */
	String getproductname() {
		return productname;
	}
	/**
	 * { returns quantity }.
	 *
	 * @return     { returns quantity }
	 */
	int getquantity() {
		return quantity;
	}
	/**
	 * { returns price}.
	 *
	 * @return     { price }
	 */
	float getprice() {
		return price;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		if (flag) {
			return productname + " " + quantity + " " + price;
		}
		return productname + " " + quantity;
	}
	/**
	 * { sets qunatity}.
	 *
	 * @param      item1  The item 1
	 */
	public void setquantity(int item1) {
		this.quantity = item1;
	}
	/**
	 * Sets the price.
	 *
	 * @return     { returns preice }
	 */
	public float setPrice() {
		return price;
	}
	/**
	 * Sets the price.
	 *
	 * @param      price  The price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

}
/**
 * Class for shoppingCart.
 */
class ShoppingCart {
	/**
	 * { array list of items of catalog }.
	 */
	ArrayList<Item> cataloglist;
	/**
	 * { arraylist of items of cartlist }.
	 */
	ArrayList<Item> cartlist;
	String[] arr = {"IND10", "IND20", "IND30", "IND50"};
	/**
	 * { array list of coupons code }.
	 */
	private ArrayList<String> couponCodes = new ArrayList<>(Arrays.asList(arr));
	/**
	 * { coupons }.
	 */
	private float coupon = 0.0f;
	/**
	 * { cflag }.
	 */
	private boolean cflag = false;
	/**
	 * Constructs the object.
	 */
	ShoppingCart() {
		cataloglist = new ArrayList<>();
		cartlist = new ArrayList<>();

	}
	/**
	 * Adds to catalog.
	 *
	 * @param      item  The item
	 */
	public void addToCatalog(Item item) {
		cataloglist.add(item);
		// System.out.println(itemlist.get(0).getprice());
	}
	/**
	 * Adds to cartesian.
	 *
	 * @param      item  The item
	 */
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
	/**
	 * { prints elements of catalog }.
	 */
	public void print() {
		for (Item e : cataloglist) {
			System.out.println(e);
		}
	}
	/**
	 * { prints elements of cartlist }.
	 */
	public void showcart() {
		for (Item e : cartlist) {
			System.out.println(e);
		}
	}
	/**
	 * { prints total amount}.
	 *
	 * @return     { returns total }
	 */
	public float gettotalamount() {
		float amount = 0;
		for (Item e : cartlist) {
			amount += e.getquantity() * getPrice(e.getproductname());

		}
		return amount;
	}
	/**
	 * Gets the price.
	 *
	 * @param      item  The item
	 *
	 * @return     The price.
	 */
	public float getPrice(String item) {
		for (Item e : cataloglist) {
			if (e.getproductname().equals(item)) {
				return e.getprice();
			}
		}
		return 0.0f;
	}
	/**
	 * Gets the payable amount.
	 *
	 * @return     The payable amount.
	 */
	public float getPayableAmount() {
		// System.out.println("hi");
		float dsc = 0.01f * coupon;
		return (gettotalamount() * (1f - dsc)) * 1.15f;

	}
	/**
	 * { applies coupons  }
	 *
	 * @param      couponCode  The coupon code
	 */
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
	/**
	 * Removes a from cartesian.
	 *
	 * @param      item  The item
	 */
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
	/**
	 * { prints in voice }.
	 */
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (Item e : cartlist) {
			System.out.println(e.getproductname() + " " + e.getquantity() + " " + getPrice(e.getproductname()));
		}
		float total = gettotalamount();
		System.out.println("Total:" + total);
		System.out.println("Disc%:" + 0.01 * coupon * total);
		System.out.println("Tax:" + ((int)((total * (1f - (0.01f * coupon)) * 0.15f) * 10)) / 10.0);
		System.out.println("Payable amount: " + ((int)(getPayableAmount() * 10)) / 10.0);

	}
}
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//empty.
	}
	/**
	 * { main function}.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		ShoppingCart s = new ShoppingCart();
		Scanner inp = new Scanner(new BufferedInputStream(System.in));
		while (inp.hasNext()) {
			String line = inp.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "Item":
				if (tokens.length > 1) {
					String[] t = tokens[1].split(",");
					int t1 = Integer.parseInt(t[1]);
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
