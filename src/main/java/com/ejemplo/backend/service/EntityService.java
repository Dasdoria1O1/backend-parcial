package main.java.com.ejemplo.backend.service;

import main.java.com.ejemplo.backend.dto.EntityDTO;
import main.java.com.ejemplo.backend.model.Entity;
import main.java.com.ejemplo.backend.repository.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntityService {
    private final EntityRepository entityRepository;
    private final ModelMapper modelMapper;

    public EntityDTO create(EntityDTO entityDTO) {
        Entity entity = modelMapper.map(entityDTO, Entity.class);
        Entity savedEntity = entityRepository.save(entity);
        return modelMapper.map(savedEntity, EntityDTO.class);
    }

    public EntityDTO update(Long id, EntityDTO entityDTO) {
        Optional<Entity> optionalEntity = entityRepository.findById(id);
        if (optionalEntity.isPresent()) {
            Entity entity = optionalEntity.get();
            entity.setName(entityDTO.getName());
            entity.setDescription(entityDTO.getDescription());
            Entity updatedEntity = entityRepository.save(entity);
            return modelMapper.map(updatedEntity, EntityDTO.class);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }

    public List<EntityDTO> findAll() {
        return entityRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, EntityDTO.class))
                .collect(Collectors.toList());
    }

    public EntityDTO findById(Long id) {
        Optional<Entity> optionalEntity = entityRepository.findById(id);
        return optionalEntity.map(entity -> modelMapper.map(entity, EntityDTO.class))
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    public void delete(Long id) {
        entityRepository.deleteById(id);
    }
}
