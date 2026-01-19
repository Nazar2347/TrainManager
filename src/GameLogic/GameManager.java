package GameLogic;
import GameLogic.GameStates.GS_Assemble;
import GameLogic.GameStates.GS_Menu;
import GameLogic.GameStates.GameState;

public class GameManager {

    private GameState currentState;
    private boolean isRunning;
    private Player player;
    public GameManager(Player player)
    {
        currentState = new GS_Menu(this);  
        this.player = player;
        isRunning = true;
    };
    public void SetState(GameState newState)
    {
        currentState = newState;
    };
    public void LoadMission()
    {

    };
    public void LoadPlayerData(String filePath)
    {
        //TODO:: Load Player Data from file
        FileReaderUtils fileReader = new FileReaderUtils();
        player = fileReader.LoadPlayer(filePath);
        player.AddLocomotiveSetToInventory(fileReader.GetLocomotive(filePath));
        player.AddWagonSetToInventory(fileReader.LoadWagon(filePath));

    };
    public void UpdatePlayerData()
    {

    };
    public void ReceiveInput()
    {
        currentState.processInput();
    };
    public void Update()
    {
        currentState.update();
    };
    public void Render()
    {
        currentState.render();
    };
    public void setRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }
    public boolean isRunning()
    {
        return isRunning;
    }
    public Player getPlayer()
    {
        return player;
    }
}
