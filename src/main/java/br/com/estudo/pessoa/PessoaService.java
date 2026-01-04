package br.com.estudo.pessoa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PessoaService {

  private final PessoaRepository repo;

  public PessoaService(PessoaRepository repo) {
    this.repo = repo;
  }

  public PessoaResponse criar(PessoaCreateRequest req) {
    var entidade = Pessoa.builder()
        .nome(req.nome())
        .idade(req.idade())
        .build();

    var salvo = repo.save(entidade);
    return toResponse(salvo);
  }

  public List<PessoaResponse> listar() {
    return repo.findAll()
        .stream()                 // Stream
        .map(this::toResponse)    // map
        .toList();
  }

  public Map<Integer, List<PessoaResponse>> agruparPorIdade() {
    return repo.findAll()
        .stream()
        .map(this::toResponse)
        .collect(Collectors.groupingBy(PessoaResponse::idade));
  }

  private PessoaResponse toResponse(Pessoa p) {
    return new PessoaResponse(p.getId(), p.getNome(), p.getIdade());
  }
}
