/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.ui;

import acoes.*;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Rodrigo
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private static TelaPrincipal instance;

    public static TelaPrincipal getInstance() {
        if (instance == null)
            instance = new TelaPrincipal();
        return instance;
    }

    /** Creates new form TelaPrincipal */
    private TelaPrincipal() {
        initComponents();
        construirBarraMenu();
        setTitle("Gerenciador de Academia");
        InterfaceUtils.centralizarFrame(this);
        btnNovoCliente.setAction(new ComandoNovoCliente());
        btnNovoCliente.setText("Novo Cliente");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnAcoes = new javax.swing.JPanel();
        btnNovoCliente = new javax.swing.JButton();
        btnBuscaCliente = new javax.swing.JButton();
        btnNovoProfessor = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnAcoes.setPreferredSize(new java.awt.Dimension(819, 120));

        btnNovoCliente.setLabel("Novo Cliente");
        btnNovoCliente.setPreferredSize(new java.awt.Dimension(100, 100));

        btnBuscaCliente.setLabel("Buscar Cliente");
        btnBuscaCliente.setPreferredSize(new java.awt.Dimension(100, 100));

        btnNovoProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovoProfessor.setLabel("Novo Professor");
        btnNovoProfessor.setPreferredSize(new java.awt.Dimension(100, 100));

        jButton5.setLabel("Buscar Professor");
        jButton5.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout pnAcoesLayout = new javax.swing.GroupLayout(pnAcoes);
        pnAcoes.setLayout(pnAcoesLayout);
        pnAcoesLayout.setHorizontalGroup(
            pnAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );
        pnAcoesLayout.setVerticalGroup(
            pnAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 330, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaCliente;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JButton btnNovoProfessor;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel pnAcoes;
    // End of variables declaration//GEN-END:variables

    private void construirBarraMenu() {
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuCliente = new JMenu("Clientes");
        JMenu menuProfessor = new JMenu("Professores");
        JMenu menuAulas = new JMenu("Aulas e pacotes");
        JMenu menuSobre = new JMenu("Ajuda");
        menuArquivo.add(criarItemMenu("Fechar", new ComandoFechar()));
        menuCliente.add(criarItemMenu("Novo Cliente", new ComandoNovoCliente()));
        menuCliente.add(criarItemMenu("Buscar Cliente", new ComandoBuscarCliente()));
        menuProfessor.add(criarItemMenu("Novo Professor", new ComandoNovoProfessor()));
        menuProfessor.add(criarItemMenu("Buscar Professor", new ComandoBuscarProfessor()));
        menuBar.add(menuArquivo);
        menuBar.add(menuCliente);
        menuBar.add(menuProfessor);
        menuBar.add(menuAulas);
        menuBar.add(menuSobre);
    }

    private JMenuItem criarItemMenu(String titulo, Action acao) {
        JMenuItem item = new JMenuItem(acao);
        item.setText(titulo);
        return item;
    }
}