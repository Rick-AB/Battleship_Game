
public class Validator {
    private final GridManager mGridManager;
   // private String errorMessage = "";
    
    public Validator(GridManager manager){
        mGridManager = manager;
    }
    
    public boolean validateProximity(String startCoordinates, String endCoordinates, Player player){
        
        String[][] sGrid;
        
        if (player == Player.PlayerOne){
            sGrid = mGridManager.getPlayerOneGrid();
        }else {
            sGrid = mGridManager.getPlayerTwoGrid();
        }
        
        int startPosZero = Integer.parseInt(startCoordinates.split(" ")[0]);
        int startPosOne = Integer.parseInt(startCoordinates.split(" ")[1]);
        int endPosZero = Integer.parseInt(endCoordinates.split(" ")[0]);
        int endPosOne = Integer.parseInt(endCoordinates.split(" ")[1]);
        
        if (startPosZero == endPosZero){
            int start = startPosOne;
            int end = endPosOne;
            if (end < start){
                int temp = start;
                start = end;
                end = temp;
            }
            int constantStart = start;
            int constantEnd = end;
            
            if (constantStart == 1 && constantEnd != 10){
                
                if (sGrid[startPosZero][constantEnd + 1].equals("O ")){
                    Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                    return false;
                }
                
            }else if (constantEnd == 10 && constantStart != 1){
                if (sGrid[startPosZero][constantStart - 1].equals("O ")){
                    Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                    return false;
                }
            }else {
                if ((sGrid[startPosZero][constantEnd + 1].equals("O ") || sGrid[startPosZero][constantStart - 1].equals("O "))){
                    Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                    return false;
                }
            }
            
            for (int i = 1; i < sGrid[0].length; i++){
                for (int j = 1; j < sGrid.length; j++){
                    if (start <= end){
                        if (startPosZero == 1){
                            
                            if (sGrid[startPosZero][start].equals("O ") || sGrid[startPosZero + 1][start].equals("O ")){
                                Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                                return false;
                            }
                            
                        }else if (startPosZero == 10){
                            
                            if (sGrid[startPosZero][start].equals("O ") || sGrid[startPosZero - 1][start].equals("O ")){
                                Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                                return false;
                            }
                            
                        }else {
                            
                            if (sGrid[startPosZero][start].equals("O ") || sGrid[startPosZero - 1][start].equals("O ") || sGrid[startPosZero + 1][start].equals("O ")){
                                Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                                return false;
                            }
                            
                        }
                        
                        start++;
                    }
                }
                
            }
            
        }else if (startPosOne == endPosOne){
            int start = startPosZero;
            int end = endPosZero;
            
            if (end < start){
                int temp = start;
                start = end;
                end = temp;
            }
            
            int constantStart = start;
            int constantEnd = end;
            
            if (constantStart == 1 && constantEnd != 10){
                if (sGrid[constantEnd + 1][startPosOne].equals("O ")){
                    Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                    return false;
                }
                
            }else if (constantEnd == 10 && constantStart != 1){
                if (sGrid[constantStart - 1][startPosOne].equals("O ")){
                    Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                    return false;
                }
            }else {
                if ((sGrid[constantEnd + 1][startPosOne].equals("O ") || sGrid[constantStart - 1][startPosOne].equals("O "))){
                    Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                    return false;
                }
            }
            
            for (int i = 1; i < sGrid[0].length; i++){
                for (int j = 1; j < sGrid.length; j++){
                    if (start <= end){
                        if (startPosOne == 1){
                            
                            if (sGrid[start][startPosOne].equals("O ") || sGrid[start][startPosOne + 1].equals("O ")){
                                Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                                return false;
                            }
                            
                        }else if (startPosOne == 10){
                            
                            if (sGrid[start][startPosOne].equals("O ") || sGrid[start][startPosOne - 1].equals("O ")){
                                Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                                return false;
                            }
                            
                        }else {
                            
                            if (sGrid[start][startPosOne].equals("O ") || sGrid[start][startPosOne - 1].equals("O ") || sGrid[start][startPosOne + 1].equals("O ")){
                                Main.errorMessage = "Error! You placed it too close to another one. Try again:";
                                return false;
                            }
                            
                        }
                        start++;
                    }
                }
                
            }
        }
        return true;
    }
    
    public boolean validateCoordinates(String startCoordinate, String endCoordinate, Main.Type type) {
        
        int startPosZero = Integer.parseInt(startCoordinate.split(" ")[0]);
        int startPosOne = Integer.parseInt(startCoordinate.split(" ")[1]);
        int endPosZero = Integer.parseInt(endCoordinate.split(" ")[0]);
        int endPosOne = Integer.parseInt(endCoordinate.split(" ")[1]);
        
        if (startPosOne != endPosOne && startPosZero != endPosZero){
            Main.errorMessage = "Error! Wrong ship location! Try again:";
            return  false;
        }
        
        if (type == Main.Type.AIRCRAFT) {
            int length;
            if (startPosZero == endPosZero) {
                
                length = Math.abs(startPosOne - endPosOne) + 1;
            }else {
                
                length = Math.abs(startPosZero - endPosZero) + 1;
            }
            if (length != Main.AIRCRAFT_LENGTH){
                Main.errorMessage = "Error! Wrong length of the Aircraft Carrier! Try again:";
                return  false;
            }
            
            
        }else if (type == Main.Type.BATTLESHIP){
            int length;
            if (startPosZero == endPosZero) {
                
                length = Math.abs(startPosOne - endPosOne) + 1;
            }else {
                
                length = Math.abs(startPosZero - endPosZero) + 1;
            }
            if (length != Main.BATTLESHIP_LENGTH){
                Main.errorMessage = "Error! Wrong length of the Battleship! Try again:";
                return  false;
            }
            
        }else if (type == Main.Type.SUBMARINE){
            int length;
            if (startPosZero == endPosZero) {
                length = Math.abs(startPosOne - endPosOne) + 1;
            }else {
                length = Math.abs(startPosZero - endPosZero) + 1;
            }
            if (length != Main.SUBMARINE_LENGTH){
                Main.errorMessage = "Error! Wrong length of the Submarine! Try again:";
                return  false;
            }
        }else if (type == Main.Type.CRUISER){
            int length;
            if (startPosZero == endPosZero) {
                
                length = Math.abs(startPosOne - endPosOne) + 1;
            }else {
                
                length = Math.abs(startPosZero - endPosZero) + 1;
            }
            if (length != Main.CRUISER_LENGTH){
                Main.errorMessage = "Error! Wrong length of the Cruiser! Try again:";
                return  false;
            }
        }else if (type == Main.Type.DESTROYER){
            int length;
            if (startPosZero == endPosZero) {
                
                length = Math.abs(startPosOne - endPosOne) + 1;
            }else {
                
                length = Math.abs(startPosZero - endPosZero) + 1;
            }
            if (length != Main.DESTROYER_LENGTH){
                Main.errorMessage = "Error! Wrong length of the Destroyer! Try again:";
                return  false;
            }
        }
        
        return true;
    }
}
