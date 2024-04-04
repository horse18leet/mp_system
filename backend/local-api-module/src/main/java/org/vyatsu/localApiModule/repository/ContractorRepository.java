package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.vyatsu.localApiModule.dto.request.api.ContractorDto;
import org.vyatsu.localApiModule.entity.contractor.Contractor;

import java.util.List;

public interface ContractorRepository extends JpaRepository<Contractor, Long> {
    List<Contractor> findByUserId(Long id);


    Contractor findByWalletId(Long id);
}
