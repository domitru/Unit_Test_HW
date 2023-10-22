package Test;

import homework_02.Car;
import homework_02.Motorcycle;
import homework_02.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {

    @Test
    //  - проверка что экземпляр объекта Car также
    //  является экземпляром транспортного средства; (instanceof)
    public void carIsInstanceOfVehicle() {
        Car car = new Car("Nissan", "Qashqai", 2020);
        assertEquals(car.getClass().getSuperclass().getTypeName(), Vehicle.class.getName());
    }

    @Test
    //  - проверка что объект Car создается с 4-мя колесами
    public void carHasFourWheels() {
        Car car = new Car("Nissan", "Qashqai", 2020);
        assertEquals(car.getNumWheels(), 4);
    }

    @Test
    //  - проверка что объект Motorcycle создается с 2-мя колесами
    public void motorcycleHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle("Honda", "Moto", 2020);
        assertEquals(motorcycle.getNumWheels(), 2);
    }

    @Test
    //  - проверка что объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    public void carReachesSpeedOfSixtyInTestDrivenMode () {
        Car car = new Car("Nissan", "Qashqai", 2020);
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    @Test
    //  - проверка что объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    public void motorcycleReachesSpeedOfSeventyFiveInTestDrivenMode () {
        Motorcycle motorcycle = new Motorcycle("Honda", "Moto", 2020);
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(), 75);
    }
    @Test
    //  - проверка, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта)
    //     машина останавливается (speed = 0)
    public void isCarStopped () {
        Car car = new Car("Nissan", "Qashqai", 2020);
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }

    @Test
    //  - проверка что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта)
    //    мотоцикл останавливается (speed = 0)
    public void isMotorcycleStopped () {
        Motorcycle motorcycle = new Motorcycle("Honda", "Moto", 2020);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(), 0);
    }
}