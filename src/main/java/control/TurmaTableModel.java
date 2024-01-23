/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Exercicio;
import model.Turma;

/**
 *
 * @author Gustavo
 */
public class TurmaTableModel extends AbstractTableModel{

    public TurmaTableModel() {
    }

    public List<Turma> getLista() {
        return lista;
    }

    List<Turma> lista = new ArrayList();

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
        Turma turma = lista.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                turma.getIdTurma();
            case 1 ->
                turma.getNome();
            case 2 ->
                turma.getAulas().getTipo();
            case 3 ->
                turma.getHorarios().getHorariosFormatados();
            default ->
                "";
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        String colunas[] = {"Id ", "Nome", "Aula", "Horarios"};
        return colunas[columnIndex];
    }

    public void adicionar(Turma turma) {
        lista.add(turma);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public Turma getTurma(int row) {
        return lista.get(row);
    }

    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1, lista.size() - 1);
    }

    public void setList(List<Turma> novaLista) {
        lista = novaLista;
        fireTableRowsInserted(0, lista.size() - 1);
    }
    
    public void limparValoresDasCelulas() {
        List<Turma> turma = new ArrayList();
        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 0; col < getColumnCount(); col++) {
                setList(turma);
            }
        }
    }
    
}
