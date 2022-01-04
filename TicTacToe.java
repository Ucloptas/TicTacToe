package pkgTicTacToe;
import java.util.*;
/**
 *
 * @author ethan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char board[][] = new char[3][3];
        for(int q = 0;q<3;q++){
            for(int w = 0;w<3;w++){
                board[q][w]='∙';
            }
        } 
        boolean victor = false;
        int odd = 0;
        boolean full=false;
        char move;
        int select;
        int row;
        int col;
        System.out.println("\n\n"+board[0][0]+" "+board[0][1]+" "+board[0][2]+" "+"\n"+board[1][0]+" "+board[1][1]+" "+board[1][2]+" "
                +"\n"+board[2][0]+" "+board[2][1]+" "+board[2][2]);
        while(!victor){
            odd++;
            if(odd%2==0)
                move = 'O';
            else
                move = 'X';
            System.out.println("it is "+move+"'s turn to move. Choose your space, 1-9\n");
            select = scan.nextInt()-1;
            while(select>8||select<0){
                System.out.print("Please input 1-9");
                select = scan.nextInt()-1;
            }
            
            row=select/3;
            col=(select%3);
            while(board[row][col]=='X'||board[row][col]=='O'){
                System.out.print("This space is taken, please choose another space");
                select = scan.nextInt()-1;
                while(select>8||select<0){
                    System.out.print("Please input 1-9");
                    select = scan.nextInt()-1;
            }   
                row=select/3;
                col=(select%3);
            
            }
            board[row][col]=move;
            victor=checkBetter(board,victor, full);
            System.out.println("\n\n\n\n\n");
        }
    }
    public static boolean checkBetter(char board[][], boolean victor, boolean full){
        System.out.println("\n\n"+board[0][0]+" "+board[0][1]+" "+board[0][2]+" "+"\n"+board[1][0]+" "+board[1][1]+" "+board[1][2]+" "
                +"\n"+board[2][0]+" "+board[2][1]+" "+board[2][2]);
        full = true;
        for(int q = 0;q<3;q++){
            for(int w = 0;w<3;w++){
                if(board[w][q]!='X'&&board[w][q]!='O'){
                    full=false;
                }
            } 
        }
        if(!full){
            for(int j = 0;j<3;j++){
                if((board[j][0]==board[j][1])&&board[j][1]!='∙'){
                    System.out.println("caught");
                    if(board[j][1]==board[j][2]){
                            System.out.println("\nthe victor is "+board[j][0]);
                            victor = true;
                            return victor;
                    }
                }
                if((board[0][j]==board[1][j])&&board[1][j]!='∙'){
                    if(board[1][j]==board[2][j]){
                            System.out.println("\nthe victor is "+board[2][j]);
                            victor = true;
                            return victor;
                    }
                }
            }
            if(board[0][0]==board[1][1]&&board[0][0]==board[2][2]&&board[2][2]!='∙'){
                victor = true;
                System.out.println("\nthe victor is "+board[0][0]);
                return victor;
            }
            if(board[0][2]==board[1][1]&&board[0][2]==board[2][0]&&board[2][0]!='∙'){
                victor = true;
                System.out.println("\nthe victor is "+board[2][0]);
                return victor;
            }
                
        }
        else{
            System.out.println("nobody wins - draw");
            victor = true;
            return victor;
        }
        
        
        
        return victor;
        
    }
}

      
