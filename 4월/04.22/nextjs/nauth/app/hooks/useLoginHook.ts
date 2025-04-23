import { useLoginStore } from "@/store/useLoginStore"
import { useEffect } from "react"
import { loadByCookie } from "../member/actions"


const useLoginHook = () => {

    const {mid, accessToken, refreshToken, save} = useLoginStore()
  
    useEffect(() => {
  
      if(!mid){
        loadByCookie().then(cookieValues => {
          if(cookieValues.mid ){
            save(cookieValues.mid, cookieValues.accessToken, cookieValues.refreshToken)
          }
        })
      }
  
    },[mid])

    return {mid, accessToken, refreshToken}

}

export default useLoginHook;