/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import view.DialogCadastroAluno;
import view.DialogCadastroProfessor;
import view.DialogConsultaAluno;
import view.DialogConsultaIntermediario;
import view.DialogConsultaProfessor;
import view.DialogCriarExercicio;
import view.DialogGerenciarExercicios;
import view.DialogIntermediarioGerarRelatorios;
import view.DialogLogin;
import view.FrmGerenciador;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Aluno;
import model.Aulas;
import model.Exercicio;
import model.Professor;
import model.Turma;
import org.hibernate.HibernateException;
import view.DialogAjuda;
import view.DialogAtribuirAulas;
import view.DialogAtribuirTurmas;
import view.DialogAulas;
import view.DialogConsultaAula;
import view.DialogConsultaExercicio;
import view.DialogConsultaTurma;
import view.DialogEdicao;
import view.DialogTurma;

/**
 *
 * @author Gustavo
 */
public class GerInterfaceGrafica {

    //JANELAS
    private FrmGerenciador janPrinc = null;
    private DialogCadastroProfessor janCadProf = null;
    private DialogCadastroAluno janCadAluno = null;
    private DialogConsultaAluno janConsAluno = null;
    private DialogTurma janCadastroTurma = null;
    private DialogConsultaIntermediario janConsInter = null;
    private DialogConsultaProfessor janConsProf = null;
    private DialogCriarExercicio janCriaEx = null;
    private DialogGerenciarExercicios janGerEx = null;
    private DialogIntermediarioGerarRelatorios janIntGerRel = null;
    private DialogLogin janLogin = null;
    private DialogAjuda janAjuda = null;
    private DialogAtribuirAulas janAtrAulas = null;
    private DialogAulas janAulas = null;
    private DialogAtribuirTurmas janAtrTurmas = null;
    private DialogEdicao janEdicao = null;
    private DialogConsultaTurma janConsTurma = null;
    private DialogConsultaExercicio janConsEx = null;
    private DialogConsultaAula janConsAula = null;

    private GerenciadorDominio gerDom;
    private GerenciadorRelatorios gerRel;

    FuncoesUteis fun = new FuncoesUteis();

    Aluno aluno = null;
    Professor professor = null;
    Exercicio ex = null;
    Aulas aula = null;
    Turma turma = null;

    public Aluno getAluno() {
        return aluno;
    }

