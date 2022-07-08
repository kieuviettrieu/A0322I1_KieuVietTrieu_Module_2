package CaseStudy.services.Interface;

import CaseStudy.models.Booking;
import CaseStudy.models.Contract;

public interface BookingService extends Service<Booking> {
    void createNewConstracts(Contract contract);
    void disPlayContracts();
    void editConstract();
}
