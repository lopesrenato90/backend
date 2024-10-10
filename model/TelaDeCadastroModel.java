package model;

import java.sql.*;
//import controller.*;


public class TelaDeCadastroModel {
    public static int cadastrarModel(String nome, String email, String senha){
        try {
            // Conexão com o banco de dados
            Connection conexao = MySQLConnector.conectar();
            // Verificação se o email já está cadastrado
            String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + email + "';";
            Statement stmSqlEmail = conexao.createStatement();
            ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);
            if (rstSqlEmail.next()) {
                stmSqlEmail.close();
                return 0;
                //lblNotificacoes.setText(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digite outro email e tente novamente."));
            } else {
                // Cadastro do novo usuário
                //lblNotificacoes.setText(setHtmlFormat("Login liberado para cadastro."));
                String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + nome + "', '" + email + "', '" + senha + "');";
                Statement stmSqlCadastrar = conexao.createStatement();
                stmSqlCadastrar.addBatch(strSqlCadastrar);
                stmSqlCadastrar.executeBatch();
                return 2;
                //lblNotificacoes.setText(setHtmlFormat("Cadastro realizado com sucesso"));
            }
        } catch (Exception e) {
            //lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com o cadastro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
            return 1;
        }
    }
}
