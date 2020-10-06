package com.kanika.spring.example.util.exceptionHandling;

import com.kanika.spring.example.dto.ProductBrandPriceDTO;
import com.kanika.spring.example.dto.ResponseProductBrandPriceDTO;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandling {
    public static ResponseProductBrandPriceDTO successListOfSeries(List<ProductBrandPriceDTO> productBrandPriceDTOList)
    {
        return new ResponseProductBrandPriceDTO().setStatus(200).setMessage("Here comes the match")
                .setCount(productBrandPriceDTOList.size()).setApi_element("abc").setResult(productBrandPriceDTOList);
    }

    public static ResponseProductBrandPriceDTO errorListOfSeries(Exception e)
    {
        return new ResponseProductBrandPriceDTO().setStatus(400).setMessage(e.getMessage())
                .setCount(0).setApi_element("abc").setResult(new ArrayList<>());
    }

    public static ResponseProductBrandPriceDTO noArgumentProvided()
    {
        return new ResponseProductBrandPriceDTO().setStatus(400).setMessage("Please provide atleast 1 argument")
                .setCount(0).setApi_element("abc").setResult(new ArrayList<>());
    }
}
