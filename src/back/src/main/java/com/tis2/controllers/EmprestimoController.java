package com.tis2.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tis2.models.DevolucaoRequest;
import com.tis2.models.Emprestimo;
import com.tis2.models.Livro;
import com.tis2.models.NovoEmprestimoRequest;
import com.tis2.models.Usuario;
import com.tis2.services.EmprestimoServices;
import com.tis2.services.LivroServices;
import com.tis2.services.UsuarioServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emprestimo")
@Validated
public class EmprestimoController {

    @Autowired
    private EmprestimoServices emprestimoService;

    @Autowired
    private UsuarioServices usuarioService;

    @Autowired
    private LivroServices livroService;

    @GetMapping
    public ResponseEntity<List<Emprestimo>> findAll() {
        List<Emprestimo> list = emprestimoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Long Id) {
        Emprestimo obj = emprestimoService.buscarPeloId(Id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/novo")
    public ResponseEntity<String> createEmprestimo(@Valid @RequestBody NovoEmprestimoRequest request) {
        // Verificar se o usuário existe
        Usuario usuario = usuarioService.findById(request.getUsuarioId());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        // Verificar se os livros existem e estão disponíveis
        List<Livro> livros = livroService.findAllById(request.getLivrosIds());
        if (livros.size() != request.getLivrosIds().size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Um ou mais livros não encontrados.");
        }
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O livro " + livro.getId() + " não está disponível.");
            }
        }

        // Criar o objeto de empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setLivros(livros);

        // Salvar o empréstimo
        emprestimoService.create(emprestimo);

        // Atualizar o status dos livros para indisponíveis
        for (Livro livro : livros) {
            livro.setDisponivel(false);
            livroService.save(livro);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Empréstimo criado com sucesso.");
    }

   @PostMapping("/devolver/{emprestimoId}")
public ResponseEntity<String> devolverEmprestimo(@PathVariable Long emprestimoId, @Valid @RequestBody DevolucaoRequest devolucaoRequest) {
    // Buscar o empréstimo pelo ID
    Emprestimo emprestimo = emprestimoService.buscarPeloId(emprestimoId);
    
    // Verificar se o empréstimo existe
    if (emprestimo == null) {
        return ResponseEntity.notFound().build();
    }
    
    // Verificar se o empréstimo já foi devolvido
    if (emprestimo.getDataDevolucao() != null) {
        return ResponseEntity.badRequest().body("O empréstimo já foi devolvido.");
    }
    
    // Atualizar os campos do empréstimo com os dados fornecidos na solicitação de devolução
    emprestimo.setDataDevolucao(devolucaoRequest.getDataDevolucao());
    emprestimo.setMotivoTaxa(devolucaoRequest.getMotivoTaxa());
    emprestimo.setTaxaExtra(devolucaoRequest.getTaxaExtra());
    
    // Calcular os valores de multa e valor do empréstimo
    BigDecimal multa = emprestimo.calcularMulta();
    BigDecimal valorEmprestimo = emprestimo.calcularPrecoTotal();
    emprestimo.setValorMulta(multa);
    emprestimo.setValorEmprestimo(valorEmprestimo);
    
    // Salvar as alterações do empréstimo no banco de dados
    emprestimoService.update(emprestimo);
    
    return ResponseEntity.ok().body("Empréstimo devolvido com sucesso.");
}


    @PutMapping("/{Id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Emprestimo obj, @PathVariable Long Id) {
        obj.setId(Id);
        emprestimoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id) {
        emprestimoService.delete(Id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<Emprestimo>> findAllByUserId(@PathVariable Long userId) {
        List<Emprestimo> objs = emprestimoService.findAllByUserId(userId);
        return ResponseEntity.ok().body(objs);
    }
}