/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.AlunoDao;
import dao.AlunoProfExercicioDao;
import dao.AulasDao;
import dao.ConexaoAjuda;
import dao.ConexaoHibernate;
import dao.ExercicioDao;
import dao.GenericDao;
import dao.ProfessorDao;
import dao.TurmaDao;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import model.Aluno;
import model.AlunoProfessorExercicio;
import model.Aulas;
import model.Exercicio;
import model.Professor;
import model.Turma;
import org.hibernate.HibernateException;

/**
 *
 * @author Gustavo
 */
public class GerenciadorDominio {

    private AlunoDao alunoDao;
    private ProfessorDao professorDao;
    private AulasDao aulasDao;
    private TurmaDao turmaDao;
    private ExercicioDao exDao;
    private ConexaoAjuda conAj;
    private AlunoProfExercicioDao alProfExDao;

    public AlunoProfExercicioDao getAlProfExDao() {
        return alProfExDao;
    }

    FuncoesUteis fun;

    GenericDao genDao = new GenericDao();

    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory();
        aulasDao = new AulasDao();
        professorDao = new ProfessorDao();
        alunoDao = new AlunoDao();
        turmaDao = new TurmaDao();
        exDao = new ExercicioDao();
        conAj = new ConexaoAjuda();
        genDao = new GenericDao();
        alProfExDao = new AlunoProfExercicioDao();

    }

    public GenericDao getGenDao() {
        return genDao;
    }

    public ProfessorDao getProfessorDao() {
        return professorDao;
    }

    public int inserirAula(String tipo, int id) {
        Aulas aulas = new Aulas(tipo, id);

        genDao.inserir(aulas);

        return aulas.getIdAula();
    }

    public ConexaoAjuda getConAj() {
        return conAj;
    }

    public List listar(Class classe) throws HibernateException {
        return genDao.listar(classe);
    }

    //COM FOTO, ID E PESSOA INDICACAO
    public int inserirAluno(int id, String profissao, int diaVencimento, boolean indicacao, String pessoaIndicacao, String nome, String cpf, Date dtNascimento, String endereco, String telefone, String bairro, char genero, String cidade, String observacao, Icon foto, Date dtCadastro, String senha, String situacao, int numero) throws HibernateException {
        Aluno aluno = new Aluno(id, profissao, diaVencimento, indicacao, pessoaIndicacao, nome, cpf, dtNascimento, endereco, telefone, bairro, genero, cidade, observacao, FuncoesUteis.IconToBytes(foto), dtCadastro, senha, situacao, numero);

        genDao.inserir(aluno);

        return aluno.getId();
    }

    public int inserirProfessor(String situacao, String numeroRegistro, boolean usuarioMaster, String nome, String cpf, Date dtNascimento, String endereco, String telefone, String bairro, char genero, String cidade, String observacao, Icon foto, Date dtCadastro, String senha, int id, int numero, String formacao, String instagram) throws HibernateException {
        Professor professor = new Professor(situacao, numeroRegistro, usuarioMaster, nome, cpf, dtNascimento, endereco, telefone, bairro, genero, cidade, observacao, FuncoesUteis.IconToBytes(foto), dtCadastro, senha, id, numero, formacao, instagram);
        
        //setando apos a criacao de professor evito o erro de null pointer para esses tres atributos devido nao serem nullables
        professor.setInstagram(instagram);
        professor.setFormacao(formacao);
        professor.setUsuarioMaster(usuarioMaster);
        genDao.inserir(professor);

        return professor.getId();
    }

    public int inserirExercicio(String nome, String funcao, int series, int repeticoesPorSerie, String idadeRecomendada, String tipo) throws HibernateException {

        Exercicio exercicio = new Exercicio(nome, funcao, series, repeticoesPorSerie, idadeRecomendada, tipo);

        genDao.inserir(exercicio);

        return exercicio.getId();

    }

    public void excluir(Object obj) throws HibernateException {
        genDao.excluir(obj);

    }

    public List<Aluno> pesquisarAluno(String pesq, int tipo) throws HibernateException {
        List<Aluno> lista = null;
        switch (tipo) {
            case 1:
                lista = alunoDao.pesquisarCPF(pesq);
                break;
            case 2:
                lista = alunoDao.pesquisarNome(pesq);
                break;
            case 3:
                if (pesq == null || pesq.equals(" ") || pesq.equals("")) { //recuperar todos os alunos do banco
                    lista = alunoDao.pesquisarNome(pesq);
                    break;
                } else {
                    lista = alunoDao.pesquisarDiaVencimento(pesq);
                    break;
                }
            case 4:
                lista = alunoDao.pesquisarTurmas(pesq);
                break;

        }
        return lista;
    }

    public List<Professor> pesquisarProfessor(String pesq, int tipo) throws HibernateException {
        List<Professor> lista = null;
        switch (tipo) {
            case 1:
                lista = professorDao.pesquisarNome(pesq);
                break;
            case 2:
                lista = professorDao.pesquisarCPF(pesq);
                break;
            case 3:
                lista = professorDao.pesquisarNumeroRegistro(pesq);
                break;


        }
        return lista;

    }

    public List<Exercicio> pesquisarExercicio(String pesq, int tipo) throws HibernateException {
        List<Exercicio> lista = null;
        switch (tipo) {
            case 1:
                int id = Integer.parseInt(pesq);
                lista = exDao.pesquisarID(id);
                break;
            case 2:
                lista = exDao.pesquisarNome(pesq);
                break;
            case 3:
                lista = exDao.pesquisarFuncao(pesq);
                break;
            case 4:
                lista = exDao.pesquisarSerie(pesq);
                break;
        }
        return lista;

    }

    public List<Turma> pesquisarTurma(String pesq, int tipo) throws HibernateException {
        List<Turma> lista = null;
        switch (tipo) {
            case 1:
                lista = turmaDao.pesquisarListaNome(pesq);
                break;
            case 2:
                lista = turmaDao.pesquisarAulas(pesq);
                break;

        }
        return lista;

    }

    public List<Aulas> pesquisarAulas(String pesq, int tipo) throws HibernateException {
        List<Aulas> lista = null;
        switch (tipo) {
            case 1:
                int id = Integer.parseInt(pesq);
                lista = aulasDao.pesquisarID(pesq,id);

                break;

            case 2:
                lista = aulasDao.pesquisarNome(pesq);
                break;
        }
        return lista;

    }

    public List<Professor> pesquisarProfessor() throws HibernateException {
        List<Professor> lista = null;

        lista = professorDao.pesquisarNome();

        return lista;
    }

    public List<Aulas> pesquisarAulas() throws HibernateException {
        List<Aulas> lista = null;

        lista = aulasDao.pesquisarNome();

        return lista;
    }

    public Turma pesquisarTurma(String pesq) {
        Turma turma = null;

        turma = turmaDao.pesquisarNome(pesq);

        return turma;

    }

    public AlunoDao getAlunoDao() {
        return alunoDao;
    }

    public AulasDao getAulasDao() {
        return aulasDao;
    }

    public TurmaDao getTurmaDao() {
        return turmaDao;
    }

    public ExercicioDao getExDao() {
        return exDao;
    }

    public List<Aluno> pesquisarAluno() {
        List<Aluno> lista = null;

        lista = alunoDao.pesquisarNome();

        return lista;

    }

    public List<Exercicio> pesquisarNomeExercicio(String pesq) {
        List<Exercicio> lista = null;

        lista = exDao.pesquisarNome(pesq);

        return lista;

    }

    public List<Turma> retornaListaTurma(Aulas aula) {
        List<Turma> lista = null;

        lista = aulasDao.carregarListaTurmas(aula);

        return lista;

    }

    public int inserirAlProfEx(AlunoProfessorExercicio ex) {
        alProfExDao.inserir(ex);

        return ex.getChavePK().getAluno().getId();
    }

    public int alterarExericio(AlunoProfessorExercicio ex) {
        alProfExDao.alterar(ex);

        return ex.getChavePK().getExercicio().getId();
    }

    public List<Exercicio> pesquisar() {
        List<Exercicio> lista = null;

        lista = exDao.pesquisar();

        return lista;
    }

    public int inserirTurma(Aulas aulas, String nome, String segunda, String terca, String quarta, String quinta, String sexta, String sabado) {

        Turma turma = new Turma(aulas, nome, segunda, terca, quarta, quinta, sexta, sabado);

        genDao.inserir(turma);
        turmaDao.adicionarTurmaAulas(aulas, turma); //resolvendo problema do lazyException
        

        return turma.getIdTurma();
    }

    public int alterarTurma(Turma turmaSelecionada, Aulas aula, String nome, String segunda, String terca, String quarta, String quinta, String sexta, String sabado) {
        turmaSelecionada.setAulas(aula);
        turmaSelecionada.setNome(nome);
        turmaSelecionada.getHorarios().setSegunda(segunda);
        turmaSelecionada.getHorarios().setTerca(terca);
        turmaSelecionada.getHorarios().setQuarta(quarta);
        turmaSelecionada.getHorarios().setQuinta(quinta);
        turmaSelecionada.getHorarios().setSexta(sexta);
        turmaSelecionada.getHorarios().setSabado(sabado);

        turmaDao.alterar(turmaSelecionada);

        return turmaSelecionada.getIdTurma();

    }

    public int alterarAluno(Aluno aluno, int id, String profissao, int diaVencimento, boolean indicacao,
            String pessoaIndicacao, String nome, String cpf, Date dtNascimento, String endereco, String telefone,
            String bairro, char genero, String cidade, String observacao, Icon foto, Date dtCadastro, String senha,
            String situacao, int numero) {
        aluno.setId(id);
        aluno.setProfissao(profissao);
        aluno.setDiaVencimento(diaVencimento);
        aluno.setIndicacao(indicacao);
        aluno.setPessoaIndicacao(pessoaIndicacao);
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setDtNascimento(dtNascimento);
        aluno.setEndereco(endereco);
        aluno.setTelefone(telefone);
        aluno.setBairro(bairro);
        aluno.setGenero(genero);
        aluno.setCidade(cidade);
        aluno.setObservacao(observacao);
        aluno.setFoto(FuncoesUteis.IconToBytes(foto));
        aluno.setDtCadastro(dtCadastro);
        aluno.setSenha(senha);
        aluno.setSituacao(situacao);
        aluno.setNumero(numero);

        alunoDao.alterar(aluno);

        return aluno.getId();
    }

    public int alterarProfessor(Professor professor, String situacao, String numeroRegistro, boolean usuarioMaster,
            String nome, String cpf, Date dtNascimento, String endereco, String telefone, String bairro, char genero,
            String cidade, String observacao, Icon foto, Date dtCadastro, String senha, int id, int numero,
            String formacao, String instagram) {

        professor.setSituacao(situacao);
        professor.setNumeroRegistro(numeroRegistro);
        professor.setUsuarioMaster(usuarioMaster);
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setDtNascimento(dtNascimento);
        professor.setEndereco(endereco);
        professor.setTelefone(telefone);
        professor.setBairro(bairro);
        professor.setGenero(genero);
        professor.setCidade(cidade);
        professor.setObservacao(observacao);
        professor.setFoto(FuncoesUteis.IconToBytes(foto));
        professor.setDtCadastro(dtCadastro);
        professor.setSenha(senha);
        professor.setId(id);
        professor.setNumero(numero);
        professor.setFormacao(formacao);
        professor.setInstagram(instagram);

        professorDao.alterar(professor);

        return professor.getId();
    }

    public int alterarAula(Aulas aula, int id, String nome) {
        aula.setIdAula(id);
        aula.setTipo(nome);
        aulasDao.alterar(aula);

        return aula.getIdAula();

    }

    public int alterarExercicio(Exercicio ex, String nome, String funcao, int series, int repeticoesPorSerie, String idadeRecomendada, String tipo) {
        ex.setNome(nome);
        ex.setFuncao(funcao);
        ex.setSeries(series);
        ex.setRepeticoesPorSerie(repeticoesPorSerie);
        ex.setIdadeRecomendada(idadeRecomendada);
        ex.setTipo(tipo);

        exDao.alterar(ex);
        return ex.getId();
    }

}
