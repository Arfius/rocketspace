package zoom.arfius.searchrocket

import zoom.arfius.searchrocket.model.ApiClasses

interface ISearch {


        fun showSpinner()
        fun hideSpinner()
        fun hideSpinnerWithError(Error: String)
        fun updateAdapter(list: List<ApiClasses.Rocket>)
}