package zoom.arfius.searchrocket.repository

import zoom.arfius.searchrocket.model.ApiClasses

interface IService {
    
        fun onError(error: String)
        fun onSuccess(list: List<ApiClasses.Rocket>)

}