package com.aboshady.stc.service;


import com.aboshady.stc.enums.FileType;
import com.aboshady.stc.exception.NotFoundException;
import com.aboshady.stc.model.File;
import com.aboshady.stc.model.Item;
import com.aboshady.stc.model.PermissionGroup;
import com.aboshady.stc.repository.ItemRepository;
import com.aboshady.stc.repository.PermissionGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Autowired
    private FileService fileService;

    public Item createSpace(String name){
        PermissionGroup permissionGroup = permissionService.createPermissionGroup(name);
        Item item = Item.builder().name(name).type(FileType.SPACE).permissionGroup(permissionGroup).build();
        return itemRepository.save(item);
    }
    public Item getItemMetaData(Long id){
        return itemRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("File with id %s is not found", id)));
    }

    public Item createFolder(Long spaceId, String name) {
        Item parentSpace = itemRepository.findById(spaceId)
                .orElseThrow(() -> new NotFoundException(String.format("cant' create folder(%s), space of id: %d is not found", name, spaceId)));

        Item item = Item.builder()
                .name(name)
                .type(FileType.SPACE)
                .permissionGroup(parentSpace.getPermissionGroup()).build();

        return itemRepository.save(item);
    }

    public Item createFile(Long folderId, String name) {
        Item parentFolder = itemRepository.findById(folderId)
                .orElseThrow(() -> new NotFoundException(String.format("cant' create file(%s), folder of id: %d is not found", name, folderId)));

        byte[] fileContent = fileService.createFileContent();
        Item item = Item.builder()
                .name(name)
                .type(FileType.SPACE)
                .file(File.builder().binary(fileContent).build())
                .permissionGroup(parentFolder.getPermissionGroup()).build();

        return itemRepository.save(item);
    }
}
