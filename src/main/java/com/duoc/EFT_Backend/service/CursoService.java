package com.duoc.EFT_Backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duoc.EFT_Backend.exception.ResourceNotFoundException;
import com.duoc.EFT_Backend.model.Curso;
import com.duoc.EFT_Backend.repository.CursoRepository;

@Service
public class CursoService {

	private final CursoRepository cursoRepository;

	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@Transactional
	public Curso crear(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Transactional(readOnly = true)
	public Curso buscarPorId(Long id) {
		return cursoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Curso", id));
	}

	@Transactional(readOnly = true)
	public List<Curso> listarTodos() {
		return cursoRepository.findAll();
	}
}
