import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hotel {

    private String city;
    private String name;
    private int stars;

    public Hotel(String city, String name, int stars) {
        this.city = city;
        this.name = name;
        this.stars = stars;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                '}';
    }

    public static class HotelComparator implements Comparator<Hotel> {

        @Override
        public int compare(Hotel hotel1, Hotel hotel2) {
            int cityCompare = hotel1.getCity().compareTo(hotel2.getCity());
            if (cityCompare != 0) {
                return cityCompare;
            }
            return hotel2.getStars() - hotel1.getStars();
        }
    }

    public static void main(String[] args) throws IOException {
        List<Hotel> hotels = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("hotel.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");

                Hotel hotel = new Hotel(data[0], data[1], Integer.parseInt(data[2]));
                hotels.add(hotel);
            }
        }

        // Вывод данных в алфавитном порядке названий городов, а для каждого города в порядке убывания количества звёзд
        Collections.sort(hotels, new HotelComparator());
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }

        // По названию города найти и вывести на экран информацию обо всех отелях города, название которого считывается с клавиатуры
        System.out.println("Введите название города:");
        String city = new BufferedReader(new InputStreamReader(System.in)).readLine();
        List<Hotel> hotelsInCity = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getCity().equals(city)) {
                hotelsInCity.add(hotel);
            }
        }
        System.out.println("Отели в городе " + city + ":");
        for (Hotel hotel : hotelsInCity) {
            System.out.println(hotel);
        }

        // По названию отеля выбрать и вывести на экран города, в которых есть отели с данным названием
        System.out.println("Введите название отеля:");
        String hotelName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        List<String> citiesWithHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                citiesWithHotels.add(hotel.getCity());
            }
        }
        System.out.println("Города, в которых есть отели с названием " + hotelName + ":");
        citiesWithHotels.forEach(System.out::println);
    }
}