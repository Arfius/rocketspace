package zoom.arfius.orientation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import zoom.arfius.orientation.presenter.IOPresenter

class Orientation : AppCompatActivity(), IOPresenter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orientation)
    }
}
