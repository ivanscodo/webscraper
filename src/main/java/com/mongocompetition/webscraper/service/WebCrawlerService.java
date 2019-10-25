package com.mongocompetition.webscraper.service;

import com.mongocompetition.webscraper.dao.WebSiteRepository;
import com.mongocompetition.webscraper.dto.CreateResponseDTO;
import com.mongocompetition.webscraper.model.WebSite;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequestScope
public class WebCrawlerService {

    private final CrawlerProcessor crawlerProcessor;
    private final WebSiteRepository webSiteRepository;

    public WebCrawlerService(CrawlerProcessor crawlerProcessor, WebSiteRepository webSiteRepository) {
        this.crawlerProcessor = crawlerProcessor;
        this.webSiteRepository = webSiteRepository;
    }

    public CreateResponseDTO create(final String url) {
        WebSite webSite = crawlerProcessor.proccessUrl(url);
        webSiteRepository.save(webSite);
        CreateResponseDTO createResponseDTO = fromEntityToDTO(webSite);
        return createResponseDTO;
    }

    private CreateResponseDTO fromEntityToDTO(WebSite webSite) {
        return CreateResponseDTO.Builder.aCreateResponseDTO()
                .withLanguage(webSite.getLanguage())
                .withRankedWords(webSite.getRankedWords())
                .withTitle(webSite.getTitle())
                .withUrl(webSite.getUrl())
                .build();
    }

    public List<CreateResponseDTO> findAll() {
        return webSiteRepository.findAll().stream()
                .map(s -> fromEntityToDTO(s))
                .collect(Collectors.toList());
    }
}
