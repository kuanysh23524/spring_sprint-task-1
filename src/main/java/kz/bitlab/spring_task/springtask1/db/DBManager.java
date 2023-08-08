package kz.bitlab.spring_task.springtask1.db;

import kz.bitlab.spring_task.springtask1.models.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager {
    @Getter
    public static List<Item> items = new ArrayList<>();
    private static Long id = 6L;

    static {
        items.add(new Item(1L, "Kuanysh", "Omarov", 100, "A+"));
        items.add(new Item(2L, "Emil", "Amiruldaev", 90, "A-"));
        items.add(new Item(3L, "Meirambek", "Imash", 100, "A+"));
        items.add(new Item(4L, "Symbat", "Kenzhebay", 80, "B"));
        items.add(new Item(5L, "Merkhat", "Manlaev", 85, "B+"));
    }

    public static void addItem(Item item) {
        if (item != null) {
            if (item.getExam() >= 95 && item.getExam() >= 100) {
                item.setMark("A+");
            }
            else if (item.getExam() >= 90 && item.getExam() <= 94) {
                item.setMark("A-");
            }
            else if (item.getExam() >= 85 && item.getExam() <= 89) {
                item.setMark("B+");
            }
            else if (item.getExam() >= 80 && item.getExam() <= 84) {
                item.setMark("B");
            }
            else if (item.getExam() >= 75 && item.getExam() <= 79) {
                item.setMark("B-");
            }
            else if (item.getExam() >= 70 && item.getExam() <= 74) {
                item.setMark("С+");
            }
            else if (item.getExam() >= 65 && item.getExam() <= 69) {
                item.setMark("С");
            }
            else if (item.getExam() >= 60 && item.getExam() <= 64) {
                item.setMark("С-");
            }
            else if (item.getExam() >= 55 && item.getExam() <= 59) {
                item.setMark("D+");
            }
            else if (item.getExam() >= 50 && item.getExam() <= 54) {
                item.setMark("D");
            }
            else if (item.getExam() >= 25 && item.getExam() <= 49) {
                item.setMark("RETAKE");
            }
            else if (item.getExam() >= 0 && item.getExam() <= 24) {
                item.setMark("SUMMER SEMESTER");
            }

        }
        item.setId(id);
        id++;
        items.add(item);
    }

    public static Item getItemById(Long id) {
        return items.stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst().orElseThrow(null);
    }

    public static void DeleteItem(Long id) {
        items.removeIf(item -> Objects.equals(item.getId(), id));
    }
}
