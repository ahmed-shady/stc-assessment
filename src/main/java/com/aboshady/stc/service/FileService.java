package com.aboshady.stc.service;


import com.aboshady.stc.StcApplication;
import com.aboshady.stc.exception.NotFoundException;
import com.aboshady.stc.model.File;
import com.aboshady.stc.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public byte[] getFileContent(Long id){
        File file =  fileRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("File with id %s is not found", id)));

        return file.getBinary();
    }

    public byte[] createFileContent(){
        try{
            return StcApplication.class.getResourceAsStream("/fileData.pdf").readAllBytes();
        }catch(Exception ex){
            throw new NotFoundException("pdf file is not found in our system to save");
        }

    }

}
