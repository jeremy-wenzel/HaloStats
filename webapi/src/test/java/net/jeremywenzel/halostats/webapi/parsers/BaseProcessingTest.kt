package net.jeremywenzel.halostats.webapi.parsers

import java.io.InputStream

abstract class BaseProcessingTest {
    /**
     * Returns a [InputStream] of the file
     *
     * @param fileName the file name of the desired file to open
     * @return [InputStream] of the file. Null if the file doesn't exists
     */
    protected fun getResponseInputStream(fileName: String): InputStream {
        try {
            return this.javaClass.classLoader?.getResourceAsStream(fileName)!!
        }
        catch (e: NullPointerException) {
            System.err.println("The filename ${fileName} probably doesn't exist")
            throw e
        }
    }
}