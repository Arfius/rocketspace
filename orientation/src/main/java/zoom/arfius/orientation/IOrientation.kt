package zoom.arfius.orientation

import android.content.Context

interface IOrientation{
    fun updateText(value:Float)
    fun getContext(): Context
}