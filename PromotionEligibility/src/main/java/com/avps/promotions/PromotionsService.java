package com.avps.promotions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.rccl.promotions.Promotions;

/***
 * this
 * 
 * class hold all the necessary methods to manage the Promotions information* such
 * as CRUD operations on Promotions data**
 * 
 * @author Lenovo
 **/
public class PromotionsService {

	/**
	 * to get connection from DBUtil class
	 */
	static Connection conn = DBUtil.getConnection();

	/**
	 * Resultset to run the query
	 */

	static ResultSet resultSet = null;
		/**
	 * list Promotions type class object created here
	 */
	static List<Promotions> rows = new ArrayList<Promotions>();

	/**
	 * this method insert the Promotions record into USERS table
	 *
	 * @param Promotions
	 *            - passed Promotions information to be inserted
	 * @throws SQLException
	 *             - when error happens with DB operation or DB
	 */
	public static void createPromotions(Promotions promotions) {

 QueryRunner queryRunner = new QueryRunner();

		String sql = "insert into rcclpromotions(PromotionName, PromotionState, DiscountAmount, MilitaryManStatus, StartDate, EndDate) values(?, ?, ?, ?,?, ?)";
 try {
			queryRunner.update(conn, sql, promotions.getPromotionName(),promotions.getPromotionState(),
					promotions.getDiscountAmount(),  promotions.getMilitaryManStatus(), promotions.getStartDate(), promotions.getEndDate()
					);
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }

		/**
	 * this method used to fetch the Promotions list from database
	 *
	 * @param Promotions
	 *            - to get the registered Promotions information
	 * @return - list type variable rows
	 * @throws SQLException
	 *             - when error occurs with DB operations
	 */
	public static List<Promotions> list(Promotions promotions) throws SQLException {
			try {

			Statement statement = conn.createStatement();
			String querySelect = "select * from rcclpromotions";
			resultSet = statement.executeQuery(querySelect);
			while (resultSet.next()) {
				Promotions rowPromotions = new Promotions();
				rowPromotions.setPromotionName(resultSet.getString("PromotionName"));
				rowPromotions.setPromotionState(resultSet.getString("PromotionState"));
				rowPromotions.setDiscountAmount(resultSet.getInt("DiscountAmount"));
				rowPromotions.setMilitaryManStatus(resultSet.getString("MilitaryManStatus"));
				rowPromotions.setStartDate(resultSet.getDate("StartDate"));
				rowPromotions.setEndDate(resultSet.getDate("EndDate"));
				rows.add(rowPromotions);
			}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return rows;
		}

//	public static Promotions getList(Promotions Promotions) throws SQLException {
//		try {
//
//			Statement statement = conn.createStatement();
//			String querySelect = "select * from Promotionsdetails where email= '" + Promotions.getEmail() + "'";
//			resultSet = statement.executeQuery(querySelect);
//			while (resultSet.next()) {
//				Promotions rowPromotions = new Promotions();
//				rowPromotions.setName(resultSet.getString("name"));
//				rowPromotions.setPreviousDate(resultSet.getDate("PreviousDate"));
//				rowPromotions.setDrivingExperience(resultSet.getInt("DrivingExperience"));
//				rowPromotions.setAge(resultSet.getInt("age"));
//				rowPromotions.setCity(resultSet.getString("city"));
//				rowPromotions.setEmail(resultSet.getString("email"));
//				rows.add(rowPromotions);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return Promotions;
//	}

//	public static Promotions login(Promotions Promotions) {
//
// try {
//String search = "Select * from Promotionsdetails where email= '" + Promotions.getEmail() + "'";
//
// Statement statement = conn.createStatement();
//
// resultSet = statement.executeQuery(search);
// boolean more = resultSet.next();
// // if user exists set the isValid variable to true
//			if (more) {
//				// getString method is used to get the data from database, so need to put column
//				// name according to db
//
//				String email = resultSet.getString("email");
//				String name = resultSet.getString("name");
//				int age = resultSet.getInt("age");
//				String city = resultSet.getString("city");
//				String state = resultSet.getString("state");
//				Date previousDate = resultSet.getDate("previousdate");
//				int experience = resultSet.getInt("drivingexperience");
//
//				System.out.println("Welcome " + resultSet.getString("name"));
//				// Promotions.setValid(true);
//				Promotions.setEmail(email);
//				Promotions.setName(name);
//				Promotions.setAge(age);
//				Promotions.setCity(city);
//				Promotions.setPreviousDate(previousDate);
//				Promotions.setDrivingExperience(experience);
//				Promotions.setState(state);
//				
//			}
//			else if (!more) {
//				System.out.println("Sorry, you are not registered user !");
//				// Promotions.setValid(false);
//			}
//
// }
// catch(Exception e) {
// System.out.println("Log In failed: An Exception has occurred! " + e);
// }
//
// return Promotions;
//
// }

}
