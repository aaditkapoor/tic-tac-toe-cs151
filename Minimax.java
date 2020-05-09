import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * A rough implementation of the Minimax Algorithm on the Tic Tac Toe project.
 * The system can use the DataModel Class. 
 */

public class Minimax {
	private DataModel model;
    private Integer[][] data; // 0 is X,1 is O
    
    
	List<Map<Integer, Integer>> states = new ArrayList<Map<Integer, Integer>>();

    
    int playerMove = 0; // X
    int computerMove = 1; // O
    
    public boolean isGameOver() {
    	return (XWin() || OWin() || states.isEmpty());
    }
    
    public boolean XWin() {
    	if ((data[0][0] == data[1][1] && data[0][0] == data[2][2]  && data[0][0]  == 0) || (
    			data[0][2] == data[1][1] && data[0][2] == data[2][0] && data[0][2] == 0)) {
    		return true; // X Wins (X=0)
    	}
    	
    	for (int i = 0; i < 3; i++) {
    		 if (((data[i][0] == data[i][1] && data[i][0] == data[i][2] && data[i][0] == 0)
                     || (data[0][i] == data[1][i] && data[0][i] == data[2][i] && data[0][i] == 0))) {
    			 return true;
    		 }
    	}
    	
    	return false;
    	
    }
    
    public boolean OWin() {
    	if ((data[0][0] == data[1][1] && data[0][0] == data[2][2]  && data[0][0]  == 1) || (
    			data[0][2] == data[1][1] && data[0][2] == data[2][0] && data[0][2] == 1)) {
    		return true; // O Wins (X=1)
    	}
    	
    	for (int i = 0; i < 3; i++) {
    		 if (((data[i][0] == data[i][1] && data[i][0] == data[i][2] && data[i][0] == 1)
                     || (data[0][i] == data[1][i] && data[0][i] == data[2][i] && data[0][i] == 1))) {
    			 return true;
    		 }
    	}
    	
    	return false;
    	
    	
    }
    
    public void putMove(Map<Integer, Integer> map, int move) {
    	int i = (int) map.keySet().toArray()[0];
    	int j = (int) map.values().toArray()[0];

    	data[i][j] = move; // 0 for x, 1 for O
    }
    
    public int minimax(Integer[][]data) {
    	List<Map<Integer, Integer>> available = getStates();
    	List<Map<Integer, Integer>> moves = new ArrayList<Map<Integer, Integer>>();
    	
    	int aiCount = 0;
    	int score = 0;
    	int humanCount = 0;
    	
    	
    	// AI Win
    	if (OWin()) {
    		score =  10;
    	}
    	else if (XWin()) {
    		score =  -10;
    	}
    	else if (available.isEmpty()) {
    		score =  0; // Board is empty
    	}
    	
    	for (int i = 0; i < available.size(); i++) {
    		
    	}
    	
    	for (int i = 0; i<data.length; i++) {
    		for (int j = 0; j<data[i].length; j++) {
    			if (data[i][j] == 1) {
    				aiCount+=1; // AS 1 Is A.I
    			}
    			else {
    				humanCount+=1; // AS 0 IS Human
    			}
    		}
    	}
    	
    	if (humanCount > aiCount) {
    		score = -1;
    	}
    	else {
    		score = 1;
    	}
    	
    	for (Map<Integer, Integer> map: available) {
    		int i = (int) map.keySet().toArray()[0];
        	int j = (int) map.values().toArray()[0];
        	
        	data[i][j] = humanCount > aiCount ? 0 : 1;
        	int current = minimax(data);
        	data[i][j] = -1; // put blank here.
        	if (humanCount > aiCount ? current > score : current < score) {
        		score = current;
        	}
    	}
    	return score;
    }
    
    public List<Map<Integer, Integer>> getStates() {
    	for (int i = 0; i<3; i++) {
    		for (int j = 0; j<3;j++) {
    			if (data[i][j] == -1) {
    				states.add(Map.of(i,j));
    			}
    		}
    	}
		return states;
    }
    
	public Minimax(DataModel model) {
		this.model = model;
		
		// default state
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				data[i][j] = -1;
			}
		}
	}	

}
