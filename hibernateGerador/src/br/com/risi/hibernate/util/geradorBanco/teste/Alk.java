package br.com.risi.hibernate.util.geradorBanco.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.risi.hibernate.model.teste.Teste;
import br.com.risi.hibernate.util.geradorBanco.HibernateUtil;


public class Alk {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Teste test = new Teste();
		test.setId(new Long(1));
		test.setNome("Wylliam teste de Conexao");
		Session session = HibernateUtil.getSessionfactory().openSession();

		
		try {
			session.getTransaction().begin();
			session.save(test);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

}
