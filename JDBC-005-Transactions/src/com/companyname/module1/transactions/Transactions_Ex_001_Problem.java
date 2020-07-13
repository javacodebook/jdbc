/*
 *	Lets consider the scenario where John wants to send money to Amit .But John entered wrong account number of amit .
 *
 *  So money is deducted from the John but not deposited into Amit account.
 *  
 *  if we give the wrong account money is deducted from the john account and .it has to be reverted back 
 * 
 */

package com.companyname.module1.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions_Ex_001_Problem {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(); ){
			
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
			
			prepareStatement.setInt(1, 199); //  credit account number is 199
			
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
			prepareStatement.setInt(2,2100);
			
			prepareStatement.executeUpdate();		
			
			

			/* Credit account code ends  */		
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
