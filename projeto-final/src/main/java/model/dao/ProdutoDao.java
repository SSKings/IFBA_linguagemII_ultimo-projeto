package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.dto.Produto;

public class ProdutoDao {

	private final EntityManagerFactory emf;

	public ProdutoDao() {

		this.emf = Persistence.createEntityManagerFactory("aplicativo");
	}

	public void cadastrar(Produto produto) {

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		}catch(Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}

	public List<Produto> listar(){
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("FROM Produto", Produto.class).getResultList();
		}catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}

	public void alterar(Produto produto) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(produto);
			em.getTransaction().commit();
		}catch(Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void excluir(Produto produto) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Produto p = em.merge(produto);
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}

	public Produto pesquisar(Produto produto){
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Produto.class, produto.getCod());
		}catch (Exception e) {
			return null;
		}finally {
			em.close();
		}


	}
}
