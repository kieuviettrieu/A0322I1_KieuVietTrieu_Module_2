package CaseStudy.services.Impl;

import CaseStudy.models.Booking;
import CaseStudy.models.person.Customer;
import CaseStudy.services.Interface.PromotionService;

import java.util.TreeSet;

public class PromotionServiceImpl implements PromotionService {
    private TreeSet<Integer> arrayCustomerService=new TreeSet<>();
    private BookingServiceImpl bookingService=new BookingServiceImpl();
    private CustomerServiceImpl customerService=new CustomerServiceImpl();

    private void createArrayService()
    {
        arrayCustomerService.clear();
        for (Booking booking:bookingService.getTreeSetBooking())
        {
            arrayCustomerService.add(booking.getCustomerCode());
        }
    }

    @Override
    public void disPlayUseService() {
        System.out.println("List customers use service: ");
        createArrayService();
        if(arrayCustomerService.size()==0)
        {
            System.out.println("Empty list!");
        }
        else
        {
            for (Integer maKhachHang:arrayCustomerService)
            {
                Customer customer=customerService.getCustomer(maKhachHang);
                System.out.println(customer.toString());
            }
        }
    }

    @Override
    public void disPlayGetVoucher() {
        VoucherServices.disPlay();
    }
}
