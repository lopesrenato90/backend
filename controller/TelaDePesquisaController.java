package controller;
import model.*;
import view.*;

import java.sql.*;

public class TelaDePesquisaController extends TelaDePesquisaView {
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao));
    }

    public static void preencherCampos(String id, String nome, String email) {
        txtId.setText(id);
        txtNome.setText(nome);
        txtEmail.setText(email);
    }

    public static void registrarPesquisa() {
        txtUsuario = txtPesquisa.getText();
    }

    public static void pesquisar() {
        if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
            limparCampos("");
        }
    }

    public static void primeiroRegistro() {
        limparCampos("Você está no primeiro registro.");
        TelaDePesquisaModel.primeiroResgistroModel(txtPesquisa.getText());
    }

    public static void registroAnterior() {
        limparCampos("Registro Anterior");
     }

    public static void proximoRegistro() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("Próximo registro posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` > " + idAtual + " order by `id` asc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void ultimoRegistro() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o último registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void desabilitarTodos() {
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
    }

    public static void habilitarVoltar() {
        desabilitarTodos();
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
    }

    public static void habilitarTodos() {
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
    }

    public static void habilitarAvancar() {
        desabilitarTodos();
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
    }
  }
public static void desabilitarPesquisar() {
    btnPesquisar.setEnabled(false);
}
