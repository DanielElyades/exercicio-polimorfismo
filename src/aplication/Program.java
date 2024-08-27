package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSourceEmployee;

public class Program {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Employee> list = new ArrayList<Employee>();
		
		System.out.print("Enter the number of employees: ");
		int n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data");
			System.out.println("Outsourced (y/n): ");
			char out = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.print("Name: ");
			String name = scanner.nextLine();
			System.out.print("Hours:");
			int hours = scanner.nextInt();
			System.out.print("Value per hour:");
			double valuePerHour = scanner.nextDouble();
			
			if(out == 'y') {
				System.out.println("Additional charge:");
				double additionalCharge = scanner.nextDouble();
				Employee emp = new OutSourceEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(emp);
			}
			else {
				list.add(new Employee(name, hours, valuePerHour));
			}
			System.out.println();
			System.out.println("Payments:");
			for(Employee emp : list) {
				System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
			}
		}
	}

}
