package com.lhind.FlightBooking.Application.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private Integer pageSize = 5;
    private Integer pageNumber = 0;
    private String sortByProperty = "id";
    private Boolean sortByAscendingOrder = true;

    public int getPage() {
        return getPageNumber();
    }
}
