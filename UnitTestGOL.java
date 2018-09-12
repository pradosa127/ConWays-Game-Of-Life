/*package gameOfLife;

import static org.junit.Assert.*;

import org.junit.Test;*/



/**
 * @author pradosa
 *
 */
/*public class UnitTestGOL {


		@Test
	public void testNullSeed() {
		int[][] seed=null;
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[5][5];
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	@Test
	public void testEmptySeed() {
		int[][] seed=new int[0][0];
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[5][5];
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	@Test
	public void testSeedWith1Element0() {
		int[][] seed=new int[][]{{0}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[][] {{0}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	@Test
	public void testSeedWith1Element1() {
		int[][] seed=new int[][]{{1}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[][] {{0}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	@Test
	public void testSeedWith1Row() {
		int[][] seed=new int[][]{{1,0,0,1,1,1,0}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[][]{{0,0,0,0,1,0,0}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	
	@Test
	public void testSeedWith1Column() {
		int[][] seed=new int[][]{{1},{0},{0},{1},{1},{1},{0}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[][]{{0},{0},{0},{0},{1},{0},{0}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	
	@Test
	public void testSeedWithSquareMatrix() {
		int[][] seed=new int[][]{{1,0,0,1,1,1},
			 {0,1,0,0,1,0}
			,{1,1,0,0,1,0}
			,{0,1,0,0,1,0}
			,{1,0,0,1,0,1},
			 {1,0,0,1,1,1}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[][]{{0,0,0,1,1,1},
			{0,1,1,0,0,0}
			,{1,1,1,1,1,1}
			,{0,1,1,1,1,1}
			,{1,1,1,1,0,1},
			{0,0,0,1,0,1}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	@Test
	public void testSeedWithSquareMatrix2() {
		int[][] seed=new int[][]{{1,0,0,1,1,1},
			 {0,1,0,0,1,0}
			,{1,1,0,0,1,0}
			,{0,1,0,0,1,0}
			,{1,0,0,1,0,1},
			 {1,0,0,1,1,1}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=2;
		int[][] expected_state=new int[][]{{0,0,1,1,1,0},
			{1,0,0,0,0,0}
			,{1,0,0,0,0,1}
			,{0,0,0,0,0,0}
			,{1,0,0,0,0,1},
			{0,1,0,1,0,0}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	@Test
	public void testSeedWithRectangularMatrix2() {
		int[][] seed=new int[][]{{1,0,0,1,1,1},
			 {0,1,0,0,1,0}
			,{1,1,0,0,1,0}
			,{0,1,0,0,1,0}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[][]{{0,0,0,1,1,1},
											 {0,1,1,0,0,0}
											,{1,1,1,1,1,1}
											,{1,1,0,0,0,0}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	@Test
	public void testSeedWithAllZeroMatrix() {
		int[][] seed=new int[][]{{0,0,0,0,0,0},
			 {0,0,0,0,0,0}
			,{0,0,0,0,0,0}
			,{0,0,0,0,0,0}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=2;
		int[][] expected_state=new int[][]{{0,0,0,0,0,0},
			 {0,0,0,0,0,0}
			,{0,0,0,0,0,0}
			,{0,0,0,0,0,0}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	
	@Test
	public void testSeedWithAllOneMatrix() {
		int[][] seed=new int[][]{{1,1,1,1},
								 {1,1,1,1}
								,{1,1,1,1}
								,{1,1,1,1}};
		GameBoard gb=new GameBoard(seed);
		int num_of_iteration=1;
		int[][] expected_state=new int[][]{{1,0,0,1},
			 {0,0,0,0}
			,{0,0,0,0}
			,{1,0,0,1}};
		   int[][] res = null;
		   for(int i=0;i<num_of_iteration;i++)
		   {
			   res=gb.nextGeneration();

		   }
		   
		   assertTrue(compare(res,expected_state));
		   
	   }
	
	public boolean compare(int[][] result,int[][] expected_state)
	{
		for(int k=0;k<result.length;k++)
		{
			for(int j=0;j<result[0].length;j++)
			{
					if(result[k][j]!=expected_state[k][j])
						return false;
					
			}
			
		}
		
		return true;
	}


}
*/