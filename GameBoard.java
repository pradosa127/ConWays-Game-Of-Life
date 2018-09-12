package gameOfLife;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;



/**
 * GameBoard class is the main class to initialize the GameOfLife game
 * @author "Pradosa Patnaik"
 * @version 0.1
 *
 */
public class GameBoard extends Canvas{
	private static final long serialVersionUID = 1L;
	
	private int frameSize1; 
	private int frameSize2;

	private BufferedImage image; // Image to show the sates of the game
	private int[] pixels; // Array to hold the reference to the image pixels

	private Random randomGen ; // Random number generator to initialize the game board
	private double generationSpeed = 10.0; //This parameter specifies the speed at which the next states of the game are generated


	
	private int height ; //specify the height of 2D array
	private int width ; //Specify the width of 2D array
	private int[][] current;// 2D array to hold the current state of the game
	private int[][] next;  // 2D array to hold the next state of the game
	
	/**
	 * Constructor to initialize the current state of the GameOfLife grid 
	 * with a given height(height) width(width)
	 * @param height
	 * @param width
	 */
	public GameBoard(int height,int width)
	{		
		
		this.height=height; 
		this.width=width;

		if(height<=10)
			this.frameSize1=100;
		else
			this.frameSize1=height*10;
		if(width<=10)
			this.frameSize2=100;
		else
			this.frameSize2=width*10;
		current=new int[height][width];
		next=new int[height][width];
		randomGen= new Random();
		
		//initializes the current state of the board randomly with 0 or 1 values
		for(int i = 0; i < height; i++)
		{
			for(int j=0;j<width;j++)
			{
				this.current[i][j] = randomGen.nextInt(2);
			}	
		}	
		
		//Initialize the game board with an empty image
		initBoard();
	}
	
	
	
	
	
	/**
	 * Constructor to initialize the Current State of the GameOfLife from a given seed (2D array of 0 and 1s)
	 * @param 2D seed array
	 * 
	 */
	public GameBoard(int[][] seed)
	{
		if(seed==null)
		{System.out.print("Seed matrix can not be null\n");
		 System.exit(0);
		}
		else if(seed.length==0)
		{
			System.out.print("Matrix length can not be 0, Please enter a valid row length");
			System.exit(0);
		}	
		else if(seed[0].length==0)
		{
			System.out.print("Matrix width can not be 0, Please enter a valid column width\n");
			System.exit(0);
		}
		this.height=seed.length;
		this.width=seed[0].length;
		
		if(height<=10)
			this.frameSize1=100;
		else
			this.frameSize1=height*10;
		if(width<=10)
			this.frameSize2=100;
		else
			this.frameSize2=width*10;

		this.current =new int[height][width];
		this.next=new int[height][width];		
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				this.current[i][j]=seed[i][j];
				
			}
			
			
		}
		
		//Initialize the game board with an empty image
		initBoard();
	}	
	
	
	/**
	 * Method to generate the next state of the game from the current sate of the game.
	 * @return return the next sate of the game
	 */
	public int[][] nextGeneration()
	{
		/**
		 * The next sate of the current cell  is decided through the 
		 * decideNextState method and stored in the corresponding cell of the next state
		 */
		System.out.println("");
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
			
				next[i][j]=decideNextState(i,j); 
				
			}
			
		}
		
		/**
		 * after the next sate is generated the next sate is copied to current state ,
		 * so that the next iteration uses the updated sate of the game
		 */
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
					current[i][j]=next[i][j];
			}
			
		}
		
		return next;
				
	}
	
	/**
	 * Method to decide next state of the cell from the current cell value and the 8 surrounding cell values as per the below criteria
	 * Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	 * Any live cell with two or three live neighbours lives on to the next generation.
     * Any live cell with more than three live neighbours dies, as if by over-population.
     * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
     * 
     * Note: As our grid is finite, so the cells on the edge will not have 8 neighbors
     * This sitation can be handled in many different ways but for simplicity we are not doing any special treatment 
     * for the edge cells and the next state is decided based on the number of actual neighbors
     * 
     * @param x (row number of current cell)
     * @param y (column number of current cell)
	 * @return return the next sate of the current cell
	 */
	private int decideNextState(int x, int y) {
		
		int countNeighbors=0;
		for(int i=-1;i<2;i++)
			for(int j=-1;j<2;j++)
			{
				if(x+i>=0 && x+i<height && y+j>=0 && y+j<width && current[x+i][y+j]==1)
					countNeighbors++;
				
			}
		//exclude the current cell value from the neighbor count
		countNeighbors-=current[x][y];
		
		if(current[x][y]==1 && (countNeighbors<2 || countNeighbors>3))
			return 0;
		else if(current[x][y]==0 && countNeighbors==3)
			return 1;
		
		return current[x][y];
	}

	/**
	 * Method to start the game to display on the screen
	 * the play speed depend on the parameter generationSpeed
	 * whose default value is set to 20
	 */
	
	public void start()
	{
		double frameCut = 1000000000.0 / generationSpeed;
		
		long currentTime = System.nanoTime();;
		long previouseTime = currentTime;
		long passedTime = 0;
		
		double unprocessedTime = 0.0;

		int generations = 0;
		
		while(true)
		{
			previouseTime = currentTime;
			currentTime = System.nanoTime();
			passedTime = currentTime - previouseTime;
			
			unprocessedTime += passedTime;
			
			if(unprocessedTime > frameCut)
			{
				unprocessedTime = 0;
				nextGeneration();
				generations++;
				
			}

			
			render();
		}
		
		
	}
	
	


	/**
	 * Method to render the next state of the cell value to the image pixels
	 * to display on screen
	 */
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();

		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
		
		int k=0;
		for(int i = 0; i < height; i++)
			for(int j=0;j<width;j++)
			{
				pixels[k] = next[i][j]==1 ? 0xffffff : 0;
				k++;
			}
        
		g.drawImage(image, 0, 0, frameSize1,frameSize2 , null);
		g.dispose();
		bs.show();
	}
	
	
	
	
	/**
	 * Method to initialize the game board using a image of size height(height) and width(width)
	 */
	public void initBoard()
	{
		Dimension d = new Dimension(frameSize1, frameSize2);
		setMinimumSize(d);
		setMaximumSize(d);
		setPreferredSize(d);
		image = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	}
	
	
	
	/**
	 * Method to display the evolution of cells in the board on the screen as the the game advances
	 */
	
	public void dispaly()
	{
		
		JFrame frame = new JFrame();
		frame.setTitle("Game Of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	    //Call the start method to start the display the evolution of the cell after each iteration
		this.start();
	}
	

	
}

