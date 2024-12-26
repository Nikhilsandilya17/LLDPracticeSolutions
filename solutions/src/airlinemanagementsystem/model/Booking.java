package airlinemanagementsystem.model;

public class Booking {
   private int bookingId;

   public int getBookingId() {
      return bookingId;
   }

   public void setBookingId(int bookingId) {
      this.bookingId = bookingId;
   }

   public Payment getPayment() {
      return payment;
   }

   public void setPayment(Payment payment) {
      this.payment = payment;
   }

   private Payment payment;


}
