package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crud.ConnectionFactory;
import modelo.Contato;

public class ContatoDao {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Contato contato) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO contatos(nome,idade,datacadastro)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectiontoMYSQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, contato.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, contato.getIdade());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(contato.getDatacadastro().getTime()));

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM contatos WHERE id = ?";

		try {
			conn = ConnectionFactory.createConnectiontoMYSQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Contato contato) {

		String sql = "UPDATE destino SET estado = ?, cidade = ?, dataDoDestino = ?" + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectiontoMYSQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, contato.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, contato.getIdade());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(contato.getDatacadastro().getTime()));
		
			pstm.setInt(4, contato.getId());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Contato> getContatos() {

		String sql = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<Contato>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectiontoMYSQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Contato contato = new Contato();

				// Recupera o id do banco e atribui ele ao objeto
				contato.setId(rset.getInt("id"));

				// Recupera o estado do banco e atribui ele ao objeto
				contato.setNome(rset.getString("nome"));

				// Recupera a cidade do banco e atribui ele ao objeto
				contato.setIdade(rset.getString("idade"));

				// Recupera a data do banco e atribui ela ao objeto
				contato.setDatacadastro(rset.getDate("datacadastro"));

				// Adiciono o destino recuperado, a lista de destinos
				contatos.add(contato);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return contatos;
	}

	public Contato getContatoById(int id) {

		String sql = "SELECT * FROM contatos where id = ?";
		Contato contato = new Contato();

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectiontoMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();
			contato.setId(rset.getInt("id"));

			// Recupera o estado do banco e atribui ele ao objeto
			contato.setNome(rset.getString("nome"));

			// Recupera a cidade do banco e atribui ele ao objeto
			contato.setIdade(rset.getString("idade"));

			// Recupera a data do banco e atribui ela ao objeto
			contato.setDatacadastro(rset.getDate("datacadastro"));

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contato;
	}

}
