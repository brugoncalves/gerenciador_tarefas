package br.com.gerenciadortarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciadortarefas.models.Tarefa;

public interface RepositorioTarefa extends JpaRepository<Tarefa, Long>{

}
