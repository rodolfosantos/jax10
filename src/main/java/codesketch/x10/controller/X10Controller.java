package codesketch.x10.controller;

import codesketch.x10.Address;
import codesketch.x10.Command;
import codesketch.x10.Function;
import codesketch.x10.actuator.Actuator;

public interface X10Controller {

    short vendorId();

    short productId();

    /**
	 * Execute a function on the controller. i.e. Turn on a light.
	 * 
	 * @param command
	 *            the command to execute
	 */
	void execute(Command command);

    /**
     * Open the device and set up the controller.
     */
    void open();

    /**
     * Close the controller
     */
    void close();

    /**
     * Read from the controller
     * 
     * @param lenght
     *            the amount of byte to read.
     * @return the read bytes.
     */
    byte[] read(int lenght);

    /**
     * Write a sequence off bytes to the controller.
     * 
     * @param sequence
     *            the sequence of byte to have to write.
     */
    void write(byte[] sequence);

    /**
     * Verifies whether the controller responded well or not.
     * 
     * @return true if the controller responded well false otherwise.
     */
    boolean ack();
    
    /**
     * Get an actuator for a module on this controller.
     * 
     * @param address
     *            the module address
     * @return the Actuator.
     */
    Actuator actuator(Address address);

	/**
	 * Generate a command instance that can be used whit this
	 * {@link X10Controller}.
	 * 
	 * @param function
	 *            the protocol function to operate
	 * @param address
	 *            the device address as house-unit code
	 * @param dimAmount
	 *            the dim amount if the requested function is dim.
	 * @return a command
	 */
	Command command(Function function, Address address, Integer dimAmount);
}
