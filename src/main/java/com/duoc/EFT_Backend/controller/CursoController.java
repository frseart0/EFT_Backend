package com.duoc.EFT_Backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.EFT_Backend.model.Curso;
import com.duoc.EFT_Backend.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	private final CursoService cursoService;

	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	@PostMapping
	public ResponseEntity<Curso> crear(@RequestBody Curso curso) {
		Curso creado = cursoService.crear(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public List<Curso> listarTodos() {
		return cursoService.listarTodos();
	}

	@GetMapping("/{id}")
	public Curso obtenerPorId(@PathVariable Long id) {
		return cursoService.buscarPorId(id);
	}

	@PutMapping("/{id}")
	public Curso actualizar(@PathVariable Long id, @RequestBody Curso curso) {
		return cursoService.actualizar(id, curso);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		cursoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
