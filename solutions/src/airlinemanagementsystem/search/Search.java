package airlinemanagementsystem.search;

import airlinemanagementsystem.model.Flight;

public interface Search {
    Flight searchFlight(String source, String destination, String date);
}
