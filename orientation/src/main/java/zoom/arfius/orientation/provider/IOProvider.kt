package zoom.arfius.orientation.provider

interface IOProvider{
    fun getXMovement(value: Float)
    fun runGyroscope()
    fun stopGyroscope()
}