package zoom.arfius.rocketspace.presenter

import zoom.arfius.rocketspace.model.ApiClasses

interface IMainPresenter {


        fun showSpinner()
        fun hideSpinner()
        fun hideSpinnerWithError(Error: String)
        fun updateAdapter(list: List<ApiClasses.Rocket>)
}