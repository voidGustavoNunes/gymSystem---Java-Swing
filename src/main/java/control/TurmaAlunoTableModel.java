/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aluno;
import model.Turma;

/**
 *
 * @author Gustavo
 */
public class TurmaAlunoTableModel extends AbstractTableModel {

    List<Aluno> lista = new ArrayList();

    public TurmaAlunoTableModel() {
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                aluno.getId();
            case 1 ->
                aluno.getNome();
            case 2 ->
                aluno.getCpf();
            case 3 ->
                aluno.getGenero();
            case 4 ->
                aluno.getSituacao();
            case 5 ->
                aluno.getProfissao();
            default ->
                "";
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        String colunas[] = {"Codigo", "Nome", "Cpf", "Gênero", "Situção", "Profissão"};
        return colunas[columnIndex];
    }

    public void adicionar(Aluno aluno) {
        lista.add(aluno);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public Aluno getAluno(int row) {
        return lista.get(row);
    }

    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1, lista.size() - 1);
    }

    public void setList(List<Aluno> novaLista) {
        lista = novaLista;
        fireTableRowsInserted(0, lista.size() - 1);
    }

    public void limparValoresDasCelulas() {
        List<Aluno> aluno = new ArrayList();
        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 0; col < getColumnCount(); col++) {
                setList(aluno);
            }
        }
    }

    public boolean contemAluno(Aluno aluno) {
        return lista.contains(aluno);
    }
}
