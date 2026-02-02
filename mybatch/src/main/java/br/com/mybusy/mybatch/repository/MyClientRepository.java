package br.com.mybusy.mybatch.repository;

import br.com.mybusy.mybatch.model.MyClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyClientRepository extends JpaRepository<MyClient, Long> {
}