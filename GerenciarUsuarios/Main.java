package GerenciarUsuarios;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        var menu = new Menu(usuarios);
        menu.exibirMenu();
    }

    
}
