package com.test.awesome.controller;

import com.test.awesome.entity.Document;
import com.test.awesome.service.DocumentDto;
import com.test.awesome.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/document/approve")
    public ResponseEntity<Document> approveDocument(
            @RequestBody DocumentDto documentDto) {
        return ResponseEntity.ok(documentService.updateDocument(documentDto));
    }
}
