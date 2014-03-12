package codesketch.x10.controller;

import java.util.Map;

import codesketch.x10.Address;
import codesketch.x10.actuator.Actuator;
import codesketch.x10.actuator.X10ActuatorDefault;
import codesketch.x10.bus.Device;

public abstract class AbstractX10Controller implements X10Controller {

    private final Device device;

    public AbstractX10Controller(Device device) {
        this.device = device;
    }

    @Override
    public Actuator actuator(Address address) {
        return new X10ActuatorDefault(address, this);
    }

    protected Device getDevice() {
        return device;
    }

    protected byte mapHouse(String house) {
        Map<String, Byte> houseEncodingMap = this.getHouseEncodingMap();
		return houseEncodingMap.get(house);
    }

    protected byte mapUnit(String unit) {
        Map<String, Byte> unitEncodingMap = this.getUnitEncodingMap();
        return unitEncodingMap.get(unit);
    }
}