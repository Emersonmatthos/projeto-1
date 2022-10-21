package crud;

import java.util.Date;

import dao.ContatoDao;
import modelo.Contato;

public class contatoCrud {

	public static void main(String[] args) {
		ContatoDao contatodao = new ContatoDao();

		// Contato c1 = new Contato(1, "João", "22", new Date());

		// contatodao.save(c1);
		// System.out.println(c1.getNome());
		contatodao.removeById(1);
		
		for (Contato c : contatodao.getContatos()) {
			System.out.println(c.toString());
		}

	}

}
