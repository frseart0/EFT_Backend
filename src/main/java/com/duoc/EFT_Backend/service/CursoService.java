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
		curso.setId(null);
		return cursoRepository.save(curso);
	}

	@Transactional
	public Curso actualizar(Long id, Curso datos) {
		Curso existente = buscarPorId(id);
		existente.setTitulo(datos.getTitulo());
		existente.setDescripcion(datos.getDescripcion());
		return cursoRepository.save(existente);
	}

	@Transactional
	public void eliminar(Long id) {
		if (!cursoRepository.existsById(id)) {
			throw new ResourceNotFoundException("Curso", id);
		}
		cursoRepository.deleteById(id);
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
