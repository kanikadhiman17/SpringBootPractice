package com.kanika.spring.example.exceptions;

import com.kanika.spring.example.domain.dto.ProductBrandPriceDTO;
import com.kanika.spring.example.domain.dto.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandling {
    public static ResponseDTO<ProductBrandPriceDTO> successListOfSeries(List<ProductBrandPriceDTO> productBrandPriceDTOList)
    {
        return new ResponseDTO<ProductBrandPriceDTO>().setStatus(200).setMessage("Here comes the match")
                .setCount(productBrandPriceDTOList.size()).setApi_element("abc").setResult(productBrandPriceDTOList);
    }

    public static ResponseDTO<ProductBrandPriceDTO> errorListOfSeries(Exception e)
    {
        return new ResponseDTO<ProductBrandPriceDTO>().setStatus(400).setMessage(e.getMessage())
                .setCount(0).setApi_element("abc").setResult(new ArrayList<>());
    }

    public static ResponseDTO<ProductBrandPriceDTO> noArgumentProvided()
    {
        return new ResponseDTO<ProductBrandPriceDTO>().setStatus(400).setMessage("Please provide atleast 1 argument")
                .setCount(0).setApi_element("abc").setResult(new ArrayList<>());
    }
}
