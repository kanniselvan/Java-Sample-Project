package model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesRecord {

    private String region;

    private String country;

    private String itemType;

    private String salesChannel;

    private  String orderPriority;

    private String orderDate;

    private double orderID;

    private String shipDate;

    private double unitSold;

    private double unitPrize;

    private double unitCost;

    private double totalRevenue;

    private double totalCost;

    private double totalProfit;

}
