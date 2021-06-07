package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.exceptions.BusinessException;
import com.project.mapper.StockMapper;
import com.project.model.Stock;
import com.project.model.dto.StockDTO;
import com.project.repository.StockRepository;
import com.project.util.MessageUtils;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	@Autowired
	private StockMapper mapper;

	@Transactional
	public StockDTO save(StockDTO dto) {
		Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(),dto.getDate());
		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		
		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDto(stock);
	}

}
