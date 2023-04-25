import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.Scanner;


	public class SQLDemo {
		private static Connection conn=null;
		private static Statement stmt = null;
		 private static String localURL = "jdbc:mysql://localhost:3306/cse103?user=root";
		    private static String csseURL = "jdbc:mysql://csse-mysql:3306/ziqijin?user=ZiqiJin18&password=123";
	    private static String csseAltURL = "jdbc:mysql://csse-mysql.xjtlu.edu.cn:3306/ziqijin18?user=ZiqiJin18&password=123";
	 public static void main(String[] args) throws SQLException, ParseException  {
	        try {
	            conn = DriverManager.getConnection(csseAltURL);
	            stmt = conn.createStatement();
	            System.out.println("Connected to database");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        //
	        Scanner input = new Scanner(System.in);  
	        //guest or staff
		    System.out.println("Are you a guest or a staff?(write down guest/staff)");
			String a = input.next();
			while (!a.equals("guest")&!a.equals("staff")){
				System.out.println( "the input is in a wrong format, please check again");
				a=input.next();
	      }
			if(a.equals("guest")){
				System.out.println("do you have an acount? Just answer yes or no");
				String answer1 = input.next();
				while (!answer1.equals("yes")&!answer1.equals("no")){
					System.out.println( "the input is in a wrong format, please check again,only answer yes or no");
					answer1=input.next();
		      }
				//have account guest
				if (answer1.equals("yes")) {
					login();
					System.out.println("what do you want to do?");
			        System.out.println("book rooms£ºbook");
			        System.out.println("delete rooms: delete");
			        System.out.println("book a meal: meal");
			        System.out.println("Please follow the guide to put in the word");
			        String answer3=input.next();
			        while (!answer3.equals("book")&!answer3.equals("delete")&!answer3.equals("meal")){
						System.out.println( "the input is in a wrong format, please check again, only answer book or delete");
						answer3=input.next();
			      }
			        //have account guest book room
			        if (answer3.equals("book")) {
			        	book();
			        	 System.out.println("do you require food services?");
					        String answer2 = input.next();
					        while (!answer2.equals("yes")&!answer2.equals("no")){
								System.out.println( "the input is in a wrong format, please check again");
								answer2=input.next();
					      }
					        if(answer2.equals("yes")) {
					        	System.out.println("now you can look up our scheldues");
					        	food();
					       
					        }
					        if(answer2.equals("no")){
					        	System.out.println("thank you for your registion!");
					        }
			        }
			        
			        //have account guest delete room

			        if (answer3.equals("delete")) {
			        	delete();
			        }
			        if (answer3.equals("meal")) {
					     System.out.println("now you can look up our scheldues");
					      food();
			        }
				
				}
				
				//guest do not have account
				if (answer1.equals("no")) {
				create();
                login();
                System.out.println("now you can book rooms");
		        
		        // no account book room
		        book();
	
		        	 System.out.println("do you require food services?");
				        String answer2 = input.next();
				        while (!answer2.equals("yes")&!answer2.equals("no")){
							System.out.println( "the input is in a wrong format, please check again");
							answer2=input.next();
				      }
				        if(answer2.equals("yes")) {
				        	System.out.println("now you can look up our scheldues");
				        	food();
				       
				        }
				        if(answer2.equals("no")){
				        	System.out.println("thank you!");
				        }
		        }
		       
			}
		       
		        
			
			if (a.equals("staff")) {
				login2();
				details();
				System.out.println("do you want any other information?(yes/no)");
				String answer2 = input.next();
		        while (!answer2.equals("yes")&!answer2.equals("no")){
					System.out.println( "the input is in a wrong format, please check again");
					answer2=input.next();
		      }
		        if(answer2.equals("yes")) {
		        	details();
		        }else {
		        	System.out.println("Have a nice day!");
		        }
			}
			
	 }
	 public static void create() {
		 Scanner input = new Scanner(System.in); 
			//guest mode
		        System.out.println("Welcome!");
		        System.out.println("Your username is?");
	        	String username = input.next();
		        System.out.println("Your real name is?");
		        String rName = input.next();
		        System.out.println("Your passport ID is?");
		        int ID = input.nextInt();
	          	System.out.println("Your telephonenumber is?");
		        int telenumber = input.nextInt();
	        	System.out.println("Your email address is?");
		        String email = input.next();
		    	System.out.println("Your password is?");
		    	String password = input.next();
		    	System.out.println("Your account has been created, now login");
		    	 try {
		    		 stmt = conn.createStatement();
		            stmt.execute("DROP TABLE IF EXISTS guest");
		            stmt.execute("CREATE TABLE `GUEST` (ID INT PRIMARY KEY, Username VARCHAR(800) NOT NULL, Password VARCHAR(800) NOT NULL);");
		            System.out.println("Table hath been created.");
		            stmt.execute("INSERT INTO GUEST VALUES ('" + ID +"','" +username +"','"+ password + "')");
		            System.out.println("Rows are added!");
		    	 }
		            catch (SQLException e) {
		                System.out.println(e.getMessage());
		            }
		    }	

	 public static void login() throws SQLException {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Enter your username");
		    String username = input.next();
		    System.out.println("Enter your password");
		    String password = input.next();
		    String query = "SELECT username, password, ID FROM guest";
				ResultSet rs = stmt.executeQuery(query);
				  if(rs.next()&&rs.getString("Username").equals(username)&&rs.getString("Password").equals(password)){	
					   
						 System.out.println("you have successfylly login");
					   }else {
						   System.out.println("Wrong password or username, try again");
						   
							login();
					   }
				}
				
				
	
	 

	 public static void login2() throws SQLException {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Enter your username");
		    String username = input.next();
		    System.out.println("Enter your password");
		    String password = input.next();
		    String query = "SELECT StaffUsername, StaffPassword FROM staff WHERE StaffUsername = '"+username+"'and StaffPassword = '"+password+"'";
		   
				ResultSet rs = stmt.executeQuery(query);
				  if(rs.next()) {
					  System.out.println("you have successfylly login");
						
					   }else {
						  
						   System.out.println("Wrong password or username, try again");
						   login2();
					   }
					
					}

		
	 public static void book() throws SQLException {
		 Scanner input = new Scanner(System.in);
		 System.out.println("which type of room you want to book?");
		 System.out.println("1.Large double bed");
		 System.out.println("2.Large single bed");
		 System.out.println("3.Small single bed");
		 System.out.println("4.VIP room");
		 System.out.println("Please put in the number before the roomtype you want to book");
		 String number = input.next();
		 while (!number.equals("1") &!number.equals("2")&!number.equals("3")&!number.equals("4")){
				System.out.println( "the input is in a wrong format, please check again");
				number=input.next();
		 }
		 if (number.equals("1")) {
			 String query = "SELECT * FROM rooms WHERE RoomType = 'Large double bed' AND status = 0" ;
				ResultSet rs;
				rs = stmt.executeQuery(query);
				while(rs.next()){
					System.out.println("These are roomnumbers you can choose: " + rs.getInt("RoomNumber"));
				}
					 System.out.println("do you want you room to be arranged or choose your room by yourself?(put in the number)");
					 System.out.println("1.arranged");
					 System.out.println("2.by myself");
					 int number2 = input.nextInt();
					 if (number2 == 1) {
						 String query2 = "SELECT * FROM rooms WHERE RoomType = 'Large double bed' AND status = 0 ORDER BY RAND() LIMIT 1";
						 rs = stmt.executeQuery(query2);
						 while(rs.next()) {
						 System.out.println("your room "+ rs.getInt("roomnumber") + " has been registered successfully");
					 }
					 }
					}
			
		 if (number.equals("2")) {
			 String query = "SELECT * FROM rooms WHERE RoomType = 'Large single bed'AND status = 0";
				ResultSet rs;
				rs = stmt.executeQuery(query);
				while(rs.next()){
					System.out.println("These are roomnumbers you can choose: " + rs.getInt("RoomNumber"));
				}
					 System.out.println("do you want you room to be arranged or choose your room by yourself?(put in the number)");
					 System.out.println("1.arranged");
					 System.out.println("2.by myself");
					 int number2 = input.nextInt();
					 if (number2 == 1) {
						 String query2 = "SELECT * FROM rooms WHERE RoomType = 'Large single bed' AND status = 0 ORDER BY RAND() LIMIT 1";
						 rs = stmt.executeQuery(query2);
						 while(rs.next()) {
						 System.out.println("your room "+ rs.getInt("roomnumber") + " has been registered successfully");
					 }
					 }
					}
		 if (number.equals("3")) {
			 String query = "SELECT * FROM rooms WHERE RoomType = 'small single bed'AND status = 0";
				ResultSet rs;
				rs = stmt.executeQuery(query);
				while(rs.next()){
					System.out.println("These are roomnumbers you can choose: " + rs.getInt("RoomNumber")); 
				}
					System.out.println("do you want you room to be arranged or choose your room by yourself?(put in the number)");
					 System.out.println("1.arranged");
					 System.out.println("2.by myself");
					 int number2 = input.nextInt();
					 if (number2 == 1) {
						 String query2 = "SELECT * FROM rooms WHERE RoomType = 'small single bed' AND status = 0 ORDER BY RAND() LIMIT 1";
						 rs = stmt.executeQuery(query2);
						 while(rs.next()) {
						 System.out.println("your room "+ rs.getInt("roomnumber") + " has been registered successfully");
					 }
					 }
					}
			
		 if (number.equals("4")) {
			 String query = "SELECT * FROM rooms WHERE RoomType = 'VIP Room' AND status = 0";
				ResultSet rs;
				
				rs = stmt.executeQuery(query);
				while(rs.next()){
					System.out.println("These are roomnumbers you can choose: " + rs.getInt("RoomNumber"));
				}
					 System.out.println("do you want you room to be arranged or choose your room by yourself?(put in the number)");
					 System.out.println("1.arranged");
					 System.out.println("2.by myself");
					 int number2 = input.nextInt();
					 if (number2 == 1) {
						 String query2 = "SELECT * FROM rooms WHERE RoomType = 'VIP Room' AND status = 0 ORDER BY RAND() LIMIT 1";
						 rs = stmt.executeQuery(query2);
						 while(rs.next()) {
						 System.out.println("your room "+ rs.getInt("roomnumber") + " has been registered successfully");
					 }
					 }
			}
		
		 System.out.println("Please double check your roomnumber(enter the roomnumber)");
		 int roomnumber = input.nextInt();
		 String query0 = "SELECT * FROM rooms WHERE status = 1 and RoomNumber = '"+roomnumber+"'";
		 ResultSet rs;
		 rs = stmt.executeQuery(query0);
		if(rs.next()) {
			System.out.println("you cannot book this room, please try again");
	     	book();
	     	} else {
		 String query2 = "UPDATE rooms SET status = "+1+" WHERE roomnumber = "+roomnumber+"";
		 rs = stmt.executeQuery(query2);
		 System.out.println("your room "+ roomnumber + " has been registered successfully");
		 //checkin
		 System.out.println("Please tap down your check-in time( in the form of yyyy-mm-dd)");
		 String checkin = input.next();
		 Date in = Date.valueOf(checkin);
		 System.out.println(in);
		 System.out.println("Please tap down your check-out time( in the form of yyyy-mm-dd)");
		 String checkout = input.next();
		 Date out = Date.valueOf(checkout);
		 System.out.println(out);
		 System.out.println("Please tap down your passportID");
		 String ID = input.next();
		 String query4 = "INSERT INTO booked (checkin,checkout,ID,roomnumber)VALUES('"+in+"','"+out+"','"+ID+"','"+roomnumber+"')";
		 rs = stmt.executeQuery(query4);
	     	}
		 }
	 
		 
		
	 
	 public static void details() throws SQLException {
		 System.out.println("What you want to check(empty rooms?/booked rooms?/specific room book dates?)");
		 System.out.println("Check the empty rooms please enter 1");
		 System.out.println("Check the booked rooms please enter 2");
		 System.out.println("Check the specific rooms please enter 3");
		 Scanner input = new Scanner(System.in);
		 String number = input.next();
		 while (!number.equals("1") &!number.equals("2")&!number.equals("3")){
				System.out.println( "the input is in a wrong format, please check again");
				number=input.next();
		 }
		 if(number.equals("1")) {
			 String query = "SELECT * FROM rooms WHERE status = 0"; 
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			if(rs.next()){
			 System.out.println("The empty rooms are£º"+ rs.getInt("RoomNumber"));
			 }else {
				 System.out.println("no rooms are empty");
			 }
		 }
		 if(number.equals("2")){
			 String query = "SELECT * FROM rooms WHERE status = 1"; 
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 if(rs.next()){
			 System.out.println("The booked rooms are£º"+ rs.getInt("RoomNumber"));
			 }else {
				 System.out.println("no rooms have been booked");
			 }
		 }
		 if(number.equals("3")){
			 System.out.println("Please enter the roomnumber you want to check");
			 int roomnumber = input.nextInt();
			 String query = "SELECT * FROM booked WHERE roomnumber = "+roomnumber+"";
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 if(rs.next()){
				System.out.println("The checkin date is " + rs.getDate("checkin"));
			    System.out.println("The checkout date is " + rs.getDate("checkout"));
			    System.out.println("The guest's passport id is " + rs.getString("id"));
			 }else {
				 System.out.println("this room hasn't been booked");
			 }
		 }
	 }
	 
	 public static void delete() throws SQLException{
		 Scanner input = new Scanner(System.in);
		 System.out.println("Please enter your passport ID");
		 String ID = input.next();
		 System.out.println("These are the rooms you can delete");
		 String query1 = "SELECT * FROM booked WHERE id = '"+ID+"'";
		 ResultSet rs;
		 rs = stmt.executeQuery(query1);
		 while(rs.next()) {
		 System.out.println("Roomnumber:"+ rs.getInt("roomnumber"));
		 }
		 System.out.println("Please choose the room you want to delete");
		 String room = input.next();
		 String query2 = "DELETE FROM booked WHERE roomnumber = '"+room+"'";
		 rs = stmt.executeQuery(query2);
		 System.out.println("you have successfully deleted the data");
		 String query3 = "UPDATE rooms SET status = '"+0+"' WHERE Roomnumber = '"+room+"'";
		 rs = stmt.executeQuery(query3);
		
	 }
	 public static void food() throws SQLException, ParseException {
		 Scanner input = new Scanner(System.in);
		 System.out.println("The meal is only provided for two days after");
		 System.out.println("Please enter today's date in order to book the meal two days after.(in the form of yyyy-mm-dd)");
		 String time = input.next();
		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date date = format.parse(time);
		 Instant instant = date.toInstant();
		 ZoneId zoneId = ZoneId.systemDefault();
		 LocalDate localDate = instant.atZone(zoneId).toLocalDate();
		 DayOfWeek day = localDate.getDayOfWeek();
        String WeekDay = "";
		 switch (day) {
		 case MONDAY:
		 	WeekDay = "1";
		 	break;
		 case FRIDAY:
		 	WeekDay = "5";
		 	break;
		 case SATURDAY:
		 	WeekDay = "6";
		 	break;
		 case SUNDAY:
		 	WeekDay = "7";
		 	break;
		 case THURSDAY:
		 	WeekDay = "4";
		 	break;
		 case TUESDAY:
		 	WeekDay = "2";
		 	break;
		 case WEDNESDAY:
		 	WeekDay = "3";
		 	break;
		 }
		 
		 if (WeekDay=="1") {
			 String query="SELECT * FROM food WHERE workdays=3";
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
				 System.out.println("the chefs' names are: "+rs.getString("chef"));
			 System.out.println("These are the dishes you can book "+rs.getString("dishes"));
		 }
		 }
		 if (WeekDay=="2") {
			 String query="SELECT * FROM food WHERE workdays=4";
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
				 System.out.println("the chefs' names are: "+rs.getString("chef"));
			 System.out.println("These are the dishes you can book "+rs.getString("dishes"));
		 }}
		 if (WeekDay=="3") {
			 String query="SELECT * FROM food WHERE workdays=5";
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
				 System.out.println("the chefs' names are: "+rs.getString("chef"));
			 System.out.println("These are the dishes you can book "+rs.getString("dishes"));
		 }}
		 if (WeekDay=="4") {
			 String query="SELECT * FROM food WHERE workdays=6";
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
				 System.out.println("the chefs' names are: "+rs.getString("chef"));
			 System.out.println("These are the dishes you can book "+rs.getString("dishes"));
		 }}
		 if (WeekDay=="5") {
			 String query="SELECT * FROM food WHERE workdays=7";
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
				 System.out.println("the chefs' names are: "+rs.getString("chef"));
			 System.out.println("These are the dishes you can book "+rs.getString("dishes"));
		 }}
		 if (WeekDay=="6") {
			 String query="SELECT * FROM food WHERE workdays=1";
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
				 System.out.println("the chefs' names are: "+rs.getString("chef"));
			 System.out.println("These are the dishes you can book "+rs.getString("dishes"));
		 }}
		 if (WeekDay=="7") {
			 String query="SELECT * FROM food WHERE workdays=2";
			 ResultSet rs;
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
		     System.out.println("the chefs' names are: "+rs.getString("chef"));
			 System.out.println("These are the dishes you can book "+rs.getString("dishes"));
		 }}
		 System.out.println("What do you want to eat?");
		 String a = input.next();
		 System.out.println("your order have been recorded, have a nice day!");
	 }

	}
	
	 
	 
	
	  
	  
	  
    



