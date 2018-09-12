package gameOfLife;
import gameOfLife.GameBoard;
public class GameTest {
	
	GameBoard golTest=null;
	
	
	/**
	 * Method to test the implementation
	 */
	

	public boolean test_game(int[][] seed, int num_of_iteration,int[][] expected_state)
	   {
		   this.golTest=new GameBoard(seed);
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=golTest.nextGeneration();

		   }
		   
		   for(int k=0;k<seed.length;k++)
			{
				for(int j=0;j<seed[0].length;j++)
				{
						if(res[k][j]!=expected_state[k][j])
							return false;
				}
			}
		   
		   return true;
	   }

}


