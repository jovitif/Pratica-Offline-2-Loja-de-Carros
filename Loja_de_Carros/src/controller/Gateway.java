package controller;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import model.entity.Usuario;
import model.service.BaseBO;
import model.service.BaseInterBO;
import model.service.UsuarioBO;

public class Gateway {
    private static final int porta = 50005;
    
    public static void config() {
    	System.setProperty("java.rmi.server.hostname", "127.0.0.1");
    	/*
    	* Quando um objeto remoto é registrado
    	* em um servidor RMI, o servidor precisa
    	* informar aos clientes como se conectar
    	* a esse objeto. Uma das informações
    	* necessárias é o endereço IP ou nome
    	* de host do servidor. O mecanismo RMI do
    	* Java usa a propriedade do sistema
    	* "java.rmi.server.hostname" para determinar
    	* qual endereço IP ou nome de host o servidor
    	* deve usar para se registrar.
    	*/
    	System.setProperty("java.security.policy", "java.policy");
    	/*
    	* Ao definir a propriedade do sistema
    	* "java.security.policy" para um arquivo de
    	* política, como "java.policy", o programa
    	* Java informa ao ambiente de tempo
    	* de execução Java qual arquivo de
    	* política deve ser usado para determinar as
    	* permissões de segurança que o programa possui.
    	*/
    	/*
    	* O arquivo de política especifica as
    	* permissões concedidas a um aplicativo
    	* Java. Ele pode ser usado para limitar
    	* as operações que o aplicativo pode
    	* realizar, como ler ou gravar arquivos
    	* no sistema de arquivos, acessar
    	* recursos de rede, interagir com o
    	* sistema operacional ou executar código
    	* nativo.
    	*/
    	/*
    	if (System.getSecurityManager() == null) {
    	System.setSecurityManager(new SecurityManager());
    	}
    	*/
    	}
   

    public static void main(String[] args) {
    	
    }

	
}
