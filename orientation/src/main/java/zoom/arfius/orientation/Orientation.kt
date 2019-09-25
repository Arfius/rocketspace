package zoom.arfius.orientation

import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import zoom.arfius.orientation.presenter.IOPresenter
import androidx.core.view.ViewCompat.setZ
import androidx.core.view.ViewCompat.setY
import androidx.core.view.ViewCompat.setX
import android.hardware.Sensor.TYPE_GYROSCOPE
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Build
import android.util.Log
import android.view.View
import android.view.WindowManager


class Orientation : AppCompatActivity(),  SensorEventListener {

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.i("[AF]onAccuracyChanged","")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        Log.i("[AF]onSensorChanged X",""+event!!.values[0])

    }


    private var mSensorManager : SensorManager?= null
    private var mAccelerometer : Sensor?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orientation)

        //----------------------

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        // focus in accelerometer
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        // setup the window
    }

    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(this,mAccelerometer,
                SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager!!.unregisterListener(this)
    }

}
