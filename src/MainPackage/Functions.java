package MainPackage;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
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
    
    //Load file from another file
    public static void readFile(File selectedFile){
        try{
            Scanner sc = new Scanner(selectedFile);
            try{
                FileWriter writer = new FileWriter("C:\\Users\\ThunderKnight\\Documents\\CODE 2022\\LabP2\\Lab7P2_HectorAcosta\\teams.txt");
                while(sc.hasNextLine()){
                    String data = sc.nextLine();
                    writer.write(data+"\n");
                }
                writer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            sc.close();
            
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
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
    
    public static void match(Equipo team1,Equipo team2){
        Random r = new Random();
        
        int team1Goals = r.nextInt(5-1) + 1;
        int team2Goals = r.nextInt(5-1) + 1;
        
        if(team1Goals > team2Goals){
            team1.setPg( team1.getPg() + 1 );
            team2.setPp(team2.getPp() + 1);
            JOptionPane.showMessageDialog(null, "El equipo ganador es "+ team1.getName()+"\n"+team1.getName()+": "+team1Goals + " - " + team2Goals + " :" + team2.getName());
        }else if(team1Goals == team2Goals){
            team1.setPe(team1.getPe() + 1);
            team2.setPe(team2.getPe() + 1);
            JOptionPane.showMessageDialog(null, "El resultado del partido es un empate"+ "\n"+team1.getName()+": "+team1Goals + " - " + team2Goals + " :" + team2.getName());
        }else{
            team2.setPg( team2.getPg() + 1 );
            team1.setPp(team1.getPp() + 1);
            JOptionPane.showMessageDialog(null, "El equipo ganador es "+ team2.getName() + "\n"+team1.getName()+": "+team1Goals + " - " + team2Goals + " :" + team2.getName());
        }
        
        team1.setPj(team1.getPj() + 1);
        team1.setGf(team1.getGf() + team1Goals);
        team1.setGc(team1.getGc() + team2Goals);
        
        if(team1.getGf()>team1.getGc()){
            team1.setDg(team1.getGf() - team1.getGc());
        }
        
        if(( team1.getPts() + team1Goals - team2Goals ) > 0 ){
            team1.setPts( team1.getPts() + team1Goals - team2Goals );
        }
        
        
        team2.setPj(team2.getPj() + 1);
        team2.setGf(team2.getGf() + team2Goals);
        team2.setGc(team2.getGc() + team1Goals);
        
        if(team2.getGf()>team2.getGc()){
            team2.setDg(team2.getGf() - team2.getGc());
        }
        
        if( (team2.getPts() + team2Goals - team1Goals ) > 0 ){
            team2.setPts( team2.getPts() + team2Goals - team1Goals );
        }
        
    }
    
}

