package GerenciarUsuarios;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {
    static ArrayList<Usuario> usuarios;

    public Menu(ArrayList<Usuario> usuarios1) {
        usuarios = usuarios1;
    }

    public static void exibirMenu() {
        String[] opcoes = { "Salvar usuários", "Listar usuários", "Buscar por e-mail", "Sair" };
        while (true) {
            String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Menu de Usuários",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == null || escolha.equals("Sair")) {
                JOptionPane.showMessageDialog(null, "Saindo do programa. Até logo!");
                break;
            } else if (escolha.equals("Salvar usuários")) {
                salvarUsuario();
            } else if (escolha.equals("Listar usuários")) {
                //listarUsuarios();
            } else if (escolha.equals("Buscar por e-mail")) {
                //buscarPorEmail();
            }
        }
    }

    public static void salvarUsuario() {
        String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
        String email = JOptionPane.showInputDialog("Digite o e-mail do usuário:");

        Usuario usuario = new Usuario(nome, email);
        usuarios.add(usuario);

        JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
    }

    public static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há usuários cadastrados.");
        } else {
            StringBuilder lista = new StringBuilder("Lista de Usuários:\n");
            for (Usuario usuario : usuarios) {
                lista.append("Nome: ").append(usuario.getNome()).append(", Email: ").append(usuario.getEmail())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    public static void buscarPorEmail() {
        String emailBusca = JOptionPane.showInputDialog("Digite o e-mail a ser buscado:");
        boolean encontrado = false;
        StringBuilder resultado = new StringBuilder("Usuário(s) com o e-mail '" + emailBusca + "':\n");

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(emailBusca)) {
                resultado.append("Nome: ").append(usuario.getNome()).append(", Email: ").append(usuario.getEmail())
                        .append("\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado com o e-mail informado.");
        } else {
            JOptionPane.showMessageDialog(null, resultado.toString());
        }
    }
    
}
