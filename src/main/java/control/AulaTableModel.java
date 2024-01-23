/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aulas;
import model.Professor;
import model.Turma;

/**
 *
 * @author Gustavo
 */
public class AulaTableModel extends AbstractTableModel {

    public AulaTableModel() {
    }

    public List<Aulas> getLista() {
        return lista;
    }
    
    GerenciadorDominio gerDom = new GerenciadorDominio();
    List<Aulas> lista = new ArrayList();

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aulas aula = lista.get(rowIndex);

        if (columnIndex == 0) {
            return aula.getIdAula();
        } else if (columnIndex == 1) {
            return aula.getTipo();
        } else if (columnIndex == 2) {
            // Exibindo a lista de professores como uma única string separada por vírgulas
            List<Professor> professores = aula.getProfessores();
            StringBuilder professoresString = new StringBuilder();
            for (Professor professor : professores) {
                professoresString.append(professor.getNome()).append(", "); // Supondo que o nome do professor seja o atributo a ser exibido
            }
            // Removendo a última vírgula e espaço, se houver algum professor na lista
            if (professoresString.length() > 0) {
                professoresString.setLength(professoresString.length() - 2);
            }
            return professoresString.toString();
        } else if (columnIndex == 3) {
            // Exibindo a lista de turmas como uma única string separada por vírgulas
            List<Turma> turmas = gerDom.retornaListaTurma(aula);
            StringBuilder turmasString = new StringBuilder();
            for (Turma turma : turmas) {
                turmasString.append(turma.getNome()).append(", "); // Supondo que o nome da turma seja o atributo a ser exibido
            }
            // Removendo a última vírgula e espaço, se houver alguma turma na lista
            if (turmasString.length() > 0) {
                turmasString.setLength(turmasString.length() - 2);
            }
            return turmasString.toString();
        } else {
            return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        String colunas[] = {"Id ", "Nome", "Professor", "Turma"};
        return colunas[columnIndex];
    }

    public void adicionar(Aulas aula) {
        lista.add(aula);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public Aulas getAulas(int row) {
        return lista.get(row);
    }

    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1, lista.size() - 1);
    }

    public void setList(List<Aulas> novaLista) {
        lista = novaLista;
        fireTableRowsInserted(0, lista.size() - 1);
    }

    public void limparValoresDasCelulas() {
        List<Aulas> aula = new ArrayList();
        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 0; col < getColumnCount(); col++) {
                setList(aula);
            }
        }
    }
}
