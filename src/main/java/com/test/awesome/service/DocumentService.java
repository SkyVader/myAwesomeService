package com.test.awesome.service;

import com.test.awesome.entity.Document;
import com.test.awesome.entity.DocumentStatus;
import com.test.awesome.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final SecurityService securityService;

    public Document createDocument(DocumentDto documentDto) {
        //stub
        return new Document();
    }

    /**
     * Метод для массового обновления документов
     * @param documentDtoList
     */
    @Async
    public void updateDocuments(List<DocumentDto> documentDtoList) {
        for (DocumentDto documentDto:
             documentDtoList) {
            try {
                updateDocument(documentDto);
            } catch (Exception e) {
            }
        }
    }

    @Transactional
    public Document updateDocument(DocumentDto documentDto) {
        Optional<Document> documentOptional = documentRepository.findById(documentDto.getId());
        if (documentOptional.isEmpty()) {
            throw new RuntimeException("Document with id " + documentDto.getId() + " not found");
        }
        Document document = documentOptional.get();
        switch (document.getStatus()) {
            case NEW:
                document.setStatus(documentDto.getStatus());
            case APPROVED:
                if (documentDto.getStatus() != DocumentStatus.NEW ) {
                    document.setStatus(documentDto.getStatus());
                } else {
                    throw new RuntimeException("Illegal new status " + documentDto.getStatus());
                }
                break;
            case EXPIRED:
            case CLOSED:
                if (documentDto.getStatus() == DocumentStatus.CLOSED) {
                    document.setStatus(documentDto.getStatus());
                } else {
                    throw new RuntimeException("Illegal new status " + documentDto.getStatus());
                }
        }
        document.setComment(document.getComment());
        document.setDescription(document.getDescription());
        document.setUpdatedAt(LocalDateTime.now());
        document.setUpdatedUser(securityService.currentUser());
        documentRepository.save(document);
        return document;
    }

    public boolean deleteDocument() {
        //stub
        return true;
    }
}
