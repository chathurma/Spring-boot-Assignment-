package com.isej.ISEJ.service;

import  com.isej.ISEJ.api.Entitiy.stock;
import com.isej.ISEJ.api.repository.IRepository;
import  com.isej.ISEJ.api.request.stockRequest;
import com.isej.ISEJ.api.response.stockResponse;
import  com.isej.ISEJ.api.utils.stockUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class stockService {

    @Autowired
    private IRepository repository;

    //Add for mysql
    public stockResponse addStock(stockRequest stockRes) {

        System.out.println(stockRes);
       stock stockObj = stock.builder()
                .id(stockRes.getId())
                .name(stockRes.getName())
                .price(stockRes.getPrice())
                .visibility(stockRes.getVisibility())
                .quantity(stockRes.getQuantity())
                .description(stockRes.getDescription())
                .image(stockRes.getImage())
                .build();

       return stockUtils.mapToResponse(repository.save(stockObj));

    }
    //Get all stock
    public List<stockResponse> getAllStock() {
        List<stockResponse> stockResponseList = new ArrayList<>();
        List<stock> stockList = repository.findAll();
        for (stock stock : stockList) {
            stockResponse stockResponse = stockUtils.mapToResponse(stock);
            stockResponseList.add(stockResponse);
        }
        return stockResponseList;
    }
    //Delete stock
    public void deleteStock(Integer id) {
        repository.deleteById(id);
    }


    //update the vsibility of 0
      public void updateVisibility(Integer id,String visibility) {
            Optional optional = getStockById(id);
            if (optional.isPresent()) {
                stock stock = (stock) optional.get();
                stock.setVisibility(visibility);
                repository.save(stock);
            }
        }


    //Get stock by id
    public Optional<stock> getStockById(Integer id) {
        Optional optional = Optional.empty();
        for (stock stock : repository.findAll()) {
            if (stock.getId().equals(id)) {
                optional = Optional.of(stock);
                return optional;
            }
        }
        return optional;

    }
    /*
    public Optional<stock> getStockById(String id) {
        Optional optional = Optional.empty();
        for (stock stock : stockList) {
            if (stock.getId().equals(id)) {
                optional = Optional.of(stock);
                return optional;
            }
        }
        return optional;

    }

    //Delete stock by id
    public void deleteStockById(String id) {
        Optional optional = getStockById(id);
        if (optional.isPresent()) {
            stockList.remove((stock) optional.get());
        }
    }
*/
    //Update visibility
    /*public void updateVisibility(String id,String visibility) {
        Optional optional = getStockById(id);
        if (optional.isPresent()) {
            stock stock = (stock) optional.get();
            stock.setVisibility(visibility);
        }
    }*/
}
