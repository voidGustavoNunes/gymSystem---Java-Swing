/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.GerInterfaceGrafica;
import control.TurmaTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import model.Turma;
import org.hibernate.HibernateException;

/**
 *
 * @author Gustavo
 */
public class DialogConsultaTurma extends javax.swing.JDialog {

    /**
     * Creates new form DialogConsultaTurma
     */
    public DialogConsultaTurma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    TurmaTableModel turma = new TurmaTableModel();
    GerInterfaceGrafica gerInter = new GerInterfaceGrafica();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonPesquisar = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jComboBoxPesquisaItens = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTurmas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonSair = new javax.swing.JButton();
        jButtonGerarRelatorio = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuConsultas = new javax.swing.JMenu();
        itemProfessorConsulta = new javax.swing.JMenuItem();
        itemAlunoConsulta = new javax.swing.JMenuItem();
        itemAulasConsulta = new javax.swing.JMenuItem();
        itemAtividadesConsulta = new javax.swing.JMenuItem();
        menuCadastros = new javax.swing.JMenu();
        itemProfessorCadastros = new javax.swing.JMenuItem();
        itemAlunoCadastros = new javax.swing.JMenuItem();
        itemAtividadeCadastros = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        atribuirAulasJMenuItem8 = new javax.swing.JMenuItem();
        AtribuirTurmasJMenuItem9 = new javax.swing.JMenuItem();
        jMenuItemEdicao = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        itemGerarRelatorios = new javax.swing.JMenuItem();
        Ajuda = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemSair = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("CONSULTA TURMA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(237, 237, 237))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(28, 28, 28))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Preencha os campos abaixo:"));

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.setToolTipText("");
        jTextFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisaActionPerformed(evt);
            }
        });

        jComboBoxPesquisaItens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Nome", "Aula" }));

        jLabel1.setText("Pesquisar por:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPesquisaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxPesquisaItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTableTurmas.setModel(turma);
        jScrollPane2.setViewportView(jTableTurmas);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonGerarRelatorio.setText("Gerar Relatorio");
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        menuConsultas.setMnemonic('c');
        menuConsultas.setText("Consultas");
        menuConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultasActionPerformed(evt);
            }
        });

        itemProfessorConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemProfessorConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/gym (2).png"))); // NOI18N
        itemProfessorConsulta.setMnemonic('p');
        itemProfessorConsulta.setText("Professor");
        itemProfessorConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProfessorConsultaActionPerformed(evt);
            }
        });
        menuConsultas.add(itemProfessorConsulta);

        itemAlunoConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemAlunoConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/excercise.png"))); // NOI18N
        itemAlunoConsulta.setMnemonic('a');
        itemAlunoConsulta.setText("Aluno");
        itemAlunoConsulta.setToolTipText("");
        itemAlunoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAlunoConsultaActionPerformed(evt);
            }
        });
        menuConsultas.add(itemAlunoConsulta);

        itemAulasConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemAulasConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/trainer.png"))); // NOI18N
        itemAulasConsulta.setText("Aulas");
        itemAulasConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAulasConsultaActionPerformed(evt);
            }
        });
        menuConsultas.add(itemAulasConsulta);

        itemAtividadesConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemAtividadesConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/fitness (1).png"))); // NOI18N
        itemAtividadesConsulta.setText("Atividades");
        itemAtividadesConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAtividadesConsultaActionPerformed(evt);
            }
        });
        menuConsultas.add(itemAtividadesConsulta);

        jMenuBar1.add(menuConsultas);

        menuCadastros.setMnemonic('d');
        menuCadastros.setText("Cadastros");
        menuCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrosActionPerformed(evt);
            }
        });

        itemProfessorCadastros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        itemProfessorCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/gym (2).png"))); // NOI18N
        itemProfessorCadastros.setText("Professor");
        itemProfessorCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProfessorCadastrosActionPerformed(evt);
            }
        });
        menuCadastros.add(itemProfessorCadastros);

        itemAlunoCadastros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        itemAlunoCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/excercise.png"))); // NOI18N
        itemAlunoCadastros.setText("Aluno");
        itemAlunoCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAlunoCadastrosActionPerformed(evt);
            }
        });
        menuCadastros.add(itemAlunoCadastros);

        itemAtividadeCadastros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        itemAtividadeCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/fitness (1).png"))); // NOI18N
        itemAtividadeCadastros.setText("Atividade");
        itemAtividadeCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAtividadeCadastrosActionPerformed(evt);
            }
        });
        menuCadastros.add(itemAtividadeCadastros);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/trainer.png"))); // NOI18N
        jMenuItem2.setText("Aulas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCadastros.add(jMenuItem2);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/employees.png"))); // NOI18N
        jMenuItem6.setText(" Turmas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuCadastros.add(jMenuItem6);

        jMenuBar1.add(menuCadastros);

        jMenu5.setMnemonic('g');
        jMenu5.setText("Gerenciar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/contract.png"))); // NOI18N
        jMenuItem1.setMnemonic('a');
        jMenuItem1.setText("Atividades");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        atribuirAulasJMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        atribuirAulasJMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/trainer.png"))); // NOI18N
        atribuirAulasJMenuItem8.setMnemonic('t');
        atribuirAulasJMenuItem8.setText("Atribuir Aulas");
        atribuirAulasJMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atribuirAulasJMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(atribuirAulasJMenuItem8);

        AtribuirTurmasJMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        AtribuirTurmasJMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/employees.png"))); // NOI18N
        AtribuirTurmasJMenuItem9.setMnemonic('u');
        AtribuirTurmasJMenuItem9.setText("Atribuir Turmas");
        AtribuirTurmasJMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtribuirTurmasJMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(AtribuirTurmasJMenuItem9);

        jMenuItemEdicao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemEdicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/configuration.png"))); // NOI18N
        jMenuItemEdicao.setMnemonic('e');
        jMenuItemEdicao.setText("Editar");
        jMenuItemEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEdicaoActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemEdicao);

        jMenuBar1.add(jMenu5);

        jMenu4.setMnemonic('n');
        jMenu4.setText("Configurações");

        itemGerarRelatorios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemGerarRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/fitness.png"))); // NOI18N
        itemGerarRelatorios.setMnemonic('a');
        itemGerarRelatorios.setText("Gerar Relatórios");
        itemGerarRelatorios.setToolTipText("");
        itemGerarRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGerarRelatoriosActionPerformed(evt);
            }
        });
        jMenu4.add(itemGerarRelatorios);

        Ajuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/icons8-help-5022.png"))); // NOI18N
        Ajuda.setMnemonic('a');
        Ajuda.setText("Ajuda");
        Ajuda.setToolTipText("");
        Ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjudaActionPerformed(evt);
            }
        });
        jMenu4.add(Ajuda);
        jMenu4.add(jSeparator1);

        itemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16px/icons8-exit-50 (1).png"))); // NOI18N
        itemSair.setMnemonic('s');
        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });
        jMenu4.add(itemSair);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        String pesquisa = jTextFieldPesquisa.getText();
        boolean apenasNumeros = gerInter.getInstance().getFun().contemApenasNumeros(pesquisa);

        if (jComboBoxPesquisaItens.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar, selecione novamente");

        } else {
            try {
                List<Turma> lista = gerInter.getInstance().getGerDom().pesquisarTurma(jTextFieldPesquisa.getText(), jComboBoxPesquisaItens.getSelectedIndex());
                turma.setList(lista);
            } catch (HibernateException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERRO pesquisar", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisaActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        jComboBoxPesquisaItens.setSelectedItem(ABORT);
        jTextFieldPesquisa.setText("");
        turma.limparValoresDasCelulas();
        gerInter.fecharJanela(this);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed

        List lista = turma.getLista();
        gerInter.getInstance().getGerRel().relComLista(lista, "relTurmas.jasper");

    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

    private void itemProfessorConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProfessorConsultaActionPerformed
        gerInter.janelaConsultaProfessor();
    }//GEN-LAST:event_itemProfessorConsultaActionPerformed

    private void itemAlunoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAlunoConsultaActionPerformed
        gerInter.janelaConsultaAluno();
    }//GEN-LAST:event_itemAlunoConsultaActionPerformed

    private void itemAulasConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAulasConsultaActionPerformed
        gerInter.janelaDialogConsultaAula();

    }//GEN-LAST:event_itemAulasConsultaActionPerformed

    private void itemAtividadesConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAtividadesConsultaActionPerformed
        gerInter.janelaDialogConsultaExercicio();
    }//GEN-LAST:event_itemAtividadesConsultaActionPerformed

    private void menuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultasActionPerformed
        gerInter.janelaConsultaProfessor();
    }//GEN-LAST:event_menuConsultasActionPerformed

    private void itemProfessorCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProfessorCadastrosActionPerformed
        gerInter.janelaCadastroProfessor();

    }//GEN-LAST:event_itemProfessorCadastrosActionPerformed

    private void itemAlunoCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAlunoCadastrosActionPerformed
        gerInter.janelaCadastroAluno();
    }//GEN-LAST:event_itemAlunoCadastrosActionPerformed

    private void itemAtividadeCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAtividadeCadastrosActionPerformed
        gerInter.janelaCriarExercicio();
    }//GEN-LAST:event_itemAtividadeCadastrosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        gerInter.janelaDialogCadastrarAula();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        gerInter.janelaDialogCadastrarTurma();

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void menuCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrosActionPerformed
        gerInter.janelaCadastroProfessor();
    }//GEN-LAST:event_menuCadastrosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        gerInter.janelaGerenciarExercicios();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void atribuirAulasJMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atribuirAulasJMenuItem8ActionPerformed
        gerInter.janelaDialogAtribuirAulas();

    }//GEN-LAST:event_atribuirAulasJMenuItem8ActionPerformed

    private void AtribuirTurmasJMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtribuirTurmasJMenuItem9ActionPerformed
        gerInter.janelaDialogAtribuirTurma();

    }//GEN-LAST:event_AtribuirTurmasJMenuItem9ActionPerformed

    private void jMenuItemEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEdicaoActionPerformed
        gerInter.janelaDialogEdicao();
    }//GEN-LAST:event_jMenuItemEdicaoActionPerformed

    private void itemGerarRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGerarRelatoriosActionPerformed
        gerInter.janelaIntermediarioGerarRelatorios();

    }//GEN-LAST:event_itemGerarRelatoriosActionPerformed

    private void AjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjudaActionPerformed
        gerInter.janelaDialogAjuda();


    }//GEN-LAST:event_AjudaActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        gerInter.fecharJanela(this);
    }//GEN-LAST:event_itemSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogConsultaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogConsultaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogConsultaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogConsultaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogConsultaTurma dialog = new DialogConsultaTurma(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Ajuda;
    private javax.swing.JMenuItem AtribuirTurmasJMenuItem9;
    private javax.swing.JMenuItem atribuirAulasJMenuItem8;
    private javax.swing.JMenuItem itemAlunoCadastros;
    private javax.swing.JMenuItem itemAlunoConsulta;
    private javax.swing.JMenuItem itemAtividadeCadastros;
    private javax.swing.JMenuItem itemAtividadesConsulta;
    private javax.swing.JMenuItem itemAulasConsulta;
    private javax.swing.JMenuItem itemGerarRelatorios;
    private javax.swing.JMenuItem itemProfessorCadastros;
    private javax.swing.JMenuItem itemProfessorConsulta;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxPesquisaItens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemEdicao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableTurmas;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuConsultas;
    // End of variables declaration//GEN-END:variables
}
