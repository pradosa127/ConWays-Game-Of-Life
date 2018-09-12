package gameOfLife;
import java.util.Scanner;
public class MainGOL {

	public static void main(String[] args) {
		
	try {	
		
		System.out.println("To play the game please press 1 \nTo test the game please press 2");
		Scanner scanner = new Scanner(System.in);
		int gameMode=scanner.nextInt();
		
		if(gameMode==1)
		{
			System.out.print("*********************Welcome to Game Of Life****************************** \n\n");
			System.out.print("Please enter the height of the game board (integer) \n");
			try{
				int rows = scanner.nextInt();
				if(rows==0)
				{
					System.out.print("Board length can not be 0, Please enter a valid row length");
					rows = scanner.nextInt();
				}
				
				System.out.print("Please enter the width of the game board (integer) \n");
				int cols = scanner.nextInt();
				if(cols==0)
				{
					System.out.print("Board width can not be 0, Please enter a valid row width");
					cols = scanner.nextInt();
				}
				
			
				GameBoard gol=new GameBoard(rows,cols);
				
				System.out.print("Press the close button on the window to exit the game\n");
		    	gol.dispaly();
		    	
			}
			catch(Exception e)
			{
				System.out.print("Please enter a valid integer");
			}
			finally
			{
				scanner.close();
			}
		}
		else if(gameMode==2)
		{
			
			System.out.print("*********************Welcome to Game Of Life in Test mode****************************** \n\n");
			System.out.print("Please specify the number of rows of the seed matrix\n");
			int rows = scanner.nextInt();
			if(rows==0)
			{
				System.out.print("Matrix length can not be 0, Please enter a valid row length");
				rows = scanner.nextInt();
			}
			
			System.out.print("Please specify the number of column of the seed matrix\n");
			int cols = scanner.nextInt();
			if(cols==0)
			{
				System.out.print("Matrix width can not be 0, Please enter a valid column width\n");
				cols = scanner.nextInt();
			}
			int[][] seed = new int[rows][cols];
			System.out.print("Enter "+rows*cols+" elements(0 or 1) of your seed matrix (one element per line followed by enter key)\n");
			
			
			
			for(int i=0;i<rows;i++)
				for(int j=0;j<cols;j++)
				{
					seed[i][j]=scanner.nextInt();
					if(seed[i][j]!=0 && seed[i][j]!=1)
					{
						System.out.print("matrix elements can not take any value other than 0 or 1\n");
						System.out.print("Game over !! \n");
						System.exit(0);
					};
				}
		
			System.out.print("Please specify the number of iterations of the game\n");
			int num_of_iteration=scanner.nextInt();	
			
			System.out.print("Enter "+rows*cols+" elements(0 or 1) of your expected state matrix (one element per line followed by enter key)\n");
			int [][]expected_state=new int[rows][cols];
	
			for(int i=0;i<rows;i++)
				for(int j=0;j<cols;j++)
				{
					expected_state[i][j]=scanner.nextInt();
				}
				  	
				  	 
		     GameTest gt =new GameTest();
		     if(gt.test_game(seed,num_of_iteration,expected_state ))
		    	 System.out.print("Testcase passed\n"); 
		     else
		    	 System.out.print("Testcase failed\n"); 
				   
		}
		else
		{
			System.out.print("Oops Invalid argument. Please restart the game and provide valid argument\n");
		}
		
	
	}
	catch(Exception e)
	{
		System.out.print("Ooops!! Something went wrong try again... ");
	}
	
	
	}
	
	

}
