package br.com.estudo.pessoa;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

  private final PessoaService service;

  public PessoaController(PessoaService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PessoaResponse criar(@RequestBody @Valid PessoaCreateRequest req) {
    return service.criar(req);
  }

  @GetMapping
  public List<PessoaResponse> listar() {
    return service.listar();
  }

  @GetMapping("/agrupadas-por-idade")
  public Map<Integer, List<PessoaResponse>> agrupadasPorIdade() {
    return service.agruparPorIdade();
  }
}
