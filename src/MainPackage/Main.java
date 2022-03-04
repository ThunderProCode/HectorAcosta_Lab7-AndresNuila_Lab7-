package MainPackage;

public class Main {
    
    private static MainScreen MainScreen = new MainScreen();
    private static EditScreen EditScreen = new EditScreen();
    
    public static void main(String[] args) {
        MainScreen.setVisible(true);
        Functions.loadTeams();
        MainScreen.fillTable();
        MainScreen.loadTeams();
        MainScreen.sortArrayList();
 
    }

    public static MainScreen getMainScreen() {
        return MainScreen;
    }

    public static void setMainScreen(MainScreen MainScreen) {
        Main.MainScreen = MainScreen;
    }

    public static EditScreen getEditScreen() {
        return EditScreen;
    }

    public static void setEditScreen(EditScreen EditScreen) {
        Main.EditScreen = EditScreen;
    }


    
}
