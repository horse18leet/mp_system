package org.vyatsu.localApiModule.dto.response.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardDTO {
    List<WalletTransactionDto> walletTransactions;
    List<OrderDto> orders;
    Map<LocalDate, Long> ordersPerInterval;
    Double intervalProfit;
    Double sumPriceOrder;
    Double sumIncome;
    Double sumExpense;
    LocalDateTime updatedAt;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
}
