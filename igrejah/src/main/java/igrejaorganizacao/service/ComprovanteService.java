package igrejaorganizacao.service;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import igrejaorganizacao.entity.Comprovante;
import igrejaorganizacao.repository.ComprovanteRepository;

@Service
public class ComprovanteService {
	
	private final ComprovanteRepository repository;

	public ComprovanteService(ComprovanteRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Comprovante salvar(MultipartFile arquivo, String descriçao)
		throws IOException{
			if (arquivo.isEmpty()) {
				throw new IllegalArgumentException("O arquivo não pode estar vazio!");
			}
		Comprovante comprovante = new Comprovante();
		
		comprovante.setDescriçao(descriçao);
		
		comprovante.setData(LocalDateTime.now());
		
		comprovante.setArquivo(arquivo.getBytes());
		
		return repository.save(comprovante);
		
	}
	
    public Comprovante buscarPorId(Long id) {
        return repository.findById(id)          
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "Comprovante não encontrado!"
                )
            );
    }
}
	

