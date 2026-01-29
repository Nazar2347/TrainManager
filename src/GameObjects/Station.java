package GameObjects;
import java.util.Arrays;
import java.util.Vector;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.List;

public abstract class Station {
protected String name;
protected float totalCargoMass;
protected int location;
protected List<Passengers> passengers;
protected HashMap<E_CargoType,List<Cargo>>cargoOnStaion;

    public Station(String name,int location)
    {
        this.name = name;
        this.location = location;
        
    }
    public String GetName()
    {
        return name;
    }
    public void LoadCargoToStation(HashMap<E_CargoType,List<Cargo>> cargo)
    {
        this.cargoOnStaion = cargo;
    }
    public void LoadCargoIntoTrainSet(Locomotive loco)
    {
        if (loco == null)
        {
          return;   
        }
        if (loco.GetAttachedWagons()==null)
        {
            return;
        }
        if (cargoOnStaion == null)
        {
            return;
        }
        Vector<Cart>carts= loco.GetAttachedWagons();
        List<Wagon> wagons = carts.stream().map(item->(Wagon)item).toList();
        
        for (Wagon i : wagons)
        {
            if (i instanceof FreightWagon freight)
            {
                switch (freight.type) {
                    case WOOD:
                        LoadCargoIntoWagon(freight, E_CargoType.OVERSIZED);
                        break;
                    case OIL:
                        LoadCargoIntoWagon(freight, E_CargoType.LIQUID);
                        break;
                    case GOODS:
                        LoadCargoIntoWagon(freight, E_CargoType.FRAGILE);
                        LoadCargoIntoWagon(freight, E_CargoType.GOODS);
                        break;
                    case GRAIN:
                        LoadCargoIntoWagon(freight, E_CargoType.GRAINED);
                        break;
                    default:
                        break;
                }
            }
            if (i instanceof PassangerWagon passangerWagon)
            {
                i.LoadCargo((Cargo)passengers);
            }
            
        }

    };
    public void UnloadCargo(Locomotive loco)
    {
        if (loco ==null)
        {
            return;
        }
        if(loco.GetAttachedWagons() == null)
        {
            return;
        }
        Vector<Cart>carts = loco.GetAttachedWagons();
        List<Wagon> wagons = carts.stream().map(item->(Wagon)item).toList();
         for (Wagon i : wagons)
        {
            if (i instanceof FreightWagon freight)
            {
                switch (freight.type) {
                    case WOOD:
                        cargoOnStaion.put(E_CargoType.OVERSIZED,freight.GetCargo());
                        break;
                    case OIL:
                        cargoOnStaion.put(E_CargoType.LIQUID,freight.GetCargo());
                        break;
                    case GOODS:
                        cargoOnStaion.put(E_CargoType.FRAGILE,freight.GetCargo());
                        cargoOnStaion.put(E_CargoType.GOODS,freight.GetCargo());
                        break;
                    case GRAIN:
                        cargoOnStaion.put(E_CargoType.GRAINED,freight.GetCargo());
                        break;
                    default:
                        break;
                }
            }
            if (i instanceof PassangerWagon passangerWagon)
            {
                i.LoadCargo((Cargo)passengers);
            }
        }

    };

    public void LoadCargoIntoWagon(FreightWagon wagon, E_CargoType cargoType)
    {
        if (cargoOnStaion.get(cargoType)!= null)
        {
            List<Cargo> oilCargos = cargoOnStaion.get(cargoType);
            for (Cargo j: oilCargos)
            {
                wagon.LoadCargo(j);
            }
        }
    }
    public int getLocation()
    {
        return location;
    };
}
