package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.dto.Usuario;

public class UsuarioDao {

	private final EntityManagerFactory emf;

	public UsuarioDao() {
		super();
		this.emf = Persistence.createEntityManagerFactory("aplicativo");
	}

	public void salvar(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Usuario pesquisar(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email "
					+ "OR u.usuario = :usuario", Usuario.class)
			.setParameter("email", usuario.getEmail())
			.setParameter("usuario", usuario.getUsuario())
			.getSingleResult();
		}catch(Exception e) {
			return null;
		}finally {
			em.close();
		}
	}

}
