package com.duoc.EFT_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.EFT_Backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
