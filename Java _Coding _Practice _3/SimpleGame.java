import java.util.*;
/* 
 * A simple basic 2 player game of Tic-Tac-Toe with a 3x3 board. 
*/
public class SimpleGame{
    //2-dimensional array for the board
    private char[][] board;
    private int choice, i=0, j=0;
    private char marked = 'O';
    //indication of the player of whoever move
    private String player = "Player 1";
    
    //use to input the number of the array a player wants to put his/her mark
    Scanner sc = new Scanner(System.in);
    //the constructor for the game
    public SimpleGame(){
        board = new char[3][3];
    }
    public void game_instructions(){
        System.out.println("TIC" + "TAC" + "TOE");
        System.out.println("Player1 is assigned as 'X'\nPlayer2 is assigned as 'O'");
        System.out.println("Select a cell number from 1-9 in which you want to move.");
        System.out.println("The first to make a line(diagonal, horizontal, vertical) of X's or O's will be the winner.");
    }
    //initializes the board into blank spaces
    public void board_initialize(){
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                board[i][j] = ' ';
            }
        }
    }
    
    public void display_board(){
        System.out.println("\t\t\t| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | ");
        System.out.println("\t\t\t-------------");
        System.out.println("\t\t\t| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | ");
        System.out.println("\t\t\t-------------");
        System.out.println("\t\t\t| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | ");
    }
     
    public char mark_change(){
        if(marked=='X'){
            marked='O';
        }else{
            marked = 'X';
        }
        return marked;
    }
    
    public void player_change(){
        if(player.equals("Player 1")){
            System.out.println("PLAYER 1 <choice>: ");
            player = "Player 2";
        }else{
            System.out.println("PLAYER 2 <choice>: ");
            player = "Player 1";
        }
    }
    
    public void player_move(){
        choice = sc.nextInt();
        if(choice==1){
            if(board[0][0]==' '){
                board[0][0] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }else if(choice==2){
            if(board[0][1]==' '){
                board[0][1] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }else if(choice==3){
            if(board[0][2]==' '){
                board[0][2] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }else if(choice==4){
            if(board[1][0]==' '){
                board[1][0] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }else if(choice==5){
            if(board[1][1]==' '){
                board[1][1] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }else if(choice==6){
            if(board[1][2]==' '){
                board[1][2] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }else if(choice==7){
            if(board[2][0]==' '){
                board[2][0] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }else if(choice==8){
            if(board[2][1]==' '){
                board[2][1] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }else if(choice==9){
            if(board[2][2]==' '){
                board[2][2] = mark_change();
                display_board();
            }else{
                System.out.println("Invalid move!");
                player_move();
            }
        }
    }
    
    /*is use to identify if the game is a draw or not
     * true means the board is full
     * false means otherwise
    */
    public boolean full_board(){
        boolean full = true;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(board[i][j]==' '){
                    full=false;
                }
            }
        }
        return full;
    }
    
    //check if there 3 same character diagonally, horizontally, or vertically
    public char winner(){
        for(i=0;i<3;i++)
            {
                //rows
                if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][2]==board[i][0]){
                    return board[i][0];
                }
                //columns
                else if(board[0][i]==board[1][i] && board[1][i]==board[2][i] && board[2][i]==board[0][i]){
                    return board[0][i];
                }
                //diagonal
                else if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[2][2]==board[0][0]){
                    return board[0][0];
                }else if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[2][0]==board[0][2]){
                    return board[0][2];
                }
            }
         return ' ';
    }
    
    //main class
    public static void main(String[] args){
        //object for the class
        SimpleGame st = new SimpleGame();
            
        char winmove=' ';
        st.game_instructions();
        st.board_initialize();
        do{
            st.player_change();
            st.player_move();
            winmove = st.winner();
            if(st.full_board()==true){
                break;
            }
        }while(winmove== ' ');
            
        //identify who is the winner
        if(winmove == 'X'){
            System.out.println("PLAYER 1 WINS!");
        }else if(winmove == 'O'){
            System.out.println("PLAYER 2 WINS!");
        }else{
            System.out.println("DRAW GAME!");
        }
    }
}