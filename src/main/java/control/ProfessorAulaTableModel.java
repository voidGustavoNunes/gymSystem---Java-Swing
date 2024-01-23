/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Professor;

/**
 *
 * @author Gustavo
 */
public class ProfessorAulaTableModel extends AbstractTableModel {

    List<Professor> lista = new ArrayList();

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Professor pro = lista.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                pro.getId();
            case 1 ->
                pro.getNome();
            case 2 ->
                pro.getCpf();
            case 3 ->
                pro.getNumeroRegistro();
            case 4 ->
                pro.getSituacao();
            case 5 ->
                pro.getTelefone();
            case 6 ->
                pro.getFoto();

            default ->
                "";
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        String colunas[] = {"IdProfessor", "Nome", "Cpf", "NumerodeRegistro", "Situacao", "Telefone", "Foto"};
        return colunas[columnIndex];
    }

    public void adicionar(Professor pro) {
        lista.add(pro);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public Professor getProfessor(int row) {
        return lista.get(row);
    }

    public List<Professor> getLista() {
        return lista;
    }

    public void limpar() {
        int rowCount = getRowCount();
        lista.clear();

        fireTableRowsDeleted(0, rowCount - 1);
    }

    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1, lista.size() - 1);
    }

    public void setList(List<Professor> novaLista) {
        lista = novaLista;
        fireTableRowsInserted(0, lista.size() - 1);
    }

    public ProfessorAulaTableModel() {
    }

    public void limparValoresDasCelulas() {
        List<Professor> professor = new ArrayList();

        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 0; col < getColumnCount(); col++) {
                setList(professor);
            }
        }
    }

    public boolean contemProfessor(Professor professor) {
        return lista.contains(professor);
    }

}
