// Singleton Pattern
class GameLevel {
    private static GameLevel instance;
    private int level;

    private GameLevel() {
        level = 1; // Default level
    }

    public static GameLevel getInstance() {
        if (instance == null) {
            instance = new GameLevel();
        }
        return instance;
    }

    public void nextLevel() {
        level++;
    }

    public int getLevel() {
        return level;
    }
}

// Factory Pattern
abstract class Vehicle {
    abstract void book();
}

class Car extends Vehicle {
    @Override
    void book() {
        System.out.println("Car has been booked.");
    }
}

class Bike extends Vehicle {
    @Override
    void book() {
        System.out.println("Bike has been booked.");
    }
}

class Scooter extends Vehicle {
    @Override
    void book() {
        System.out.println("Scooter has been booked.");
    }
}

class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        switch (vehicleType) {
            case "Car":
                return new Car();
            case "Bike":
                return new Bike();
            case "Scooter":
                return new Scooter();
            default:
                return null;
        }
    }
}

// Abstract Factory Pattern
interface Ride {
    Vehicle createVehicle();
}

class UrbanRide implements Ride {
    @Override
    public Vehicle createVehicle() {
        return new Car(); // Urban prefers Car
    }
}

class SuburbanRide implements Ride {
    @Override
    public Vehicle createVehicle() {
        return new Scooter(); // Suburban prefers Scooter
    }
}

class RideFactory {
    public static Ride getRide(String location) {
        if (location.equalsIgnoreCase("Urban")) {
            return new UrbanRide();
        } else if (location.equalsIgnoreCase("Suburban")) {
            return new SuburbanRide();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Singleton usage for game level
        GameLevel gameLevel = GameLevel.getInstance();
        System.out.println("Current Level: " + gameLevel.getLevel());
        gameLevel.nextLevel();
        System.out.println("Next Level: " + gameLevel.getLevel());

        // Factory usage for ride-sharing application
        Vehicle vehicle = VehicleFactory.getVehicle("Bike");
        vehicle.book();

        // Abstract Factory pattern for ride based on location
        Ride ride = RideFactory.getRide("Urban");
        Vehicle urbanVehicle = ride.createVehicle();
        urbanVehicle.book();
    }
}
