package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {

	@NotNull
	private Integer salaId;
	
	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	private LocalTime horario;
	
	@NotNull
	private Integer filmeId;
	
	/**
	 * @deprecate Hibernate Only
	 */
	@Deprecated
	public SessaoForm(){}
	
	public SessaoForm(Integer salaId, LocalTime horario, Integer filmeId) {
		this.salaId 	= salaId;
		this.horario 	= horario;
		this.filmeId 	= filmeId;
	}
	
	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao) {
		Sala sala 	= salaDao.findOne(salaId);
		Filme filme = filmeDao.findOne(filmeId);
		
		return new Sessao(this.horario, sala, filme);
	}

	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Integer getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}
	
}
