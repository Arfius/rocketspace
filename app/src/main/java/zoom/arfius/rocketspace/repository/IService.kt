package zoom.arfius.rocketspace.repository

import zoom.arfius.rocketspace.model.ApiClasses

interface IService {
    
        fun onError(error: String)
        fun onSuccess(list: List<ApiClasses.Rocket>)

}