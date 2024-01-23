package control;

import javax.swing.table.AbstractTableModel;
import model.Horario;

public class HorarioTableModel extends AbstractTableModel {

    private Horario horario;

    public HorarioTableModel() {
        this.horario = new Horario();
    }

    @Override
    public int getRowCount() {
        // Define a quantidade de linhas conforme a estrutura do objeto Horario
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 6; // Número de colunas para os dias da semana
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (horario.getSegunda() != null) ? horario.getSegunda() : "";
            case 1:
                return (horario.getTerca() != null) ? horario.getTerca() : "";
            case 2:
                return (horario.getQuarta() != null) ? horario.getQuarta() : "";
            case 3:
                return (horario.getQuinta() != null) ? horario.getQuinta() : "";
            case 4:
                return (horario.getSexta() != null) ? horario.getSexta() : "";
            case 5:
                return (horario.getSabado() != null) ? horario.getSabado() : "";
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        String colunas[] = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        return colunas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; // Todas as células serão editáveis
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                horario.setSegunda((String) value);
                break;
            case 1:
                horario.setTerca((String) value);
                break;
            case 2:
                horario.setQuarta((String) value);
                break;
            case 3:
                horario.setQuinta((String) value);
                break;
            case 4:
                horario.setSexta((String) value);
                break;
            case 5:
                horario.setSabado((String) value);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
        fireTableDataChanged(); // Notifica a tabela sobre a mudança nos dados
    }

    public void limparValoresDasCelulas() {
        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 0; col < getColumnCount(); col++) {
                setValueAt("", row, col);
            }
        }
    }
    
    
}
