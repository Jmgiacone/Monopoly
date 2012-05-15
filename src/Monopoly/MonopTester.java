package Monopoly;

/**
 *
 * @author Jordan
 */
public class MonopTester {

    /**
     * @param args the command line arguments
     */
    
    static int[][] board = new int[11][11];
    public static void main(String[] args) 
    {
        boardTest();
        
        System.out.println();
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                if(board[j][i] < 10 && board[j][i] >= 0)
                {
                   System.out.print(" " + board[j][i] + " "); 
                }
                else
                {
                    System.out.print(board[j][i] + " ");
                }
            }
            System.out.println("");
        }

    }
    
    private static void boardTest()
    {
        int x = 10, y = 10;
        for(int i = 39; i >= 0; i--)
        {
            board[x][y] = i;
            if(y == 10 && x > 0)
            {
                x--;
            }
            else if(x == 0 && y > 0)
            {
                y--;
            }
            else if(y == 0 && x < 10)
            {
                x++;
            }
            else if(x == 10 && y < 10)
            {
                y++;
            }
        }
    }
}
