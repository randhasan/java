import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Rand Hasan
 * StockTransaction.java
 * Program that prints a summary of the purchase and sale of stock after receiving
 * input for the number of shares originally purchased, price paid for the stock,
 * number of shares sold and price the shares were sold for.
 */

public class StockTransaction {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		final double COMMISSION_RATE = .02;
		
		try
		{
			
			System.out.print("Enter number of shares purchased: ");
			double sharesPurchased = input.nextDouble();
			System.out.print("Enter share purchase price: ");
			double purchasePrice = input.nextDouble();
			System.out.print("Enter number of shares sold: ");
			double sharesSold = input.nextDouble();
			System.out.print("Enter share selling price: ");
			double sellingPrice = input.nextDouble();
			
			System.out.println("\nPurchase Summary:");
			System.out.format("%,.0f shares at $%,.2f per share: $%,.2f \n", sharesPurchased, purchasePrice, sharesPurchased*purchasePrice);
			double purchaseCommission = COMMISSION_RATE*(sharesPurchased*purchasePrice);
			System.out.format("Commission on purchase: $%,.2f \n", purchaseCommission);
			double purchaseCost = purchaseCommission+(sharesPurchased*purchasePrice);
			System.out.format("Total purchase cost: $%,.2f \n", purchaseCost);
			
			System.out.println("\nSale Summary:");
			System.out.format("%,.0f shares at $%,.2f per share: $%,.2f \n", sharesSold, sellingPrice, sharesSold*sellingPrice);
			double saleCommission = COMMISSION_RATE*(sharesSold*sellingPrice);
			System.out.format("Commission on sale: $%,.2f \n", saleCommission);
			double sellingFundsReceived = (sharesSold*sellingPrice)- saleCommission;
			System.out.format("Total selling funds received: $%,.2f \n", sellingFundsReceived);			
			
			System.out.println("\nComparative Purchase Summary:");
			System.out.format("%,.0f shares at $%,.2f per share: $%,.2f \n", sharesSold, purchasePrice, sharesSold*purchasePrice);
			double compPurchaseCommission = COMMISSION_RATE*(sharesSold*purchasePrice);
			System.out.format("Commission on sale: $%.2f \n", compPurchaseCommission);
			double compPurchaseCost = compPurchaseCommission + (sharesSold*purchasePrice);
			System.out.format("Total comparative purchase cost: $%,.2f \n", compPurchaseCost);
			
			System.out.format("\nProfit or Loss: $%,.2f", sellingFundsReceived-compPurchaseCost);
					
		}
		
		catch(InputMismatchException ex)
		{
			System.out.println("Please enter a valid number.");
		}
		
	}

}

/**
Purchase Summary:
1,000 shares at $30.00 per share: $30,000.00 
Commission on purchase: $600.00 
Total purchase cost: $30,600.00 

Sale Summary:
600 shares at $29.50 per share: $17,700.00 
Commission on sale: $354.00 
Total selling funds received: $17,346.00 

Comparative Purchase Summary:
600 shares at $30.00 per share: $18,000.00 
Commission on sale: $360.00 
Total comparative purchase cost: $18,360.00 

Profit or Loss: $-1,014.00
 */
