package com.aboshady.stc.enums;

import lombok.Getter;

@Getter
public enum FileType {
    SPACE("Space"), FOLDER("Folder"), FILE("File");

    private final String value;

    FileType(String value){
        this.value = value;
    }
}
