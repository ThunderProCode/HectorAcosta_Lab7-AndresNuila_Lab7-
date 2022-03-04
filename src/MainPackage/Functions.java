package MainPackage;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Functions {
    
    public static ArrayList<Equipo> teams = new ArrayList();
    
    //Crea un nuevo equipo
    public static Equipo createTeam(String name){
        return new Equipo(name);
    }
    
    //Agrega un equipo al arraylist
    public static void addTeam(Equipo team){
        teams.add(team);
    }
  
    //Elimina un equipo del arraylist
    public static void deleteTeam(Equipo team){
        teams.remove(team);
    }
    
    //Crea un nuevo archivo 
    public static void writeToFile(String newTeam){
        try{
            FileWriter writer = new FileWriter("C:\\Users\\ThunderKnight\\Documents\\CODE 2022\\LabP2\\Lab7P2_HectorAcosta\\teams.txt");
            writer.write(newTeam+"\n");
            writer.close();
            
            JOptionPane.showMessageDialog(null, "Archivo Modificado");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //Lee un archivo 
    public static void loadTeams(){
        try{
            File teamsFile = new File("C:\\Users\\ThunderKnight\\Documents\\CODE 2022\\LabP2\\Lab7P2_HectorAcosta\\teams.txt");
            Scanner sc = new Scanner(teamsFile);
            
            
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
    }
    
    
}

