/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aluno;

import model.AlunoProfessorExercicio;


/**
 *
 * @author Gustavo
 */
public class AlunoProfessorExercicioTableModel extends AbstractTableModel {

    List<AlunoProfessorExercicio> lista = new ArrayList();


    public AlunoProfessorExercicioTableModel() {
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AlunoProfessorExercicio alProfEx = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                alProfEx.getChavePK().getAluno().getNome();
            case 1 ->
                alProfEx.getChavePK().getProfessor().getNome();
            case 2 ->
                alProfEx.getChavePK().getExercicio().getNome();
            default ->
                "";
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        String colunas[] = {"Nome do Aluno", "Nome do Professor", "Nome do Exercício"};
        return colunas[columnIndex];
    }

    public void adicionar(AlunoProfessorExercicio alPrEx) {
        lista.add(alPrEx);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public AlunoProfessorExercicio get(int row) {
        return lista.get(row);
    }

    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1, lista.size() - 1);
    }

    public void setList(List<AlunoProfessorExercicio> novaLista) {
        lista = novaLista;
        fireTableRowsInserted(0, lista.size() - 1);
    }
    
        public void limparValoresDasCelulas() {
        List<AlunoProfessorExercicio> alunoProfEx = new ArrayList();
        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 0; col < getColumnCount(); col++) {
                setList(alunoProfEx);
            }
        }
    }

}