package zoom.arfius.orientation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_orientation.*
import zoom.arfius.orientation.presenter.OPresenter


class Orientation : AppCompatActivity(), IOrientation {

    lateinit var presenter: OPresenter

    override fun updateText(value:Float) {
        axisx.setText(""+value);
        if(value>0){
            update(textViewH,5.0,value)
            update(textViewE,4.0,value)
            update(textViewL1,3.0,value)
            update(textViewL2,1.0,value)
            update(textViewO,1.0,value)
        }else
        {
            update(textViewH,1.0,-1*value)
            update(textViewE,2.0,-1*value)
            update(textViewL1,3.0,-1*value)
            update(textViewL2,4.0,-1*value)
            update(textViewO,5.0,-1*value)
        }


    }

    fun update(tw:TextView,weight:Double,scale:Float ){
        var c=weight*scale+24;
        Log.i("update",tw.text.toString()+" >"+c);
        tw.textSize= c.toFloat()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orientation)
        presenter= OPresenter(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.runGyroscope();
    }

    override fun onPause() {
        super.onPause()
        presenter.stopGyroscope();
    }

    override fun getContext():Context{
        return baseContext;
    }

}
