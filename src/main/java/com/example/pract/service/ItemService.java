package com.example.pract.service;


import com.example.pract.domain.dto.request.ItemRequest;
import com.example.pract.domain.dto.response.ApiResponse;
import com.example.pract.domain.dto.response.ResponseUtils;
//import com.example.pract.domain.mappers.ItemMapper;
import com.example.pract.domain.models.Item;
import com.example.pract.domain.projections.ItemInfo;
import com.example.pract.exception.ResourceNotFoundException;
import com.example.pract.domain.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ItemService {

    @Autowired
    private final ItemRepository itemRepository;
//    private final ItemMapper mapper;
//    @Autowired
//    private final ResponseUtils responseUtils;


    public ApiResponse<String> create(ItemRequest request) {
        ResponseUtils responseUtils = null;
        if (itemRepository.findById(request.getDevice_id()).isPresent()) {
            return responseUtils.success("Device ID already exists: " + request.getDevice_id());
        }

        Item item = convertToEntity(request);
//        Item item = ItemMapper.toEntity(request);
        itemRepository.save(item);
        return responseUtils.success("Item created successfully.");
    }


    private Item convertToEntity(ItemRequest request) {
            Item item = new Item();
            item.setLabel(request.getLabel());
            item.setModel(request.getModel());
            return item;
        }


    public Item getByDeviceId(Long deviceId) {
        Optional<Item> data = itemRepository.findById(deviceId);

        return data.map(ResponseUtils::success)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + deviceId)).body();
    }

    //
//    public ApiResponse<Item> getByDeviceId(Long deviceId) {
//        Optional<Item> data = itemRepository.findByDevice_id(deviceId);
//
//        if(data.isPresent()){
//            return data.map(ResponseUtils::success).orElseThrow(() ->  new ResourceNotFoundException("Item not found with id: "+deviceId));
//        }
//        return
//
//    }
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public boolean deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));

        itemRepository.delete(item);
        return false;
    }



    public ApiResponse<String> update(Long deviceId, ItemRequest request) {
        // Find the item by its deviceId
        Optional<Item> optionalItem = itemRepository.findById(deviceId);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();  // Get the actual Item object
            item.setLabel(request.getLabel());
            item.setModel(request.getModel());
//            item.setCreation_date(request.getExpiryDate());

            itemRepository.save(item);
            return ResponseUtils.created("Item updated successfully.");
        }

        return ResponseUtils.created("Failed to update: Item not found.");
    }

    public ApiResponse<String> delete(Long deviceId) {
        Item item = itemRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + deviceId));
        itemRepository.delete(item);;
        return ResponseUtils.success("success");
    }
}
