package zoom.arfius.orientation.presenter

import zoom.arfius.orientation.IOrientation
import zoom.arfius.orientation.provider.OProvider

class OPresenter(view: IOrientation):IOPresenter{

    lateinit var provider: OProvider;
    var mview:IOrientation=view;

    init{
        provider= OProvider(view.getContext(),this)
    }

    override fun getXMovement(value: Float) {
        mview.updateText(value)
    }

    fun runGyroscope() {
        provider.runProvider()
    }

    fun stopGyroscope() {
        provider.stopProvider()

    }
}