/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Gustavo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable{
    
    @Column (name="nomePessoa", length = 200, nullable = false)
    String nome;
    
    @Column (length = 14 ,nullable = false)
    String cpf;
    
    @Temporal (TemporalType.DATE)
    @Column (nullable = false, updatable = false)
    Date dtNascimento;
    
    @Column (nullable = false)
    String endereco;
    
    @Column (nullable = false)
    String telefone;
    
    @Column (nullable = false)
    String bairro;
    
    @Column (length = 1)
    char genero;
    
    @Column (nullable = false)
    String cidade;
    
    String observacao;
    
    @Lob
    private byte[] foto;
    
    
    String situacao;
    
    @Column( updatable = false) //nao pode ser alterado
    Date dtCadastro;
    
    @Size(min = 6) // Defina o tamanho mínimo da senha
    @Column (nullable = false)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()-_+=])[a-zA-Z0-9!@#$%^&*()-_+=]*$", message = "A senha deve conter pelo menos uma letra maiúscula, um número e um caractere especial !@#$%^&*()-_+=")
    String senha;
    
    @Id
    //@GeneratedValue( strategy = GenerationType.) //autonumeracao por cada tabela
    int id;
    
    int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }



    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getCidade() {
        return cidade;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }



    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    


    public Pessoa(String nome, String cpf, Date dtNascimento, String endereco, String telefone, String bairro, char genero, String cidade, String observacao, Date dtCadastro, String senha, int id, String situacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.genero = genero;
        this.cidade = cidade;
        this.observacao = observacao;
        this.dtCadastro = dtCadastro;
        this.senha = senha;
        this.id = id;
        this.situacao = situacao;
    }

    public Pessoa(String nome, String cpf, Date dtNascimento, String endereco, String telefone, String bairro, char genero, String cidade, String observacao, byte[] foto, Date dtCadastro, String senha, int id, String situacao, int numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.genero = genero;
        this.cidade = cidade;
        this.observacao = observacao;
        this.foto = foto;
        this.dtCadastro = dtCadastro;
        this.senha = senha;
        this.id = id;
        this.situacao = situacao;
        this.numero = numero;
    }
    
    

    public Pessoa() {
    }
    
}
