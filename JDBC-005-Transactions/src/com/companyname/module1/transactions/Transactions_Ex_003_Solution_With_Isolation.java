/*
 *	Lets see the solution 
 *
 * 	Step 1 :- Set the auto commit to false  
 *  Step 2 :- commit when transaction is completed .
 *  Step 3 :- roll back  when transaction is failed  .
 */

package com.companyname.module1.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions_Ex_003_Solution_With_Isolation {

	public static void main(String[] args) {
		Connection connection = DBUtil.getConnection(); 
		
		try (Statement createStatement = connection.createStatement(); ){
			
			/*
			 * Solution for the isolation .Set based on requirement 
			 */
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			
			// Step 1 :- Set the auto commit to false 
			connection.setAutoCommit(false);
			
			
			PreparedStatement prepareStatement= null;
			int existingBalance=0;
			int moneyTobeTransfered =1000;
			
			/* Debt Account code  Start */
			
			String selectSQL = "SELECT * FROM WELLS_FAR_GO_ACCOUNTS WHERE ACCOUNT_NO=?";
			
			
			// Step 1 :- Get account balance from John account;
			prepareStatement = connection.prepareStatement(selectSQL);
			
			prepareStatement.setInt(1, 100); // 
			
			 ResultSet executeQueryResult = prepareStatement.executeQuery();
			
			// For the first record execution it takes :- Query -> Parse -> Optimize -> compile -> execute -> result
			

				while(executeQueryResult.next()){
					
					System.out.println("ACCOUNT_NO :- "+executeQueryResult.getInt("ACCOUNT_NO"));
					System.out.println("NAME :- "+executeQueryResult.getString("NAME"));
					existingBalance = executeQueryResult.getInt("BALANCE");
					System.out.println("BALANCE :- "+existingBalance);
								
				}
			
			System.out.println("Balance Retrived Sucessfully ");		
			
			prepareStatement = connection.prepareStatement(" UPDATE WELLS_FAR_GO_ACCOUNTS SET BALANCE =? WHERE ACCOUNT_NO = ?");
			 
			prepareStatement.setInt(1, existingBalance-moneyTobeTransfered ); // Want to send 
			prepareStatement.setInt(2, 100);
			
			prepareStatement.executeUpdate();		
			
			/* Debt Account code  end */
			
			
			/* Credit account code starts */
			
				selectSQL = "SELECT * FROM WELLS_FAR_GO_ACCOUNTS WHERE ACCOUNT_NO=?";
			
			
			// Step 1 :- Get account balance from John account;
			prepareStatement = connection.prepareStatement(selectSQL);
			
			prepareStatement.setInt(1, 199); //  credit account number is 199 .change to other value for failed case .
			
			/**
			 * if we give the wrong account money is deducted from the john account and .it has to be reverted back 
			 * 
			 */
			 executeQueryResult = prepareStatement.executeQuery();
			
			// For the first record execution it takes :- Query -> Parse -> Optimize -> compile -> execute -> result
			
			 if (!executeQueryResult.isBeforeFirst() ) {    
				    System.out.println("Invalide account number ");
				    throw new SQLException("invalid accoutn number ");
				} 
			 
				while(executeQueryResult.next()){
					
					System.out.println("ACCOUNT_NO :- "+executeQueryResult.getInt("ACCOUNT_NO"));
					System.out.println("NAME :- "+executeQueryResult.getString("NAME"));
					existingBalance = executeQueryResult.getInt("BALANCE");
					System.out.println("BALANCE :- "+existingBalance);
								
				}
			
			System.out.println("Balance Retrived Sucessfully ");		
			
			prepareStatement = connection.prepareStatement(" UPDATE WELLS_FAR_GO_ACCOUNTS SET BALANCE =? WHERE ACCOUNT_NO = ?");
			 
			prepareStatement.setInt(1, existingBalance+moneyTobeTransfered ); // 
			prepareStatement.setInt(2,199);
			
			prepareStatement.executeUpdate();		
			
			// Step 2 :- commit when transaction is completed .
			connection.commit();

			/* Credit account code ends  */		
			
			
		} catch (SQLException sqlException) {
			try {
				// Step 3 :- roll back  when transaction is failed  .
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sqlException.printStackTrace();
		}
		

	}

}
