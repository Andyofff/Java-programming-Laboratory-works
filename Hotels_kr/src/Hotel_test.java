import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Hotel_test {

    @Test
    void testSortByCity() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Minsk", "Belarus", 2));
        hotels.add(new Hotel("New York", "USA", 5));
        hotels.add(new Hotel("Paris", "France", 4));

        // Сортируем по городу
        Collections.sort(hotels, new Hotel.HotelComparator());

        // Проверяем, что список отсортирован по городу
        assertEquals("Minsk", hotels.get(0).getCity());
        assertEquals("New York", hotels.get(1).getCity());
        assertEquals("Paris", hotels.get(2).getCity());
    }

    @Test
    void testSortByStars() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Minsk", "Belarus", 2));
        hotels.add(new Hotel("New York", "USA", 5));
        hotels.add(new Hotel("Paris", "France", 4));

        // Сортируем по количеству звёзд
        Collections.sort(hotels, new HotelComparator().reversed());

        // Проверяем, что список отсортирован по количеству звёзд
        assertEquals("Paris", hotels.get(0).getCity());
        assertEquals("Minsk", hotels.get(1).getCity());
        assertEquals("New York", hotels.get(2).getCity());
    }
}