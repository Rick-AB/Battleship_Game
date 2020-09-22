import java.util.Scanner;


enum ShotType{
    NewHit,
    OldHit,
    Miss
}
enum Player{
    PlayerOne,
    PlayerTwo,
    NONE
}
public class Main {
    
    private static GridManager sGridManager;
    private static Validator sValidator;
    private static Cannon sCannon;
    
    enum Type{
        AIRCRAFT,
        BATTLESHIP,
        SUBMARINE,
        CRUISER,
        DESTROYER
    }
    
    private static Scanner sScanner;
    private static Player currentPlayer = Player.PlayerOne;
    private static int PLAYER_ONE_AIRCRAFT_LIFE = 5;
    private static int PLAYER_ONE_BATTLESHIP_LIFE = 4;
    private static int PLAYER_ONE_SUBMARINE_LIFE = 3;
    private static int PLAYER_ONE_CRUISER_LIFE = 3;
    private static int PLAYER_ONE_DESTROYER_LIFE = 2;
    private static int PLAYER_TWO_AIRCRAFT_LIFE = 5;
    private static int PLAYER_TWO_BATTLESHIP_LIFE = 4;
    private static int PLAYER_TWO_SUBMARINE_LIFE = 3;
    private static int PLAYER_TWO_CRUISER_LIFE = 3;
    private static int PLAYER_TWO_DESTROYER_LIFE = 2;
    public static final int AIRCRAFT_LENGTH = 5;
    public static final int BATTLESHIP_LENGTH = 4;
    public static final int CRUISER_LENGTH = 3;
    public static final int SUBMARINE_LENGTH = 3;
    public static final int DESTROYER_LENGTH = 2;
    public static String errorMessage = "";
    
    public static void main(String[] args) {
        sScanner = new Scanner(System.in);
        
        sGridManager = new GridManager();
        sValidator = new Validator(sGridManager);
        sCannon = new Cannon(sGridManager);
        sGridManager.generateGrids();
        positionFleet();
        startGame();
        endGame();
    }
    
    private static void endGame() {
        System.out.println("You sank the last ship. You won. Congratulations!");
    }
    
