package com.rstyle.audit.repository;

import com.rstyle.audit.entity.ClientArrestListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientArrestListRepository extends JpaRepository<ClientArrestListEntity,Integer > {
    List<ClientArrestListEntity> findByIdClient(int idClient);

    ClientArrestListEntity findByIdArrest(int arrest_id);
}
