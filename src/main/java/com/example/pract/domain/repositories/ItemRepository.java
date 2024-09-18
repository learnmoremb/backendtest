package com.example.pract.domain.repositories;
import com.example.pract.domain.models.Item;
import com.example.pract.domain.projections.ItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
//    Optional<Item> findByDevice_id(Long device_id);

    // Find items by groupId
}

