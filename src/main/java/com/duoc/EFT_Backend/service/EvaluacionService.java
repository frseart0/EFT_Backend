package com.duoc.EFT_Backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duoc.EFT_Backend.exception.ResourceNotFoundException;
import com.duoc.EFT_Backend.model.Curso;
import com.duoc.EFT_Backend.model.Evaluacion;
import com.duoc.EFT_Backend.repository.CursoRepository;
import com.duoc.EFT_Backend.repository.EvaluacionRepository;

@Service
public class EvaluacionService {

	private final EvaluacionRepository evaluacionRepository;
	private final CursoRepository cursoRepository;

	public EvaluacionService(EvaluacionRepository evaluacionRepository, CursoRepository cursoRepository) {
		this.evaluacionRepository = evaluacionRepository;
		this.cursoRepository = cursoRepository;
	}

	@Transactional
	public Evaluacion crear(Evaluacion evaluacion, Long cursoId) {
		Curso curso = cursoRepository.findById(cursoId)
				.orElseThrow(() -> new ResourceNotFoundException("Curso", cursoId));
		evaluacion.setCurso(curso);
		return evaluacionRepository.save(evaluacion);
	}

	@Transactional(readOnly = true)
	public Evaluacion buscarPorId(Long id) {
		return evaluacionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Evaluacion", id));
	}

	@Transactional(readOnly = true)
	public List<Evaluacion> listarTodos() {
		return evaluacionRepository.findAll();
	}
}
