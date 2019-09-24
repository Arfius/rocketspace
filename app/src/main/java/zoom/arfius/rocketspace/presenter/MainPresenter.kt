package zoom.arfius.rocketspace.presenter

import zoom.arfius.rocketspace.model.ApiClasses
import zoom.arfius.rocketspace.repository.FalconAPINet
import zoom.arfius.rocketspace.repository.IService

class MainPresenter(
        iMainPresenter: IMainPresenter
) :IService{
    private val iPresenter = iMainPresenter

    fun getRocketList(query:String){
        iPresenter.showSpinner()
        FalconAPINet.search(this,query)

    }

    override fun onError(error: String) {
        iPresenter.hideSpinnerWithError(error)
    }

    override fun onSuccess(list: List<ApiClasses.Rocket>) {
        iPresenter.hideSpinner()
        iPresenter.updateAdapter(list)
    }
}