package org.vyatsu.localApiModule.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
<<<<<<< Updated upstream
import org.springframework.amqp.core.DirectExchange;
=======
>>>>>>> Stashed changes
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.vyatsu.localApiModule.dto.request.api.ContractorDto;
import org.vyatsu.localApiModule.dto.request.api.OrderReqDto;
import org.vyatsu.localApiModule.dto.request.messaging.RealizationReportWBDto;
import org.vyatsu.localApiModule.dto.response.api.OrderDto;
import org.vyatsu.localApiModule.entity.contractor.Contractor;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;
import org.vyatsu.localApiModule.entity.enums.ContractorType;
import org.vyatsu.localApiModule.entity.enums.WalletTransactionType;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.item.Order;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.mapper.ApiKeyMapper;
<<<<<<< Updated upstream
import org.vyatsu.localApiModule.messaging.dto.OrderWBDto;
=======
import org.vyatsu.localApiModule.mapper.ItemMapper;
import org.vyatsu.localApiModule.mapper.OrderMapper;
import org.vyatsu.localApiModule.messaging.dto.OrderWBDto;
import org.vyatsu.localApiModule.messaging.dto.SaleWBDto;
import org.vyatsu.localApiModule.repository.ItemRepository;
>>>>>>> Stashed changes
import org.vyatsu.localApiModule.repository.OrderRepository;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.*;
import org.vyatsu.localApiModule.util.HelperUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private AuthenticationFacade authenticationFacade;

    @Autowired
    private RabbitTemplate rabbitTemplate;
<<<<<<< Updated upstream
//
//    @Autowired
//    private DirectExchange directExchange;

    private final ApiKeyServiceImpl apiKeyService;
=======

    private final ApiKeyService apiKeyService;
    private final WalletService walletService;
    private final ContractorService contractorService;
    private final WalletTransactionService walletTransactionService;
