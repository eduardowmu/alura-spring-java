package br.com.mybusy.db.db_core.repository;

import br.com.mybusy.db.db_core.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}