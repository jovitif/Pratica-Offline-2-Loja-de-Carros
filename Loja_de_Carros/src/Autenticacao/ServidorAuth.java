package Autenticacao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Carros.Carro;

public class ServidorAuth implements UsuarioInterface {
    private List<Usuario> users;

    public ServidorAuth() {
        users = allUsers();
    }

    public static List<Usuario> allUsers() {
        List<Usuario> users = new ArrayList<>();
        users.add(new Usuario("joaosales", "@Joaosales1234", Permissao.funcionario));
        users.add(new Usuario("Tester", "#Tester1234", Permissao.cliente));
        users.add(new Usuario("Maria", "@Maria1234", Permissao.funcionario));
        users.add(new Usuario("Batman", "@Batman1234", Permissao.cliente));
        users.add(new Usuario("SeuBarriga", "@Barriguinha1234", Permissao.cliente));
        users.add(new Usuario("Francismo", "@Fran1234",Permissao.funcionario));
        return users;
    }

	@Override
	public Usuario comprarCarro(Carro carro, String comprador) throws RemoteException{
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getLogin().equals(comprador)) {
				users.get(i).adicionarCarro(carro);
				System.out.println("O usuário " + comprador + " acabou de comprar o carro:" + carro); 
				return users.get(i);
			}
		}
		return null;
	}

    
    @Override
    public Usuario autenticado(String login, String senha) throws RemoteException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login) && users.get(i).getSenha().equals(senha)) {
            	System.out.println("Novo usuário entrou no sistema: " + users.get(i).getLogin());
            	return users.get(i);
            }
        }
        return null;
    }
}

