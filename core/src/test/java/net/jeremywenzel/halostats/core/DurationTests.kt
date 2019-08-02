package net.jeremywenzel.halostats.core

import net.jeremywenzel.halostats.core.util.Duration
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.IllegalArgumentException

class DurationTests {

    @Test(expected = IllegalArgumentException::class)
    fun `Duration Unexpected Character For Time`() {
        val duration = Duration.fromIsoString("PT6H8Q1S")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Duration P not first character`() {
        val duration = Duration.fromIsoString("T6H8M1S")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Duration T not second character`() {
        val duration = Duration.fromIsoString("P6H8Q1S")
    }

    @Test
    fun `Duration Hours Test`() {
        val duration = Duration.fromIsoString("PT6H8M1S")
        assertEquals(6, duration.hours)
    }

    @Test
    fun `Duration No Hours Test`() {
        val duration = Duration.fromIsoString("PT8M1S")
        assertEquals(0, duration.hours)
    }

    @Test
    fun `Duration Minutes Test`() {
        val duration = Duration.fromIsoString("PT6H8M1S")
        assertEquals(8, duration.minutes)
    }

    @Test
    fun `Duration No Minutes Test`() {
        val duration = Duration.fromIsoString("PT6H1S")
        assertEquals(0, duration.minutes)
    }

    @Test
    fun `Duration Seconds Test`() {
        val duration = Duration.fromIsoString("PT6H8M1S")
        assertEquals(1, duration.seconds)
    }

    @Test
    fun `Duration No Seconds Test`() {
        val duration = Duration.fromIsoString("PT6H8M")
        assertEquals(0, duration.seconds)
    }

    @Test
    fun `Duration With Fraction Seconds Test`() {
        val duration = Duration.fromIsoString("PT6H8M1.2783196S")
        assertEquals(1, duration.seconds)
    }
}