>>>>>>> Stashed changes

    private ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    private final ApiKeyMapper apiKeyMapper;
    private final OrderMapper orderMapper;
    private final ItemMapper itemMapper;


    @Override
    public List<Order> getOrdersByItemId(Long id) {
        return orderRepository.findOrdersByItemId(id);
    }

    @Override
    public Order CreateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public ResponseEntity<Object> getOrders(HttpServletRequest request, OrderReqDto dto) {
        dto.setApiKeys(apiKeyMapper.toDtoList(apiKeyService.getAllApiKeyUser(dto.getApiKeyType())));
        dto.setApiKey(HelperUtil.GetJwtToken(request));
<<<<<<< Updated upstream
        if(dto.getApiKeys() != null){
=======
        if (dto.getApiKeys() != null) {
>>>>>>> Stashed changes
            Object result = null;
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

<<<<<<< Updated upstream
    @RabbitListener(queues = "queue.RecordOrders")
    public void recordOrders(OrderWBDto orderWBDto){
=======
    @Override
    public void createWBOrder(OrderWBDto orderWBDto) {
        Order order = Order.builder()
                .createdAt(LocalDateTime.parse(orderWBDto.getDate()))
                .price(orderWBDto.getFinishedPrice())
                .item(itemRepository.findByVendorCode(String.valueOf(orderWBDto.getNmId())))
                .orderType(orderWBDto.getOrderType())
                .isRefund(false)
                .isCancel(orderWBDto.getIsCancel())
                .srid(orderWBDto.getSrid())
                .build();

        boolean isExists = orderRepository.existsBySrid(order.getSrid());
        if (!isExists) {
            orderRepository.save(order);
        }

    }

    /*
    фиксируем выкуп товара + отказ товара
     */
    @Override
    public void createWBSale(SaleWBDto saleWBDto) {
        Order order = orderRepository.findBySrid(saleWBDto.getSrid());
        if (order != null) {
            order.setIsRefund(saleWBDto.getForPay() < 0);
            order.setTakedAt(LocalDateTime.parse(saleWBDto.getLastChangeDate()));
            orderRepository.save(order);
        }
    }

    @Override
    public List<OrderDto> getOrdersByDateFrom(LocalDateTime dateFrom) {
        User user = authenticationFacade.getAuthenticationUser();
        LocalDateTime dateTo = LocalDateTime.now();
        List<Order> orders = orderRepository.findOrdersByUserAndCreatedAtBetween(user.getId(), dateFrom, dateTo);
        return orderMapper.toListDto(orders);
    }

    @Override
    public void processRealizationReportData(String message) throws JsonProcessingException {
        User user = authenticationFacade.getAuthenticationUser();

        ObjectMapper objectMapper = new ObjectMapper();
        List<RealizationReportWBDto> realizationReportsWBDto = objectMapper.readValue(message, new TypeReference<>() {
        });

        List<WalletTransaction> walletTransactions = new ArrayList<>();

        for (RealizationReportWBDto report : realizationReportsWBDto) {
            Item itemDto = itemRepository.findByVendorCode(report.getNmId().toString());
            WalletTransaction walletTransaction = new WalletTransaction();
            walletTransaction.setItem(itemDto);

            ContractorDto contractorDto = new ContractorDto();
            contractorDto.setPaymentNum("");
            contractorDto.setEmail("");
            contractorDto.setDescription("");
            contractorDto.setType(ContractorType.Маркетплейс);
            contractorDto.setActualAddress("");
            contractorDto.setEmail("");
            contractorDto.setPhoneNum("");

            // TODO: 17.06.2024 проверить какие еще бывают операции по приходу у ВБ
            switch (report.getSupplierOperName()) {
                case "Продажа":
                    walletTransaction.setType(WalletTransactionType.Приход);
                    walletTransaction.setDescription("Добавлено системой. " + report.getSupplierOperName() + report.getQuantity() + " шт. " + report.getAcquiringBank());
                    walletTransaction.setAmount(report.getPpvzForPay());
                    contractorDto.setName("Wildberries");
                    break;
                case "Хранение":
                    walletTransaction.setType(WalletTransactionType.Расход);
                    walletTransaction.setDescription("Добавлено системой. " + report.getSupplierOperName());
                    walletTransaction.setAmount(report.getStorageFee());
                    contractorDto.setName("Wildberries");
                    break;
                case "Логистика":
                    walletTransaction.setType(WalletTransactionType.Расход);
                    walletTransaction.setDescription("Добавлено системой. " +  report.getSupplierOperName());
                    walletTransaction.setAmount(report.getDeliveryRub());
                    contractorDto.setName("Wildberries");
                    break;
                case "Удержание":
                    contractorDto.setName("Wildberries");
                    walletTransaction.setType(WalletTransactionType.Расход);
                    walletTransaction.setDescription("Добавлено системой. " + report.getSupplierOperName());
                    walletTransaction.setAmount(report.getDeduction());
                    contractorDto.setName("Wildberries");
                    break;
                case "Возмещение издержек по перевозке/по складским операциям с товаром":
                    contractorDto.setName(report.getSupplierOperName());
                    walletTransaction.setType(WalletTransactionType.Расход);
                    walletTransaction.setDescription("Добавлено системой. " + report.getSupplierOperName() + ". " + report.getRebillLogisticOrg());
                    walletTransaction.setAmount(report.getRebillLogisticCost());
                    contractorDto.setName(report.getRebillLogisticOrg());
                    break;
            }
            ContractorDto contractor = contractorService.createContractor(contractorDto);
            walletTransaction.setWallet(walletService.getContractorWalletByContractorId(contractor.getId()));
            walletTransaction.setImplDate(LocalDateTime.parse(report.getCreateDt()));
            walletTransaction.setUser(user);
            walletTransactions.add(walletTransaction);
        }
        walletTransactionService.createWalletTransactions(walletTransactions);
    }

    @RabbitListener(queues = "queue.RecordOrders")
    public void recordOrders(OrderWBDto orderWBDto) {
>>>>>>> Stashed changes
        System.out.println(orderWBDto);
    }
}
