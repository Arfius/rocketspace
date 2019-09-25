package zoom.arfius.searchrocket.presenter

import zoom.arfius.searchrocket.model.ApiClasses

interface IMainPresenter {


        fun showSpinner()
        fun hideSpinner()
        fun hideSpinnerWithError(Error: String)
        fun updateAdapter(list: List<ApiClasses.Rocket>)
}