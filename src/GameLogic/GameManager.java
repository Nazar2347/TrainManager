package GameLogic;
import GameLogic.GameStates.GS_Assemble;
import GameLogic.GameStates.GS_Menu;
import GameLogic.GameStates.GameState;

public class GameManager {

    private GameState currentState;
    private boolean isRunning;
    public GameManager()
    {
        currentState = new GS_Menu(this);  
        isRunning = true;
    };
    public void SetState(GameState newState)
    {
        currentState = newState;
    };
    public void LoadMission()
    {

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
}
