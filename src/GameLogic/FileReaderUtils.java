package GameLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import GameObjects.E_LocomotiveType;
import GameObjects.E_WagonType;
import GameObjects.FreightWagon;
import GameObjects.Locomotive;
import GameObjects.PassangerWagon;
import GameObjects.Wagon;

public class FileReaderUtils {

    HashSet<Locomotive> LoadLocomotives(String filePath)
    {
         // Parse format: KEY=VALUE
        // Format: LOCOMOTIVE=name,emptyMass,maxMass,fuelCapacity,fuelConsumptionRate,maxWagons,maxTowedMass
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            HashSet<Locomotive> locomotives=new HashSet<Locomotive>();
            while ((line = reader.readLine()) != null)
            {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#"))
                    continue;

                
                if (line.contains("="))
                {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (key.equals("LOCOMOTIVE"))
                    {
                        String[] locoParts = value.split(",");
                        if (locoParts.length >= 8)
                        {
                            try
                            {
                                String locoName = locoParts[0];
                                String sLocoType = locoParts[1];
                                E_LocomotiveType locotype =E_LocomotiveType.valueOf(sLocoType);
                                float emptyMass = Float.parseFloat(locoParts[2]);
                                float maxMass = Float.parseFloat(locoParts[3]);
                                float fuelCapacity = Float.parseFloat(locoParts[4]);
                                float fuelConsumptionRate = Float.parseFloat(locoParts[5]);
                                int maxWagons = Integer.parseInt(locoParts[6]);
                                float maxTowedMass = Float.parseFloat(locoParts[7]);

                                Locomotive locomotive = new Locomotive(locoName,locotype, emptyMass, maxMass, fuelCapacity, fuelConsumptionRate, maxWagons, maxTowedMass);
                                System.out.println("Locomotive loaded: " + locoName);
                                locomotives.add(locomotive);
                            } catch (NumberFormatException e)
                            {
                                System.err.println("Invalid locomotive data: " + value);
                            }
                        }
                    }
                }
            }
            System.out.println("Player data loaded successfully from: " + filePath);
            return locomotives;

        } 
        catch (IOException e)
        {
            System.err.println("Error loading comotive data: " + e.getMessage());
            return null;
        }

    }
    public void SaveLocomotive(Locomotive locomotive, String filePath)
    {

    }
    public HashSet<Wagon> LoadWagons(String filePath)
    {
        // Parse format: KEY=VALUE
        // Format: WAGON=type,name,emptyMass,maxMass
        // type: "FREIGHT" or "PASSENGER"
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            HashSet<Wagon> wagons=new HashSet<Wagon>();
            String line;
            while ((line = reader.readLine()) != null)
            {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#"))
                    continue;
                if (line.contains("="))
                {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (key.equals("WAGON"))
                    {
                        String[] wagonParts = value.split(",");
                        if (wagonParts.length >= 4)
                        {
                            try
                            {
                                String wagonType = wagonParts[0].toUpperCase();
                                
                                String wagonName = wagonParts[1];
                                float emptyMass = Float.parseFloat(wagonParts[2]);
                                float maxMass = Float.parseFloat(wagonParts[3]);

                                Wagon wagon = null;
                                if (wagonType.equals("FREIGHT"))
                                {
                                    if (wagonParts.length<4)
                                    {
                                        System.err.println("Unknown freight wagon type: " + wagonType);
                                        return null;
                                    }
                                    String sFreightType= wagonParts[4];
                                    E_WagonType freightType = E_WagonType.valueOf(sFreightType);
                            
                                    wagon = new FreightWagon(wagonName,freightType, emptyMass, maxMass);
                                    wagons.add(wagon);
                                } 
                                else if (wagonType.equals("PASSENGER"))
                                {
                                    wagon = new PassangerWagon(wagonName, emptyMass, maxMass);
                                    wagons.add(wagon);
                                }

                                if (wagon != null)
                                {
                                    System.out.println("Wagon loaded: " + wagonName + " (" + wagonType + ")");
                                } else
                                {
                                    System.err.println("Unknown wagon type: " + wagonType);
                                }
                            } catch (NumberFormatException e)
                            {
                                System.err.println("Invalid wagon data: " + value);
                            }
                        }
                    }
                }
            }
            System.out.println("Player data loaded successfully from: " + filePath);
            return wagons;

        } catch (IOException e)
        {
            System.err.println("Error loading wagons data: " + e.getMessage());
            return null;
        }
    }
    public void SaveWagon(String filePath)
    {

    }
    public Player LoadPlayer(String filePath)
    { 
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            String playerName = "";
            int moneyBalance = 0;
            while ((line = reader.readLine()) != null)
            {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#"))
                    continue;

                // Parse format: KEY=VALUE
                if (line.contains("="))
                {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key)
                    {
                        case "NAME":
                            playerName = value;
                            break;

                        case "MONEY":
                            try
                            {
                                moneyBalance = Integer.parseInt(value);
                            } catch (NumberFormatException e)
                            {
                                System.err.println("Invalid money value: " + value);
                            }
                            break;
                    }
                }
            }
            System.out.println("Player data loaded successfully from: " + filePath);
            return new Player(playerName, moneyBalance);

        } catch (IOException e)
        {
            System.err.println("Error loading player data: " + e.getMessage());
            return null;
        }
    }
}
