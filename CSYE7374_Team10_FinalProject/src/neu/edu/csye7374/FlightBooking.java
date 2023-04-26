package neu.edu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class FlightBooking {
    // Singleton Design Pattern
    static class FlightBookingSystem {
        private static FlightBookingSystem instance = new FlightBookingSystem();
        private PaymentGateway paymentGateway;
        private PaymentStrategy paymentStrategy;

        private FlightBookingSystem() {
            // private constructor to prevent instantiation from outside
        }

        public static FlightBookingSystem getInstance() {
            return instance;
        }

        public void setPaymentGateway(PaymentGateway paymentGateway) {
            this.paymentGateway = paymentGateway;
        }

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void bookFlightTicket(FlightTicketComponent ticket) {
            double amount = ticket.getPrice();
            paymentGateway.processPayment(amount);
            paymentStrategy.pay(amount);
            ticket.displayTicketDetails();
        }
    }

    public interface FlightTicketComponent{

    }
    // Factory Design Pattern
    static class FlightTicketFactory {
        public FlightTicket createTicket(String ticketNumber, String passengerName, String ticketClass) {
            if (ticketClass.equals("Economy")) {
                return new EconomyFlightTicket(ticketNumber, passengerName);
            } else if (ticketClass.equals("Business")) {
                return new BusinessFlightTicket(ticketNumber, passengerName);
            } else if (ticketClass.equals("First Class")) {
                return new FirstClassFlightTicket(ticketNumber, passengerName);
            } else {
                throw new IllegalArgumentException("Invalid ticket class: " + ticketClass);
            }
        }
    }

    // Builder Design Pattern
    static class FlightTicketBuilder {
        private String ticketNumber;
        private String passengerName;
        private String ticketClass;

        public FlightTicketBuilder setTicketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public FlightTicketBuilder setPassengerName(String passengerName) {
            this.passengerName = passengerName;
            return this;
        }

        public FlightTicketBuilder setTicketClass(String ticketClass) {
            this.ticketClass = ticketClass;
            return this;
        }

        public FlightTicket build() {
            if (ticketClass.equals("Economy")) {
                return new EconomyFlightTicket(ticketNumber, passengerName);
            } else if (ticketClass.equals("Business")) {
                return new BusinessFlightTicket(ticketNumber, passengerName);
            } else if (ticketClass.equals("First Class")) {
                return new FirstClassFlightTicket(ticketNumber, passengerName);
            } else {
                throw new IllegalArgumentException("Invalid ticket class: " + ticketClass);
            }
        }
    }

    // Prototype Design Pattern
    static abstract class FlightTicket implements FlightTicketComponent, Cloneable {
        protected String ticketNumber;
        protected String passengerName;

        public FlightTicket(String ticketNumber, String passengerName) {
            this.ticketNumber = ticketNumber;
            this.passengerName = passengerName;
        }

        public void displayTicketDetails() {
            System.out.println("Ticket Number: " + ticketNumber);
            System.out.println("Passenger Name: " + passengerName);
        }

        public abstract double getPrice();

        public Object clone() {
            Object clone = null;
            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }

        public void setTicketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
        }
    }

    static class EconomyFlightTicket extends FlightTicket {
        public EconomyFlightTicket(String ticketNumber, String passengerName) {
            super(ticketNumber, passengerName);
        }

        public double getPrice() {
            return 100.0;
        }
    }

    static class BusinessFlightTicket extends FlightTicket {
        public BusinessFlightTicket(String ticketNumber, String passengerName) {
            super(ticketNumber, passengerName);
        }

        public double getPrice() {
            return 200.0;
        }
    }

    static class FirstClassFlightTicket extends FlightTicket {
        public FirstClassFlightTicket(String ticketNumber, String passengerName) {
            super(ticketNumber, passengerName);
        }

        public double getPrice() {
            return 300.0;
        }
    }

    // Adapter Design Pattern
    static class HotelBookingSystem {
        public String bookHotel(String confirmationNumber, String guestName, String roomType) {
            System.out.println("Booking hotel with confirmation number " + confirmationNumber + " for guest " + guestName + " in room type " + roomType);
            return confirmationNumber;
        }
    }

    static class HotelBookingAdapter implements FlightTicketComponent {
        private HotelBookingSystem hotelBookingSystem;
        private String confirmationNumber;
        private String guestName;
        private String roomType;

        public HotelBookingAdapter(HotelBookingSystem hotelBookingSystem) {
            this.hotelBookingSystem = hotelBookingSystem;
        }

        public FlightTicket bookHotel(String confirmationNumber, String guestName, String roomType) {
            this.confirmationNumber = hotelBookingSystem.bookHotel(confirmationNumber, guestName, roomType);
            this.guestName = guestName;
            this.roomType = roomType;
            return this;
        }

        public void displayTicketDetails() {
            System.out.println("Hotel Confirmation Number: " + confirmationNumber);
            System.out.println("Guest Name: " + guestName);
            System.out.println("Room Type: " + roomType);
        }

        public double getPrice() {
            return 150.0;
        }
    }

    // Decorator Design Pattern
    static abstract class FlightTicketDecorator implements FlightTicketComponent {
        protected FlightTicketComponent ticketComponent;

        public FlightTicketDecorator(FlightTicketComponent ticketComponent) {
            this.ticketComponent = ticketComponent;
        }

        public void displayTicketDetails() {
            ticketComponent.displayTicketDetails();
        }

        public abstract double getPrice();
    }

    static class SeatDecorator extends FlightTicketDecorator {
        public SeatDecorator(FlightTicketComponent ticketComponent) {
            super(ticketComponent);
        }

        public void displayTicketDetails() {
            super.displayTicketDetails();
            System.out.println("Seat: 23A");
        }

        public double getPrice() {
            return ticketComponent.getPrice() + 10.0;
        }
    }

    static class MealDecorator extends FlightTicketDecorator {
        public MealDecorator(FlightTicketComponent ticketComponent) {
            super(ticketComponent);
        }

        public void displayTicketDetails() {
            super.displayTicketDetails();
            System.out.println("Meal: Chicken");
        }

        public double getPrice() {
            return ticketComponent.getPrice() + 20.0;
        }
    }

    // Composite Design Pattern
    static class FlightTicketGroup implements FlightTicketComponent {
        private List<FlightTicketComponent> tickets = new ArrayList<>();

        public void addTicket(FlightTicketComponent ticket) {
            tickets.add(ticket);
        }

        public void displayTicketDetails() {
            for (FlightTicketComponent ticket : tickets) {
                ticket.displayTicketDetails();
                System.out.println();
            }
        }

        public double getPrice() {
            double totalPrice = 0.0;
            for (FlightTicketComponent ticket : tickets) {
                totalPrice += ticket.getPrice();
            }
            return totalPrice;
        }
    }

    // Bridge Design Pattern
    interface PaymentGateway {
        void processPayment(double amount);
    }

    static class CreditCardPaymentGateway implements PaymentGateway {
        public void processPayment(double amount) {
            System.out.println("Processing credit card payment for amount " + amount);
        }
    }

    static class DebitCardPaymentGateway implements PaymentGateway {
        public void processPayment(double amount) {
            System.out.println("Processing debit card payment for amount " + amount);
        }
    }

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPaymentStrategy implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paying with credit card for amount " + amount);
        }
    }

    static class DebitCardPaymentStrategy implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paying with debit card for amount " + amount);
        }
    }

    // Facade Design Pattern
    static class FlightBookingFacade {
        private FlightBookingSystem bookingSystem = FlightBookingSystem.getInstance();
        private FlightTicketFactory ticketFactory = new FlightTicketFactory();
        private CreditCardPaymentGateway paymentGateway = new CreditCardPaymentGateway();
        private CreditCardPaymentStrategy paymentStrategy = new CreditCardPaymentStrategy();

        public void bookFlightTicket(String ticketNumber, String passengerName, String ticketClass, String paymentMethod) {
            FlightTicket ticket = ticketFactory.createTicket(ticketNumber, passengerName, ticketClass);
            bookingSystem.setPaymentGateway(paymentGateway);
            bookingSystem.setPaymentStrategy(paymentStrategy);
            bookingSystem.bookFlightTicket(ticket);
        }
    }

    // Command Design Pattern
    interface FlightTicketBookingCommand {
        void execute();
    }

    static class FlightTicketBookingCommandImpl implements FlightTicketBookingCommand {
        private FlightBookingSystem bookingSystem;
        private FlightTicketComponent ticket;

        public FlightTicketBookingCommandImpl(FlightBookingSystem bookingSystem, FlightTicketComponent ticket) {
            this.bookingSystem = bookingSystem;
            this.ticket = ticket;
        }

        public void execute() {
            bookingSystem.bookFlightTicket(ticket);
        }
    }

    static class FlightTicketBookingInvoker {
        private FlightTicketBookingCommand command;

        public FlightTicketBookingInvoker(FlightTicketBookingCommand command) {
            this.command = command;
        }

        public void bookFlightTicket() {
            command.execute();
        }
    }

    // State Design Pattern
    static class FlightTicketBookingContext {
        private FlightTicketBookingState state;

        public FlightTicketBookingContext() {
            state = new FlightTicketBookingStateAvailable();
        }

        public void setState(FlightTicketBookingState state) {
            this.state = state;
        }

        public void bookFlightTicket(FlightTicketComponent ticket) {
            state.bookFlightTicket(this, ticket);
        }

        public void cancelFlightTicket() {
            state.cancelFlightTicket(this);
        }
    }

    interface FlightTicketBookingState {
        void bookFlightTicket(FlightTicketBookingContext context, FlightTicketComponent ticket);
        void cancelFlightTicket(FlightTicketBookingContext context);
    }

    static class FlightTicketBookingStateAvailable implements FlightTicketBookingState {
        public void bookFlightTicket(FlightTicketBookingContext context, FlightTicketComponent ticket) {
            System.out.println("Booking flight ticket...");
            context.setState(new FlightTicketBookingStateBooked());
        }

        public void cancelFlightTicket(FlightTicketBookingContext context) {
            System.out.println("Cannot cancel flight ticket that has not been booked.");
        }
    }

    static class FlightTicketBookingStateBooked implements FlightTicketBookingState {
        public void bookFlightTicket(FlightTicketBookingContext context, FlightTicketComponent ticket) {
            System.out.println("Cannot book flight ticket that has already been booked.");
        }

        public void cancelFlightTicket(FlightTicketBookingContext context) {
            System.out.println("Cancelling flight ticket...");
            context.setState(new FlightTicketBookingStateAvailable());
        }
    }

    // Observer Design Pattern
    interface FlightTicketBookingObserver {
        void update(FlightTicketComponent ticket);
    }

    static class FlightTicketBookingObserverImpl implements FlightTicketBookingObserver {
        public void update(FlightTicketComponent ticket) {
            System.out.println("Flight ticket booked: ");
            ticket.displayTicketDetails();
        }
    }

    static class FlightTicketBookingSubject {
        private List<FlightTicketBookingObserver> observers = new ArrayList<>();

        public void addObserver(FlightTicketBookingObserver observer) {
            observers.add(observer);
        }

        public void removeObserver(FlightTicketBookingObserver observer) {
            observers.remove(observer);
        }

        public void notifyObservers(FlightTicketComponent ticket) {
            for (FlightTicketBookingObserver observer : observers) {
                observer.update(ticket);
            }
        }
    }

    static class FlightBookingSystem extends FlightTicketBookingSubject {
        private static FlightBookingSystem instance = new FlightBookingSystem();
        private PaymentGateway paymentGateway;
        private PaymentStrategy paymentStrategy;

        private FlightBookingSystem() {
            // private constructor to prevent instantiation from outside
        }

        public static FlightBookingSystem getInstance() {
            return instance;
        }

        public void setPaymentGateway(PaymentGateway paymentGateway) {
            this.paymentGateway = paymentGateway;
        }

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void bookFlightTicket(FlightTicketComponent ticket) {
            double amount = ticket.getPrice();
            paymentGateway.processPayment(amount);
            paymentStrategy.pay(amount);
            ticket.displayTicketDetails();
            notifyObservers(ticket);
        }
    }

    public static void executeDemo(){
        // Singleton Design Pattern
        FlightBookingSystem bookingSystem = FlightBookingSystem.getInstance();

        // Factory Design Pattern
        FlightTicketFactory ticketFactory = new FlightTicketFactory();
        FlightTicket ticket = ticketFactory.createTicket("ABC123", "John Doe", "Economy");
        FlightTicket ticket2 = ticketFactory.createTicket("DEF456", "Jane Smith", "Business");

        // Builder Design Pattern
        FlightTicketBuilder ticketBuilder = new FlightTicketBuilder();
        FlightTicket ticket3 = ticketBuilder.setTicketNumber("GHI789")
                .setPassengerName("Bob Johnson")
                .setTicketClass("First Class")
                .build();

        // Prototype Design Pattern
        FlightTicket ticket4 = (FlightTicket) ticket.clone();
        ticket4.setTicketNumber("JKL012");

        // Adapter Design Pattern
        HotelBookingSystem hotelBookingSystem = new HotelBookingSystem();
        HotelBookingAdapter hotelBookingAdapter = new HotelBookingAdapter(hotelBookingSystem);
        FlightTicket ticket5 = hotelBookingAdapter.bookHotel("MNO345", "Alice Lee", "Economy");

        // Decorator Design Pattern
        FlightTicketDecorator ticketDecorator = new MealDecorator(new SeatDecorator(ticket));
        ticketDecorator.displayTicketDetails();

        // Composite Design Pattern
        FlightTicketGroup ticketGroup = new FlightTicketGroup();
        ticketGroup.addTicket(ticket);
        ticketGroup.addTicket(ticket2);
        ticketGroup.addTicket(ticket3);
        ticketGroup.addTicket(ticket4);
        ticketGroup.addTicket(ticket5);
        ticketGroup.addTicket(ticketDecorator);

        // Bridge Design Pattern
        PaymentGateway paymentGateway = new CreditCardPaymentGateway();
        bookingSystem.setPaymentGateway(paymentGateway);
        bookingSystem.bookFlightTicket(ticketGroup);

        // Facade Design Pattern
        FlightBookingFacade flightBookingFacade = new FlightBookingFacade();
        flightBookingFacade.bookFlightTicket("PQR678", "David Chen", "Business", "Credit Card");

        // Strategy Design Pattern
        PaymentStrategy paymentStrategy = new CreditCardPaymentStrategy();
        bookingSystem.setPaymentStrategy(paymentStrategy);
        bookingSystem.bookFlightTicket(ticketGroup);

        // Command Design Pattern
        FlightTicketBookingCommand bookingCommand = new FlightTicketBookingCommand(bookingSystem, ticketGroup);
        FlightTicketBookingInvoker bookingInvoker = new FlightTicketBookingInvoker(bookingCommand);
        bookingInvoker.bookFlightTicket();

        // State Design Pattern
        FlightTicketBookingContext bookingContext = new FlightTicketBookingContext();
        bookingContext.bookFlightTicket(ticketGroup);
        bookingContext.cancelFlightTicket();

        // Observer Design Pattern
        FlightTicketBookingObserver bookingObserver = new FlightTicketBookingObserver();
        bookingSystem.addObserver(bookingObserver);
        bookingSystem.bookFlightTicket(ticketGroup);
    }
}
