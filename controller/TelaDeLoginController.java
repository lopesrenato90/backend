package controller;
import model.*;
import view.*;

public class TelaDeLoginController extends TelaDeLoginView {
    private LogarModel logarModel;

    public TelaDeLoginController() {
        this.logarModel = logarModel ;
        initView();
        addListeners();
    }

    private void initView() {
        // Colocar componentes do View

    private void addListeners() {
        // botão login
        loginButton.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String login = loginField.getText();
        String senha = senhaField.getText();
        
        if (logarModel.validateCredentials(login, senha)) {
            // Vá para a próxima tela ou mensagem de
            System.out.println("Login efetuado!");
        } else {
            // Mensagem de erro
            System.out.println("Credenciais inválidas, tente novamente.");
        }
    }
}
