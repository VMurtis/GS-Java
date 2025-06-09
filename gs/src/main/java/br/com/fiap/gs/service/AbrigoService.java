package br.com.fiap.gs.service;


import br.com.fiap.gs.dto.abrigo.AbrigoDto;
import br.com.fiap.gs.dto.abrigo.AbrigoGetDto;
import br.com.fiap.gs.model.entities.*;
import br.com.fiap.gs.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;


    public Abrigo save(AbrigoDto dto) {

        return abrigoRepository.save(new Abrigo(dto));
    }

    public List<AbrigoGetDto> getAll() {
        return abrigoRepository.findAll().stream().map(AbrigoGetDto::new).toList();
    }

    public AbrigoGetDto getId(Long id) {

        Optional<Abrigo> abrigo = abrigoRepository.findById(id);

        if (abrigo.isPresent()) {
            Abrigo a = abrigo.get();

            return new AbrigoGetDto(a.getId(), a.getNome(), a.getEndereco(), a.getCapacidadeMaxima(), a.getCidade(), a.getEstado(), a.getCep(),a.getEstoque().stream().map(Estoque::getId).toList(),
                    a.getNecessidades().stream().map(Necessidade::getTipo).toList(), a.getDesabrigados().stream().map(Desabrigado::getId).toList(),
                    a.getAdministradores().stream().map(Administrador::getId).toList());
        } else {
            return null;
        }
    }

    public AbrigoGetDto update(Long id, AbrigoGetDto dto) {
        Abrigo abrigo = abrigoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado"));

        abrigo.setNome(dto.nome());
        abrigo.setEndereco(dto.endereco());
        abrigo.setCapacidadeMaxima(dto.capacidadeMaxima());
        abrigo.setCidade(dto.cidade());
        abrigo.setEstado(dto.estado());
        abrigo.setCep(dto.cep());


        Abrigo atualizado = abrigoRepository.save(abrigo);
        return new AbrigoGetDto(atualizado);
    }


    public void delete(Long id) {
        abrigoRepository.deleteById(id);
    }


}


