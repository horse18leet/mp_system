package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.dto.request.api.ContractorDto;
import org.vyatsu.localApiModule.entity.contractor.Contractor;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContractorMapper {
    Contractor toEntity(ContractorDto contractorDto);
    List<Contractor> toEntity(List<ContractorDto> contractorDto);

    ContractorDto toDto(Contractor contractor);
    List<ContractorDto> toDto(List<Contractor> contractor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contractor partialUpdate(ContractorDto contractorDto, @MappingTarget Contractor contractor);
}