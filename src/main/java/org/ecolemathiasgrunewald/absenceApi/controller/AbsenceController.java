package org.ecolemathiasgrunewald.absenceApi.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;

import org.ecolemathiasgrunewald.absenceApi.model.Absence;
import org.ecolemathiasgrunewald.absenceApi.model.utils.AbsencePagingResponse;
import org.ecolemathiasgrunewald.absenceApi.model.utils.PagingHeaders;
import org.ecolemathiasgrunewald.absenceApi.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Slf4j
@RestController
@RequestMapping("api/absences")
public class AbsenceController {
	
	@Autowired
	private AbsenceService absenceService;

	@Transactional
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Absence>> getAbsences(
			@And({
				@Spec(path = "date", params ="date",spec = Equal.class),
				@Spec(path = "date", params = {"dateGt", "dateLt"}, spec = Between.class)
			}) Specification<Absence> spec,
			Sort sort,
			@RequestHeader HttpHeaders headers) {
			final AbsencePagingResponse response = absenceService.getAbsences(spec, headers, sort);
			return new ResponseEntity<>(response.getElements(),returnHttpHeaders(response),HttpStatus.OK);
		
	}
	
	public HttpHeaders returnHttpHeaders(AbsencePagingResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
        headers.set(PagingHeaders.PAGE_OFFSET.getName(), String.valueOf(response.getPageOffset()));
        headers.set(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(response.getPageNumber()));
        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
        return headers;
    }


}
