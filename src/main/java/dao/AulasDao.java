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
import model.Aulas;
import model.Professor;
import model.Turma;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
public class AulasDao extends GenericDao {

    public AulasDao() {
    }

    private List<Aulas> pesquisar(String pesq, int tipo) {
        List<Aulas> lista = new ArrayList();

        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // CRITERIA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Aulas.class);

            // TABELAS
            Root tabela = consulta.from(Aulas.class);

            tabela.fetch("turmas", JoinType.INNER);
            consulta.distinct(true);

            //RESTRIÇÕES
            Predicate restricoes = null;
            switch (tipo) {
                
                
                case 2:
                    restricoes = builder.like(tabela.get("tipo"), pesq + "%");
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
        return listar(Aulas.class);
    }

    public List<Turma> carregarListaTurmas(Aulas aula) {
        Session session = null;
        List<Turma> lista = new ArrayList<>();
        try {
            session = ConexaoHibernate.getSessionFactory().openSession();
            session.beginTransaction();

            // Verifica se a lista JÁ FOI CARREGADA
            if (!Hibernate.isInitialized(aula.getTurmas())) {

                // Carrega o PROXY para outro objeto
                Aulas aulaTemp = session.get(Aulas.class, aula.getIdAula());

                // Carrega a lista de TURMAS
                lista = aulaTemp.getTurmas();

                // Carrega os dados do banco
                lista.size();

                // Atualiza a lista na aula passada como parâmetro
                aula.setTurmas(lista);
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

    public List<Aulas> pesquisarNome(String pesq) {

        return pesquisar(pesq, 2);
    }

    private List<Aulas> pesquisar() {
        //List<Cliente> lista = new ArrayList();

        //return lista;
        // TESTE
        return listar(Aulas.class);
    }

    public List<Aulas> pesquisarNome() {
        return pesquisar();
    }

    public List<Aulas> pesquisarID(String pesq, int id) {
        List<Aulas> lista = new ArrayList();
        Aulas ped = (Aulas) load(Aulas.class, id);
        lista.add(ped);
        if (lista.size() == 0) {
            lista = pesquisar(pesq, 2);
        }
        return lista;
    }

    public List<Aulas> pesquisarProfessor(String pesq) {
        return pesquisar(pesq, 3);
    }

}
