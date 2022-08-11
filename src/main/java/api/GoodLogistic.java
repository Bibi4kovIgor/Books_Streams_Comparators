package api;

import entity.Address;

public interface GoodLogistic {
    Double getDistance(Address...addresses);
//    Long getTransferTime(LocalDateTime...times);
}
