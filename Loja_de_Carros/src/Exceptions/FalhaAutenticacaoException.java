package Exceptions;

public class FalhaAutenticacaoException extends Exception {
	private static final long serialVersionUID = 1L;

	public FalhaAutenticacaoException() {
        super("Falha na autenticação do usuário.");
    }

    public FalhaAutenticacaoException(String message) {
        super(message);
    }

    public FalhaAutenticacaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
