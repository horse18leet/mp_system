package org.vyatsu.localApiModule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.request.api.ContractorDto;
<<<<<<< Updated upstream
import org.vyatsu.localApiModule.exception.AppException;
=======
>>>>>>> Stashed changes
import org.vyatsu.localApiModule.mapper.ContractorMapper;
import org.vyatsu.localApiModule.service.ContractorService;

import java.util.List;

@RestController
@RequestMapping("/contractor")
@RequiredArgsConstructor
public class ContractorController {

    private final ContractorService contractorService;

    private final ContractorMapper contractorMapper;

    //получение списка подрядчиков пользователя
    @GetMapping
    private ResponseEntity<List<ContractorDto>> getUserContractors(){
        List<ContractorDto> userContractors = contractorService.getContractorsByUser();
        return ResponseEntity.ok(userContractors);
    }

    //получение подрядчика по id
    @GetMapping("/{id}")
    private ResponseEntity<ContractorDto> getContractorById(@PathVariable Long id){
        ContractorDto contractorDto = contractorService.getContractorById(id);
        return ResponseEntity.ok(contractorDto);
    }

    //создание подрядчика
    @PostMapping("/create")
    private ResponseEntity<ContractorDto> createContractor(@RequestBody ContractorDto contractorDto){
        ContractorDto createdContractor = contractorService.createContractor(contractorDto);
        return ResponseEntity.ok(createdContractor);
    }

    //редактирование подрядчика
    @PutMapping("/edit")
    private ResponseEntity<ContractorDto> editContractor(@RequestBody ContractorDto contractorDto){
        contractorDto = contractorService.editContractor(contractorDto);
        return ResponseEntity.ok(contractorDto);
    }

    //удаление подрядчика по id
    @DeleteMapping("/drop/{id}")
    private void deleteUserContractor(@PathVariable Long id){
        contractorService.deleteContractor(id);
    }
}
