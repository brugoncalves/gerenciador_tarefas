package br.com.gerenciadortarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciadortarefas.models.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
}
