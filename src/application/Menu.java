package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.Users_dao;
import dao.Weights_dao;
import entity.User;


public class Menu {
	
		private Scanner scanner = new Scanner(System.in);
		private String[] menuOpts = {"Display weight log", "Enter name", "Enter weight", "Enter date", "Update weight", "Delete entry"};
		private Users_dao usersDao = new Users_dao();
		private Weights_dao weightsDao = new Weights_dao();
		
		private void printMenu() {
			System.out.println("-----------");
			for (int i=0; i < menuOpts.length; i++) {
				System.out.println((i+1) + ")" + menuOpts[i]);
			}
		}
		
		private void displayLog()throws SQLException{
			List <User> log = usersDao.displayLog();
			for(User u : log) {
				System.out.println(u.getid() + " - " + u.getName());	
			}
		}
		
		private void enterName() throws SQLException{
			System.out.println("Enter Name");
			String name = scanner.nextLine();
			usersDao.enterNewName (name);
		}
		
		private void enterWeight() throws SQLException{
			String measureDate = "";

			System.out.println("User ID: ");
			int userId = scanner.nextInt();
			do {
				System.out.print("Enter Weigh In Date");
				measureDate= scanner.nextLine();
				if(measureDate.isEmpty()) {
					System.out.println("Weigh in date cannot be empty. Please try again...");
				}
				
			}while(measureDate.isEmpty());
			
			System.out.println("Enter Weight: ");
			int weight = scanner.nextInt();
			
			weightsDao.enterNewWeight (userId, measureDate, weight);
		}
		
		
		public void start() {
			String selection = "";
			
			do {
				printMenu();
				selection = scanner.nextLine();
				
				try {
					switch(selection) {
					case "1": displayLog();
						break;
					case "2": enterName();
						break;
					case "3": enterWeight();
						break;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
				if (!selection.equals("-1")) {
					System.out.println("Press enter to continue...");
					scanner.nextLine();
				}
				
			
		} while (!selection.equals("-1"));
		
		
	}
}