    private static void startGame() {
        Player winner;
        
        do {
            if (currentPlayer == Player.PlayerOne){
                sGridManager.printPlayerOneBoard();
                printLine();
                System.out.println("Player 1, it's your turn:");
            }else {
                sGridManager.printPlayerTwoBoard();
                printLine();
                System.out.println("Player 2, it's your turn:");
            }
    
            printLine();
            
            String input = sScanner.nextLine();
            String coordinate = convertCoordinates(input);
    
            while (coordinate.equals("")){
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                printLine();
        
                input = sScanner.nextLine();
                coordinate = convertCoordinates(input);
            }
    
            ShotType hit = sCannon.fire(coordinate, currentPlayer);
    
            printLine();
            
            int typeHit = sGridManager.singleShipSunk(coordinate, hit, currentPlayer);
    
            //System.out.println(typeHit);
            winner = sGridManager.allShipsSunk();
            
            if (winner != Player.NONE){
                return;
            }
            
            if (hit == ShotType.NewHit){
                switch (typeHit){
                    case 0:
                        if (currentPlayer == Player.PlayerTwo){
                            PLAYER_ONE_AIRCRAFT_LIFE--;
                            if (PLAYER_ONE_AIRCRAFT_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }else if (currentPlayer == Player.PlayerOne){
                            PLAYER_TWO_AIRCRAFT_LIFE--;
                            if (PLAYER_TWO_AIRCRAFT_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }
                        break;
                        
                    case 1:
                        if (currentPlayer == Player.PlayerTwo){
                            PLAYER_ONE_BATTLESHIP_LIFE--;
                            if (PLAYER_ONE_BATTLESHIP_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }else if (currentPlayer == Player.PlayerOne){
                            PLAYER_TWO_BATTLESHIP_LIFE--;
                            if (PLAYER_TWO_BATTLESHIP_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }
                        break;
                    case 2:
                        if (currentPlayer == Player.PlayerTwo){
                            PLAYER_ONE_SUBMARINE_LIFE--;
                            if (PLAYER_ONE_SUBMARINE_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }else if (currentPlayer == Player.PlayerOne){
                            PLAYER_TWO_SUBMARINE_LIFE--;
                            if (PLAYER_TWO_SUBMARINE_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }
                        break;
                    case 3:
                        if (currentPlayer == Player.PlayerTwo){
                            PLAYER_ONE_CRUISER_LIFE--;
                            if (PLAYER_ONE_CRUISER_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }else if (currentPlayer == Player.PlayerOne){
                            PLAYER_TWO_CRUISER_LIFE--;
                            if (PLAYER_TWO_CRUISER_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }
                        break;
                    case 4:
                        if (currentPlayer == Player.PlayerTwo){
                            PLAYER_ONE_DESTROYER_LIFE--;
                            if (PLAYER_ONE_DESTROYER_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }else if (currentPlayer == Player.PlayerOne){
                            PLAYER_TWO_DESTROYER_LIFE--;
                            if (PLAYER_TWO_DESTROYER_LIFE == 0){
                                System.out.println("You sank a ship!\n" + moveToNextPlayerMessage());
                            }else {
                                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
                            }
                        }
                        break;
                    default:
                        break;
                }
                
            }else if (hit == ShotType.OldHit){
                System.out.println("You hit a ship!\n" + moveToNextPlayerMessage());
            }else {
                System.out.println("You missed!\n" + moveToNextPlayerMessage());
            }
            
            sScanner.nextLine();
            
            if (currentPlayer == Player.PlayerOne){
                currentPlayer = Player.PlayerTwo;
            }else if (currentPlayer == Player.PlayerTwo){
                currentPlayer = Player.PlayerOne;
            }
            
        }while (true);
        
    }private static String moveToNextPlayerMessage(){
        return "Press Enter and pass the move to another player\n...";
    }
    
    private static void positionFleet() {
        for (int i = 0; i <= 1; i++){
            if (currentPlayer == Player.PlayerOne){
                System.out.println("Player 1, place your ships on the game field");
                printLine();
                sGridManager.printPlayerOneHiddenGrid();
            }else {
                System.out.println("Player 2, place your ships on the game field");
                printLine();
                sGridManager.printPlayerTwoHiddenGrid();
            }
            printLine();
    
            positionAircraft(currentPlayer);
            positionBattleship(currentPlayer);
            positionSubmarine(currentPlayer);
            positionCruiser(currentPlayer);
            positionDestroyer(currentPlayer);
            
            currentPlayer = Player.PlayerTwo;
    
            System.out.println(moveToNextPlayerMessage());
            sScanner.nextLine();
            //clearScreen();
        }
        //System.out.println("PASSED!");
        currentPlayer = Player.PlayerOne;
        
    }
    
    private static void positionCruiser(Player currentPlayer) {
        System.out.println("Enter the coordinates of the Cruiser (3 cells):\n");
        boolean validCoordinates;
        boolean validProximity;
    
        String startCoordinate;
        String endCoordinate;
        do {
            String[] coordinates = sScanner.nextLine().split(" ");
            String coordinate1 = coordinates[0];
            String coordinate2 = coordinates[1];
        
            startCoordinate = convertCoordinates(coordinate1);
            endCoordinate = convertCoordinates(coordinate2);
        
            validCoordinates = sValidator.validateCoordinates(startCoordinate,
                    endCoordinate , Type.CRUISER);
            validProximity = sValidator.validateProximity(startCoordinate, endCoordinate, currentPlayer);
        
            if (!validCoordinates || !validProximity){
                System.out.println(errorMessage + "\n");
            }
        
        }while (!validCoordinates || !validProximity);
        
        printLine();
        sGridManager.positionShip(startCoordinate, endCoordinate, Type.CRUISER, currentPlayer);
        
    }
    
    private static void positionDestroyer(Player currentPlayer) {
        System.out.println("Enter the coordinates of the Destroyer (2 cells):\n");
        boolean validCoordinates;
        boolean validProximity;
    
        String startCoordinate;
        String endCoordinate;
        do {
            String[] coordinates = sScanner.nextLine().split(" ");
            String coordinate1 = coordinates[0];
            String coordinate2 = coordinates[1];
        
            startCoordinate = convertCoordinates(coordinate1);
            endCoordinate = convertCoordinates(coordinate2);
        
            validCoordinates = sValidator.validateCoordinates(startCoordinate,
                    endCoordinate , Type.DESTROYER);
            validProximity = sValidator.validateProximity(startCoordinate, endCoordinate, currentPlayer);
        
            if (!validCoordinates || !validProximity){
                System.out.println(errorMessage + "\n");
            }
        
        }while (!validCoordinates || !validProximity);
        
        printLine();
        sGridManager.positionShip(startCoordinate, endCoordinate, Type.DESTROYER, currentPlayer);
        
    }
    
    private static void positionSubmarine(Player currentPlayer) {
        System.out.println("Enter the coordinates of the Submarine (3 cells):\n");
        boolean validCoordinates;
        boolean validProximity;
    
        String startCoordinate;
        String endCoordinate;
        do {
            String[] coordinates = sScanner.nextLine().split(" ");
            String coordinate1 = coordinates[0];
            String coordinate2 = coordinates[1];
        
            startCoordinate = convertCoordinates(coordinate1);
            endCoordinate = convertCoordinates(coordinate2);
        
            validCoordinates = sValidator.validateCoordinates(startCoordinate,
                    endCoordinate , Type.SUBMARINE);
            validProximity = sValidator.validateProximity(startCoordinate, endCoordinate, currentPlayer);
        
            if (!validCoordinates || !validProximity){
                System.out.println(errorMessage + "\n");
            }
        
        }while (!validCoordinates || !validProximity);
        
        printLine();
        sGridManager.positionShip(startCoordinate, endCoordinate, Type.SUBMARINE, currentPlayer);
        
    }
    
    private static void positionAircraft(Player currentPlayer){
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):\n");
        boolean validCoordinates;
        boolean validProximity;
    
        String startCoordinate;
        String endCoordinate;
        do {
            String[] coordinates = sScanner.nextLine().split(" ");
            String coordinate1 = coordinates[0];
            String coordinate2 = coordinates[1];
        
            startCoordinate = convertCoordinates(coordinate1);
            endCoordinate = convertCoordinates(coordinate2);
        
            validCoordinates = sValidator.validateCoordinates(startCoordinate,
                    endCoordinate , Type.AIRCRAFT);
            validProximity = sValidator.validateProximity(startCoordinate, endCoordinate, currentPlayer);
        
            if (!validCoordinates || !validProximity){
                System.out.println(errorMessage + "\n");
            }
        
        }while (!validCoordinates || !validProximity);
        
        printLine();
        sGridManager.positionShip(startCoordinate, endCoordinate, Type.AIRCRAFT, currentPlayer);
        
    }
    
    private static void positionBattleship(Player currentPlayer){
        System.out.println("Enter the coordinates of the Battleship (4 cells):\n");
        boolean validCoordinates;
        boolean validProximity;
    
        String startCoordinate;
        String endCoordinate;
        do {
            String[] coordinates = sScanner.nextLine().split(" ");
            String coordinate1 = coordinates[0];
            String coordinate2 = coordinates[1];
        
            startCoordinate = convertCoordinates(coordinate1);
            endCoordinate = convertCoordinates(coordinate2);
        
            validCoordinates = sValidator.validateCoordinates(startCoordinate,
                    endCoordinate , Type.BATTLESHIP);
            validProximity = sValidator.validateProximity(startCoordinate, endCoordinate, currentPlayer);
        
            if (!validCoordinates || !validProximity){
                System.out.println(errorMessage + "\n");
            }
        
        }while (!validCoordinates || !validProximity);
    
        printLine();
        sGridManager.positionShip(startCoordinate, endCoordinate, Type.BATTLESHIP, currentPlayer);
    }
    
    private static String convertCoordinates(String coordinate){
        
        String firstChar = coordinate.split("")[0];
        String secondChar;
        
        if (coordinate.length() < 3){
           secondChar = coordinate.split("")[1];
        }else {
            secondChar = coordinate.split("")[1] + coordinate.split("")[2];
            if (Integer.parseInt(secondChar) > 10){
                return "";
            }
        }
        
        switch (firstChar){
            case "A":
            case "a":
                return "1 " + secondChar;
            case "B":
            case "b":
                return "2 " + secondChar;
            case "C":
            case "c":
                return "3 " + secondChar;
            case "D":
            case "d":
                return "4 " + secondChar;
            case "E":
            case "e":
                return "5 " + secondChar;
            case "F":
            case "f":
                return "6 " + secondChar;
            case "G":
            case "g":
                return "7 " + secondChar;
            case "H":
            case "h":
                return "8 " + secondChar;
            case "I":
            case "i":
                return "9 " + secondChar;
            case "J":
            case "j":
                return "10 " + secondChar;
            default:
                return "";
        }
    }
    
    private static void printLine(){
        System.out.println();
    }
}
