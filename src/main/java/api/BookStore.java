package api;

import entity.Address;
import entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class BookStore implements Store<Book>{

    private List<Book> books;
    private Address address;

    @Override
    public void addGood(Book book) {

    }

    @Override
    public Book getGoodById(String id) {
        return null;
    }

    @Override
    public Book updateGood(String id) {
        return null;
    }

    @Override
    public Book deleteGood(String id) {
        return null;
    }

    /**
    *
    * TODO: Remove this method
    *  This functionality was added just for demonstration using of an anonymous class
    *
    */
//    public GoodLogistic makeRoute() {
//        return new GoodLogistic() {
//            @Override
//            public Double getDistance(Address... addresses) {
//                double distance = 0D;
//                for (int i = 0; i < addresses.length-1; i++) {
//                    distance += Math.sqrt(
//                            Math.pow((addresses[i+1].getCoordinateGPSLongtitude() - addresses[i].getCoordinateGPSLongtitude()), 2)
//                            + Math.pow((addresses[i+1].getCoordinateGPSLatitude() - addresses[i].getCoordinateGPSLatitude()), 2));
//                }
//                return distance;
//            }
//
//            @Override
//            public Long getTransferTime(LocalDateTime... times) {
//                long transferTime = 0L;
//                for (int i = 0; i < times.length-1; i++) {
//                    transferTime +=
//                            ZonedDateTime.of(times[i+1], ZoneId.systemDefault()).toInstant().toEpochMilli()
//                            - ZonedDateTime.of(times[i], ZoneId.systemDefault()).toInstant().toEpochMilli();
//                }
//                return transferTime;
//            }
//        };
//    }

    public GoodLogistic makeRoute() {
        return addresses -> {
            double distance = 0D;
            for (int i = 0; i < addresses.length-1; i++) {
                distance += Math.sqrt(
                        Math.pow((addresses[i+1].getCoordinateGPSLongtitude() - addresses[i].getCoordinateGPSLongtitude()), 2)
                        + Math.pow((addresses[i+1].getCoordinateGPSLatitude() - addresses[i].getCoordinateGPSLatitude()), 2));
            }
            return distance;
        };
    }
    /**
     * TODO: Remove this method
     * This method was added just for demonstration using of lambda expressions classes
     *
     * */
    public GoodLogistic makeRouteBetweenTwoAddresses(Address address1, Address address2) {
        return (addresses) ->  Math.sqrt(
                        Math.pow((address2.getCoordinateGPSLongtitude() - address1.getCoordinateGPSLongtitude()), 2)
                        + Math.pow((address2.getCoordinateGPSLatitude() - address1.getCoordinateGPSLatitude()), 2));
    }

    @SafeVarargs
    public final void printByParameter(Function<Book, ?>... parameters) {
        for (Function<Book, ?> parameter : parameters) {
            String result = books.stream()
                    .map(parameter)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(result);
        }
    }
}
