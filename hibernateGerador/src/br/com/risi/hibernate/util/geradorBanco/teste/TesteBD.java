package br.com.risi.hibernate.util.geradorBanco.teste;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.mock.MockTeste;
import br.com.risi.hibernate.model.teste.AndamentoProcesso;
import br.com.risi.hibernate.model.teste.Pessoa;
import br.com.risi.hibernate.model.teste.Processo;
import br.com.risi.hibernate.model.teste.Usuario;
import br.com.risi.hibernate.util.geradorBanco.HibernateUtil;

public class TesteBD {
	
	public static void main(String[] args) {

		// Cria as tabelas anotadas no Banco de Dados
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		
		// Executa o mock e popula o banco de Dados
		List<AndamentoProcesso> andamentos = MockTeste.complementaListaEntidade(AndamentoProcesso.class, 4);
		populaBancoComUsuariosMock(andamentos);

		List<Pessoa> pessoas = MockTeste.complementaListaEntidade(Pessoa.class, 8);
		populaBancoComUsuariosMock(pessoas);
		
		List<Processo> processos = MockTeste.complementaListaEntidade(Processo.class, 8);
		populaBancoComUsuariosMock(processos);
		
		List<Usuario> usuarios = MockTeste.complementaListaEntidade(Usuario.class, 8);
		populaBancoComUsuariosMock(usuarios);
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
