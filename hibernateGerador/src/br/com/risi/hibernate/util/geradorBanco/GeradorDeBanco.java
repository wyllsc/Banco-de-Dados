package br.com.risi.hibernate.util.geradorBanco;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeradorDeBanco
{
	public static void main(String[] args) {

		// Cria as tabelas anotadas no Banco de Dados
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		
		// TODO Executa o mock e popula o banco de Dados Substituir o ? pela Entidade a ser criada
		
		// List<???> andamentos = MockTeste.complementaListaEntidade(???.class, 4);
		// populaBancoComUsuariosMock(andamentos);

	}
	
	/**
	 * Método responsável por adicionar a lista no Banco
	 * @param List<T> - lista de entidade mockada
	 */
	public static <T>  void populaBancoComUsuariosMock(List<T> entidade){
		for (T ent : entidade) {
			Session session = HibernateUtil.getSessionfactory().openSession();
			try {
				session.getTransaction().begin();
				session.save(ent);
				session.getTransaction().commit();
			} catch (HibernateException ex) {
				ex.printStackTrace();
			} finally {
				session.close();
			}
		}
	}
}
