/*                                                                      *\
**                    SICU Stress Measurement System                    **
**                      Project P04  |  C380 Team A                     **
**          EBME 380: Biomedical Engineering Design Experience          **
**                    Case Western Reserve University                   **
**                          2016 Fall Semester                          **
\*                                                                      */

package edu.cwru.sicu_sms.util;

import jssc.SerialPort;
import jssc.SerialPortEventListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is an abstraction of a serial port comprising all the necessary parameters and core functionality needed for the client application.
 *
 * @since December 12, 2016
 * @author Ted Frohlich <ttf10@case.edu>
 * @author Abby Walker <amw138@case.edu>
 */
abstract class AbstractSerialPort implements SerialPortEventListener {
    
    final SerialPort serialPort;
    final Properties properties;
    
    /**
     * Instantiates the underlying serial port with the port name associated with the given property key.
     *
     * @param key the string key used to load the port name from the 'port' properties file
     */
    AbstractSerialPort(String key) {
        properties = new Properties();
        try {
            FileInputStream inStream = new FileInputStream("port.properties");
            properties.load(inStream);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serialPort = new SerialPort(properties.getProperty(key));
    }
    
}