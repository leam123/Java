import java.util.*;

public class TicTacToe{
    private char[][] board;
    private int choice, i=0, j=0;
    private char marked = 'O';
    private String player = "Player 1";
    
    Scanner sc = new Scanner(System.in);
    public TicTacToe(){
        board = new char[3][3];
    }
    public void game_instructions(){
        System.out.println("TIC" + "TAC" + "TOE");
        System.out.println("Player1 is assigned as 'X' ");
        System.out.println("Player2 is assigned as 'O' ");
        System.out.println("Select a cell number from 1-9 in which you want to move.");
        System.out.println("The first to make a line(digaonal, horizontal, vertical) of X's or O's will be the winner.");
    }
    /*public void board_reference(){
        System.out.println("\t\t\tGAME BOARD REFERENCE");
        System.out.println("\t\t\t| 1 " + " | 2 " + " | 3 " + " | ");
        System.out.println("\t\t\t-------------");
        System.out.println("\t\t\t| 4 " + " | 5 " + " | 6 " + " | ");
        System.out.println("\t\t\t-------------");
        System.out.println("\t\t\t| 7 " + " | 8 " + " | 9 " + " | ");
    }*/
    public char mark_change(){
        if(marked=='X'){
            marked='O';
        }else{
            marked = 'X';
        }
        return marked;
    }
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
    public void display_board(){
        System.out.println("\t\t\t| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | ");
        System.out.println("\t\t\t----------");
        System.out.println("\t\t\t| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | ");
        System.out.println("\t\t\t----------");
        System.out.println("\t\t\t| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | ");
    }
    public void board_initialize(){
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                board[i][j] = ' ';
            }
        }
    }
    public char winner(){
        for(i=0;i<3;i++)
            {
                if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][2]==board[i][0]){
                    return board[i][0];
                }else if(board[0][i]==board[1][i] && board[1][i]==board[2][i] && board[2][i]==board[0][i]){
                    return board[0][i];
                }else if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[2][2]==board[0][0]){
                    return board[0][0];
                }else if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[2][0]==board[0][2]){
                    return board[0][2];
                }
            }
         return ' ' ;
    }
        public static void main(String[] args){
            TicTacToe tt = new TicTacToe();
            
            char winmove=' ';
            tt.game_instructions();
            //tt.board_reference();
            tt.board_initialize();
            do{
                tt.player_change();
                tt.player_move();
                //tt.player1_move();
                winmove = tt.winner();
                /*if(winmove== ' '){
                    break;
                }*/
                if(tt.full_board()==true){
                    break;
                }
                /*tt.player2_move();
                winmove=tt.winner();*/
            }while(winmove== ' ');
            
            if(winmove == 'X'){
                System.out.println("PLAYER 1 WINS!");
            }else if(winmove == 'O'){
                System.out.println("PLAYER 2 WINS!");
            }else{
                System.out.println("DRAW GAME!");
            }
        }
        /*public void player1_move(){
        System.out.println("PLAYER1 enter your number: ");
        choice = sc.nextInt();
        if(choice==1){
            if(board[0][0]==' '){
                board[0][0]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }else if(choice==2){
            if(board[0][1]==' '){
                board[0][1]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }else if(choice==3){
            if(board[0][2]==' '){
                board[0][2]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }else if(choice==4){
            if(board[1][0]==' '){
                board[1][0]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }else if(choice==5){
            if(board[1][1]==' '){
                board[1][1]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }else if(choice==6){
            if(board[1][2]==' '){
                board[1][2]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }else if(choice==7){
            if(board[2][0]==' '){
                board[2][0]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }else if(choice==8){
            if(board[2][1]==' '){
                board[2][1]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }else if(choice==9){
            if(board[2][2]==' '){
                board[2][2]='X';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player1_move();
            }
        }
    }
    public void player2_move(){
        System.out.println("PLAYER2 enter your number: ");
        choice = sc.nextInt();
        
        if(choice==1){
            if(board[0][0]==' '){
                board[0][0]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }else if(choice==2){
            if(board[0][1]==' '){
                board[0][1]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }else if(choice==3){
            if(board[0][2]==' '){
                board[0][2]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }else if(choice==4){
            if(board[1][0]==' '){
                board[1][0]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }else if(choice==5){
            if(board[1][1]==' '){
                board[1][1]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }else if(choice==6){
            if(board[1][2]==' '){
                board[1][2]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }else if(choice==7){
            if(board[2][0]==' '){
                board[2][0]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }else if(choice==8){
            if(board[2][1]==' '){
                board[2][1]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }else if(choice==9){
            if(board[2][2]==' '){
                board[2][2]='O';
                display_board();
            }
            else{
                System.out.println("Invalid move!");
                player2_move();
            }
        }
    }*/
}