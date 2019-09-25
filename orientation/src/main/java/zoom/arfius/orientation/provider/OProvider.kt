package zoom.arfius.orientation.provider

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import zoom.arfius.orientation.presenter.IOPresenter

class OProvider(context: Context, presenter: IOPresenter):  SensorEventListener {

    private var mSensorManager : SensorManager?= null
    private var mAccelerometer : Sensor?= null
    private lateinit var mpresenter : IOPresenter

    init{
        mSensorManager = context.getSystemService( Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ORIENTATION)
        mpresenter=presenter
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //Log.i("[AF]onAccuracyChanged","")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        Log.i("[AF]onSensorChanged X",""+event!!.values[2])
        mpresenter?.getXMovement(event!!.values[2]);
    }

    fun runProvider(){
        mSensorManager!!.registerListener(this,mAccelerometer, SensorManager.SENSOR_DELAY_GAME)
    }

    fun stopProvider(){
        mSensorManager!!.unregisterListener(this)
    }




}