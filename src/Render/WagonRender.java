package Render;

import GameObjects.E_WagonType;
import GameObjects.FreightWagon;
import GameObjects.PassangerWagon;
import GameObjects.Wagon;

public class WagonRender {

    String GoodsWagood =

       "  |~~~~~~~~~~~~~| \n"+
       "  | Goods wagon | \n"+
       ",_|_____________|_\n"+
      "    OOO     OOO   \n";
    String WoodWagon= 
        "    Wood wagon    \n"+
        "  |   ┼     ┼   | \n"+
        ",_└ __┼_____┼__ ┘_\n"+
        "    OOO     OOO   \n";
    String CoalWagon = 
        "    Coal wagon    \n"+
        "  _______________ \n"+
        "  |             | \n"+
        ",_└ ___________ ┘_\n"+
        "    OOO     OOO   \n";
    String TankerWagon =
        "  ╔-------------╗ \n"+
        "  | Tanker Wagon| \n"+
        ",_╚≡≡≡≡≡≡≡≡≡≡≡≡≡╝_\n"+
        "    OOO     OOO  \n"; 
    String PassangerWagon = 
    "  ╔=============╗ \n"+
    "  ║[] [] [] [] █║ \n"+
    ",_║____________█║_\n"+
    "    OOO     OOO   \n";
    String PassangerWagon2 = 
    "  ╔=============╗ \r\n" + 
    "  ║■■■■■■■■■■■▌█║ \r\n" + 
    ",_║____________█║_\r\n" + 
    "    OOO     OOO    \n";

    public String RenderWagon(Wagon wagon)
    {
        if (wagon.getClass()==FreightWagon.class)
        {
            FreightWagon freightWagon = ((FreightWagon)wagon);
            E_WagonType wagonType = freightWagon.getFreighType();
            switch (wagonType) {
                case WOOD:
                    return WoodWagon;
                case GOODS:
                    return GoodsWagood;
                case GRAIN:
                    return CoalWagon;
                case OIL:
                    return TankerWagon;
                default:
                    return GoodsWagood;
            }
        }
        else if (wagon.getClass()==PassangerWagon.class)
        {
            return PassangerWagon;
        }
        return GoodsWagood;
    }
}

