package net.jeremywenzel.halostats.webapi

class ResponseObject<E>(val responseValue: E?, val wasException: Boolean = false)