package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.dto.request.api.ContractorDto;
import org.vyatsu.localApiModule.exception.AppException;

import java.util.List;

public interface ContractorService {

    List<ContractorDto> getContractorsByUser();

    ContractorDto createContractor(ContractorDto contractorDto);

    ContractorDto getContractorById(Long id);

    void deleteContractor(Long id);

    ContractorDto editContractor(ContractorDto contractorDto);
}
