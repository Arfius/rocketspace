package zoom.arfius.searchrocket.presenter

import zoom.arfius.searchrocket.ISearch
import zoom.arfius.searchrocket.model.ApiClasses
import zoom.arfius.searchrocket.repository.FalconAPINet
import zoom.arfius.searchrocket.repository.IService

class MainPresenter(
        iSearch: ISearch
) : IService {
    private val iPresenter = iSearch

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