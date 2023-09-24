import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public class Order {
		Double TotalPrice = 0.0;
		ArrayList<String> name = new ArrayList<>();
		int table;
	}

//	Vector<Order>Data = new Vector<>();

	Scanner scan = new Scanner(System.in);
	int input;
	int choose;
	int x;
	int flag = 0;
	String item;
	Double price = 0.0;
	Double tax = 0.0;
	Double service = 0.0;

	public static void main(String[] args) {
		new Main();
	}

	public void Menu() {
		System.out.println("==========================");
		System.out.println("|      Blues Cafe        |");
		System.out.println("==========================");
		System.out.println("|1. Add Order            |");
		System.out.println("|2. Show All Orders      |");
		System.out.println("|3. Remove Order         |");
		System.out.println("|4. Exit                 |");
		System.out.println("==========================");
	}

	public Main() {
//		System.out.println("Hello World!");
		ArrayList<Order> data = new ArrayList<>();

		do {
			Menu();
			System.out.print("Please input the number : ");
			input = scan.nextInt(); // %d
			scan.nextLine();
			if (input == 1) {
				Order order = new Order();
				System.out.print("Please input table number : ");
				x = scan.nextInt();
				scan.nextLine();
				if (data.size() == 0) {
					order.table = x;
					do {
						System.out.print("Input item (If you don't want to continue, type no) : ");
						item = scan.next();
						scan.nextLine(); // getchar
						if (item.equals("no")) {
							break;
						}
						System.out.print("Input price : ");
						price = scan.nextDouble();
						order.name.add(item);
						order.TotalPrice = order.TotalPrice + price;

						System.out.println("List of items that have been entered : ");
						for (int i = 0; i < order.name.size(); i++) {
							System.out.println(i + 1 + ". " + order.name.get(i));
						}
					} while (!item.equals("no"));
					tax = order.TotalPrice * 10 / 100;
					service = order.TotalPrice * 75 / 1000;
					order.TotalPrice = order.TotalPrice + tax + service;
					data.add(order);
				} else {
					flag = 0; //menandakan table
					for (int i = 0; i < data.size(); i++) {
						if (data.get(i).table == x) {
							do {
								System.out.print("Input item (If you don't want to continue, type no) : ");
								item = scan.next();
								scan.nextLine(); // getchar
								if (item.equals("no")) {
									break;
								}
								System.out.print("Input price : ");
								price = scan.nextDouble();
								data.get(i).name.add(item);
								data.get(i).TotalPrice = data.get(i).TotalPrice + price;

								System.out.println("List of items that have been entered : ");
								for (int j = 0; j < data.get(i).name.size(); j++) {
									System.out.println(j + 1 + ". " + data.get(i).name.get(j));
								}
							} while (!item.equals("no"));
							tax = data.get(i).TotalPrice * 10 / 100;
							service = data.get(i).TotalPrice * 75 / 1000;
							data.get(i).TotalPrice = data.get(i).TotalPrice + tax + service;
							flag = 1;
							break;
						}
						if (flag == 1) {
							break;
						}
					}

					if (flag == 0) {
						order.table = x;
						do {
							System.out.print("Input item (If you don't want to continue, type no) : ");
							item = scan.next();
							scan.nextLine(); // getchar
							if (item.equals("no")) {
								break;
							}
							System.out.print("Input price : ");
							price = scan.nextDouble();
							order.name.add(item);
							order.TotalPrice = order.TotalPrice + price;

							System.out.println("List of items that have been entered : ");
							for (int j = 0; j < order.name.size(); j++) {
								System.out.println(j + 1 + ". " + order.name.get(j));
							}
						} while (!item.equals("no"));
						tax = order.TotalPrice * 10 / 100;
						service = order.TotalPrice * 75 / 1000;
						order.TotalPrice = order.TotalPrice + tax + service;
						data.add(order);
					}
				}
			} else if (input == 2) {
				if (data.size() < 1) {
					System.out.println("Empty order");
					scan.nextLine();
				}
				for (int i = 0; i < data.size(); i++) {
					System.out.println("Table number : " + data.get(i).table);
					System.out.println(
							"Order to " + (i + 1) + " : " + data.get(i).name + " = Rp." + data.get(i).TotalPrice);
				}
			} else if (input == 3) {
				for (int i = 0; i < data.size(); i++) {
					System.out.println("Table number : " + data.get(i).table);
					System.out.println(
							"Order to " + (i + 1) + " : " + data.get(i).name + " = Rp." + data.get(i).TotalPrice);
				}
				System.out.print("Please enter the order you want to remove : ");
				choose = scan.nextInt();
				scan.nextLine();
				data.remove(choose - 1);
				for (int i = 0; i < data.size(); i++) {
					System.out.println(
							"Order to " + (i + 1) + " : " + data.get(i).name + " = Rp." + data.get(i).TotalPrice);
				}
				scan.nextLine();
			}
		} while (input != 4);
		System.out.println("Thank you for the visit!");
	}
}
