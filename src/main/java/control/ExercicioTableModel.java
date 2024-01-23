/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Exercicio;


/**
 *
 * @author Gustavo
 */
public class ExercicioTableModel extends AbstractTableModel{
    public ExercicioTableModel() {
    }

    List<Exercicio> lista = new ArrayList();

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public List<Exercicio> getLista() {
        return lista;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exercicio ex = lista.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                ex.getId();
            case 1 ->
                ex.getNome();
            case 2 ->
                ex.getFuncao();
            case 3 ->
                ex.getSeries();
            default ->
                "";
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        String colunas[] = {"Id ", "Nome", "Funcao", "Series"};
        return colunas[columnIndex];
    }

    public void adicionar(Exercicio ex) {
        lista.add(ex);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public Exercicio getExercicio(int row) {
        return lista.get(row);
    }

    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1, lista.size() - 1);
    }

    public void setList(List<Exercicio> novaLista) {
        lista = novaLista;
        fireTableRowsInserted(0, lista.size() - 1);
    }
    
    public void limparValoresDasCelulas() {
        List<Exercicio> ex = new ArrayList();
        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 0; col < getColumnCount(); col++) {
                setList(ex);
            }
        }
    }
}
