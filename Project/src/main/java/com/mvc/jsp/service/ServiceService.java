
package com.mvc.jsp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface ServiceService {
	void register(ServiceDto dto);
	
	default Service dtoToEntity(ServiceDto dto) {

		Service entity = Service.builder()
				.inqCode(dto.getInqCode())
				.inqContent(dto.getInqContent())
				.inqEmail(dto.getInqEmail())
				.inqTitle(dto.getInqTitle())
				.build();

		return entity;

	}

}
