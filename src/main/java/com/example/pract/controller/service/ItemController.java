package com.example.pract.controller.service;


import com.example.pract.domain.dto.request.ItemRequest;
import com.example.pract.domain.dto.response.ApiResponse;
import com.example.pract.domain.dto.response.ResponseUtils;
import com.example.pract.domain.models.Item;
import com.example.pract.domain.projections.ItemInfo;
import com.example.pract.service.ItemService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItemss() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    // Create a new item
    @PostMapping(value = "/create")
    public ResponseEntity<ApiResponse<String>> create(@RequestBody ItemRequest request) {
        var response = itemService.create(request);
        return ResponseUtils.respond(response);
    }

    @GetMapping(value = "/{deviceid}")
    public ResponseEntity<Item> getByLicenseNumber(@PathVariable @NotNull Long deviceid) {
        var response = itemService.getByDeviceId(deviceid);
        return ResponseEntity.ok((Item) response);
    }

    @PutMapping(value = "/update/{deviceId}")
    public ResponseEntity<ApiResponse<String>> update(@PathVariable long deviceId, @RequestBody ItemRequest request) {
        var response = itemService.update(deviceId,request);
        return ResponseUtils.respond(response);
    }

    // Delete an item by ID
    @DeleteMapping("/{deviceId}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long deviceId) {
        var response = itemService.delete(deviceId);
        return ResponseUtils.respond(response);
    }
}

