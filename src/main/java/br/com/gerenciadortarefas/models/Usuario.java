package br.com.gerenciadortarefas.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Long id;

	@NotNull(message = "O e-mail é obrigatório")
	@Length(min = 10, max = 100, message = "O e-mail deve conter entre 10 e 100 caracteres")
	@Column(name = "usr_email", nullable = false, length = 100)
	private String email;

	@Column(name = "usr_senha", nullable = false, length = 100)
	@NotNull(message = "A senha é obrigatória.")
	private String senha;

	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
	private List<Tarefa> tarefas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

}
