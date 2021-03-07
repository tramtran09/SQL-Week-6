package application;

import java.sql.SQLException;
import java.util.Scanner;

import dao.Users_dao;
import dao.Weights_dao;



public class Menu {
	
		private Scanner scanner = new Scanner(System.in);
		private String[] menuOpts = {"Enter name", "Enter weight and date", "Update weight", "Delete user"};
		private Users_dao usersDao = new Users_dao();
		private Weights_dao weightsDao = new Weights_dao();
		
		private void printMenu() {
			System.out.println("-----------");
			for (int i=0; i < menuOpts.length; i++) {
				System.out.println((i+1) + ")" + menuOpts[i]);
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
					System.out.println("\nWeigh in date cannot be empty. Please try again...");
				}
				
			}while(measureDate.isEmpty());
			
			System.out.println("Enter Weight: ");
			String weight = scanner.nextLine();
			
			weightsDao.enterNewWeight (userId, measureDate, weight);
		}
		
		private void updateWeight()throws SQLException {
			System.out.println("Enter ID of user to update log: ");
			String nl = scanner.nextLine()	;
			Integer id = null;
			try {
				id = Integer.parseInt(nl);
			}catch (NumberFormatException e) {
				System.out.println("Please enter a number!");
				return;
			}
			if (id != null) {
					System.out.println("Enter weight");
					String weight = scanner.nextLine();
				if(!weight.isEmpty()) {
					weightsDao.updateWeight (id,weight);
				}
			}
		}
		
		private void deleteUser() throws SQLException{
			System.out.println("Enter ID to delete: ");
			int id = Integer.parseInt(scanner.nextLine());
			usersDao.deleteUserById(id);
		}
		
		public void start() {
			String selection = "";
			
			do {
				printMenu();
				selection = scanner.nextLine();
				
				try {
					switch(selection) {
					case "1": enterName();
						break;
					case "2": enterWeight();
						break;
					case "3": updateWeight();
						break;
					case "4": deleteUser();
						break;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					//end();
				}
				if (!selection.equals("-1")) {
					System.out.println("Press enter to continue...");
					scanner.nextLine();
				}	
			
		} while (!selection.equals("-1"));
		
		//end();
	}
//	public void end() {
//		System.out.println("Goodbye!");
//		scanner.close();
//		usersDao.close();
//		weightsDao.close();
//	}
}
