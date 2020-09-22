public class GridManager {
    private String[] mPlayerOneCoordinates;
    private String[] mPlayerTwoCoordinates;
    private String[][] mPlayerOneGrid;
    private String[][] mPlayerOneHiddenGrid;
    private String[][] mPlayerTwoGrid;
    private String[][] mPlayerTwoHiddenGrid;
    private final int mTotalShipCells;
    
    public GridManager(){
        mPlayerOneCoordinates = new String[5];
        mPlayerTwoCoordinates = new String[5];
        mPlayerOneGrid = new String[11][11];
        mPlayerOneHiddenGrid = new String[11][11];
        mPlayerTwoGrid = new String[11][11];
        mPlayerTwoHiddenGrid = new String[11][11];
        
        mTotalShipCells =
                Main.AIRCRAFT_LENGTH + Main.BATTLESHIP_LENGTH + Main.CRUISER_LENGTH + Main.SUBMARINE_LENGTH + Main.DESTROYER_LENGTH;
        
    }
    
    
    public void generateGrids(){
        generatePlayerOneGrid();
        generatePlayerOneHiddenGrid();
        generatePlayerTwoGrid();
        generatePlayerTwoHiddenGrid();
        
    }
    
    private void generatePlayerTwoHiddenGrid() {
        int asciiValueForAlphabet = 65;
    
        mPlayerTwoHiddenGrid[0][0] = "  ";
    
        for (int i = 1; i < mPlayerTwoHiddenGrid.length; i++){
            char c = (char) asciiValueForAlphabet;
            mPlayerTwoHiddenGrid[i][0] = c + " ";
            asciiValueForAlphabet++;
        }
    
        for (int i = 1; i < mPlayerTwoHiddenGrid[0].length; i++){
            mPlayerTwoHiddenGrid[0][i] = i + " ";
            for (int j = 1; j < mPlayerTwoHiddenGrid.length; j++){
                mPlayerTwoHiddenGrid[i][j] = "~ ";
            }
        }
    }
    
    private void generatePlayerTwoGrid() {
        int asciiValueForAlphabet = 65;
    
        mPlayerTwoGrid[0][0] = "  ";
    
        for (int i = 1; i < mPlayerTwoGrid.length; i++){
            char c = (char) asciiValueForAlphabet;
            mPlayerTwoGrid[i][0] = c + " ";
            asciiValueForAlphabet++;
        }
    
        for (int i = 1; i < mPlayerTwoGrid[0].length; i++){
            mPlayerTwoGrid[0][i] = i + " ";
            for (int j = 1; j < mPlayerTwoGrid.length; j++){
                mPlayerTwoGrid[i][j] = "~ ";
            }
        }
    }
    
    private void generatePlayerOneGrid(){
        int asciiValueForAlphabet = 65;
    
        mPlayerOneGrid[0][0] = "  ";
    
        for (int i = 1; i < mPlayerOneGrid.length; i++){
            char c = (char) asciiValueForAlphabet;
            mPlayerOneGrid[i][0] = c + " ";
            asciiValueForAlphabet++;
        }
    
        for (int i = 1; i < mPlayerOneGrid[0].length; i++){
            mPlayerOneGrid[0][i] = i + " ";
            for (int j = 1; j < mPlayerOneGrid.length; j++){
                mPlayerOneGrid[i][j] = "~ ";
            }
        }
        
    }
    
    private void generatePlayerOneHiddenGrid(){
        int asciiValueForAlphabet = 65;
    
        mPlayerOneHiddenGrid[0][0] = "  ";
    
        for (int i = 1; i < mPlayerOneHiddenGrid.length; i++){
            char c = (char) asciiValueForAlphabet;
            mPlayerOneHiddenGrid[i][0] = c + " ";
            asciiValueForAlphabet++;
        }
    
        for (int i = 1; i < mPlayerOneHiddenGrid[0].length; i++){
            mPlayerOneHiddenGrid[0][i] = i + " ";
            for (int j = 1; j < mPlayerOneHiddenGrid.length; j++){
                mPlayerOneHiddenGrid[i][j] = "~ ";
            }
        }
    }
    
    public void printPlayerTwoGrid(){
        for (int i = 0; i < mPlayerTwoGrid[0].length; i++){
            for (int j = 0; j< mPlayerTwoGrid.length; j++){
                System.out.print(mPlayerTwoGrid[i][j]);
            }
            System.out.println();
        }
    }
    
    public void printPlayerTwoHiddenGrid(){
        for (int i = 0; i < mPlayerTwoHiddenGrid[0].length; i++){
            for (int j = 0; j< mPlayerTwoHiddenGrid.length; j++){
                System.out.print(mPlayerTwoHiddenGrid[i][j]);
            }
            System.out.println();
        }
    }
    
    public void printPlayerOneBoard(){
        printPlayerTwoHiddenGrid();
        System.out.println("---------------------");
        printPlayerOneGrid();
    }
    
    public void printPlayerTwoBoard(){
        printPlayerOneHiddenGrid();
        System.out.println("---------------------");
        printPlayerTwoGrid();
    }
    public void printPlayerOneGrid(){
        for (int i = 0; i < mPlayerOneGrid[0].length; i++){
            for (int j = 0; j< mPlayerOneGrid.length; j++){
                System.out.print(mPlayerOneGrid[i][j]);
            }
            System.out.println();
        }
    }
    
    public void printPlayerOneHiddenGrid(){
        for (int i = 0; i < mPlayerOneHiddenGrid[0].length; i++){
            for (int j = 0; j< mPlayerOneHiddenGrid.length; j++){
                System.out.print(mPlayerOneHiddenGrid[i][j]);
            }
            System.out.println();
        }
    }
    
    public void positionShip(String startCoordinate, String endCoordinate, Main.Type type, Player player){
        
        switch (type){
            case AIRCRAFT:
                if (player == Player.PlayerOne){
                    mPlayerOneCoordinates[0] = startCoordinate + " " +  endCoordinate;
                }else {
                    mPlayerTwoCoordinates[0] = startCoordinate + " " + endCoordinate;
                }
                break;
            case BATTLESHIP:
                if (player == Player.PlayerOne){
                    mPlayerOneCoordinates[1] = startCoordinate + " " +  endCoordinate;
                }else {
                    mPlayerTwoCoordinates[1] = startCoordinate + " " +  endCoordinate;
                }
                break;
            case CRUISER:
                if (player == Player.PlayerOne){
                    mPlayerOneCoordinates[2] = startCoordinate + " " +  endCoordinate;
                }else {
                    mPlayerTwoCoordinates[2] = startCoordinate + " " +  endCoordinate;
                }
                break;
            case SUBMARINE:
                if (player == Player.PlayerOne){
                    mPlayerOneCoordinates[3] = startCoordinate + " " +  endCoordinate;
                }else {
                    mPlayerTwoCoordinates[3] = startCoordinate + " " +  endCoordinate;
                }
                break;
            case DESTROYER:
                if (player == Player.PlayerOne){
                    mPlayerOneCoordinates[4] = startCoordinate + " " +  endCoordinate;
                }else {
                    mPlayerTwoCoordinates[4] = startCoordinate + " " +  endCoordinate;
                }
                break;
            default:
                return;
        }
        
        
        int startPosZero = Integer.parseInt(startCoordinate.split(" ")[0]);
        int startPosOne = Integer.parseInt(startCoordinate.split(" ")[1]);
        int endPosZero = Integer.parseInt(endCoordinate.split(" ")[0]);
        int endPosOne = Integer.parseInt(endCoordinate.split(" ")[1]);
        
        if (player == Player.PlayerOne){
            if (startPosZero == endPosZero){
                int start = startPosOne;
                int end = endPosOne;
        
                if (end < start){
                    int temp = start;
                    start = end;
                    end = temp;
                }
        
                for (int i = 1; i < mPlayerOneGrid[0].length; i++){
                    for (int j = 1; j < mPlayerOneGrid.length; j++){
                        if (i == startPosZero && start <= end) {
                            mPlayerOneGrid[i][start] = "O ";
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
        
                for (int i = 1; i < mPlayerOneGrid[0].length; i++){
                    for (int j = 1; j < mPlayerOneGrid.length; j++){
                        if (j == startPosOne && start <= end) {
                            mPlayerOneGrid[start][j] = "O ";
                        }
                    }
                    start++;
                }
            }
            printPlayerOneGrid();
    
        }else {
            if (startPosZero == endPosZero){
                int start = startPosOne;
                int end = endPosOne;
        
                if (end < start){
                    int temp = start;
                    start = end;
                    end = temp;
                }
        
                for (int i = 1; i < mPlayerTwoGrid[0].length; i++){
                    for (int j = 1; j < mPlayerTwoGrid.length; j++){
                        if (i == startPosZero && start <= end) {
                            mPlayerTwoGrid[i][start] = "O ";
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
        
                for (int i = 1; i < mPlayerTwoGrid[0].length; i++){
                    for (int j = 1; j < mPlayerTwoGrid.length; j++){
                        if (j == startPosOne && start <= end) {
                            mPlayerTwoGrid[start][j] = "O ";
                        }
                    }
                    start++;
                }
            }
            printPlayerTwoGrid();
        }
        System.out.println();
    
    }
    
    public void updateGrids(String coordinates, boolean hit, Player player){
        int row = Integer.parseInt(coordinates.split(" ")[0]);
        int column = Integer.parseInt(coordinates.split(" ")[1]);
        
        if (player == Player.PlayerTwo){
            if (hit){
                mPlayerOneHiddenGrid[row][column] = "X ";
                mPlayerOneGrid[row][column] = "X ";
            }else {
                mPlayerOneHiddenGrid[row][column] = "M ";
                mPlayerOneGrid[row][column] = "M ";
            }
        }else if (player == Player.PlayerOne){
            if (hit){
                mPlayerTwoHiddenGrid[row][column] = "X ";
                mPlayerTwoGrid[row][column] = "X ";
            }else {
                mPlayerTwoHiddenGrid[row][column] = "M ";
                mPlayerTwoGrid[row][column] = "M ";
            }
        }
        
    }
    
    public Player allShipsSunk(){
        int xPlayerOneCells = 0;
        int xPlayerTwoCells = 0;
        
        for (int i = 0; i < mPlayerOneGrid[0].length; i++){
            for (int j = 0; j < mPlayerOneGrid.length; j++){
                if (mPlayerOneGrid[i][j].equals("X ")){
                    xPlayerOneCells++;
                }
            }
        }
    
        for (int i = 0; i < mPlayerTwoGrid[0].length; i++){
            for (int j = 0; j < mPlayerTwoGrid.length; j++){
                if (mPlayerTwoGrid[i][j].equals("X ")){
                    xPlayerTwoCells++;
                }
            }
        }
        
        if (xPlayerOneCells == mTotalShipCells ){
            return Player.PlayerTwo;
        }else if (xPlayerTwoCells == mTotalShipCells){
            return Player.PlayerOne;
        }return Player.NONE;
        
    }
    
    public int singleShipSunk(String lastKnownCoordinate, ShotType hit, Player player){
        int lastKnownRow = Integer.parseInt(lastKnownCoordinate.split(" ")[0]);
        int lastKnownColumn = Integer.parseInt(lastKnownCoordinate.split(" ")[1]);
        
        if (player == Player.PlayerTwo){
            
            if (hit == ShotType.Miss){
                return -1;
                
            }else {
                for (int k = 0; k < mPlayerOneCoordinates.length; k++){
                    int rowStart = Integer.parseInt(mPlayerOneCoordinates[k].split(" ")[0]);
                    int columnStart = Integer.parseInt(mPlayerOneCoordinates[k].split(" ")[1]);
                    int rowEnd = Integer.parseInt(mPlayerOneCoordinates[k].split(" ")[2]);
                    int columnEnd = Integer.parseInt(mPlayerOneCoordinates[k].split(" ")[3]);
            
                    if (columnEnd < columnStart){
                        int temp = columnStart;
                        columnStart = columnEnd;
                        columnEnd = temp;
                
                    }
            
                    if (rowEnd < rowStart){
                        int temp = rowStart;
                        rowStart = rowEnd;
                        rowEnd = temp;
                    }
            
                    for (int i = rowStart; i <= rowEnd; i++){
                        for (int j = columnStart; j <= columnEnd; j++){
                            if (i == lastKnownRow && j == lastKnownColumn){
                                return k;
                            }
                        }
                    }
                }
            }
        }else if (player == Player.PlayerOne){
            
            if (hit == ShotType.Miss){
                return -1;
                
            }else {
                for (int k = 0; k < mPlayerTwoCoordinates.length; k++){
                    int rowStart = Integer.parseInt(mPlayerTwoCoordinates[k].split(" ")[0]);
                    int columnStart = Integer.parseInt(mPlayerTwoCoordinates[k].split(" ")[1]);
                    int rowEnd = Integer.parseInt(mPlayerTwoCoordinates[k].split(" ")[2]);
                    int columnEnd = Integer.parseInt(mPlayerTwoCoordinates[k].split(" ")[3]);
            
                    if (columnEnd < columnStart){
                        int temp = columnStart;
                        columnStart = columnEnd;
                        columnEnd = temp;
                
                    }
            
                    if (rowEnd < rowStart){
                        int temp = rowStart;
                        rowStart = rowEnd;
                        rowEnd = temp;
                    }
            
                    for (int i = rowStart; i <= rowEnd; i++){
                        for (int j = columnStart; j <= columnEnd; j++){
                            if (i == lastKnownRow && j == lastKnownColumn){
                                return k;
                            }
                        }
                    }
                }
            }
        }
        
        
        return -1;
        
    }
    
    
    
    public String[][] getPlayerOneGrid() {
        return mPlayerOneGrid;
    }
    
    public String[][] getPlayerTwoGrid() {
        return mPlayerTwoGrid;
    }
    
}
