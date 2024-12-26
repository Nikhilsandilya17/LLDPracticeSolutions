package airlinemanagementsystem.search;

import airlinemanagementsystem.model.Flight;

import java.util.List;

public interface Search {
    List<Flight> search(String source, String destination, String date);
}
