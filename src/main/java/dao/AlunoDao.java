/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Aluno;
import model.Turma;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
public class AlunoDao extends GenericDao {

    public AlunoDao() {
    }

    private List<Aluno> pesquisar(String pesq, int tipo) {
        List<Aluno> lista = new ArrayList();
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // CRITERIA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Aluno.class);

            // TABELAS
            Root tabela = consulta.from(Aluno.class);

            tabela.fetch("turmas", JoinType.LEFT);
            consulta.distinct(true);

            //RESTRIÇÕES
            Predicate restricoes = null;
            switch (tipo) {
                // where nomeCliente LIKE 'pesq%'
                case 1:
                    restricoes = builder.like(tabela.get("cpf"), pesq + "%");
                    break;
                case 2:
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
                case 3:

                    Integer diaVencimento = Integer.parseInt(pesq);
                    restricoes = builder.equal(tabela.get("diaVencimento"), builder.literal(diaVencimento));
                    break;

                case 4:
                    Join<Turma, Aluno> turmaJoin = tabela.join("turmas");
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
            }

            consulta.where(restricoes);
            lista = sessao.createQuery(consulta).getResultList();
            sessao.getTransaction().commit();
            sessao.close();

        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
        return lista;

    }

    public List<Turma> carregarListaTurmas(Aluno aluno) {
        Session session = null;
        List<Turma> lista = new ArrayList<>();
        try {
            session = ConexaoHibernate.getSessionFactory().openSession();
            session.beginTransaction();

            // Verifica se a lista JÁ FOI CARREGADA
            if (!Hibernate.isInitialized(aluno.getTurmas())) {

                // Carrega o PROXY para outro objeto
                Aluno alunoTemp = session.get(Aluno.class, aluno.getId());

                // Carrega a lista de TURMAS
                lista = alunoTemp.getTurmas();

                // Carrega os dados do banco
                lista.size();

                // Atualiza a lista na aula passada como parâmetro
                aluno.setTurmas(lista);
            }

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new HibernateException(error);
        }
        return lista;
    }

//    public List<Aluno> pesquisarID(int id) {;
//        List<Aluno> lista = new ArrayList();
//        Aluno aln = (Aluno) get(Aluno.class, id);
//        lista.add(aln);
//        return lista;
//    }
    private List<Aluno> pesquisar() {

        return listar(Aluno.class);
    }

    public List<Aluno> pesquisarNome() {
        return pesquisar();
    }

    public List<Aluno> pesquisarNome(String pesq) {
        return pesquisar(pesq, 2);
    }

    public List<Aluno> pesquisarCPF(String pesq) {
        return pesquisar(pesq, 1);
    }

//    public List<Aluno> pesquisarCodigo(String pesq) {
    //       return pesquisar(pesq, 3);
    //   }
    public List<Aluno> pesquisarDiaVencimento(String pesq) {
        return pesquisar(pesq, 3);
    }

    public List<Aluno> pesquisarTurmas(String pesq) {
        return pesquisar(pesq, 4);
    }

}
