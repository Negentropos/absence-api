package org.ecolemathiasgrunewald.absenceApi.service;

import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Objects;

import org.ecolemathiasgrunewald.absenceApi.model.Absence;
import org.ecolemathiasgrunewald.absenceApi.model.utils.AbsencePagingResponse;
import org.ecolemathiasgrunewald.absenceApi.model.utils.PagingHeaders;
import org.ecolemathiasgrunewald.absenceApi.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AbsenceService {
	
	@Autowired
	private AbsenceRepository absenceRepository;
		
	public Iterable<Absence> getAbsences(){
		return absenceRepository.findAll(Sort.unsorted());
	}
	
	/**
     * get element using Criteria.
     *
     * @param spec    *
     * @param headers pagination data
     * @param sort    sort criteria
     * @return retrieve elements with pagination
     */
	public AbsencePagingResponse getAbsences(
			Specification<Absence> spec,
			HttpHeaders headers,
			Sort sort
			)
		{
			if (isRequestPaged(headers)) {
	            return getAbsences(spec, buildPageRequest(headers, sort));
	        } else {
	            List<Absence> entities = getAbsences(spec, sort);
	            return new AbsencePagingResponse((long) entities.size(), 0L, 0L, 0L, 0L, entities);
	        }
			
		}
	
	private boolean isRequestPaged(HttpHeaders headers) {
        return headers.containsKey(PagingHeaders.PAGE_NUMBER.getName()) && headers.containsKey(PagingHeaders.PAGE_SIZE.getName());
    }
	
	private Pageable buildPageRequest(HttpHeaders headers, Sort sort) {
        int page = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_NUMBER.getName())).get(0));
        int size = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_SIZE.getName())).get(0));
        return PageRequest.of(page, size, sort);
    }
	
	 /**
     * get elements using Criteria.
     *
     * @param spec     *
     * @param pageable pagination data
     * @return retrieve elements with pagination
     */
	public AbsencePagingResponse getAbsences(Specification<Absence> spec, Pageable pageable) {
        Page<Absence> page = absenceRepository.findAll(spec, pageable);
        List<Absence> content = page.getContent();
        return new AbsencePagingResponse(page.getTotalElements(), (long) page.getNumber(), (long) page.getNumberOfElements(), pageable.getOffset(), (long) page.getTotalPages(), content);
    }
	
	/**
     * get elements using Criteria.
     *
     * @param spec *
     * @return elements
     */
    public List<Absence> getAbsences(Specification<Absence> spec, Sort sort) {
        return absenceRepository.findAll(spec, sort);
    }

}
