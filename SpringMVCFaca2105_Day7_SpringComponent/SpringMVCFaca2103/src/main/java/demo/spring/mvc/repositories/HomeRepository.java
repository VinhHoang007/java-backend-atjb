package demo.spring.mvc.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import demo.spring.mvc.dtos.HomeListItemDTO;

// DAO
@Repository
public class HomeRepository {

    public List<HomeListItemDTO> loadData() {
        List<HomeListItemDTO> result = new ArrayList<HomeListItemDTO>();

        // Read DB and set to result
        result.add(new HomeListItemDTO(1, "Name 1", "Address1"));
        result.add(new HomeListItemDTO(2, "Name 2", "Address2"));
        result.add(new HomeListItemDTO(5, "Name 5", "Address5"));
        result.add(new HomeListItemDTO(10, "Name 10", "Address10"));
        result.add(new HomeListItemDTO(15, "Name 15", "Address15"));
        result.add(new HomeListItemDTO(20, "Name 20", "Address20"));
        result.add(new HomeListItemDTO(30, "Name 30", "Address30"));

        return result;
    }
}
