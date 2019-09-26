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
    lateinit var views:Array<TextView>

    override fun updateText(value:Float) {
        axisx.setText(""+value);

        if(value>=-40.0&&value<-24.0){
            update(textViewH,50.0)

        }
        if(value>=-24.0&&value<-8.0){
            update(textViewE,50.0)
        }
        if(value>=-8.0&&value<8.0){
            update(textViewL1,50.0)
        }
        if(value>=8.0&&value<24.0){
            update(textViewL2,50.0)
        }
        if(value>=24.0&&value<40.0){
            update(textViewO,50.0)
        }
    }

    fun update(tw:TextView,size:Double ){
        var c=size;
        Log.i("update",tw.text.toString()+" >"+c);
        tw.textSize= c.toFloat()
        views.forEach { e->

            if(e.id!=tw.id)
                e.textSize=24.0F;

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orientation)
        presenter= OPresenter(this)
        views=arrayOf(textViewH,textViewE,textViewL1,textViewL2,textViewO)
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
