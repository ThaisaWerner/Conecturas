package com.tw.spring.service;

import com.tw.spring.controller.pedido.PedidoRequest;
import com.tw.spring.controller.pedido.PedidoResponse;
import com.tw.spring.controller.pedido.PedidoUpdateRequest;
import com.tw.spring.controller.pedido.PedidoUpdateResponse;
import com.tw.spring.exception.DefaultException;
import com.tw.spring.model.ClienteBeneficiario;
import com.tw.spring.model.ClienteDoador;
import com.tw.spring.model.Livro;
import com.tw.spring.model.Pedido;
import com.tw.spring.repository.ClienteBeneficiarioRepository;
import com.tw.spring.repository.ClienteDoadorRepository;
import com.tw.spring.repository.LivrosRepository;
import com.tw.spring.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
@AllArgsConstructor
public class PedidoService {

    private static final String SOLICITADO = "SOLICITADO";
    private static final String ADOTADO = "ADOTADO";
    private static final String ENVIADO = "ENVIADO";
    private static final String RECEBIDO = "RECEBIDO";

    private final PedidoRepository pedidoRepository;
    private final LivrosRepository livrosRepository;
    private final ClienteDoadorRepository doadorRepository;
    private final ClienteBeneficiarioRepository beneficiarioRepository;

    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {
        ClienteBeneficiario beneficiarioEncontrado = beneficiarioRepository
                .findById(pedidoRequest.getIdBeneficiario())
                .orElseThrow(() -> new DefaultException(NOT_FOUND, "Usuário não encontrado."));

        List<Livro> livros = livrosRepository.findAllById(pedidoRequest.getIdLivros());

        List<Long> listaDeIdsLivrosRetornoDoBanco = livros.stream()
                .map(Livro::getId)
                .collect(Collectors.toList());

        List<Long> diferencaEntreLivrosEncontradosESolicitados = pedidoRequest.getIdLivros().stream()
                .filter(idLivro -> !listaDeIdsLivrosRetornoDoBanco.contains(idLivro))
                .collect(Collectors.toList());

        if(diferencaEntreLivrosEncontradosESolicitados.size() > 0) {
            String ids = diferencaEntreLivrosEncontradosESolicitados.stream().map(Object::toString).collect(Collectors.joining(","));
            throw new DefaultException(BAD_REQUEST, "O(s) livro(s) " + ids + " não foram encontrados");
        }

        Pedido pedidoASerSalvo = new Pedido(null, pedidoRequest.getDescricao(), new Date(), null,
                beneficiarioEncontrado, livros, SOLICITADO);

        Pedido pedidoSalvo = pedidoRepository.save(pedidoASerSalvo);

        return pedidoSalvo.convertToResponse();
    }
    public PedidoResponse buscaPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido
                .orElseThrow(() -> new DefaultException(NOT_FOUND, "Pedido não encontrado"))
                .convertToResponse();
    }

    public PedidoUpdateResponse atualizarPedido(Long id, PedidoUpdateRequest request) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new DefaultException(NOT_FOUND, "Pedido não encontrado"));

        if (ADOTADO.equalsIgnoreCase(request.getStatus())) {
            return adotarPedido(pedido, request.getIdClienteDoador());
        }

        if (ENVIADO.equalsIgnoreCase(request.getStatus())) {
            return enviarPedido(pedido);
        }

        if (RECEBIDO.equalsIgnoreCase(request.getStatus())) {
            return receberPedido(pedido);
        }

        throw new DefaultException(BAD_REQUEST, "Status " + request.getStatus() + " é inválido");
    }

    public void excluirPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new DefaultException(NOT_FOUND, "Pedido não encontrado"));

        if (!pedido.getStatus().equalsIgnoreCase(SOLICITADO)) {
            throw new DefaultException(BAD_REQUEST, "Pedido não pode ser excluido pois o status é diferente de solicitado");
        }

        pedidoRepository.delete(pedido);
    }

    private PedidoUpdateResponse adotarPedido(Pedido pedido, Long idClienteDoador) {
        if (!SOLICITADO.equalsIgnoreCase(pedido.getStatus())) {
            throw new DefaultException(BAD_REQUEST, "Pedido " + pedido.getId() + " não pode ser adotado pois seu status atual é diferente de " + SOLICITADO );
        }
        if (idClienteDoador == null) {
            throw new DefaultException(BAD_REQUEST, "idClienteDoador é obrigatório quando o status do pedido for " + ADOTADO);
        }

        ClienteDoador clienteDoador = doadorRepository.findById(idClienteDoador)
                .orElseThrow(() -> new DefaultException(BAD_REQUEST, "Clinte doador " + idClienteDoador + " não encontrado"));

        pedido.setStatus(ADOTADO);
        pedido.setClienteDoador(clienteDoador);

        pedidoRepository.save(pedido);

        return new PedidoUpdateResponse(pedido.getId(), pedido.getStatus());

    }

    private PedidoUpdateResponse enviarPedido(Pedido pedido) {
        if (!ADOTADO.equalsIgnoreCase(pedido.getStatus())) {
            throw new DefaultException(BAD_REQUEST, "Pedido " + pedido.getId() + " não pode ser enviado pois seu status atual é diferente de " + ADOTADO );
        }

        pedido.setStatus(ENVIADO);

        pedidoRepository.save(pedido);

        return new PedidoUpdateResponse(pedido.getId(), pedido.getStatus());

    }

    private PedidoUpdateResponse receberPedido(Pedido pedido) {
        if (!ENVIADO.equalsIgnoreCase(pedido.getStatus())) {
            throw new DefaultException(BAD_REQUEST, "Pedido " + pedido.getId() + " não pode ser recebido pois seu status atual é diferente de " + ENVIADO );
        }

        pedido.setStatus(RECEBIDO);

        pedidoRepository.save(pedido);

        return new PedidoUpdateResponse(pedido.getId(), pedido.getStatus());

    }
}
