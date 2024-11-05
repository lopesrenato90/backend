package view;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeAtualizacaoView extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblImagem;
    public static JButton btnCarregarImagem;
    public static JButton btnRemoverImagem;
    public static final JTextField txtImagem = new JTextField();

    public static JLabel lblNome;
    public static JTextField txtNome;
    public static String nomeAtual;

    public static JLabel lblEmail;
    public static JTextField txtEmail;
    public static String emailAtual;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;
    public static String senhaAtual;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public static GridBagLayout gbLayout;
    public static GridBagConstraints gbConstraints;

    public TelaDeAtualizacaoView()
    {
        super("Tela de Atualização");
        gbLayout = new GridBagLayout();
        setLayout(gbLayout);
        gbConstraints = new GridBagConstraints();
        //setLayout(new GridLayout(7,1,5,5));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblId,0,0,1,1);

        TelaDeAtualizacaoController.popularIds();
        cbxId = new JComboBox<String>(ids);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(cbxId,0,0,1,1);
        
        //add(linha_id);

        JPanel linha_imagem = new JPanel(new GridLayout(1,3));

        lblImagem = new JLabel(InterfaceController.imgPadrao);
        linha_imagem.add(lblImagem);

        btnCarregarImagem = new JButton("Carregar Imagem");
        linha_imagem.add(btnCarregarImagem);

        btnRemoverImagem = new JButton("Remover Imagem");
        linha_imagem.add(btnRemoverImagem);

        //add(linha_imagem);
        addComponent(linha_imagem, 1,0,1,1);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);
        linha_nome.add(txtNome);

        //add(linha_nome);
        addComponent(linha_nome, 2,0,1,1);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);
        linha_email.add(txtEmail);

        //add(linha_email);
        addComponent(linha_email, 3,0,1,1);

        JPanel linha_senha = new JPanel(new GridLayout(1, 2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        linha_senha.add(lblSenha);

        txtSenha = new JPasswordField(tamanhoInputs);
        linha_senha.add(txtSenha);

        //add(linha_senha);
        addComponent(linha_senha, 4,0,1,1);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnAtualizar = new JButton("Atualizar");
        linha_botoes.add(btnAtualizar);

        btnCancelar = new JButton("Cancelar");
        linha_botoes.add(btnCancelar);

        //add(linha_botoes);
        addComponent(linha_botoes, 5,0,1,1);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        //add(linha_notificacoes);
        addComponent(linha_notificacoes, 6,0,1,1);

        btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.atualizarId();
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.limparCampos();
                }
            }
        );

        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        TelaDeAtualizacaoController.atualizarCampos(cbxId.getSelectedItem().toString());
                    }
                } 
            }
        );

        btnCarregarImagem.addActionListener(
            new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.carregarImagem();
                } 
            }
        );

        btnRemoverImagem.addActionListener(
            new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.removerImagem();
                } 
            }
        );

        setSize(500, 300);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public void addComponent(Component component, int row, int column, int width, int height) {
        gbConstraints.gridx = column;
        gbConstraints.gridy = row;
        gbConstraints.gridwidth = width;
        gbConstraints.gridheight = height;
        gbLayout.setConstraints(component, gbConstraints);
        add(component);
    }

    public static TelaDeAtualizacaoView appTelaDeAtualizacaoView;
    public static void main(String[] args) {
        appTelaDeAtualizacaoView = new TelaDeAtualizacaoView();
        appTelaDeAtualizacaoView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}