package br.edu.ifrs.tads.ppa.demo.repository;

import br.edu.ifrs.tads.ppa.demo.model.Role; // <-- Importação adicionada
import org.springframework.data.repository.ListCrudRepository;

import java.util.Collection;
import java.util.Set;

public interface RoleRepository extends ListCrudRepository<Role, Integer> {
    // This interface will automatically provide CRUD operations for the Role entity
    // You can add custom query methods here if needed

    Role findByName(String name);

    Set<Role> findByNameIn(Collection<String> names);

    boolean existsByName(String name);
}