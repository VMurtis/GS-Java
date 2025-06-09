package br.com.fiap.gs.service;

import br.com.fiap.gs.dto.Desabrigado.DesabrigadoDto;
import br.com.fiap.gs.dto.Desabrigado.DesabrigadoGetDto;
import br.com.fiap.gs.dto.Usuario.UsuarioDto;
import br.com.fiap.gs.dto.Usuario.UsuarioGetDto;
import br.com.fiap.gs.model.entities.Desabrigado;
import br.com.fiap.gs.model.entities.Usuario;
import br.com.fiap.gs.repository.DesabrigadoRepository;
import br.com.fiap.gs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesabrigadoService {
    @Autowired
    private DesabrigadoRepository desabrigadoRepository;


    public Desabrigado save(DesabrigadoDto dto) {

        return desabrigadoRepository.save(new Desabrigado(dto));
    }

    public List<DesabrigadoGetDto> getAll() {
        return desabrigadoRepository.findAll().stream().map(DesabrigadoGetDto::new).toList();
    }

    public DesabrigadoGetDto getId(Long id) {

        Optional<Desabrigado> desabrigado = desabrigadoRepository.findById(id);

        if (desabrigado.isPresent()) {
            Desabrigado d = desabrigado.get();

            return new DesabrigadoGetDto(d.getId(), d.getNome(), d.getEmail(), d.getSenha(), d.getIdade(), d.getTelefone(), d.getAbrigo());
        } else {
            return null;
        }
    }

    public DesabrigadoGetDto update(Long id, DesabrigadoGetDto dto) {
        Desabrigado desabrigado = desabrigadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        desabrigado.setNome(dto.nome());
        desabrigado.setEmail(dto.email());
        desabrigado.setSenha(dto.senha());
        desabrigado.setIdade(dto.idade());
        desabrigado.setTelefone(dto.telefone());


        Desabrigado atualizado = desabrigadoRepository.save(desabrigado);
        return new DesabrigadoGetDto(atualizado);
    }


    public void delete(Long id) {
        desabrigadoRepository.deleteById(id);
    }

}


