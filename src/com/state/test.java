package com.state;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char mat[][]= { {'B', 'N', 'E', 'Y', 'S'},
                {'H', 'E', 'D', 'E', 'S'},
                {'S', 'G', 'N', 'D', 'E'}};
		String word="Des";
		

	}
	int wordcount(char[][] board,String word) {
		int count=0;
		//check or
		for(int i=0;i<board.length;i++) {
			String s="";
			
			for(int j=0;j<board[i].length;j++) {
				 s=s+board[i][j];
			}
			if(s.contains(word)) {
				count++;
			}
			
		}
		
		int row=board.length;
		int col=board[0].length;
		for(int i=0;i<col;i++) {
			String s="";
			
			for(int j=0;j<row;j++) {
				 s=s+board[j][i];
			}
			if(s.contains(word)) {
				count++;
			}
			
		}
		return count;
		
		
	}

}
