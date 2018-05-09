package com.kazale.pontointeligente.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.kazale.pontointeligente.api.entities.Lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@NamedQueries({
    @NamedQuery(
        name = "LancamentoReposiroty.findByFuncionarioId",
        query = "SELECT lanc FROM lancamento lanc WHERE lanc.funcionario_id = :funcionarioId"
    )
})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

    List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
    Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}