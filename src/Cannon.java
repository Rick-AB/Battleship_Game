public class Cannon {
    private final GridManager mGridManager;
    private String[][] mGrid;
    public Cannon(GridManager manager){
        mGridManager = manager;
    }
    
    public ShotType fire(String coordinate, Player player){
        if (player == Player.PlayerOne){
            mGrid = mGridManager.getPlayerTwoGrid();
        }else if (player == Player.PlayerTwo){
            mGrid = mGridManager.getPlayerOneGrid();
        }
        
        int row = Integer.parseInt(coordinate.split(" ")[0]);
        int column = Integer.parseInt(coordinate.split(" ")[1]);
        
        if (mGrid[row][column].equals("O ")){
            mGridManager.updateGrids(coordinate, true, player);
            return ShotType.NewHit;
        }else if (mGrid[row][column].equals("X ")){
            mGridManager.updateGrids(coordinate, true, player);
            return ShotType.OldHit;
        }else {
            mGridManager.updateGrids(coordinate, false, player);
            return ShotType.Miss;
        }
    }
}
