package MainPackage;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Functions {
    
    private static ArrayList<Equipo> teams = new ArrayList();
    
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
    public static void writeToFile(){
        try{
            FileWriter writer = new FileWriter("C:\\Users\\ThunderKnight\\Documents\\CODE 2022\\LabP2\\Lab7P2_HectorAcosta\\teams.txt");
            
            for (Equipo team : teams) {
                writer.write(team.toString()+"\n");
            }
            
            writer.close();
            
            System.out.println("Archivo Modificado");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //Carga los equipos ya existentes
    public static void loadTeams(){
        try{
            File teamsFile = new File("C:\\Users\\ThunderKnight\\Documents\\CODE 2022\\LabP2\\Lab7P2_HectorAcosta\\teams.txt");
            Scanner sc = new Scanner(teamsFile);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                String[] teamData = data.split(";");
                String name = teamData[0];
                int pj = Integer.parseInt(teamData[1]);
                int pg = Integer.parseInt(teamData[2]);
                int pe = Integer.parseInt(teamData[3]);
                int pp = Integer.parseInt(teamData[4]);
                int gf = Integer.parseInt(teamData[5]);
                int gc = Integer.parseInt(teamData[6]);
                int dg = Integer.parseInt(teamData[7]);
                int pts = Integer.parseInt(teamData[8]);
                Equipo newTeam = new Equipo(name,pj,pg,pe,pp,gf,gc,dg,pts);
                teams.add(newTeam);
            }
            
            sc.close();
            System.out.println(teams);
            
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
    }

    public static ArrayList<Equipo> getTeams() {
        return teams;
    }

    public static void setTeams(ArrayList<Equipo> teams) {
        Functions.teams = teams;
    }
    
    public static Equipo getTeamByName(String teamName){
        for (Equipo team : teams) {
            if(team.getName().equals(teamName)){
                return team;
            }
        }
        return null;
    }
    
    public static void initEditScreen(){
       EditScreen EditScreen = Main.getEditScreen();
       EditScreen.loadTeams();
       EditScreen.setVisible(true);
    }
    
}

