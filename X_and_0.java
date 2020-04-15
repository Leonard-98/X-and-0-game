import java.util.*;
import java.lang.*;
public class X_and_0{
    
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();
    
    public static void printGameBoard(char [][] boardGame){
        for(char [] row : boardGame){
	       for(char c:row){
	           System.out.print(c);
	       }
	       System.out.println();
        }
    }
    public static void placePiece(char[][] boardGame,int pos,String user){
       char symbol =' ';
       
       if(user.equals("player")) {
           symbol='X';
           playerPositions.add(pos);
       }
       else if(user.equals("cpu")) {
           symbol='0'; 
           cpuPositions.add(pos);
       }
       
       switch(pos){
	       case 1:
	           boardGame[0][0]=symbol;
	           break;
	       case 2:
	           boardGame[0][2]=symbol;
	           break;
	       case 3:
	           boardGame[0][4]=symbol;
	           break;
	       case 4:
	           boardGame[2][0]=symbol;
	           break;
	       case 5:
	           boardGame[2][2]=symbol;
	           break;
	       case 6:
	           boardGame[2][4]=symbol;
	           break;
	       case 7:
	           boardGame[4][0]=symbol;
	           break;
	       case 8:
	           boardGame[4][2]=symbol;
	           break;
	       case 9:
	           boardGame[4][4]=symbol;
	           break;
	       default:
	            break;
	   } 
    }
    
    public static void checkWinner(){
        
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);
        
        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
        
        for(List l:winning){
            if(playerPositions.containsAll(l)){
                System.out.println("Felicitari, ai castigat!");
                System.exit(0);
            }else if(cpuPositions.containsAll(l)){
                System.out.println("Ai pierdut!");
                System.exit(0);
            }else if(playerPositions.size() + cpuPositions.size()==9){
                System.out.println("Este egalitate!");
                System.exit(0);
            }
        }
    }
	public static void main(String[] args) {
	   
	   char [][] boardGame={{' ','|',' ','|',' '},
	            {'-','+','-','+','-'},
	            {' ','|',' ','|',' '},
	            {'-','+','-','+','-'},
	            {' ','|',' ','|',' '}};
	  
	  while(true){
	   Scanner scan= new Scanner (System.in); 
	   System.out.println("Alege un numar intre 1 si 9 :");
	   int playerPos = scan.nextInt();
	   while(playerPositions.contains(playerPos)||cpuPositions.contains(playerPos)){
	       System.out.println("Pozitia e luata. Alege alta pozitie:");
	       playerPos = scan.nextInt();
	   }
	   placePiece(boardGame,playerPos,"player");
	   
	   Random rand = new Random();
	   int cpuPos = rand.nextInt(9)+1;
	   while(playerPositions.contains(cpuPos)||cpuPositions.contains(cpuPos)){
	       cpuPos = rand.nextInt(9)+1;
	   }
	   
	   placePiece(boardGame,cpuPos,"cpu");
	   printGameBoard(boardGame);
	   checkWinner();
	  }
	}
}

