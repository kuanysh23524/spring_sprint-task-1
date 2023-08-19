package kz.bitlab.spring_task.springtask1.Services;

import kz.bitlab.spring_task.springtask1.models.Item;
import kz.bitlab.spring_task.springtask1.repositories.ItemRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ItemServices {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getitems() {
        return itemRepository.findAll();
    }

    public void addItem(Item item) {
        if (item != null) {
            if (item.getExam() >= 95 && item.getExam() >= 100) {
                item.setMark("A+");
            } else if (item.getExam() >= 90 && item.getExam() <= 94) {
                item.setMark("A-");
            } else if (item.getExam() >= 85 && item.getExam() <= 89) {
                item.setMark("B+");
            } else if (item.getExam() >= 80 && item.getExam() <= 84) {
                item.setMark("B");
            } else if (item.getExam() >= 75 && item.getExam() <= 79) {
                item.setMark("B-");
            } else if (item.getExam() >= 70 && item.getExam() <= 74) {
                item.setMark("С+");
            } else if (item.getExam() >= 65 && item.getExam() <= 69) {
                item.setMark("С");
            } else if (item.getExam() >= 60 && item.getExam() <= 64) {
                item.setMark("С-");
            } else if (item.getExam() >= 55 && item.getExam() <= 59) {
                item.setMark("D+");
            } else if (item.getExam() >= 50 && item.getExam() <= 54) {
                item.setMark("D");
            } else if (item.getExam() >= 25 && item.getExam() <= 49) {
                item.setMark("RETAKE");
            } else if (item.getExam() >= 0 && item.getExam() <= 24) {
                item.setMark("SUMMER SEMESTER");
            }

        }
        itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void editItem(Item updatedItem) {
        itemRepository.save(updatedItem);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
//        items.removeIf(item -> Objects.equals(item.getId(), id));
    }
}
