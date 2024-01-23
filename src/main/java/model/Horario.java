/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Gustavo
 */
@Entity
public class Horario implements Serializable {

    public Horario(String segunda, String terca, String quarta, String quinta, String sexta, String sabado) {
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
    }

    @Column
    String segunda;

    @Column
    String terca;

    @Column
    String quarta;

    @Column
    String quinta;

    @Column
    String sexta;

    @Column
    String sabado;

    public String getSegunda() {
        return segunda;
    }

    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }

    public String getTerca() {
        return terca;
    }

    public void setTerca(String terca) {
        this.terca = terca;
    }

    public String getQuarta() {
        return quarta;
    }

    public void setQuarta(String quarta) {
        this.quarta = quarta;
    }

    public String getQuinta() {
        return quinta;
    }

    public void setQuinta(String quinta) {
        this.quinta = quinta;
    }

    public String getSexta() {
        return sexta;
    }

    public void setSexta(String sexta) {
        this.sexta = sexta;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Horario() {
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @OneToOne(mappedBy = "horarios")
    //@MapsId
    @JoinColumn(name = "idHorario")
    private Turma turma;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idHorario;

    public int getId() {
        return idHorario;
    }

    @Override
    public String toString() {
        String horarios;
        horarios = getHorariosFormatados();
        
        return horarios;
    }

    public String getHorariosFormatados() {
        StringBuilder horariosFormatados = new StringBuilder();
        adicionarHorarioFormatado("Seg: ", segunda, horariosFormatados);
        adicionarHorarioFormatado("Ter: ", terca, horariosFormatados);
        adicionarHorarioFormatado("Qua: ", quarta, horariosFormatados);
        adicionarHorarioFormatado("Qui: ", quinta, horariosFormatados);
        adicionarHorarioFormatado("Sex: ", sexta, horariosFormatados);
        adicionarHorarioFormatado("Sab: ", sabado, horariosFormatados);
        return horariosFormatados.toString().trim();
    }

    private void adicionarHorarioFormatado(String prefixo, String horario, StringBuilder horariosFormatados) {
        if (!horario.isEmpty()) {
            horariosFormatados.append(prefixo).append(horario).append(" ");
        }
    }

}
