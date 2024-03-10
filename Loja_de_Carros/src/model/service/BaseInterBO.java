package model.service;

import java.util.List;

public interface BaseInterBO <VO>{
	public boolean adicionar(VO vo) throws Exception;
	public VO buscarPorNome(VO vo) throws Exception;
	public VO buscarPorRenavam(VO vo) throws Exception;
	public List<VO> listar() throws Exception;
	public boolean atualizar(VO vo) throws Exception;
	public boolean apagar(VO vo) throws Exception;
}
