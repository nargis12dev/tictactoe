package tictactoe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class tictaetoe {
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[]args) {
    	
    	char[][] gameboard = {
    			{' ', '|', ' ', '|', ' '},
    			{'-', '+', '-', '+', '-'},
    			{' ', '|', ' ', '|', ' '},
    			{'-', '+', '-', '+', '-'},
    			{' ', '|', ' ', '|', ' '}
    			};
    	printGameBoard(gameboard);
    	while(true) {
    		Scanner scan=new Scanner(System.in);
    	System.out.println("print numbers from (1-9):");
    	int playerPos = scan.nextInt();
    	while(playerPositions.contains(playerPositions) || cpuPositions.contains(playerPositions)) {
    		playerPos=scan.nextInt();
    	}
    	placepiece(gameboard,playerPos,"player");
    	String  result=checkWinner();
    	 if(result.length()>0) {
    		 System.out.println(result);
    		 break;
    	 }
    	Random rand=new Random();
    	int cpuPos=rand.nextInt(9)+1;
    	while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
    		cpuPos=rand.nextInt(9)+1;
    	}
    	placepiece(gameboard,cpuPos,"cpu");
    	printGameBoard(gameboard);
    	  result=checkWinner();
    	 if(result.length()>0) {
    		 System.out.println(result);
    		 break;
    	 }

    	}
}
  public static void printGameBoard(char[][] gameboard) {
	  for (char[] row:gameboard) {
		    for (char c: row) {
		    	System.out.print(c);
		    }
		    System.out.println();
		    	}
		    }
  public static void placepiece(char[][] gameboard,int pos,String user) {
    char symbol=' ';
	 if(user.equals("player")){
		  symbol='X';
		  playerPositions.add(pos);
	  }else if(user.equals("cpu")){
		  symbol='O';
		  cpuPositions.add(pos);
	  }
	  switch(pos) {
	   case 1:
		  gameboard[0][0]=symbol;
		  break;
	   case 2:
		  gameboard[0][2]=symbol;
		  break;
	   case 3:
		  gameboard[0][4]=symbol;
		  break;
	   case 4:
		  gameboard[2][0]=symbol;
		  break;
	   case 5:
		  gameboard[2][2]=symbol;
		  break;
	   case 6:
		  gameboard[2][4]=symbol;
		  break;
	   case 7:
		  gameboard[4][0]=symbol;
		  break;
	   case 8:
		  gameboard[4][2]=symbol;
		  break;
	   case 9:
		  gameboard[4][4]=symbol;
		  break;
		  default:
			  break;  
        }
     }
  public static String checkWinner() {
	  List topRow = Arrays.asList(1, 2, 3);
	  List midRow = Arrays.asList(4, 5, 6);
	  List bottomRow = Arrays.asList(7, 8, 9);
	  List leftCol = Arrays.asList(1, 4, 7);
	  List midCol = Arrays.asList(2, 5, 8);
	  List rightCol = Arrays.asList(3, 6, 9);
	  List cross1 = Arrays.asList(1, 5, 9);
	  List cross2 = Arrays.asList(7, 5, 3);
	  List<List> winning = new ArrayList<List>();
	  winning.add(topRow);
	  winning.add(midRow);
	  winning.add(bottomRow);
	  winning.add(leftCol);
	  winning.add(midCol);
	  winning.add(rightCol);
	  winning.add(cross1);
	  winning.add(cross2);
	  for (List l:winning) {
		  if(playerPositions.containsAll(l)) {
			  return"congratulations you won!";
		  }else if(cpuPositions.contains(l)) {
			  return"cpu wins!sorry:(";
	  } else if (playerPositions.size()+cpuPositions.size()==9){
			  return"TIE!";
	  }
  }
	  return "";
     }
   }
   
  