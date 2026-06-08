package com.noblewalk.backend.service;

import com.noblewalk.backend.exceptions.PriceListAlreadyExistsException;
import com.noblewalk.backend.exceptions.PriceListNotFoundException;
import com.noblewalk.backend.model.dtos.request.PriceListRequest;
import com.noblewalk.backend.model.entity.PriceListEntity;
import com.noblewalk.backend.repo.PriceListRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PriceListService {

    @Autowired
    private PriceListRepo priceListRepo;
    @Autowired
    private ModelMapper modelMapper;

    public PriceListEntity getPriceListByItemId(String itemId) {

        PriceListRequest response = new PriceListRequest();
        log.info("Fetching price list of item with id {}", itemId);
        Optional<PriceListEntity> priceList = priceListRepo.findByItemId(itemId);
        if (priceList.isPresent()) return priceList.get();
        else throw new PriceListNotFoundException("Price list not found for Item Id: " + itemId);
    }

    public PriceListRequest getPriceList(String itemId) {

        log.info("Get price list of item with id {}", itemId);
        PriceListEntity priceList = getPriceListByItemId(itemId);
        return modelMapper.map(priceList, PriceListRequest.class);
    }

    public String createPriceList(PriceListRequest request) {

        String item =  request.getItemId();
        log.info("Fetch price list for the item {}", item);
        PriceListEntity priceList;
        try{
            priceList = getPriceListByItemId(item);
        }
        catch (PriceListNotFoundException e){

            priceList = modelMapper.map(request, PriceListEntity.class);
            log.info("Save price list for the item {}", item);
            priceListRepo.save(priceList);
            return "S";
        }
        throw new PriceListAlreadyExistsException("Price list already exists for the item: " + item);
    }

    public String updatePriceList(PriceListRequest request) {

        log.info("");
        return "";
    }


}
