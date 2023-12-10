package com.aboshady.stc.controller;


import com.aboshady.stc.model.Item;
import com.aboshady.stc.service.FileService;
import com.aboshady.stc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {
    @Autowired
    ItemService itemService;

    @Autowired
    FileService fileService;


    @PostMapping("/space/{name}")
    public Item createSpace(@PathVariable("name") String name) {
        return itemService.createSpace(name);
    }

    @PostMapping("{spaceId}/folder/{name}")
    public Item createFolder(@PathVariable("spaceId") Long spaceId, @PathVariable(value = "name") String name) {
        return itemService.createFolder(spaceId, name);
    }

    @PostMapping("{folderId}/file/{name}")
    public Item createFile(@PathVariable("folderId") Long folderId, @PathVariable(value = "name") String name) {
        return itemService.createFile(folderId, name);
    }

    @GetMapping("{id}")
    public Item getMetaData(@PathVariable("id") Long id){
        return itemService.getItemMetaData(id);
    }


    @GetMapping("download/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") Long id) throws IOException {


        byte[] content = fileService.getFileContent(id);
        ByteArrayResource resource = new ByteArrayResource(content);

        return ResponseEntity.ok()
                .contentLength(content.length)
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, String.format("%d.pdf", id))
                .body(resource);
    }
}
