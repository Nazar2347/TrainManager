package Render;

public class TrainRender {

    private String trainVisual1 = 
   
        "______________     . . . o o o o o o o           \n"+
        "            ||            _____       o          \n"+
        "            |    _____====  ]DD|_n_n__][.        \n"+
        "____________|_|_[_________]_|__|________)<       \n"+
        "       o!o!o'  ooo   ooo  'oo    OOOOO oo|_      \n"+
        "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";

private String trainVisual2 =
        "______________     . . . o o o o o o o           \n"+
        "            ||            _____       x          \n"+
        "            |    _____====  ]DD|_n_n__][.        \n"+
        "____________|_|_[_________]_|__|________)<       \n"+
        "       o!o!o'  ooo   ooo  'oo    OOOOO oo|_      \n"+
        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";

private String trainVisual3 =
        "______________     . . . o o o o o o x           \n"+
        "            ||            _____       o          \n"+
        "            |    _____====  ]DD|_n_n__][.        \n"+
        "____________|_|_[_________]_|__|________)<       \n"+
        "       o!o!o'  ooo   ooo  'oo    OOOOO oo|_      \n"+
        "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";

private String trainVisual4 =
        "______________     . . . o o o o o x o           \n"+
        "            ||            _____       x          \n"+
        "            |    _____====  ]DD|_n_n__][.        \n"+
        "____________|_|_[_________]_|__|________)<       \n"+
        "       o!o!o'  ooo   ooo  'oo    OOOOO oo|_      \n"+
        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";

private String trainVisual5 =
        "______________     . . . o o o o x o x           \n"+
        "            ||            _____       o          \n"+
        "            |    _____====  ]DD|_n_n__][.        \n"+
        "____________|_|_[_________]_|__|________)<       \n"+
        "       o!o!o'  ooo   ooo  'oo    OOOOO oo|_      \n"+
        "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";

private String trainVisual6 =
        "______________     . . . o o o x o x o           \n"+
        "            ||            _____       x          \n"+
        "            |    _____====  ]DD|_n_n__][.        \n"+
        "____________|_|_[_________]_|__|________)<       \n"+
        "       o!o!o'  ooo   ooo  'oo    OOOOO oo|_      \n"+
        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
private String trainVisual7 =
        "______________     . . . o x o x o x o           \n"+
        "            ||            _____       x          \n"+
        "            |    _____====  ]DD|_n_n__][.        \n"+
        "____________|_|_[_________]_|__|________)<       \n"+
        "       o!o!o'  ooo   ooo  'oo    OOOOO oo|_      \n"+
        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";

private String trainVisual8 =
        "______________     . . . x o x o x o x           \n"+
        "            ||            _____       o          \n"+
        "            |    _____====  ]DD|_n_n__][.        \n"+
        "____________|_|_[_________]_|__|________)<       \n"+
        "       o!o!o'  ooo   ooo  'oo    OOOOO oo|_      \n"+
        "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";


private String trainAnimation [] = {
    trainVisual1,
    trainVisual2,
    trainVisual3,
    trainVisual4,
    trainVisual5,
    trainVisual6,
    trainVisual7,
    trainVisual8
};

private String TrainType1 = 
"   . . . . o o o o o       \n"+
"         _____      o      \n"+
" ____====  ]OO|_n_n__][.   \n"+
"[________]_|__|________)<  \n"+
" oo    oo  'oo OOOO-| oo\\_\n";

private String TrainType2 = 
        "   _┌┬┐_________  \n"+
        "  /[]|  ■■   |[]| \n"+
        " >|__|_______|__|_ \n"+
        "  /OOO└---┘  OOO/  \n";

private String TrainType3 = 
        "______________    \n" + //
        "| ░░░       [\\┐  \n" + //
        "|______________|< \n" + //
        " OOO▀≡▀└---┘OOO\\ \\";
private String TrainType4 = 
"       »  ┌----------------┐« \n" + //
        " //[]|▓▓▓       |[]\\ \n" + //
        " [___|__________|___] \n" + //
        "≤()^()▀≡▀└---┘═▀()^()≥";


    public void RenderTrain()  //just for sake of animation
    {
        for (String frame : trainAnimation) {
            ClearRender();
            System.out.println(frame);

            try { //required by Java for sleep function
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    protected void ClearRender()
    {
        //TODO::Clear Console
        //System.out.print("\033[H\033[2J"); 
        System.out.flush();
        
    }
}