    public FuncoesUteis getFun() {
        return fun;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Exercicio getEx() {
        return ex;
    }

    public Aulas getAula() {
        return aula;
    }

    public Turma getTurma() {
        return turma;
    }

    //SINGLETON
    private final static GerInterfaceGrafica unicaInstancia = new GerInterfaceGrafica();

    public GerInterfaceGrafica() {
        gerDom = new GerenciadorDominio();
        gerRel = new GerenciadorRelatorios();
    }

    public GerenciadorRelatorios getGerRel() {
        return gerRel;
    }

    public static GerInterfaceGrafica getInstance() {
        return unicaInstancia;
    }

    public GerenciadorDominio getGerDom() {
        return gerDom;
    }

    //ABRIR DIALOG
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent, true);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela" + classe.getName());
            }

        }
        dlg.setVisible(true);
        return dlg;

    }

    //ABRIR DIALOG
    private JDialog abrirJanelaDiferente(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent, true);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela" + classe.getName());
            }

        }
        dlg.setVisible(false);
        return dlg;

    }

    private JDialog abrirJanela(JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor().newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir a janela " + classe.getName());
            }
        }

        if (dlg != null) {
            dlg.setVisible(true);
        }

        return dlg;
    }

    // ABRIR FRAME
    private JFrame abrirJanela(JDialog parent, JFrame frame, Class classe) {
        if (frame == null) {
            try {
                frame = (JFrame) classe.getConstructor().newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela" + classe.getName());
            }
        }

        frame.setVisible(true);
        return frame;
    }

    public void janelaCadastroAluno() {
        janCadAluno = (DialogCadastroAluno) abrirJanela(janPrinc, janCadAluno, DialogCadastroAluno.class);

    }

    public void janelaCadastroProfessor() {
        janCadProf = (DialogCadastroProfessor) abrirJanela(janPrinc, janCadProf, DialogCadastroProfessor.class);

    }

    public void janelaConsultaAluno() {
        janConsAluno = (DialogConsultaAluno) abrirJanela(janPrinc, janConsAluno, DialogConsultaAluno.class);

    }

    public void janelaConsultaIntermediario() {
        janConsInter = (DialogConsultaIntermediario) abrirJanela(janPrinc, janConsInter, DialogConsultaIntermediario.class);

    }

    public void janelaConsultaProfessor() {
        janConsProf = (DialogConsultaProfessor) abrirJanela(janPrinc, janConsProf, DialogConsultaProfessor.class);

    }

    public void janelaCriarExercicio() {
        janCriaEx = (DialogCriarExercicio) abrirJanela(janPrinc, janCriaEx, DialogCriarExercicio.class);

    }

    public void janelaGerenciarExercicios() {
        janGerEx = (DialogGerenciarExercicios) abrirJanela(janPrinc, janGerEx, DialogGerenciarExercicios.class);

    }

    public void janelaIntermediarioGerarRelatorios() {
        janIntGerRel = (DialogIntermediarioGerarRelatorios) abrirJanela(janPrinc, janIntGerRel, DialogIntermediarioGerarRelatorios.class);

    }

    public void janelaDialogLogin() {
        janLogin = (DialogLogin) abrirJanela(janPrinc, janLogin, DialogLogin.class);

    }

    public void janelaFrmGerenciador() {
        janPrinc = (FrmGerenciador) abrirJanela(janLogin, janPrinc, FrmGerenciador.class);

    }

    public void janelaDialogAjuda() {
        janAjuda = (DialogAjuda) abrirJanela(janPrinc, janAjuda, DialogAjuda.class);
    }

    public void janelaDialogAtribuirAulas() {

        janAtrAulas = (DialogAtribuirAulas) abrirJanela(janPrinc, janAtrAulas, DialogAtribuirAulas.class);

    }


    public void janelaDialogConsultaAula() {
        janConsAula = (DialogConsultaAula) abrirJanela(janPrinc, janConsAula, DialogConsultaAula.class);

    }

    public void janelaDialogAtribuirTurma() {
        janAtrTurmas = (DialogAtribuirTurmas) abrirJanela(janPrinc, janAtrTurmas, DialogAtribuirTurmas.class);
    }

    public void janelaDialogConsultaExercicio() {
        janConsEx = (DialogConsultaExercicio) abrirJanela(janPrinc, janConsEx, DialogConsultaExercicio.class);
    }

    public void janelaDialogCadastrarAula() {
        janAulas = (DialogAulas) abrirJanela(janPrinc, janAulas, DialogAulas.class);

    }

    public void janelaDialogCadastrarTurma() {
        janCadastroTurma = (DialogTurma) abrirJanela(janPrinc, janCadastroTurma, DialogTurma.class);

    }

    public void janelaDialogEdicao() {
        janEdicao = (DialogEdicao) abrirJanela(janPrinc, janEdicao, DialogEdicao.class);

    }

    public void preencherCamposAulas(Aulas aula) {
        janAtrAulas = (DialogAtribuirAulas) abrirJanela(janPrinc, janAtrAulas, DialogAtribuirAulas.class);

    }

    public void janelaDialogConsultaTurma() {
        janConsTurma = (DialogConsultaTurma) abrirJanela(janPrinc, janConsTurma, DialogConsultaTurma.class);

    }

    public void fecharJanela(JDialog dlg1) {
        if (dlg1 != null && dlg1.isVisible()) {
            dlg1.dispose();
        }
    }

    public void fecharJanela(JFrame frm1) {
        if (frm1 != null && frm1.isVisible()) {
            frm1.dispose();
        }
    }

    private void redimensionaFoto(ImageIcon imagem, JLabel label) {
        imagem.setImage(imagem.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setText("");
        label.setIcon(imagem);
    }

    public void abrirFoto(JDialog janela, JLabel label) {
        JFileChooser janArq = new JFileChooser();

        janArq.setAcceptAllFileFilterUsed(false);
        janArq.setFileFilter(new FileNameExtensionFilter("Arquivos de imagem", "png", "bmp", "jpg", "gif"));

        if (janArq.showOpenDialog(janela) == JFileChooser.APPROVE_OPTION) {
            File arq = janArq.getSelectedFile();
            ImageIcon imagem = new ImageIcon(arq.getAbsolutePath());
            redimensionaFoto(imagem, label);
        }
    }

    public void abrirJanPrincipal() {
        if (janPrinc == null) {
            janPrinc = new FrmGerenciador();
        }
        janPrinc.setVisible(true);
    }

    public void carregarCombo(Class classe, JComboBox combo) {
        List lista;
        try {
            lista = gerDom.listar(classe);
            combo.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(janPrinc, ex.getMessage());
        }
    }

    public void abreJanelaPreencheCampos(Object ob) {
        DialogCadastroAluno dialogAluno = null;
        DialogCadastroProfessor dialogProfessor = null;
        DialogTurma dialogTurma = null;
        DialogAulas dialogAulas = null;
        DialogCriarExercicio dialogEx = null;
        if (ob != null) {
            if (ob.getClass() == Aluno.class) {
                aluno = (Aluno) ob;
                dialogAluno = (DialogCadastroAluno) abrirJanelaDiferente(janPrinc, janCadAluno, DialogCadastroAluno.class);
                dialogAluno.preencherCampos(aluno);
                dialogAluno.setVisible(true);

            } else if (ob.getClass() == Professor.class) {
                professor = (Professor) ob;
                dialogProfessor = (DialogCadastroProfessor) abrirJanelaDiferente(janPrinc, janCadProf, DialogCadastroProfessor.class);
                dialogProfessor.preencherCampos(professor);
                dialogProfessor.setVisible(true);

            } else if (ob.getClass() == Aulas.class) {
                aula = (Aulas) ob;

                dialogAulas = (DialogAulas) abrirJanelaDiferente(janPrinc, janAulas, DialogAulas.class);
                dialogAulas.preencherCampos(aula);
                
                dialogAulas.setVisible(true);

            } else if (ob.getClass() == Turma.class) {
                turma = (Turma) ob;

                dialogTurma = (DialogTurma) abrirJanelaDiferente(janPrinc, janCadastroTurma, DialogTurma.class);
                dialogTurma.preencherCampos(turma);
                dialogTurma.tornaExcluirVisivel();
                dialogTurma.setVisible(true);

            } else if (ob.getClass() == Exercicio.class) {
                ex = (Exercicio) ob;

                dialogEx = (DialogCriarExercicio) abrirJanelaDiferente(janPrinc, janCriaEx, DialogCriarExercicio.class);
                dialogEx.preencherCampos(ex);
                dialogEx.setaEnable();
                dialogEx.setVisible(true);

            }

        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            /*
            FlatDarkLaf dark = new FlatDarkLaf();
            javax.swing.UIManager.setLookAndFeel( dark );
             */
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // TRADUÇÃO
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
        javax.swing.UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        GerInterfaceGrafica gerIG = GerInterfaceGrafica.getInstance();
        gerIG.abrirJanPrincipal();

    }

}
